/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.ballerinalang.compiler.bir.codegen;

import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRBasicBlock;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRFunction;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRFunctionParameter;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRTypeDefinition;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRVariableDcl;
import org.wso2.ballerinalang.compiler.bir.model.BIRNonTerminator.UnaryOP;
import org.wso2.ballerinalang.compiler.bir.model.BIROperand;
import org.wso2.ballerinalang.compiler.bir.model.InstructionKind;
import org.wso2.ballerinalang.compiler.bir.model.VarKind;
import org.wso2.ballerinalang.compiler.bir.model.VarScope;
import org.wso2.ballerinalang.compiler.semantics.model.types.BInvokableType;
import org.wso2.ballerinalang.compiler.semantics.model.types.BRecordType;
import org.wso2.ballerinalang.compiler.semantics.model.types.BType;
import org.wso2.ballerinalang.compiler.util.Name;
import org.wso2.ballerinalang.compiler.util.TypeTags;
import org.wso2.ballerinalang.compiler.util.diagnotic.DiagnosticPos;
import org.wso2.ballerinalang.util.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.wso2.ballerinalang.compiler.bir.codegen.JvmMethodGen.cleanupFunctionName;
import static org.wso2.ballerinalang.compiler.bir.codegen.JvmMethodGen.getBasicBlock;
import static org.wso2.ballerinalang.compiler.bir.codegen.JvmMethodGen.getFunction;
import static org.wso2.ballerinalang.compiler.bir.codegen.JvmMethodGen.getFunctionParam;
import static org.wso2.ballerinalang.compiler.bir.codegen.JvmMethodGen.getVariableDcl;
import static org.wso2.ballerinalang.compiler.bir.codegen.JvmTerminatorGen.toNameString;
import static org.wso2.ballerinalang.compiler.bir.model.BIRTerminator.Branch;
import static org.wso2.ballerinalang.compiler.bir.model.BIRTerminator.GOTO;

/**
 * BIR desugar phase related methods at JVM code generation.
 *
 * @since 1.2.0
 */
public class JvmDesugarPhase {

    public static void addDefaultableBooleanVarsToSignature(BIRFunction func, BType booleanType) {

        BIRFunction currentFunc = getFunction(func);
        currentFunc.type = new BInvokableType(currentFunc.type.paramTypes, currentFunc.type.restType,
                currentFunc.type.retType, currentFunc.type.tsymbol);
        BInvokableType type = currentFunc.type;
        currentFunc.type.paramTypes = updateParamTypesWithDefaultableBooleanVar(currentFunc.type.paramTypes,
                type != null ? type.restType : type, booleanType);
        int index = 0;
        List<BIRVariableDcl> updatedVars = new ArrayList<>();
        List<BIRVariableDcl> localVars = currentFunc.localVars;
        int nameIndex = 0;

        for (BIRVariableDcl localVar : localVars) {
            updatedVars.add(index, localVar);
            index += 1;
            if (localVar instanceof BIRFunctionParameter) {
                // An additional boolean arg is gen for each function parameter.
                String argName = "%syn" + nameIndex;
                nameIndex += 1;
                BIRFunctionParameter booleanVar = new BIRFunctionParameter(null, booleanType,
                        new Name(argName), VarScope.FUNCTION, VarKind.ARG, "", false);
                updatedVars.add(index, booleanVar);
                index += 1;
            }
        }
        currentFunc.localVars = updatedVars;
    }

    public static void enrichWithDefaultableParamInits(BIRFunction currentFunc, JvmMethodGen jvmMethodGen) {

        int k = 1;
        List<BIRFunctionParameter> functionParams = new ArrayList<>();
        List<BIRVariableDcl> localVars = currentFunc.localVars;
        while (k < localVars.size()) {
            BIRVariableDcl localVar = getVariableDcl(localVars.get(k));
            if (localVar instanceof BIRFunctionParameter) {
                functionParams.add((BIRFunctionParameter) localVar);
            }
            k += 1;
        }

        jvmMethodGen.resetIds();

        List<BIRBasicBlock> basicBlocks = new ArrayList<>();

        BIRBasicBlock nextBB = insertAndGetNextBasicBlock(basicBlocks, "desugaredBB", jvmMethodGen);

        int paramCounter = 0;
        DiagnosticPos pos = currentFunc.pos;
        while (paramCounter < functionParams.size()) {
            BIRFunctionParameter funcParam = functionParams.get(paramCounter);
            if (funcParam != null && funcParam.hasDefaultExpr) {
                int boolParam = paramCounter + 1;
                BIRFunctionParameter funcBooleanParam = getFunctionParam(functionParams.get(boolParam));
                BIROperand boolRef = new BIROperand(funcBooleanParam);
                UnaryOP notOp = new UnaryOP(pos, InstructionKind.NOT, boolRef, boolRef);
                nextBB.instructions.add(notOp);
                List<BIRBasicBlock> bbArray = currentFunc.parameters.get(funcParam);
                BIRBasicBlock trueBB = getBasicBlock(bbArray.get(0));
                for (BIRBasicBlock defaultBB : bbArray) {
                    basicBlocks.add(getBasicBlock(defaultBB));
                }
                BIRBasicBlock falseBB = insertAndGetNextBasicBlock(basicBlocks, "desugaredBB", jvmMethodGen);
                nextBB.terminator = new Branch(pos, boolRef, trueBB, falseBB);

                BIRBasicBlock lastBB = getBasicBlock(bbArray.get(bbArray.size() - 1));
                lastBB.terminator = new GOTO(pos, falseBB);

                nextBB = falseBB;
            }
            paramCounter += 2;
        }

        if (basicBlocks.size() == 1) {
            // this means only one block added, if there are default vars, there must be more than one block
            return;
        }
        if (currentFunc.basicBlocks.size() == 0) {
            currentFunc.basicBlocks = basicBlocks;
            return;
        }

        BIRBasicBlock firstBB = getBasicBlock(currentFunc.basicBlocks.get(0));

        nextBB.terminator = new GOTO(pos, firstBB);
        basicBlocks.addAll(currentFunc.basicBlocks);

        currentFunc.basicBlocks = basicBlocks;
    }

    public static BIRBasicBlock insertAndGetNextBasicBlock(List<BIRBasicBlock> basicBlocks,
                                                           String prefix, JvmMethodGen jvmMethodGen) {

        BIRBasicBlock nextbb = new BIRBasicBlock(getNextDesugarBBId(prefix, jvmMethodGen));
        basicBlocks.add(nextbb);
        return nextbb;
    }

    public static Name getNextDesugarBBId(String prefix, JvmMethodGen jvmMethodGen) {

        int nextId = jvmMethodGen.incrementAndGetNextId();
        return new Name(prefix + nextId);
    }

    private static List<BType> updateParamTypesWithDefaultableBooleanVar(List<BType> funcParams, BType restType,
                                                                         BType booleanType) {

        List<BType> paramTypes = new ArrayList<>();

        int counter = 0;
        int index = 0;
        // Update the param types to add boolean variables to indicate if the previous variable contains a user
        // given value
        int size = funcParams == null ? 0 : funcParams.size();
        while (counter < size) {
            paramTypes.add(index, funcParams.get(counter));
            paramTypes.add(index + 1, booleanType);
            index += 2;
            counter += 1;
        }
        if (!(restType == null)) {
            paramTypes.add(index, restType);
            paramTypes.add(index + 1, booleanType);
        }
        return paramTypes;
    }

    static void rewriteRecordInits(List<BIRTypeDefinition> typeDefs) {

        for (BIRTypeDefinition typeDef : typeDefs) {
            BType recordType = typeDef.type;
            if (recordType.tag != TypeTags.RECORD) {
                continue;
            }
            List<BIRFunction> attachFuncs = typeDef.attachedFuncs;
            for (BIRFunction func : attachFuncs) {
                rewriteRecordInitFunction(func, (BRecordType) recordType);
            }
        }
    }

    private static void rewriteRecordInitFunction(BIRFunction func, BRecordType recordType) {

        BIRVariableDcl receiver = func.receiver;

        // Rename the function name by appending the record name to it.
        // This done to avoid frame class name overlappings.
        func.name = new Name(cleanupFunctionName(toNameString(recordType) + func.name.value));

        // change the kind of receiver to 'ARG'
        receiver.kind = VarKind.ARG;

        // Update the name of the reciever. Then any instruction that was refering to the receiver will
        // now refer to the injected parameter.
        String paramName = "$_" + receiver.name.value;
        receiver.name = new Name(paramName);

        // Inject an additional parameter to accept the self-record value into the init function
        BIRFunctionParameter selfParam = new BIRFunctionParameter(null, receiver.type, receiver.name,
                                                                  receiver.scope, VarKind.ARG, paramName, false);

        List<BType> updatedParamTypes = Lists.of(receiver.type);
        updatedParamTypes.addAll(func.type.paramTypes);
        func.type = new BInvokableType(updatedParamTypes, func.type.restType, func.type.retType, null);

        List<BIRVariableDcl> localVars = func.localVars;
        List<BIRVariableDcl> updatedLocalVars = new ArrayList<>();
        updatedLocalVars.add(localVars.get(0));
        updatedLocalVars.add(selfParam);
        int index = 1;
        while (index < localVars.size()) {
            updatedLocalVars.add(localVars.get(index));
            index += 1;
        }
        func.localVars = updatedLocalVars;
    }
}
