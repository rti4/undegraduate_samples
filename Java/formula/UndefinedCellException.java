package formula;

/*needed to extend Exception generated errors when I didnt do it*/
class UndefinedCellException extends Exception{
	String columnname= ""; //kristy said make this 0 and ""
	int row = 0; //since java requires int != null

	/*Kristy said this is not need*/
	UndefinedCellException(String temp_col, int temp_row){
		columnname = temp_col;
		row =temp_row;
	}
	
	/*not sure if this is the correct way to do this*/
	/*Kristy said make it public "getfunction" dont change!*/
	public String getMessage(){
		
		return new String(columnname + "["+ row + "] is undefined\n");




	}



}
