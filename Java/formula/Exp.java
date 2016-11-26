package formula;

/*I cant have this type be String because Java yells at me
  it needs to be a generic type so that I can use the 
  <=, <, >=, >, !=, etc operations
*/
abstract class Exp{
	/*Java yelled at me about not have this because hash required to throw
	  exceptionhandling
	*/
	abstract double eval(int row) throws UndefinedCellException;
}
