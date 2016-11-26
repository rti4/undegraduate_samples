// $ANTLR 3.0.1 Formula.g 2010-04-02 22:38:28

    package formula;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FormulaLexer extends Lexer {
    public static final int NUMBER=6;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T8=8;
    public static final int T26=26;
    public static final int T9=9;
    public static final int T25=25;
    public static final int ID=4;
    public static final int Tokens=31;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int WS=7;
    public static final int NEWLINE=5;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public FormulaLexer() {;} 
    public FormulaLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "Formula.g"; }

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // Formula.g:6:4: ( '[' )
            // Formula.g:6:6: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // Formula.g:7:4: ( ']' )
            // Formula.g:7:6: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // Formula.g:8:5: ( '=' )
            // Formula.g:8:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // Formula.g:9:5: ( ',' )
            // Formula.g:9:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // Formula.g:10:5: ( '-' )
            // Formula.g:10:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // Formula.g:11:5: ( '+' )
            // Formula.g:11:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // Formula.g:12:5: ( '<' )
            // Formula.g:12:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // Formula.g:13:5: ( '>' )
            // Formula.g:13:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // Formula.g:14:5: ( '<=' )
            // Formula.g:14:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // Formula.g:15:5: ( '>=' )
            // Formula.g:15:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // Formula.g:16:5: ( '==' )
            // Formula.g:16:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // Formula.g:17:5: ( '!=' )
            // Formula.g:17:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // Formula.g:18:5: ( 'and' )
            // Formula.g:18:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // Formula.g:19:5: ( 'or' )
            // Formula.g:19:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // Formula.g:20:5: ( '?' )
            // Formula.g:20:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // Formula.g:21:5: ( ':' )
            // Formula.g:21:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // Formula.g:22:5: ( '*' )
            // Formula.g:22:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // Formula.g:23:5: ( '/' )
            // Formula.g:23:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // Formula.g:24:5: ( '(' )
            // Formula.g:24:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // Formula.g:25:5: ( ')' )
            // Formula.g:25:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // Formula.g:26:5: ( 'sum' )
            // Formula.g:26:7: 'sum'
            {
            match("sum"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // Formula.g:27:5: ( 'min' )
            // Formula.g:27:7: 'min'
            {
            match("min"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // Formula.g:28:5: ( 'max' )
            // Formula.g:28:7: 'max'
            {
            match("max"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // Formula.g:99:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Formula.g:99:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // Formula.g:99:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Formula.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // Formula.g:102:9: ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // Formula.g:102:11: ( '0' .. '9' )+
                    {
                    // Formula.g:102:11: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Formula.g:102:11: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Formula.g:102:23: ( '0' .. '9' )* '.' ( '0' .. '9' )+
                    {
                    // Formula.g:102:23: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Formula.g:102:24: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('.'); 
                    // Formula.g:102:37: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Formula.g:102:38: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // Formula.g:105:9: ( ( '\\r' )? '\\n' )
            // Formula.g:105:11: ( '\\r' )? '\\n'
            {
            // Formula.g:105:11: ( '\\r' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Formula.g:105:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // Formula.g:108:9: ( ( ' ' | '\\t' )+ )
            // Formula.g:108:11: ( ' ' | '\\t' )+
            {
            // Formula.g:108:11: ( ' ' | '\\t' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Formula.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // Formula.g:1:8: ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | ID | NUMBER | NEWLINE | WS )
        int alt8=27;
        switch ( input.LA(1) ) {
        case '[':
            {
            alt8=1;
            }
            break;
        case ']':
            {
            alt8=2;
            }
            break;
        case '=':
            {
            int LA8_3 = input.LA(2);

            if ( (LA8_3=='=') ) {
                alt8=11;
            }
            else {
                alt8=3;}
            }
            break;
        case ',':
            {
            alt8=4;
            }
            break;
        case '-':
            {
            alt8=5;
            }
            break;
        case '+':
            {
            alt8=6;
            }
            break;
        case '<':
            {
            int LA8_7 = input.LA(2);

            if ( (LA8_7=='=') ) {
                alt8=9;
            }
            else {
                alt8=7;}
            }
            break;
        case '>':
            {
            int LA8_8 = input.LA(2);

            if ( (LA8_8=='=') ) {
                alt8=10;
            }
            else {
                alt8=8;}
            }
            break;
        case '!':
            {
            alt8=12;
            }
            break;
        case 'a':
            {
            int LA8_10 = input.LA(2);

            if ( (LA8_10=='n') ) {
                int LA8_30 = input.LA(3);

                if ( (LA8_30=='d') ) {
                    int LA8_35 = input.LA(4);

                    if ( ((LA8_35>='0' && LA8_35<='9')||(LA8_35>='A' && LA8_35<='Z')||LA8_35=='_'||(LA8_35>='a' && LA8_35<='z')) ) {
                        alt8=24;
                    }
                    else {
                        alt8=13;}
                }
                else {
                    alt8=24;}
            }
            else {
                alt8=24;}
            }
            break;
        case 'o':
            {
            int LA8_11 = input.LA(2);

            if ( (LA8_11=='r') ) {
                int LA8_31 = input.LA(3);

                if ( ((LA8_31>='0' && LA8_31<='9')||(LA8_31>='A' && LA8_31<='Z')||LA8_31=='_'||(LA8_31>='a' && LA8_31<='z')) ) {
                    alt8=24;
                }
                else {
                    alt8=14;}
            }
            else {
                alt8=24;}
            }
            break;
        case '?':
            {
            alt8=15;
            }
            break;
        case ':':
            {
            alt8=16;
            }
            break;
        case '*':
            {
            alt8=17;
            }
            break;
        case '/':
            {
            alt8=18;
            }
            break;
        case '(':
            {
            alt8=19;
            }
            break;
        case ')':
            {
            alt8=20;
            }
            break;
        case 's':
            {
            int LA8_18 = input.LA(2);

            if ( (LA8_18=='u') ) {
                int LA8_32 = input.LA(3);

                if ( (LA8_32=='m') ) {
                    int LA8_37 = input.LA(4);

                    if ( ((LA8_37>='0' && LA8_37<='9')||(LA8_37>='A' && LA8_37<='Z')||LA8_37=='_'||(LA8_37>='a' && LA8_37<='z')) ) {
                        alt8=24;
                    }
                    else {
                        alt8=21;}
                }
                else {
                    alt8=24;}
            }
            else {
                alt8=24;}
            }
            break;
        case 'm':
            {
            switch ( input.LA(2) ) {
            case 'i':
                {
                int LA8_33 = input.LA(3);

                if ( (LA8_33=='n') ) {
                    int LA8_38 = input.LA(4);

                    if ( ((LA8_38>='0' && LA8_38<='9')||(LA8_38>='A' && LA8_38<='Z')||LA8_38=='_'||(LA8_38>='a' && LA8_38<='z')) ) {
                        alt8=24;
                    }
                    else {
                        alt8=22;}
                }
                else {
                    alt8=24;}
                }
                break;
            case 'a':
                {
                int LA8_34 = input.LA(3);

                if ( (LA8_34=='x') ) {
                    int LA8_39 = input.LA(4);

                    if ( ((LA8_39>='0' && LA8_39<='9')||(LA8_39>='A' && LA8_39<='Z')||LA8_39=='_'||(LA8_39>='a' && LA8_39<='z')) ) {
                        alt8=24;
                    }
                    else {
                        alt8=23;}
                }
                else {
                    alt8=24;}
                }
                break;
            default:
                alt8=24;}

            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt8=24;
            }
            break;
        case '.':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt8=25;
            }
            break;
        case '\n':
        case '\r':
            {
            alt8=26;
            }
            break;
        case '\t':
        case ' ':
            {
            alt8=27;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T8 | T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | ID | NUMBER | NEWLINE | WS );", 8, 0, input);

            throw nvae;
        }

        switch (alt8) {
            case 1 :
                // Formula.g:1:10: T8
                {
                mT8(); 

                }
                break;
            case 2 :
                // Formula.g:1:13: T9
                {
                mT9(); 

                }
                break;
            case 3 :
                // Formula.g:1:16: T10
                {
                mT10(); 

                }
                break;
            case 4 :
                // Formula.g:1:20: T11
                {
                mT11(); 

                }
                break;
            case 5 :
                // Formula.g:1:24: T12
                {
                mT12(); 

                }
                break;
            case 6 :
                // Formula.g:1:28: T13
                {
                mT13(); 

                }
                break;
            case 7 :
                // Formula.g:1:32: T14
                {
                mT14(); 

                }
                break;
            case 8 :
                // Formula.g:1:36: T15
                {
                mT15(); 

                }
                break;
            case 9 :
                // Formula.g:1:40: T16
                {
                mT16(); 

                }
                break;
            case 10 :
                // Formula.g:1:44: T17
                {
                mT17(); 

                }
                break;
            case 11 :
                // Formula.g:1:48: T18
                {
                mT18(); 

                }
                break;
            case 12 :
                // Formula.g:1:52: T19
                {
                mT19(); 

                }
                break;
            case 13 :
                // Formula.g:1:56: T20
                {
                mT20(); 

                }
                break;
            case 14 :
                // Formula.g:1:60: T21
                {
                mT21(); 

                }
                break;
            case 15 :
                // Formula.g:1:64: T22
                {
                mT22(); 

                }
                break;
            case 16 :
                // Formula.g:1:68: T23
                {
                mT23(); 

                }
                break;
            case 17 :
                // Formula.g:1:72: T24
                {
                mT24(); 

                }
                break;
            case 18 :
                // Formula.g:1:76: T25
                {
                mT25(); 

                }
                break;
            case 19 :
                // Formula.g:1:80: T26
                {
                mT26(); 

                }
                break;
            case 20 :
                // Formula.g:1:84: T27
                {
                mT27(); 

                }
                break;
            case 21 :
                // Formula.g:1:88: T28
                {
                mT28(); 

                }
                break;
            case 22 :
                // Formula.g:1:92: T29
                {
                mT29(); 

                }
                break;
            case 23 :
                // Formula.g:1:96: T30
                {
                mT30(); 

                }
                break;
            case 24 :
                // Formula.g:1:100: ID
                {
                mID(); 

                }
                break;
            case 25 :
                // Formula.g:1:103: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 26 :
                // Formula.g:1:110: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 27 :
                // Formula.g:1:118: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA5_eofS =
        "\4\uffff";
    static final String DFA5_minS =
        "\2\56\2\uffff";
    static final String DFA5_maxS =
        "\2\71\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\2\1\uffff\12\1",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "102:1: NUMBER : ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ );";
        }
    }
 

}