package formula;

import java.io.*;
import java.util.*;
import org.antlr.runtime.*;

class interpreter {

	/* Map variable name to Integer object holding value */
	static HashMap memory = new HashMap();

	public static void main(String args[]) {
		interpreter singleton = new interpreter();
		singleton.execute();
	}

	interpreter() {}

	void execute() {
		java.util.Scanner input = new java.util.Scanner(System.in);
		FormulaParser formulaParser;
		FormulaLexer lex;

		while (true) {
			try {
				// read a formula expression and evaluate it
				System.out.print(">>> ");
				lex = new FormulaLexer(new ANTLRReaderStream(new StringReader(input.nextLine() + "\n")));
				CommonTokenStream tokens = new CommonTokenStream(lex);
				formulaParser = new FormulaParser(tokens);
				formulaParser.pgm();
			} catch (RecognitionException e) {
				e.printStackTrace();
			} catch (java.util.NoSuchElementException e) { break; }
			catch (Exception e) {System.out.println(e);}
		}
	}
}

