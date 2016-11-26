package formula;

class OrExp extends BinaryExp{
	double eval(int curr_row)throws UndefinedCellException{
		if((this.leftexpress.eval(curr_row) != 0)|| (this.rightexpress.eval(curr_row) != 0)){
			return 1;
		}else{
			return 0;
		}
	}

	OrExp(Exp left, Exp right){
		super (left, right);
	}




}
