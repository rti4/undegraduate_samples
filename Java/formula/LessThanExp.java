package formula;


class LessThanExp extends BinaryExp{

	double eval(int row) throws UndefinedCellException{
		/*------------------------------------------------------------------
		|	<,>, <=, >=, ==													|
		|	cant be performed on Strings so I needed to create a			|
		|	means to eval the strings										|
		-------------------------------------------------------------------*/

		if(leftexpress.eval(row) >= rightexpress.eval(row)){
			return 0;
		}else {
			return 1;
		}	
	}

	/*----------------------------------------------------------------------
	|  This needs to be the constructors name because						|
	|  java requires that a call to super be the first statement in the		|
	|  constructor															|
	------------------------------------------------------------------------*/
	
	LessThanExp(Exp left, Exp  right){
		super(left, right);
	}

}
