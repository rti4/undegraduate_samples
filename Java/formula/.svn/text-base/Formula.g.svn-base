grammar Formula;

@lexer::header {
    package formula;
}   

@header {
    package formula;
}

@members {
    String lefthand_id;
    String righthand_id;
    void checkIndex(String n, int line, int pos) {
        if (!n.matches("[0-9]+"))
            System.out.printf("line \%d:\%d \%s must be an integer row reference\n", line, pos, n);
    }

    void checkIdMatch(int line, int pos) {
        if (lefthand_id != null && 
            righthand_id != null && 
            !lefthand_id.equals(righthand_id))
            System.out.printf("line \%d:\%d - \%s not defined\n", line, pos, righthand_id);
    }
}

pgm     : formula+ 
        ;

formula @init { lefthand_id = null; righthand_id = null; }
        : ID '[' lIndex ']' '=' exp NEWLINE  
        | NEWLINE
        ;

lIndex  : NUMBER { checkIndex($NUMBER.text, $NUMBER.getLine(), $NUMBER.getCharPositionInLine()); }
        | ID '=' rowList { lefthand_id = $ID.text; }
        ;

rowList : rowRef (',' rowRef)*
        ;

rowRef  : NUMBER { checkIndex($NUMBER.text, $NUMBER.getLine(), $NUMBER.getCharPositionInLine()); }  
        | numRange
		;
        
numRange: lowBound '-' upBound
        ; 

lowBound: NUMBER { checkIndex($NUMBER.text, $NUMBER.getLine(), $NUMBER.getCharPositionInLine()); }
        ;

upBound : NUMBER { checkIndex($NUMBER.text, $NUMBER.getLine(), $NUMBER.getCharPositionInLine()); }
        ;

exp     : arithExp (expType)*
        ;

expType : boolExp
        | relExp 
        | ternyExp
        ;

arithExp: multExp (('+' | '-') multExp)*
        | 
        ;

relExp  : ('<' | '>' | '<=' | '>=' | '==' | '!=') arithExp
        ; 

boolExp : ('and' | 'or') arithExp
        ;

ternyExp: '?' arithExp ':' arithExp
        ;

multExp : atom (('*' | '/') atom)*
        ;

atom    : '-'?NUMBER
        | ID('[' rIndex ']')? 
        | '(' exp ')' 
        | ('sum' | 'min' | 'max')'('cellList')'
        ;

rIndex  : ID { righthand_id = $ID.text; checkIdMatch($ID.getLine(), $ID.getCharPositionInLine()); }
        | NUMBER { checkIndex($NUMBER.text, $NUMBER.getLine(), $NUMBER.getCharPositionInLine()); }
		;

cellList: cellRef (',' cellRef)*
        ; 

cellRef : ID'['rowList']'
        | ID'['cellID']'
        ;

cellID  : ID { righthand_id = $ID.text; checkIdMatch($ID.getLine(), $ID.getCharPositionInLine()); }
        ;

ID      : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9' | '_')* 
        ;

NUMBER  : '0'..'9'+ | ('0'..'9')*'.'('0'..'9')+
        ;

NEWLINE : '\r'? '\n' 
        ; 

WS      : (' '|'\t')+ {skip();} 
        ;
