package formula;

class MultiplyExp extends BinaryExp{

	double eval(int curr_row) throws UndefinedCellException{

		return (leftexpress.eval(curr_row) * rightexpress.eval(curr_row));
	}

	MultiplyExp(Exp leftside, Exp rightside){
		super(leftside,rightside);

	}




}
