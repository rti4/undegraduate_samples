package formula;

abstract class BinaryExp extends Exp{
	Exp leftexpress;
	Exp rightexpress;

	/*this stores the left and right express values*/
	/*this is not needed in this section either -*/
	BinaryExp(Exp left, Exp right){
		leftexpress = left;
		rightexpress = right;
	}
	
}
