/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class creates and operates on ComplexNumber objects
 *
 * @version 12/18/17
 * @author Rohan Prasad
 */

public class ComplexNumber implements Number {

	private double real;//Holds real portion of Complex Number
	private double imaginary;//Holds imaginary portion of Complex Number


	/**
	 * Constructor
	 * @param r Real portion
	 * @param i	Imaginary portion
	 */
	public ComplexNumber(double r, double i){
		real = r;
		imaginary = i;
	}

	@Override
	/**
	 * Add Method
	 * @param	Passes in a Complex Number to add with the object at hand
	 * @return Returns reduced sum of two Complex Numbers
	 */
	public Number add(Number num) throws IllegalArgumentException {
		double r3 = 0;
		double 	i3 = 0;
		ComplexNumber c = new ComplexNumber(0,0);

		if(num instanceof ComplexNumber){
			r3 = ((ComplexNumber )num).getReal() + getReal();
			i3 = ((ComplexNumber )num).getImaginary() + getImaginary();

			c.setReal(r3);
			c.setImaginary(i3);
		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;
	}

	@Override
	/**
	 * Subtract Method
	 * @param	Passes in a Complex Number to subtract with the object at hand
	 * @return Returns reduced difference of two Complex Numbers
	 */
	public Number subtract(Number num)throws IllegalArgumentException {
		double r3 = 0;
		double 	i3 = 0;
		ComplexNumber c = new ComplexNumber(0,0);

		if(num instanceof ComplexNumber){
			r3 = ((ComplexNumber )num).getReal() - getReal();
			i3 = ((ComplexNumber )num).getImaginary() - getImaginary();

			c.setReal(-r3);
			c.setImaginary(-i3);
		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;
	}

	@Override
	/**
	 * Multiply Method
	 * @param	Passes in a Complex Number to multiply with the object at hand
	 * @return Returns reduced product of two Complex Numbers
	 */
	public Number multiply(Number num)throws IllegalArgumentException {
		double foilT1 = 0;
		double foilT2 = 0;
		double foilT3 = 0;
		double foilT4 = 0;
		ComplexNumber c = new ComplexNumber(0,0);

		if(num instanceof ComplexNumber){
			foilT1 = ((ComplexNumber)num).getReal() * getReal();
			foilT2 = ((ComplexNumber)num).getReal() * getImaginary();
			foilT3 = ((ComplexNumber)num).getImaginary() * getReal();
			foilT4 = ((ComplexNumber)num).getImaginary() * getImaginary();


			c.setReal(foilT1 - foilT4);
			c.setImaginary(foilT2 + foilT3);
		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;
	}

	@Override
	/**
	 * Divide Method
	 * @param	Passes in a Complex Number to divide with the object at hand
	 * @return Returns reduced quotient of two Complex Numbers
	 */
	public Number divide(Number num) {
		ComplexNumber c = new ComplexNumber(0,0);
		if(num instanceof ComplexNumber){
			ComplexNumber conj = new ComplexNumber(((ComplexNumber)num).getReal(),-((ComplexNumber)num).getImaginary());


			ComplexNumber numer = new ComplexNumber(0,0);

			double denominator = Math.pow(conj.getReal(),2) + Math.pow(conj.getImaginary(),2);

			numer = (ComplexNumber)this.multiply(conj);


			double r3 = numer.getReal()/denominator;
			double i3 = numer.getImaginary()/denominator;

			c.setReal(r3);
			c.setImaginary(i3);
		}

		return c;


	}

	/**
	 * Gets Real portion of Complex Number
	 * @return	Returns real portion of Complex Number
	 */
	public void setReal(double r){
		real = r;
	}
	/**
	 * Gets imaginary portion of Complex Number
	 * @return Returns imaginary portion of Complex Number
	 */
	public void setImaginary(double i){
		imaginary = i;
	}
	/**
	 * Sets real portion of Complex Number
	 * @param f	Passed in fraction
	 */
	public double getReal(){
		return real;
	}
	/**
	 * Sets imaginary portion of Complex Number
	 * @param f	Passed in fraction
	 */
	public double getImaginary(){
		return imaginary;
	}

	/**
	 * toString method for printing	
	 * @param operation	Operation being performed
	 * @return Returns string outputted to user
	 */
	public String toString(String operation){
		String str = "";
		if(this.getImaginary() > 0){
			if(this.getImaginary() == 0){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal());

			}else if(this.getReal() == 0){
				str =("The " + operation + " of the two Complex Numbers is "  +  this.getImaginary() + "i");
			}else{
				str =("The " + operation + " of the two Complex Numbers is "  + this.getReal() + "+" +  this.getImaginary() + "i");
			}
		}else {
			if(this.getImaginary() == 0){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal());

			}else if(this.getReal() == 0){
				str =("The " + operation + " of the two Complex Numbers is "  +  this.getImaginary() + "i");
			}else{
				str =("The " + operation + " of the two Complex Numbers is "  + this.getReal() + this.getImaginary() + "i");
			}
		}
		return str;


	}

}


