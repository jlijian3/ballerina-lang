// Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// ========================== Basics ==========================

function testValueTypeInUnion() returns string {
    int|string x = 5;
    if (x is int) {
        int y = x;
        return "int: " + string.convert(y);
    } else {
        return "string";
    }
}

type A record {
    string a;
};

type B record {
    string b;
    string c;
};

function testSimpleRecordTypes_1() returns string {
    A x = {a:"foo"};
    any y = x;
     if (y is A) {
        return y.a;
    } else if (y is B) {
        return y.b + "-" + y.c;
    }

    return "n/a";
}

function testSimpleRecordTypes_2() returns string {
    B x = {b:"foo", c:"bar"};
    any y = x;
     if (y is A) {
        return y.a;
    } else if (y is B) {
        return y.b + "-" + y.c;
    }

    return "n/a";
}

function testSimpleTernary() returns string {
    any a = "hello";
    return a is string ? a : "not a string";
}

function testMultipleTypeGuardsWithAndOperator() returns int {
    int|string x = 5;
    any y = 7;
    if (x is int && y is int) {
        return x + y;
    } else {
        return -1;
    }
}

function testMultipleTypeGuardsWithAndOperatorInTernary() returns int {
    int|string x = 5;
    any y = 7;
    return (x is int && y is int) ? x + y  : -1;
}

function testTypeGuardInElse_1() returns string {
    int|string x = 5;
    if (x is int) {
        int y = x;
        return "int: " + string.convert(y);
    } else {
        return "string";
    }
}

function testTypeGuardInElse_2() returns string {
    int|string|float|boolean x = true;
    if (x is int) {
        int y = x;
        return "int: " + string.convert(y);
    } else if (x is string) {
        return "string: " + x;
    } else if (x is float) {
        float y = x;
        return "float: " + string.convert(y);
    } else {
        boolean b = x;
        return "boolean: " + string.convert(b);
    }
}

function testTypeGuardInElse_3() returns string {
    int|string|float|boolean x = true;
    int|string|float|boolean y = false;
    if (x is int|string) {
        if (y is string) {
            return "y is string: " + y;
        } else if (y is int) {
            int i = y;
            return "y is float: " + string.convert(i);
        } else {
            return "x is int|string";
        }
    } else if (x is float) {
        float f = x;
        return "float: " + string.convert(f);
    } else {
        if (y is int) {
            int i = y;
            return "x is boolean and y is int: " + string.convert(i);
        } else if (y is string) {
            return "x is boolean and y is string: " + y;
        } else if (y is float) {
            float f = y;
            return "x is boolean and y is float: " + string.convert(f);
        } else {
            boolean b = y;
            return "x is boolean and y is boolean: " + string.convert(b);
        }
    }
}

function testTypeGuardInElse_4() returns string {
    int|string|float|boolean x = true;
    int|string|float|boolean y = false;
    string val = "1st round: ";
    if (x is int|string) {
        if (y is string) {
            val += "y is string: " + y;
        } else if (y is int) {
            int i = y;
            val += "y is float: " + string.convert(i);
        } else {
            val += "x is int|string";
        }
    } else if (x is float) {
        float f = x;
        val += "float: " + string.convert(f);
    } else {
        if (y is int) {
            int i = y;
            val += "x is boolean and y is int: " + string.convert(i);
        } else if (y is string) {
            val += "x is boolean and y is string: " + y;
        } else if (y is float) {
            float f = y;
            val += "x is boolean and y is float: " + string.convert(f);
        } else {
            boolean b = y;
            val += "x is boolean and y is boolean: " + string.convert(b);
        }
    }

    val += " | 2nd round: ";
    if (x is int|string) {
        if (y is string) {
            val += "y is string: " + y;
        } else if (y is int) {
            int i = y;
            val += "y is float: " + string.convert(i);
        } else {
            val += "x is int|string";
        }
    } else if (x is float) {
        float f = x;
        val += "float: " + string.convert(f);
    } else {
        if (y is int) {
            int i = y;
            val += "x is boolean and y is int: " + string.convert(i);
        } else if (y is string) {
            val += "x is boolean and y is string: " + y;
        } else if (y is float) {
            float f = y;
            val += "x is boolean and y is float: " + string.convert(f);
        } else {
            boolean b = y;
            val += "x is boolean and y is boolean: " + string.convert(b);
        }
    }

    return val;
}

function testTypeGuardInElse_5() returns string {
    int|string|float|boolean x = 5;
    if (x is int|string) {
        if (x is string) {
            return "x is string: " + x;
        } else {
            int i = x;
            return "x is int: " + string.convert(i);
        }
    } else if (x is float) {
        float f = x;
        return "float: " + string.convert(f);
    } else {
        return "x is boolean: " + string.convert(x);
    }
}

function testTypeGuardInElse_6() returns string {
    int|string|table<record {}> x = 5;
    if (x is table<record {}>) {
        table<record {}> t = x;
        return "table";
    } else {
        int|string y = x;
        if (y is string) {
            string s = y;
            return "string: " + y;
        } else {
            int i = y;
            return "int: " + i;
        }
    }
}

function testTypeGuardInElse_7() returns string {
    int|string|table<A> x = 5;
    if (x is table<A>) {
        table<A> t = x;
        return "table";
    } else {
        int|string y = x;
        if (y is string) {
            string s = y;
            return "string: " + y;
        } else {
            int i = y;
            return "int: " + i;
        }
    }
}

function testComplexTernary_1() returns string {
    int|string|float|boolean|int[] x = "string";
    return x is int ? "int" : (x is float ? "float" : (x is boolean ? "boolean" : (x is int[] ? "int[]" : x)));
}

function testComplexTernary_2() returns string {
    int|string|float|boolean|xml x = "string";
    if (x is int|string|float|boolean) {
        return x is int ? "int" : (x is float ? "float" : (x is boolean ? "boolean" : x));
    } else {
        xml y = x;
        return "xml";
    }
}

function testArray() returns int {
    int [] intArr = [10, 20];
    any[] arr = intArr;
    if (arr is int[]) {
        return arr[1];
    } else {
        return -1;
    }
}

function testUpdatingGuardedVar_1() returns string {
    any value = "BALLERINA";
    if (value is int|string|float) {
        if (value is string) {
         value = value + " - updated";
        } else {
            return "an int or float";
        }
    } else {
        return "some other type";
    }

    return string.convert(value);
}

function testUpdatingGuardedVar_2() returns string {
    any value = "BALLERINA";
    if (!(value is int|string|float)) {
        return "some other type";
    } else {
        if (value is string) {
            value = value + " - updated once";
            value = getUpdatedString(value);
        } else {
            return "an int or float";
        }
    }

    return string.convert(value);
}

function getUpdatedString(string s) returns string {
    return s + " - updated via function";
}

type func function() returns boolean;
int fPtrFlag = 0;

function testFuncPtrTypeInferenceInElseGuard() returns (boolean, int) {
    func? f = function () returns boolean {
        fPtrFlag = 100;
        return true;
    };

    if (f is ()) {
        return (false, fPtrFlag);
    } else {
        return (f.call(), fPtrFlag);
    }
}

function testTypeGuardNegation(int|string|boolean x) returns string {
    if!(x is int) {
        if !(x is string) {
            boolean y = x;
            return "boolean: " + y;
        } else {
            string y = x;
            return "string: " + y;
        }
    } else {
        int y = x;
        return "int: " + x;
    }
}

function testTypeGuardsWithBinaryOps(int|string|boolean|float x) returns string {
    if ((x is int|string && x is int) || (x is boolean)) {
        if (x is boolean) {
            boolean y = x;
            return "boolean: " + y;
        } else {
            int y = x;
            return "int: " + y;
        }
    } else {
        if (x is float) {
            float y = x;
            return "float: " + y;
        } else {
            string y = x;
            return "string: " + y;
        }
    }
}

type Person record {
    string name;
    int age;
};

type Student record {
    *Person;
    float gpa;
};

function testTypeGuardsWithRecords_1() returns string {
    Student s = {name:"John", age:20, gpa:3.5};
    Person|Student|string x = s;

    if (x is Person) {
        Person y = x;
        return y.name;
    } else {
        string y = x;
        return y;
    }
}

function testTypeGuardsWithRecords_2() returns string {
    Student s = {name:"John", age:20, gpa:3.5};
    Person|Student|string x = s;

    if (x is Student) {
        Student y = x;
        return "student: " + y.name;
    } else if (x is Person) {
        Person y = x;
        return "person: " + y.name;
    } else {
        string y = x;
        return y;
    }
}

public type CustomError error<string, record { int status = 500; }>;

function testTypeGuardsWithError() returns string {
    CustomError err = error("some error", {});
    any|error e = err;
    if (e is error) {
        if (e is CustomError) {
            CustomError ce = e;
            return "status: " + ce.detail().status;
        } else {
            return "not a custom error";
        }
    } else {
        return "not an error";
    }
}

function testTypeGuardsWithErrorInmatch() returns string {
    error e = error("some error");
    any|error x = e;
    match x {
        var p if p is error => return string `${p.reason()}`;
        var p => return "Internal server error";
    }
}


function testTypeNarrowingWithClosures() returns string {
    int|string x = 8;
    if (x is string) {
        return "string: "+ x;
    } else {
        var y = function() returns int {
                    if (x is int) {
                        return x;
                    } else {
                        return -1;
                    }
                };
        return "int: "+ y.call();
    }
}

function testTypeGuardsWithBinaryAnd(string|int x) returns string {
    if (x is int && x < 5) {
        return "int: " + x + " is < 5";
    } else if (x is int) {
        return "int: " + x + " is >= 5";
    } else {
        return "string: " + x;
    }
}

function testTypeGuardsWithBinaryOpsInTernary(int|string|boolean|float x) returns string {
    return ((x is int|string && x is int) || (x is boolean)) ?
            (x is boolean ? booleanToString(x) : intToString(x)) :
            (x is float ? floatToString(x) : "string: " + x);
}

function booleanToString(boolean a) returns string {
    return "boolean: " + a;
}

function intToString(int a) returns string {
    return "int: " + a;
}

function floatToString(float a) returns string {
    return "float: " + a;
}

public function testUpdatingTypeNarrowedVar_1() returns string {
    int|string|boolean x = 5;
    if (x is int|boolean) {
        x = "hello";   // update the var with a type outside of narrowed types
        if (x is int) {
            int z = x;
            return "int: " + z;
        } else if (x is string) {
            string z = x;
            return "string: " + z;
        } else {
            boolean z = x;
            return "boolean: " + z;
        }
    } else {
        string z = x;
        return "outer string: " + z;
    }
}

public function testUpdatingTypeNarrowedVar_2(int|string|boolean a) returns string {
    int|string|boolean x = a;
    if (x is int) {
        if (x > 5) {
            x = -1;
        }
        int z = x;
        return "int: " + z;
    }

    return "not an int";
}

public function testUpdatingTypeNarrowedVar_3() returns string {
    int|string|boolean x = 5;
    if (x is int|boolean) {
        if (x is int) {
            x = "hello";   // update the var with a type outside of narrowed types
        }

        if (x is int) {
            int z = x;
            return "int: " + z;
        } else if (x is string) {
            string z = x;
            return "string: " + z;
        } else {
            boolean z = x;
            return "boolean: " + z;
        }
    } else {
        string z = x;
        return "outer string: " + z;
    }
}

error e1 = error("e1");
error e2 = error("e2");
error? errorW1 = e1;
error? errorW2 = e2;

function testTypeGuardForGlobalVars() returns (string, string) {
    string w1ErrMsg = "";
    string w2ErrMsg = "";
    if (errorW1 is error) {
        w1ErrMsg = errorW1.reason();
    }
    if (errorW2 is error) {
        w2ErrMsg = errorW2.reason();
    }
    return (w1ErrMsg, w2ErrMsg);
}

int|string|boolean global_x = 5;

public function testUpdatingTypeNarrowedGlobalVar() returns string {
    if (global_x is int|boolean) {
        if (global_x is int) {
            global_x = "hello";   // update the var with a type outside of narrowed types
        }

        if (global_x is int) {
            int z = global_x;
            return "int: " + z;
        } else if (global_x is string) {
            string z = global_x;
            return "string: " + z;
        } else {
            boolean z = global_x;
            return "boolean: " + z;
        }
    } else {
        string z = global_x;
        return "outer string: " + z;
    }
}

type FooBarOneTwoTrue "foo"|"bar"|1|2.0|true;
type FooBar "foo"|"bar";
type OneTwo 1|2.0;

function testFiniteTypeAsBroaderTypes_1() returns boolean {
    FooBarOneTwoTrue f = "foo";
    boolean equals = finiteTypeAsBroaderTypesHelper(f) == "string: foo";

    f = "bar";
    return equals && finiteTypeAsBroaderTypesHelper(f) == "string: bar";
}

function testFiniteTypeAsBroaderTypes_2() returns boolean {
    FooBarOneTwoTrue f = 1;
    return finiteTypeAsBroaderTypesHelper(f) == "int: 1";
}

function testFiniteTypeAsBroaderTypes_3() returns boolean {
    FooBarOneTwoTrue f = 2.0;
    return finiteTypeAsBroaderTypesHelper(f) == "float: 2.0";
}

function testFiniteTypeAsBroaderTypes_4() returns boolean {
    FooBarOneTwoTrue f = true;
    return finiteTypeAsBroaderTypesHelper(f) == "boolean: true";
}

function finiteTypeAsBroaderTypesHelper(FooBarOneTwoTrue f) returns string {
    if (f is string) {
        match f {
            "foo" => return "string: foo";
            "bar" => return "string: bar";
        }
        return "expected foo or bar!";
    } else {
        if (f is int|float) {
            int|float ot = f;
            if (ot is int) {
                int i = ot;
                return string `int: ${i}`;
            } else {
                float fl = ot;
                return string `float: ${fl}`;
            }
        } else {
            boolean b = f;
            return string `boolean: ${b}`;
        }
    }
}

function testFiniteTypeAsBroaderTypesAndFiniteType_1() returns boolean {
    FooBarOneTwoTrue f = "foo";
    boolean equals = finiteTypeAsBroaderTypesAndFiniteTypeHelper(f) == "string: foo";

    f = "bar";
    return equals && finiteTypeAsBroaderTypesAndFiniteTypeHelper(f) == "string: bar";
}

function testFiniteTypeAsBroaderTypesAndFiniteType_2() returns boolean {
    FooBarOneTwoTrue f = 1;
    return finiteTypeAsBroaderTypesAndFiniteTypeHelper(f) == "int: 1";
}

function testFiniteTypeAsBroaderTypesAndFiniteType_3() returns boolean {
    FooBarOneTwoTrue f = 2.0;
    return finiteTypeAsBroaderTypesAndFiniteTypeHelper(f) == "float: 2.0";
}

function testFiniteTypeAsBroaderTypesAndFiniteType_4() returns boolean {
    FooBarOneTwoTrue f = true;
    return finiteTypeAsBroaderTypesAndFiniteTypeHelper(f) == "boolean: true";
}

function finiteTypeAsBroaderTypesAndFiniteTypeHelper(FooBarOneTwoTrue f) returns string {
    if (f is string) {
        FooBar fb = f;
        match fb {
            "foo" => return "string: foo";
            "bar" => return "string: bar";
        }
        return "expected foo or bar!";
    } else {
        if (f is OneTwo) {
            OneTwo ot = f;
            if (ot is int) {
                int i = ot;
                return string `int: ${i}`;
            } else {
                float fl = ot;
                return string `float: ${fl}`;
            }
        } else {
            boolean b = f;
            return string `boolean: ${b}`;
        }
    }
}

type FooBarOneTwoBoolean "foo"|"bar"|1|2.0|boolean;
type FooBarBaz "foo"|"bar"|"baz";
type FooBarInt "foo"|"bar"|int;

function testFiniteTypeAsComplexFiniteTypes_1() returns boolean {
    FooBarOneTwoBoolean f = "foo";
    (string, FooBarBaz|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperOne(f);
    return s == "FooBarBaz" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_2() returns boolean {
    FooBarOneTwoBoolean f = 2.0;
    (string, FooBarBaz|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperOne(f);
    return s == "OneTwo" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_3() returns boolean {
    FooBarOneTwoBoolean f = true;
    (string, FooBarBaz|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperOne(f);
    return s == "boolean" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_4() returns boolean {
    FooBarOneTwoBoolean f = "bar";
    (string, FooBarInt|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperTwo(f);
    return s == "FooBarInt" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_5() returns boolean {
    FooBarOneTwoBoolean f = 1;
    (string, FooBarInt|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperTwo(f);
    return s == "FooBarInt" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_6() returns boolean {
    FooBarOneTwoBoolean f = 2.0;
    (string, FooBarInt|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperTwo(f);
    return s == "OneTwo" && f == v;
}

function testFiniteTypeAsComplexFiniteTypes_7() returns boolean {
    FooBarOneTwoBoolean f = false;
    (string, FooBarInt|OneTwo|boolean) (s, v) = finiteTypeAsComplexFiniteTypesHelperTwo(f);
    return s == "boolean" && f == v;
}

function finiteTypeAsComplexFiniteTypesHelperOne(FooBarOneTwoBoolean f) returns (string, FooBarBaz|OneTwo|boolean) {
    if (f is FooBarBaz) {
        FooBarBaz x = f;
        return ("FooBarBaz", x);
    } else {
        if (f is OneTwo) {
            OneTwo x = f;
            return ("OneTwo", x);
        } else {
            boolean x = f;
            return ("boolean", x);
        }
    }
}

function finiteTypeAsComplexFiniteTypesHelperTwo(FooBarOneTwoBoolean f) returns (string, FooBarInt|OneTwo|boolean) {
    if (f is FooBarInt) {
        FooBarInt x = f;
        return ("FooBarInt", x);
    } else {
        if (f is OneTwo) {
            OneTwo x = f;
            return ("OneTwo", x);
        } else {
            boolean x = f;
            return ("boolean", x);
        }
    }
}

function testTypeNarrowingForIntersectingDirectUnion_1() returns boolean {
    string s = "hello world";
    string|typedesc st = s;
    if (st is string|boolean) {
        string s2 = st;
        return s2 == s;
    }
    return false;
}

function testTypeNarrowingForIntersectingDirectUnion_2() returns boolean {
    xml x = xml `Hello World`;
    string|xml st = x;
    if (st is string|boolean) {
        return true;
    } else {
        xml t2 = st;
        return t2 == x;
    }
}

function testTypeNarrowingForIntersectingAssignableUnion_1() returns boolean {
    string s = "hello world";
    string|typedesc st = s;
    if (st is json|xml) {
        string s2 = st;
        return s2 == s;
    }
    return false;
}

function testTypeNarrowingForIntersectingAssignableUnion_2() returns boolean {
    record{} t = { name: "Maryam" };
    string|record{} st = t;
    if (st is json|xml) {
        return true;
    } else {
        record{} t2 = st;
        return t2 == t;
    }
}
