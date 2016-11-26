package formula;
import java.util.Hashtable;
class VarExp extends Exp {

	// the number of rows for each column in the spreadsheet
	static final int NUMROWS = 100; 

	// The hash table is keyed on the name of a column. Each column name has
	// a value which is an array of Cell objects, one for each row in the 
	// column
	static Hashtable varTable = new Hashtable();
	String colName;
	int row;

	static Cell getCell(String colName, int rowIndex) throws UndefinedCellException{
		Cell cell = null;
		Cell[] cell_array;
		/*if the column exist attempt to retreive the cell*/
		if(varTable.containsKey(colName)){
			cell_array = (Cell[]) varTable.get(colName);
			cell = cell_array[rowIndex];
			if(cell == null){
				/*for the love of peter why is 'new' needed*/	
				throw new UndefinedCellException(colName, rowIndex);
				//System.out.printf("cell did not exist in column: %s\n", colName);
			}
		}else{
			/*else the column did not exist and we need to do error handling*/
			//System.out.printf("Could not find column\n");
			throw new UndefinedCellException(colName, rowIndex);
		}
		
		return cell;
	}



	static void setCell(String colName, int rowIndex, Exp formula){
		Cell[] cell_array;
		/*if the column exist retrieve that column*/
		if(varTable.containsKey(colName)){
			System.out.printf("column existed making array to contain column\n");
			cell_array = (Cell[]) varTable.get(colName);
		}else{
			/*else make the column*/
			System.out.printf("column didnt exist,making column\n");
			cell_array = new Cell[rowIndex];
			varTable.put(colName, cell_array);
		}

		if(cell_array[rowIndex] == null) {
			cell_array[rowIndex] = new Cell(formula);
			/* do I need new for here*/
			//System.out.printf("Printing expression that we just stored @ temprow\n");
			//cell_array[temprow].print_cell_exp();
		}else{
			/*reattempt to store the cell*/
			cell_array[rowIndex].setCell(formula);
		
		}





	}

	public double eval(int rowNum) throws UndefinedCellException{
		Cell currentCell= getCell(this.colName, this.row);
		

		double ret_val= 0.0;
		try{
			ret_val = currentCell.eval(this.row);
		}catch(UndefinedCellException currentUndefinedCellException){
			//does anything need to go here
			//I already tell it to throw UndefindedCellException

		}
		return ret_val;

	}


	//I believe that you left out that these need to be 'this'es
	/*this is not needed by Kristy*/
	public VarExp(String id, int rowNum) {
		colName = id;
		row = rowNum;
	}
}
