// $ANTLR 3.0.1 Formula.g 2010-04-02 22:38:28

    package formula;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FormulaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "NEWLINE", "NUMBER", "WS", "'['", "']'", "'='", "','", "'-'", "'+'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'and'", "'or'", "'?'", "':'", "'*'", "'/'", "'('", "')'", "'sum'", "'min'", "'max'"
    };
    public static final int WS=7;
    public static final int NEWLINE=5;
    public static final int NUMBER=6;
    public static final int ID=4;
    public static final int EOF=-1;

        public FormulaParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "Formula.g"; }


        String lefthand_id;
        String righthand_id;
        void checkIndex(String n, int line, int pos) {
            if (!n.matches("[0-9]+"))
                System.out.printf("line %d:%d %s must be an integer row reference\n", line, pos, n);
        }

        void checkIdMatch(int line, int pos) {
            if (lefthand_id != null && 
                righthand_id != null && 
                !lefthand_id.equals(righthand_id))
                System.out.printf("line %d:%d - %s not defined\n", line, pos, righthand_id);
        }



    // $ANTLR start pgm
    // Formula.g:27:1: pgm : ( formula )+ ;
    public final void pgm() throws RecognitionException {
        try {
            // Formula.g:27:9: ( ( formula )+ )
            // Formula.g:27:11: ( formula )+
            {
            // Formula.g:27:11: ( formula )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=ID && LA1_0<=NEWLINE)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Formula.g:27:11: formula
            	    {
            	    pushFollow(FOLLOW_formula_in_pgm38);
            	    formula();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end pgm


    // $ANTLR start formula
    // Formula.g:30:1: formula : ( ID '[' lIndex ']' '=' exp NEWLINE | NEWLINE );
    public final void formula() throws RecognitionException {
         lefthand_id = null; righthand_id = null; 
        try {
            // Formula.g:31:9: ( ID '[' lIndex ']' '=' exp NEWLINE | NEWLINE )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==NEWLINE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("30:1: formula : ( ID '[' lIndex ']' '=' exp NEWLINE | NEWLINE );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Formula.g:31:11: ID '[' lIndex ']' '=' exp NEWLINE
                    {
                    match(input,ID,FOLLOW_ID_in_formula70); 
                    match(input,8,FOLLOW_8_in_formula72); 
                    pushFollow(FOLLOW_lIndex_in_formula74);
                    lIndex();
                    _fsp--;

                    match(input,9,FOLLOW_9_in_formula76); 
                    match(input,10,FOLLOW_10_in_formula78); 
                    pushFollow(FOLLOW_exp_in_formula80);
                    exp();
                    _fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_formula82); 

                    }
                    break;
                case 2 :
                    // Formula.g:32:11: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_formula96); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end formula


    // $ANTLR start lIndex
    // Formula.g:35:1: lIndex : ( NUMBER | ID '=' rowList );
    public final void lIndex() throws RecognitionException {
        Token NUMBER1=null;
        Token ID2=null;

        try {
            // Formula.g:35:9: ( NUMBER | ID '=' rowList )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NUMBER) ) {
                alt3=1;
            }
            else if ( (LA3_0==ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("35:1: lIndex : ( NUMBER | ID '=' rowList );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Formula.g:35:11: NUMBER
                    {
                    NUMBER1=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_lIndex114); 
                     checkIndex(NUMBER1.getText(), NUMBER1.getLine(), NUMBER1.getCharPositionInLine()); 

                    }
                    break;
                case 2 :
                    // Formula.g:36:11: ID '=' rowList
                    {
                    ID2=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_lIndex128); 
                    match(input,10,FOLLOW_10_in_lIndex130); 
                    pushFollow(FOLLOW_rowList_in_lIndex132);
                    rowList();
                    _fsp--;

                     lefthand_id = ID2.getText(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end lIndex


    // $ANTLR start rowList
    // Formula.g:39:1: rowList : rowRef ( ',' rowRef )* ;
    public final void rowList() throws RecognitionException {
        try {
            // Formula.g:39:9: ( rowRef ( ',' rowRef )* )
            // Formula.g:39:11: rowRef ( ',' rowRef )*
            {
            pushFollow(FOLLOW_rowRef_in_rowList151);
            rowRef();
            _fsp--;

            // Formula.g:39:18: ( ',' rowRef )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Formula.g:39:19: ',' rowRef
            	    {
            	    match(input,11,FOLLOW_11_in_rowList154); 
            	    pushFollow(FOLLOW_rowRef_in_rowList156);
            	    rowRef();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end rowList


    // $ANTLR start rowRef
    // Formula.g:42:1: rowRef : ( NUMBER | numRange );
    public final void rowRef() throws RecognitionException {
        Token NUMBER3=null;

        try {
            // Formula.g:42:9: ( NUMBER | numRange )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NUMBER) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==12) ) {
                    alt5=2;
                }
                else if ( (LA5_1==9||LA5_1==11) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("42:1: rowRef : ( NUMBER | numRange );", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("42:1: rowRef : ( NUMBER | numRange );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Formula.g:42:11: NUMBER
                    {
                    NUMBER3=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_rowRef176); 
                     checkIndex(NUMBER3.getText(), NUMBER3.getLine(), NUMBER3.getCharPositionInLine()); 

                    }
                    break;
                case 2 :
                    // Formula.g:43:11: numRange
                    {
                    pushFollow(FOLLOW_numRange_in_rowRef192);
                    numRange();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end rowRef


    // $ANTLR start numRange
    // Formula.g:46:1: numRange : lowBound '-' upBound ;
    public final void numRange() throws RecognitionException {
        try {
            // Formula.g:46:9: ( lowBound '-' upBound )
            // Formula.g:46:11: lowBound '-' upBound
            {
            pushFollow(FOLLOW_lowBound_in_numRange210);
            lowBound();
            _fsp--;

            match(input,12,FOLLOW_12_in_numRange212); 
            pushFollow(FOLLOW_upBound_in_numRange214);
            upBound();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end numRange


    // $ANTLR start lowBound
    // Formula.g:49:1: lowBound : NUMBER ;
    public final void lowBound() throws RecognitionException {
        Token NUMBER4=null;

        try {
            // Formula.g:49:9: ( NUMBER )
            // Formula.g:49:11: NUMBER
            {
            NUMBER4=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_lowBound231); 
             checkIndex(NUMBER4.getText(), NUMBER4.getLine(), NUMBER4.getCharPositionInLine()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end lowBound


    // $ANTLR start upBound
    // Formula.g:52:1: upBound : NUMBER ;
    public final void upBound() throws RecognitionException {
        Token NUMBER5=null;

        try {
            // Formula.g:52:9: ( NUMBER )
            // Formula.g:52:11: NUMBER
            {
            NUMBER5=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_upBound250); 
             checkIndex(NUMBER5.getText(), NUMBER5.getLine(), NUMBER5.getCharPositionInLine()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end upBound


    // $ANTLR start exp
    // Formula.g:55:1: exp : arithExp ( expType )* ;
    public final void exp() throws RecognitionException {
        try {
            // Formula.g:55:9: ( arithExp ( expType )* )
            // Formula.g:55:11: arithExp ( expType )*
            {
            pushFollow(FOLLOW_arithExp_in_exp273);
            arithExp();
            _fsp--;

            // Formula.g:55:20: ( expType )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=14 && LA6_0<=22)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Formula.g:55:21: expType
            	    {
            	    pushFollow(FOLLOW_expType_in_exp276);
            	    expType();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end exp


    // $ANTLR start expType
    // Formula.g:58:1: expType : ( boolExp | relExp | ternyExp );
    public final void expType() throws RecognitionException {
        try {
            // Formula.g:58:9: ( boolExp | relExp | ternyExp )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 20:
            case 21:
                {
                alt7=1;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                {
                alt7=2;
                }
                break;
            case 22:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("58:1: expType : ( boolExp | relExp | ternyExp );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // Formula.g:58:11: boolExp
                    {
                    pushFollow(FOLLOW_boolExp_in_expType295);
                    boolExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // Formula.g:59:11: relExp
                    {
                    pushFollow(FOLLOW_relExp_in_expType307);
                    relExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // Formula.g:60:11: ternyExp
                    {
                    pushFollow(FOLLOW_ternyExp_in_expType320);
                    ternyExp();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expType


    // $ANTLR start arithExp
    // Formula.g:63:1: arithExp : ( multExp ( ( '+' | '-' ) multExp )* | );
    public final void arithExp() throws RecognitionException {
        try {
            // Formula.g:63:9: ( multExp ( ( '+' | '-' ) multExp )* | )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID||LA9_0==NUMBER||LA9_0==12||LA9_0==26||(LA9_0>=28 && LA9_0<=30)) ) {
                alt9=1;
            }
            else if ( (LA9_0==NEWLINE||(LA9_0>=14 && LA9_0<=23)||LA9_0==27) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("63:1: arithExp : ( multExp ( ( '+' | '-' ) multExp )* | );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // Formula.g:63:11: multExp ( ( '+' | '-' ) multExp )*
                    {
                    pushFollow(FOLLOW_multExp_in_arithExp336);
                    multExp();
                    _fsp--;

                    // Formula.g:63:19: ( ( '+' | '-' ) multExp )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=12 && LA8_0<=13)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Formula.g:63:20: ( '+' | '-' ) multExp
                    	    {
                    	    if ( (input.LA(1)>=12 && input.LA(1)<=13) ) {
                    	        input.consume();
                    	        errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_arithExp339);    throw mse;
                    	    }

                    	    pushFollow(FOLLOW_multExp_in_arithExp347);
                    	    multExp();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Formula.g:65:9: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end arithExp


    // $ANTLR start relExp
    // Formula.g:67:1: relExp : ( '<' | '>' | '<=' | '>=' | '==' | '!=' ) arithExp ;
    public final void relExp() throws RecognitionException {
        try {
            // Formula.g:67:9: ( ( '<' | '>' | '<=' | '>=' | '==' | '!=' ) arithExp )
            // Formula.g:67:11: ( '<' | '>' | '<=' | '>=' | '==' | '!=' ) arithExp
            {
            if ( (input.LA(1)>=14 && input.LA(1)<=19) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_relExp378);    throw mse;
            }

            pushFollow(FOLLOW_arithExp_in_relExp402);
            arithExp();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end relExp


    // $ANTLR start boolExp
    // Formula.g:70:1: boolExp : ( 'and' | 'or' ) arithExp ;
    public final void boolExp() throws RecognitionException {
        try {
            // Formula.g:70:9: ( ( 'and' | 'or' ) arithExp )
            // Formula.g:70:11: ( 'and' | 'or' ) arithExp
            {
            if ( (input.LA(1)>=20 && input.LA(1)<=21) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_boolExp420);    throw mse;
            }

            pushFollow(FOLLOW_arithExp_in_boolExp428);
            arithExp();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end boolExp


    // $ANTLR start ternyExp
    // Formula.g:73:1: ternyExp : '?' arithExp ':' arithExp ;
    public final void ternyExp() throws RecognitionException {
        try {
            // Formula.g:73:9: ( '?' arithExp ':' arithExp )
            // Formula.g:73:11: '?' arithExp ':' arithExp
            {
            match(input,22,FOLLOW_22_in_ternyExp444); 
            pushFollow(FOLLOW_arithExp_in_ternyExp446);
            arithExp();
            _fsp--;

            match(input,23,FOLLOW_23_in_ternyExp448); 
            pushFollow(FOLLOW_arithExp_in_ternyExp450);
            arithExp();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end ternyExp


    // $ANTLR start multExp
    // Formula.g:76:1: multExp : atom ( ( '*' | '/' ) atom )* ;
    public final void multExp() throws RecognitionException {
        try {
            // Formula.g:76:9: ( atom ( ( '*' | '/' ) atom )* )
            // Formula.g:76:11: atom ( ( '*' | '/' ) atom )*
            {
            pushFollow(FOLLOW_atom_in_multExp467);
            atom();
            _fsp--;

            // Formula.g:76:16: ( ( '*' | '/' ) atom )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Formula.g:76:17: ( '*' | '/' ) atom
            	    {
            	    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_multExp470);    throw mse;
            	    }

            	    pushFollow(FOLLOW_atom_in_multExp478);
            	    atom();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end multExp


    // $ANTLR start atom
    // Formula.g:79:1: atom : ( ( '-' )? NUMBER | ID ( '[' rIndex ']' )? | '(' exp ')' | ( 'sum' | 'min' | 'max' ) '(' cellList ')' );
    public final void atom() throws RecognitionException {
        try {
            // Formula.g:79:9: ( ( '-' )? NUMBER | ID ( '[' rIndex ']' )? | '(' exp ')' | ( 'sum' | 'min' | 'max' ) '(' cellList ')' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case NUMBER:
            case 12:
                {
                alt13=1;
                }
                break;
            case ID:
                {
                alt13=2;
                }
                break;
            case 26:
                {
                alt13=3;
                }
                break;
            case 28:
            case 29:
            case 30:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("79:1: atom : ( ( '-' )? NUMBER | ID ( '[' rIndex ']' )? | '(' exp ')' | ( 'sum' | 'min' | 'max' ) '(' cellList ')' );", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // Formula.g:79:11: ( '-' )? NUMBER
                    {
                    // Formula.g:79:11: ( '-' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==12) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Formula.g:79:11: '-'
                            {
                            match(input,12,FOLLOW_12_in_atom500); 

                            }
                            break;

                    }

                    match(input,NUMBER,FOLLOW_NUMBER_in_atom502); 

                    }
                    break;
                case 2 :
                    // Formula.g:80:11: ID ( '[' rIndex ']' )?
                    {
                    match(input,ID,FOLLOW_ID_in_atom514); 
                    // Formula.g:80:13: ( '[' rIndex ']' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==8) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Formula.g:80:14: '[' rIndex ']'
                            {
                            match(input,8,FOLLOW_8_in_atom516); 
                            pushFollow(FOLLOW_rIndex_in_atom518);
                            rIndex();
                            _fsp--;

                            match(input,9,FOLLOW_9_in_atom520); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // Formula.g:81:11: '(' exp ')'
                    {
                    match(input,26,FOLLOW_26_in_atom535); 
                    pushFollow(FOLLOW_exp_in_atom537);
                    exp();
                    _fsp--;

                    match(input,27,FOLLOW_27_in_atom539); 

                    }
                    break;
                case 4 :
                    // Formula.g:82:11: ( 'sum' | 'min' | 'max' ) '(' cellList ')'
                    {
                    if ( (input.LA(1)>=28 && input.LA(1)<=30) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom552);    throw mse;
                    }

                    match(input,26,FOLLOW_26_in_atom563); 
                    pushFollow(FOLLOW_cellList_in_atom564);
                    cellList();
                    _fsp--;

                    match(input,27,FOLLOW_27_in_atom565); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end atom


    // $ANTLR start rIndex
    // Formula.g:85:1: rIndex : ( ID | NUMBER );
    public final void rIndex() throws RecognitionException {
        Token ID6=null;
        Token NUMBER7=null;

        try {
            // Formula.g:85:9: ( ID | NUMBER )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==NUMBER) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("85:1: rIndex : ( ID | NUMBER );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // Formula.g:85:11: ID
                    {
                    ID6=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_rIndex583); 
                     righthand_id = ID6.getText(); checkIdMatch(ID6.getLine(), ID6.getCharPositionInLine()); 

                    }
                    break;
                case 2 :
                    // Formula.g:86:11: NUMBER
                    {
                    NUMBER7=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_rIndex597); 
                     checkIndex(NUMBER7.getText(), NUMBER7.getLine(), NUMBER7.getCharPositionInLine()); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end rIndex


    // $ANTLR start cellList
    // Formula.g:89:1: cellList : cellRef ( ',' cellRef )* ;
    public final void cellList() throws RecognitionException {
        try {
            // Formula.g:89:9: ( cellRef ( ',' cellRef )* )
            // Formula.g:89:11: cellRef ( ',' cellRef )*
            {
            pushFollow(FOLLOW_cellRef_in_cellList609);
            cellRef();
            _fsp--;

            // Formula.g:89:19: ( ',' cellRef )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==11) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Formula.g:89:20: ',' cellRef
            	    {
            	    match(input,11,FOLLOW_11_in_cellList612); 
            	    pushFollow(FOLLOW_cellRef_in_cellList614);
            	    cellRef();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end cellList


    // $ANTLR start cellRef
    // Formula.g:92:1: cellRef : ( ID '[' rowList ']' | ID '[' cellID ']' );
    public final void cellRef() throws RecognitionException {
        try {
            // Formula.g:92:9: ( ID '[' rowList ']' | ID '[' cellID ']' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==8) ) {
                    int LA16_2 = input.LA(3);

                    if ( (LA16_2==NUMBER) ) {
                        alt16=1;
                    }
                    else if ( (LA16_2==ID) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("92:1: cellRef : ( ID '[' rowList ']' | ID '[' cellID ']' );", 16, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("92:1: cellRef : ( ID '[' rowList ']' | ID '[' cellID ']' );", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("92:1: cellRef : ( ID '[' rowList ']' | ID '[' cellID ']' );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // Formula.g:92:11: ID '[' rowList ']'
                    {
                    match(input,ID,FOLLOW_ID_in_cellRef634); 
                    match(input,8,FOLLOW_8_in_cellRef635); 
                    pushFollow(FOLLOW_rowList_in_cellRef636);
                    rowList();
                    _fsp--;

                    match(input,9,FOLLOW_9_in_cellRef637); 

                    }
                    break;
                case 2 :
                    // Formula.g:93:11: ID '[' cellID ']'
                    {
                    match(input,ID,FOLLOW_ID_in_cellRef649); 
                    match(input,8,FOLLOW_8_in_cellRef650); 
                    pushFollow(FOLLOW_cellID_in_cellRef651);
                    cellID();
                    _fsp--;

                    match(input,9,FOLLOW_9_in_cellRef652); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end cellRef


    // $ANTLR start cellID
    // Formula.g:96:1: cellID : ID ;
    public final void cellID() throws RecognitionException {
        Token ID8=null;

        try {
            // Formula.g:96:9: ( ID )
            // Formula.g:96:11: ID
            {
            ID8=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_cellID670); 
             righthand_id = ID8.getText(); checkIdMatch(ID8.getLine(), ID8.getCharPositionInLine()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end cellID


 

    public static final BitSet FOLLOW_formula_in_pgm38 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ID_in_formula70 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_formula72 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_lIndex_in_formula74 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_formula76 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_formula78 = new BitSet(new long[]{0x00000000747FD070L});
    public static final BitSet FOLLOW_exp_in_formula80 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NEWLINE_in_formula82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_formula96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_lIndex114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_lIndex128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_lIndex130 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rowList_in_lIndex132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowRef_in_rowList151 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_rowList154 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rowRef_in_rowList156 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_NUMBER_in_rowRef176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numRange_in_rowRef192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lowBound_in_numRange210 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_numRange212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_upBound_in_numRange214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_lowBound231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_upBound250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithExp_in_exp273 = new BitSet(new long[]{0x00000000007FC002L});
    public static final BitSet FOLLOW_expType_in_exp276 = new BitSet(new long[]{0x00000000007FC002L});
    public static final BitSet FOLLOW_boolExp_in_expType295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relExp_in_expType307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternyExp_in_expType320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExp_in_arithExp336 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_set_in_arithExp339 = new BitSet(new long[]{0x0000000074001050L});
    public static final BitSet FOLLOW_multExp_in_arithExp347 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_set_in_relExp378 = new BitSet(new long[]{0x0000000074001052L});
    public static final BitSet FOLLOW_arithExp_in_relExp402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_boolExp420 = new BitSet(new long[]{0x0000000074001052L});
    public static final BitSet FOLLOW_arithExp_in_boolExp428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ternyExp444 = new BitSet(new long[]{0x0000000074801050L});
    public static final BitSet FOLLOW_arithExp_in_ternyExp446 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ternyExp448 = new BitSet(new long[]{0x0000000074001052L});
    public static final BitSet FOLLOW_arithExp_in_ternyExp450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_multExp467 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_multExp470 = new BitSet(new long[]{0x0000000074001050L});
    public static final BitSet FOLLOW_atom_in_multExp478 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_12_in_atom500 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_atom502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom514 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_8_in_atom516 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rIndex_in_atom518 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_atom520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_atom535 = new BitSet(new long[]{0x000000007C7FD050L});
    public static final BitSet FOLLOW_exp_in_atom537 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_atom539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom552 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_atom563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cellList_in_atom564 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_atom565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_rIndex583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rIndex597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cellRef_in_cellList609 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_cellList612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cellRef_in_cellList614 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ID_in_cellRef634 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_cellRef635 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rowList_in_cellRef636 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_cellRef637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_cellRef649 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_cellRef650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_cellID_in_cellRef651 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_cellRef652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_cellID670 = new BitSet(new long[]{0x0000000000000002L});

}