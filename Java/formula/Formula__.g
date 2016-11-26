lexer grammar Formula;
@header {
    package formula;
}

T8 : '[' ;
T9 : ']' ;
T10 : '=' ;
T11 : ',' ;
T12 : '-' ;
T13 : '+' ;
T14 : '<' ;
T15 : '>' ;
T16 : '<=' ;
T17 : '>=' ;
T18 : '==' ;
T19 : '!=' ;
T20 : 'and' ;
T21 : 'or' ;
T22 : '?' ;
T23 : ':' ;
T24 : '*' ;
T25 : '/' ;
T26 : '(' ;
T27 : ')' ;
T28 : 'sum' ;
T29 : 'min' ;
T30 : 'max' ;

// $ANTLR src "Formula.g" 99
ID      : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9' | '_')* 
        ;

// $ANTLR src "Formula.g" 102
NUMBER  : '0'..'9'+ | ('0'..'9')*'.'('0'..'9')+
        ;

// $ANTLR src "Formula.g" 105
NEWLINE : '\r'? '\n' 
        ; 

// $ANTLR src "Formula.g" 108
WS      : (' '|'\t')+ {skip();} 
        ;
