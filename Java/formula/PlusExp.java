package formula;

class PlusExp extends BinaryExp{


	double eval(int curr_row) throws UndefinedCellException{
		return  (leftexpress.eval(curr_row) + rightexpress.eval(curr_row));
	}

	PlusExp(Exp leftside, Exp rightside){
		super(leftside,rightside);

	}




}
