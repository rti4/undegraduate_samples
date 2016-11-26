CLASSPATH = .:..:/usr/share/java/antlr3.jar:/usr/share/java/antlr.jar:~/proj1/formula

all: project1

project1:
	antlr3 Formula.g
	javac -cp $(CLASSPATH) *.java

jar: project1
	echo "Main-Class: Parser" > manifest.txt
	jar cf interpreter.jar *.java *.class manifest.txt

run:
	java -cp $(CLASSPATH) formula.interpreter

clean:
	rm Formula__.g FormulaLexer.java FormulaParser.java Formula.tokens *.class 
