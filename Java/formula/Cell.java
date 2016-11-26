package formula;
class Cell {
	Exp formula;
	boolean upToDate = false; // useful for the next project assignment
	boolean undef = false; // whether the cell's value is undefined
	double value = 0;

	/*do you intential forget to put the this...or is it not needed*/
	public Cell(Exp expression) {
		this.formula = expression;
	}

	public void setCell(Exp expression) {
		this.formula = expression;
		this.upToDate = false;
		this.undef = false;
	}


	/*said something about needed to be caught*/
	double eval(int curr_row) throws UndefinedCellException{
		
		/*if the cell value is undefined*/
		if(this.undef){
			throw new UndefinedCellException(null, curr_row);
		}
	
		/*Java doesnt handle boolean == 0 or == 1 so I used !*/
		if(!this.upToDate){
			
			this.value = this.formula.eval(curr_row);
			this.undef = false;
			this.upToDate= true;
		}
		
		return this.value;


	}
}
