package formula;

class AndExp extends BinaryExp{
	
	
	double eval(int curr_row)throws UndefinedCellException{
		if((this.leftexpress.eval(curr_row) != 0)&& (this.rightexpress.eval(curr_row) != 0)){
			return 1;
		}else{
			return 0;
		}

	}

	AndExp(Exp left, Exp right){
		super (left, right);
	}




}
