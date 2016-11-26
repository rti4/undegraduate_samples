class Salary{

	public static void main(String args[]){
		int num_pairs =0;
		if(((args.length % 2) != 0) || (args.length == 0)){
			System.out.printf("invalid input need an equal # of people to salaries%n");
			System.exit(1);
		}else if((args.length % 2) == 0){
			num_pairs = (args.length /2);
//			System.out.printf("%d%n", args.length);
		}else{
			System.out.printf("Unexpected error check command line arguments %n");
		}
	
		//why do i need a class for this?
		double salary_array[] = new double[num_pairs];
		String name_array[] = new String [num_pairs];
		//System.out.printf("passed error handling%n");
		for(int x=0, y=0; y < args.length;x++, y=y+2){
			name_array[x] = args[y];
			salary_array[x]=Double.parseDouble(args[y+1]);
		}
	
		double average=0, sum=0;
		for(int x=0; x <num_pairs; x++){
			sum += salary_array[x];
		}
		average = (sum/num_pairs);
		System.out.printf("Average salary = %,.2f%n", average);
		for(int x =0; x < num_pairs; x++){
			System.out.printf("%-15s %,10.2f ", name_array[x], salary_array[x] );
			if(salary_array[x] >= average){
				System.out.printf("true%n");
			}else if(salary_array[x] < average){
				System.out.printf("false%n");
			}else{
				System.out.printf("Error: Math operation while calculating boolean value%n");
			}
		}
	}
}
