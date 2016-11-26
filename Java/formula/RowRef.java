package formula;
class RowRef{
	int right_side;
	int left_side;
	
	/*two different index*/
	RowRef(int row){
		this.right_side = row;
		this.left_side = row;
	}


	RowRef(int row1, int row2){
		this.right_side= row1;
		this.left_side=row2;
	}

}
