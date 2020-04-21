/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package io.ballerinalang.compiler.syntax.tree;


/**
 * The {@code NodeTransformer} transform each node in the syntax tree to
 * another object of type T.
 * <p>
 * This class separates tree nodes from various unrelated operations that needs
 * to be performed on the syntax tree nodes.
 * <p>
 * This class allows you to transform the syntax tree into something else without
 * mutating instance variables.
 * <p>
 * There exists a transform method for each node in the Ballerina syntax tree.
 * These methods return T. If you are looking for a visitor that has visit
 * methods that return void, see {@link NodeVisitor}.
 *
 * This is a generated class.
 *
 * @param <T> the type of class that is returned by visit methods
 * @see NodeVisitor
 * @since 1.3.0
 */
public abstract class NodeTransformer<T> {

    public T transform(ModulePartNode modulePartNode) {
        return transformSyntaxNode(modulePartNode);
    }

    public T transform(FunctionDefinitionNode functionDefinitionNode) {
        return transformSyntaxNode(functionDefinitionNode);
    }

    public T transform(ImportDeclarationNode importDeclarationNode) {
        return transformSyntaxNode(importDeclarationNode);
    }

    public T transform(ListenerDeclarationNode listenerDeclarationNode) {
        return transformSyntaxNode(listenerDeclarationNode);
    }

    public T transform(TypeDefinitionNode typeDefinitionNode) {
        return transformSyntaxNode(typeDefinitionNode);
    }

    public T transform(ServiceDeclarationNode serviceDeclarationNode) {
        return transformSyntaxNode(serviceDeclarationNode);
    }

    public T transform(AssignmentStatementNode assignmentStatementNode) {
        return transformSyntaxNode(assignmentStatementNode);
    }

    public T transform(CompoundAssignmentStatementNode compoundAssignmentStatementNode) {
        return transformSyntaxNode(compoundAssignmentStatementNode);
    }

    public T transform(VariableDeclarationNode variableDeclarationNode) {
        return transformSyntaxNode(variableDeclarationNode);
    }

    public T transform(BlockStatementNode blockStatementNode) {
        return transformSyntaxNode(blockStatementNode);
    }

    public T transform(BreakStatementNode breakStatementNode) {
        return transformSyntaxNode(breakStatementNode);
    }

    public T transform(ExpressionStatementNode expressionStatementNode) {
        return transformSyntaxNode(expressionStatementNode);
    }

    public T transform(ContinueStatementNode continueStatementNode) {
        return transformSyntaxNode(continueStatementNode);
    }

    public T transform(ExternalFunctionBodyNode externalFunctionBodyNode) {
        return transformSyntaxNode(externalFunctionBodyNode);
    }

    public T transform(IfElseStatementNode ifElseStatementNode) {
        return transformSyntaxNode(ifElseStatementNode);
    }

    public T transform(ElseBlockNode elseBlockNode) {
        return transformSyntaxNode(elseBlockNode);
    }

    public T transform(WhileStatementNode whileStatementNode) {
        return transformSyntaxNode(whileStatementNode);
    }

    public T transform(PanicStatementNode panicStatementNode) {
        return transformSyntaxNode(panicStatementNode);
    }

    public T transform(ReturnStatementNode returnStatementNode) {
        return transformSyntaxNode(returnStatementNode);
    }

    public T transform(LocalTypeDefinitionStatementNode localTypeDefinitionStatementNode) {
        return transformSyntaxNode(localTypeDefinitionStatementNode);
    }

    public T transform(BinaryExpressionNode binaryExpressionNode) {
        return transformSyntaxNode(binaryExpressionNode);
    }

    public T transform(BracedExpressionNode bracedExpressionNode) {
        return transformSyntaxNode(bracedExpressionNode);
    }

    public T transform(CheckExpressionNode checkExpressionNode) {
        return transformSyntaxNode(checkExpressionNode);
    }

    public T transform(FieldAccessExpressionNode fieldAccessExpressionNode) {
        return transformSyntaxNode(fieldAccessExpressionNode);
    }

    public T transform(FunctionCallExpressionNode functionCallExpressionNode) {
        return transformSyntaxNode(functionCallExpressionNode);
    }

    public T transform(MethodCallExpressionNode methodCallExpressionNode) {
        return transformSyntaxNode(methodCallExpressionNode);
    }

    public T transform(MappingConstructorExpressionNode mappingConstructorExpressionNode) {
        return transformSyntaxNode(mappingConstructorExpressionNode);
    }

    public T transform(MemberAccessExpressionNode memberAccessExpressionNode) {
        return transformSyntaxNode(memberAccessExpressionNode);
    }

    public T transform(TypeofExpressionNode typeofExpressionNode) {
        return transformSyntaxNode(typeofExpressionNode);
    }

    public T transform(UnaryExpressionNode unaryExpressionNode) {
        return transformSyntaxNode(unaryExpressionNode);
    }

    public T transform(ComputedNameFieldNode computedNameFieldNode) {
        return transformSyntaxNode(computedNameFieldNode);
    }

    public T transform(ConstantDeclarationNode constantDeclarationNode) {
        return transformSyntaxNode(constantDeclarationNode);
    }

    public T transform(DefaultableParameterNode defaultableParameterNode) {
        return transformSyntaxNode(defaultableParameterNode);
    }

    public T transform(RequiredParameterNode requiredParameterNode) {
        return transformSyntaxNode(requiredParameterNode);
    }

    public T transform(RestParameterNode restParameterNode) {
        return transformSyntaxNode(restParameterNode);
    }

    public T transform(ExpressionListItemNode expressionListItemNode) {
        return transformSyntaxNode(expressionListItemNode);
    }

    public T transform(ImportOrgNameNode importOrgNameNode) {
        return transformSyntaxNode(importOrgNameNode);
    }

    public T transform(ImportPrefixNode importPrefixNode) {
        return transformSyntaxNode(importPrefixNode);
    }

    public T transform(ImportSubVersionNode importSubVersionNode) {
        return transformSyntaxNode(importSubVersionNode);
    }

    public T transform(ImportVersionNode importVersionNode) {
        return transformSyntaxNode(importVersionNode);
    }

    public T transform(SpecificFieldNode specificFieldNode) {
        return transformSyntaxNode(specificFieldNode);
    }

    public T transform(SpreadFieldNode spreadFieldNode) {
        return transformSyntaxNode(spreadFieldNode);
    }

    public T transform(NamedArgumentNode namedArgumentNode) {
        return transformSyntaxNode(namedArgumentNode);
    }

    public T transform(PositionalArgumentNode positionalArgumentNode) {
        return transformSyntaxNode(positionalArgumentNode);
    }

    public T transform(RestArgumentNode restArgumentNode) {
        return transformSyntaxNode(restArgumentNode);
    }

    public T transform(ObjectTypeDescriptorNode objectTypeDescriptorNode) {
        return transformSyntaxNode(objectTypeDescriptorNode);
    }

    public T transform(RecordTypeDescriptorNode recordTypeDescriptorNode) {
        return transformSyntaxNode(recordTypeDescriptorNode);
    }

    public T transform(ReturnTypeDescriptorNode returnTypeDescriptorNode) {
        return transformSyntaxNode(returnTypeDescriptorNode);
    }

    public T transform(NilTypeDescriptorNode nilTypeDescriptorNode) {
        return transformSyntaxNode(nilTypeDescriptorNode);
    }

    public T transform(OptionalTypeDescriptorNode optionalTypeDescriptorNode) {
        return transformSyntaxNode(optionalTypeDescriptorNode);
    }

    public T transform(ObjectFieldNode objectFieldNode) {
        return transformSyntaxNode(objectFieldNode);
    }

    public T transform(RecordFieldNode recordFieldNode) {
        return transformSyntaxNode(recordFieldNode);
    }

    public T transform(RecordFieldWithDefaultValueNode recordFieldWithDefaultValueNode) {
        return transformSyntaxNode(recordFieldWithDefaultValueNode);
    }

    public T transform(RecordRestDescriptorNode recordRestDescriptorNode) {
        return transformSyntaxNode(recordRestDescriptorNode);
    }

    public T transform(TypeReferenceNode typeReferenceNode) {
        return transformSyntaxNode(typeReferenceNode);
    }

    public T transform(QualifiedIdentifierNode qualifiedIdentifierNode) {
        return transformSyntaxNode(qualifiedIdentifierNode);
    }

    public T transform(ServiceBodyNode serviceBodyNode) {
        return transformSyntaxNode(serviceBodyNode);
    }

    public T transform(AnnotationNode annotationNode) {
        return transformSyntaxNode(annotationNode);
    }

    public T transform(MetadataNode metadataNode) {
        return transformSyntaxNode(metadataNode);
    }

    public T transform(ModuleVariableDeclarationNode moduleVariableDeclarationNode) {
        return transformSyntaxNode(moduleVariableDeclarationNode);
    }

    public T transform(TypeTestExpressionNode typeTestExpressionNode) {
        return transformSyntaxNode(typeTestExpressionNode);
    }

    public T transform(ArrayTypeDescriptorNode arrayTypeDescriptorNode) {
        return transformSyntaxNode(arrayTypeDescriptorNode);
    }

    public T transform(RemoteMethodCallActionNode remoteMethodCallActionNode) {
        return transformSyntaxNode(remoteMethodCallActionNode);
    }

    public T transform(NilLiteralNode nilLiteralNode) {
        return transformSyntaxNode(nilLiteralNode);
    }

    // Tokens

    public T transform(Token token) {
        return null;
    }

    public T transform(IdentifierToken identifier) {
        return null;
    }

    // Misc

    // TODO Why Minutiae is in this visitor? Check on this.
    public T transform(Minutiae minutiae) {
        return transformSyntaxNode(minutiae);
    }

    /**
     * Transforms the given {@code Node} into an object of type T.
     * <p>
     * This method is invoked by each transform method in this class. You can
     * override it to provide a common transformation for each node.
     *
     * @param node the {@code Node} to be transformed
     * @return the transformed object
     */
    protected abstract T transformSyntaxNode(Node node);
}
