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
 * Define various kinds of syntax tree nodes, tokens and minutiae.
 *
 * @since 2.0.0
 */
public enum SyntaxKind {

    // Keywords

    PUBLIC_KEYWORD(50, "public"),
    PRIVATE_KEYWORD(51, "private"),
    REMOTE_KEYWORD(52, "remote"),
    ABSTRACT_KEYWORD(53, "abstract"),
    CLIENT_KEYWORD(54, "client"),
    IMPORT_KEYWORD(100, "import"),
    FUNCTION_KEYWORD(101, "function"),
    CONST_KEYWORD(102, "const"),
    LISTENER_KEYWORD(103, "listener"),
    SERVICE_KEYWORD(104, "service"),
    XMLNS_KEYWORD(105, "xmlns"),
    ANNOTATION_KEYWORD(106, "annotation"),
    TYPE_KEYWORD(107, "type"),
    RECORD_KEYWORD(108, "record"),
    OBJECT_KEYWORD(109, "object"),
    VERSION_KEYWORD(110, "version"),
    AS_KEYWORD(111, "as"),
    ON_KEYWORD(112, "on"),
    RESOURCE_KEYWORD(113, "resource"),
    FINAL_KEYWORD(114, "final"),
    SOURCE_KEYWORD(115, "source"),
    WORKER_KEYWORD(117, "worker"),
    PARAMETER_KEYWORD(118, "parameter"),
    FIELD_KEYWORD(119, "field"),

    RETURNS_KEYWORD(200, "returns"),
    RETURN_KEYWORD(201, "return"),
    EXTERNAL_KEYWORD(202, "external"),
    TRUE_KEYWORD(203, "true"),
    FALSE_KEYWORD(204, "false"),
    IF_KEYWORD(205, "if"),
    ELSE_KEYWORD(206, "else"),
    WHILE_KEYWORD(207, "while"),
    CHECK_KEYWORD(208, "check"),
    CHECKPANIC_KEYWORD(209, "checkpanic"),
    PANIC_KEYWORD(210, "panic"),
    CONTINUE_KEYWORD(211, "continue"),
    BREAK_KEYWORD(212, "break"),
    TYPEOF_KEYWORD(213, "typeof"),
    IS_KEYWORD(214, "is"),
    NULL_KEYWORD(215, "null"),
    LOCK_KEYWORD(216, "lock"),
    FORK_KEYWORD(217, "fork"),
    TRAP_KEYWORD(218, "trap"),
    IN_KEYWORD(219, "in"),
    FOREACH_KEYWORD(220, "foreach"),
    TABLE_KEYWORD(221, "table"),
    KEY_KEYWORD(222, "key"),
    LET_KEYWORD(223, "let"),
    NEW_KEYWORD(224, "new"),
    FROM_KEYWORD(225, "from"),
    WHERE_KEYWORD(226, "where"),
    SELECT_KEYWORD(227, "select"),
    START_KEYWORD(228, "start"),
    FLUSH_KEYWORD(229, "flush"),
    DEFAULT_KEYWORD(230, "default"),
    WAIT_KEYWORD(231, "wait"),
    DO_KEYWORD(232, "do"),
    TRANSACTION_KEYWORD(233, "transaction"),
    TRANSACTIONAL_KEYWORD(234, "transactional"),
    COMMIT_KEYWORD(235, "commit"),
    ROLLBACK_KEYWORD(236, "rollback"),
    RETRY_KEYWORD(237, "retry"),
    ENUM_KEYWORD(238, "enum"),
    BASE16_KEYWORD(239, "base16"),
    BASE64_KEYWORD(240, "base64"),

    // Type keywords
    INT_KEYWORD(250, "int"),
    BYTE_KEYWORD(251, "byte"),
    FLOAT_KEYWORD(252, "float"),
    DECIMAL_KEYWORD(253, "decimal"),
    STRING_KEYWORD(254, "string"),
    BOOLEAN_KEYWORD(255, "boolean"),
    XML_KEYWORD(256, "xml"),
    JSON_KEYWORD(257, "json"),
    HANDLE_KEYWORD(258, "handle"),
    ANY_KEYWORD(259, "any"),
    ANYDATA_KEYWORD(260, "anydata"),
    NEVER_KEYWORD(261, "never"),
    VAR_KEYWORD(262, "var"),
    MAP_KEYWORD(263, "map"),
    FUTURE_KEYWORD(264, "future"),
    TYPEDESC_KEYWORD(265, "typedesc"),
    ERROR_KEYWORD(266, "error"),
    STREAM_KEYWORD(267, "stream"),
    READONLY_KEYWORD(268, "readonly"),
    DISTINCT_KEYWORD(269, "distinct"),

    // Separators
    OPEN_BRACE_TOKEN(500, "{"),
    CLOSE_BRACE_TOKEN(501, "}"),
    OPEN_PAREN_TOKEN(502, "("),
    CLOSE_PAREN_TOKEN(503, ")"),
    OPEN_BRACKET_TOKEN(504, "["),
    CLOSE_BRACKET_TOKEN(505, "]"),
    SEMICOLON_TOKEN(506, ";"),
    DOT_TOKEN(507, "."),
    COLON_TOKEN(508, ":"),
    COMMA_TOKEN(509, ","),
    ELLIPSIS_TOKEN(510, "..."),
    OPEN_BRACE_PIPE_TOKEN(511, "{|"),
    CLOSE_BRACE_PIPE_TOKEN(512, "|}"),
    AT_TOKEN(513, "@"),
    HASH_TOKEN(514, "#"),
    BACKTICK_TOKEN(515, "`"),
    DOUBLE_QUOTE_TOKEN(516, "\""),
    SINGLE_QUOTE_TOKEN(517, "'"),

    // Operators
    EQUAL_TOKEN(550, "="),
    DOUBLE_EQUAL_TOKEN(551, "=="),
    TRIPPLE_EQUAL_TOKEN(552, "==="),
    PLUS_TOKEN(553, "+"),
    MINUS_TOKEN(554, "-"),
    SLASH_TOKEN(555, "/"),
    PERCENT_TOKEN(556, "%"),
    ASTERISK_TOKEN(557, "*"),
    LT_TOKEN(558, "<"),
    LT_EQUAL_TOKEN(559, "<="),
    GT_TOKEN(560, ">"),
    RIGHT_DOUBLE_ARROW_TOKEN(561, "=>"),
    QUESTION_MARK_TOKEN(562, "?"),
    PIPE_TOKEN(563, "|"),
    GT_EQUAL_TOKEN(564, ">="),
    EXCLAMATION_MARK_TOKEN(565, "!"),
    NOT_EQUAL_TOKEN(566, "!="),
    NOT_DOUBLE_EQUAL_TOKEN(567, "!=="),
    BITWISE_AND_TOKEN(568, "&"),
    BITWISE_XOR_TOKEN(569, "^"),
    LOGICAL_AND_TOKEN(570, "&&"),
    LOGICAL_OR_TOKEN(571, "||"),
    NEGATION_TOKEN(572, "~"),
    RIGHT_ARROW_TOKEN(573, "->"),
    INTERPOLATION_START_TOKEN(574, "${"),
    XML_PI_START_TOKEN(575, "<?"),
    XML_PI_END_TOKEN(576, "?>"),
    XML_COMMENT_START_TOKEN(577, "<!--"),
    XML_COMMENT_END_TOKEN(578, "-->"),
    SYNC_SEND_TOKEN(579, "->>"),
    LEFT_ARROW_TOKEN(580, "<-"),
    DOUBLE_DOT_LT_TOKEN(580, "..<"),
    DOUBLE_LT_TOKEN(581, "<<"),
    ANNOT_CHAINING_TOKEN(582, ".@"),
    OPTIONAL_CHAINING_TOKEN(583, "?."),
    ELVIS_TOKEN(584, "?:"),
    DOT_LT_TOKEN(585, ".<"),
    SLASH_LT_TOKEN(586, "/<"),
    DOUBLE_SLASH_DOUBLE_ASTERISK_LT_TOKEN(587, "/**/<"),
    SLASH_ASTERISK_TOKEN(588, "/*"),

    IDENTIFIER_TOKEN(1000),
    STRING_LITERAL(1001),
    DECIMAL_INTEGER_LITERAL(1002),
    HEX_INTEGER_LITERAL(1003),
    DECIMAL_FLOATING_POINT_LITERAL(1004),
    HEX_FLOATING_POINT_LITERAL(1005),
    XML_TEXT_CONTENT(1006),
    TEMPLATE_STRING(1007),

    // Minutiae kinds
    WHITESPACE_MINUTIAE(1500),
    END_OF_LINE_MINUTIAE(1501),
    COMMENT_MINUTIAE(1502),
    DOCUMENTATION_LINE(1503),
    INVALID_NODE_MINUTIAE(1504),

    // module-level declarations
    IMPORT_DECLARATION(2000),
    FUNCTION_DEFINITION(2001),
    TYPE_DEFINITION(2002),
    SERVICE_DECLARATION(2003),
    MODULE_VAR_DECL(2004),
    LISTENER_DECLARATION(2005),
    CONST_DECLARATION(2006),
    ANNOTATION_DECLARATION(2007),
    MODULE_XML_NAMESPACE_DECLARATION(2008),
    ENUM_DECLARATION(2009),

    // Statements
    BLOCK_STATEMENT(1200),
    LOCAL_VAR_DECL(1201),
    ASSIGNMENT_STATEMENT(1202),
    IF_ELSE_STATEMENT(1203),
    ELSE_BLOCK(1204),
    WHILE_STATEMENT(1205),
    CALL_STATEMENT(1206),
    PANIC_STATEMENT(1207),
    RETURN_STATEMENT(1208),
    CONTINUE_STATEMENT(1209),
    BREAK_STATEMENT(1210),
    COMPOUND_ASSIGNMENT_STATEMENT(1211),
    LOCAL_TYPE_DEFINITION_STATEMENT(1212),
    ACTION_STATEMENT(1213),
    LOCK_STATEMENT(1214),
    NAMED_WORKER_DECLARATION(1215),
    FORK_STATEMENT(1216),
    FOREACH_STATEMENT(1217),
    TRANSACTION_STATEMENT(1218),
    ROLLBACK_STATEMENT(1219),
    RETRY_STATEMENT(1220),
    XML_NAMESPACE_DECLARATION(1221),

    // Expressions
    BINARY_EXPRESSION(1300),
    BRACED_EXPRESSION(1301),
    FUNCTION_CALL(1302),
    QUALIFIED_NAME_REFERENCE(1303),
    INDEXED_EXPRESSION(1304),
    FIELD_ACCESS(1305),
    METHOD_CALL(1306),
    CHECK_EXPRESSION(1307),
    MAPPING_CONSTRUCTOR(1308),
    TYPEOF_EXPRESSION(1309),
    UNARY_EXPRESSION(1310),
    TYPE_TEST_EXPRESSION(1311),
    BASIC_LITERAL(1312),
    SIMPLE_NAME_REFERENCE(1313),
    TRAP_EXPRESSION(1314),
    LIST_CONSTRUCTOR(1315),
    TYPE_CAST_EXPRESSION(1316),
    TABLE_CONSTRUCTOR(1317),
    LET_EXPRESSION(1318),
    XML_TEMPLATE_EXPRESSION(1319),
    RAW_TEMPLATE_EXPRESSION(1320),
    STRING_TEMPLATE_EXPRESSION(1321),
    IMPLICIT_NEW_EXPRESSION(1322),
    EXPLICIT_NEW_EXPRESSION(1323),
    PARENTHESIZED_ARG_LIST(1324),
    EXPLICIT_ANONYMOUS_FUNCTION_EXPRESSION(1325),
    IMPLICIT_ANONYMOUS_FUNCTION_EXPRESSION(1326),
    QUERY_EXPRESSION(1327),
    ANNOT_ACCESS(1328),
    OPTIONAL_FIELD_ACCESS(1329),
    CONDITIONAL_EXPRESSION(1330),
    TRANSACTIONAL_EXPRESSION(1331),
    SERVICE_CONSTRUCTOR_EXPRESSION(1332),
    XML_FILTER_EXPRESSION(1333),
    XML_STEP_EXPRESSION(1334),
    XML_NAME_PATTERN_CHAIN(1335),
    XML_ATOMIC_NAME_PATTERN(1336),

    // Type descriptors
    TYPE_DESC(2000),
    RECORD_TYPE_DESC(2001),
    OBJECT_TYPE_DESC(2002),
    NIL_TYPE_DESC(2003),
    OPTIONAL_TYPE_DESC(2004),
    ARRAY_TYPE_DESC(2005),
    INT_TYPE_DESC(2006),
    BYTE_TYPE_DESC(2007),
    FLOAT_TYPE_DESC(2008),
    DECIMAL_TYPE_DESC(2009),
    STRING_TYPE_DESC(2010),
    BOOLEAN_TYPE_DESC(2011),
    XML_TYPE_DESC(2012),
    JSON_TYPE_DESC(2013),
    HANDLE_TYPE_DESC(2014),
    ANY_TYPE_DESC(2015),
    ANYDATA_TYPE_DESC(2016),
    NEVER_TYPE_DESC(2017),
    VAR_TYPE_DESC(2018),
    SERVICE_TYPE_DESC(2019),
    PARAMETERIZED_TYPE_DESC(2020),
    UNION_TYPE_DESC(2021),
    ERROR_TYPE_DESC(2022),
    STREAM_TYPE_DESC(2023),
    TABLE_TYPE_DESC(2024),
    FUNCTION_TYPE_DESC(2025),
    TUPLE_TYPE_DESC(2026),
    PARENTHESISED_TYPE_DESC(2027),
    READONLY_TYPE_DESC(2028),
    DISTINCT_TYPE_DESC(2029),
    INTERSECTION_TYPE_DESC(2030),
    SINGLETON_TYPE_DESC(2031),
    TYPE_REFERENCE_TYPE_DESC(2032),

    // Actions
    REMOTE_METHOD_CALL_ACTION(2500),
    BRACED_ACTION(2501),
    CHECK_ACTION(2502),
    START_ACTION(2503),
    TRAP_ACTION(2504),
    FLUSH_ACTION(2505),
    ASYNC_SEND_ACTION(2506),
    SYNC_SEND_ACTION(2507),
    RECEIVE_ACTION(2508),
    WAIT_ACTION(2509),
    QUERY_ACTION(2510),
    COMMIT_ACTION(2511),

    // Other
    RETURN_TYPE_DESCRIPTOR(3000),
    REQUIRED_PARAM(3001),
    DEFAULTABLE_PARAM(3002),
    REST_PARAM(3003),
    EXTERNAL_FUNCTION_BODY(3004),
    RECORD_FIELD(3005),
    RECORD_FIELD_WITH_DEFAULT_VALUE(3006),
    TYPE_REFERENCE(3007),
    RECORD_REST_TYPE(3008),
    POSITIONAL_ARG(3009),
    NAMED_ARG(3010),
    REST_ARG(3011),
    OBJECT_FIELD(3012),
    IMPORT_ORG_NAME(3013),
    MODULE_NAME(3014),
    SUB_MODULE_NAME(3015),
    IMPORT_VERSION(3016),
    IMPORT_SUB_VERSION(3017),
    IMPORT_PREFIX(3018),
    SPECIFIC_FIELD(3019),
    COMPUTED_NAME_FIELD(3020),
    SPREAD_FIELD(3021),
    EXPRESSION_LIST_ITEM(3022),
    SERVICE_BODY(3023),
    ANNOTATION(3024),
    METADATA(3025),
    ARRAY_DIMENSION(3026),
    NIL_LITERAL(3027),
    ANNOTATION_ATTACH_POINT(3028),
    FUNCTION_BODY_BLOCK(3029),
    NAMED_WORKER_DECLARATOR(3030),
    EXPRESSION_FUNCTION_BODY(3031),
    DOCUMENTATION_STRING(3032),
    TYPE_CAST_PARAM(3033),
    KEY_SPECIFIER(3034),
    EXPLICIT_TYPE_PARAMS(3035),
    ERROR_TYPE_PARAMS(3036),
    LET_VAR_DECL(3037),
    STREAM_TYPE_PARAMS(3038),
    FUNCTION_SIGNATURE(3039),
    INFER_PARAM_LIST(3040),
    TYPE_PARAMETER(3041),
    KEY_TYPE_CONSTRAINT(3042),
    QUERY_CONSTRUCT_TYPE(3043),
    FROM_CLAUSE(3044),
    WHERE_CLAUSE(3045),
    LET_CLAUSE(3046),
    QUERY_PIPELINE(3047),
    SELECT_CLAUSE(3048),
    METHOD_DECLARATION(3049),
    TYPED_BINDING_PATTERN(3050),
    BINDING_PATTERN(3051),
    CAPTURE_BINDING_PATTERN(3052),
    REST_BINDING_PATTERN(3053),
    LIST_BINDING_PATTERN(3054),
    RECEIVE_FIELDS(3055),
    REST_TYPE(3056),
    DOUBLE_GT_TOKEN(3056, ">>"),
    TRIPPLE_GT_TOKEN(3057, ">>>"),
    WAIT_FIELDS_LIST(3058),
    WAIT_FIELD(3059),
    ENUM_MEMBER(3060),
    BRACKETED_LIST(3061),
    LIST_BP_OR_LIST_CONSTRUCTOR(3062),
    BYTE_ARRAY_LITERAL(3063),
    MAPPING_BINDING_PATTERN(3064),
    FIELD_BINDING_PATTERN(3065),
    MAPPING_BP_OR_MAPPING_CONSTRUCTOR(3066),
    WILDCARD_BINDING_PATTERN(3067),

    // XML
    XML_ELEMENT(4000),
    XML_EMPTY_ELEMENT(4001),
    XML_TEXT(4002),
    XML_COMMENT(4003),
    XML_PI(4004),
    XML_ELEMENT_START_TAG(4005),
    XML_ELEMENT_END_TAG(4006),
    XML_SIMPLE_NAME(4007),
    XML_QUALIFIED_NAME(4008),
    XML_ATTRIBUTE(4009),
    XML_ATTRIBUTE_VALUE(4010),
    INTERPOLATION(4011),

    INVALID(4),
    MODULE_PART(3),
    EOF_TOKEN(2),
    LIST(1),
    NONE(0);

    final int tag;
    final String strValue;

    SyntaxKind(int tag, String strValue) {
        this.tag = tag;
        this.strValue = strValue;
    }

    SyntaxKind(int tag) {
        this.tag = tag;
        this.strValue = "";
    }

    public String stringValue() {
        return strValue;
    }
}
