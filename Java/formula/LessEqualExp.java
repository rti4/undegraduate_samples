package formula;


class LessEqualExp extends BinaryExp{

	/*if you forget to throw the UndefinedCellException javac yells out you*/

	double eval(int row) throws UndefinedCellException{
		/*------------------------------------------------------------------
		|	<,>, <=, >=, ==													|
		|	cant be performed on Strings so I needed to create a			|
		|	means to eval the strings										|
		-------------------------------------------------------------------*/
	
		if(leftexpress.eval(row) <= rightexpress.eval(row)){
			return 1;
		}else {
			return 0;
		}
		
	}

	/*----------------------------------------------------------------------
	|  This needs to be the constructors name because						|
	|  java requires that a call to super be the first statement in the		|
	|  constructor															|
	------------------------------------------------------------------------*/
	
	LessEqualExp(Exp left, Exp  right){
		super(left, right);
	}

}
