/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class creates and operates on ComplexFraction objects
 *
 * @version 12/18/17
 * @author Rohan Prasad
 */

public class ComplexFraction implements Number {


	private Fraction real;//Holds real portion of complex fraction
	private Fraction imaginary;//Holds imaginary portion of complex fraction


	/**
	 * Constructor
	 * @param r Real Numerator
	 * @param rd Real Denominator
	 * @param i Imaginary Numerator
	 * @param id Imaginary Denominator
	 */
	public ComplexFraction(int r, int rd, int i, int id){
		Fraction realFraction = new Fraction(r,rd);
		Fraction imagFraction = new Fraction(i,id);

		real = realFraction;
		imaginary = imagFraction;

	}

	@Override
	/**
	 * Add Method
	 * @param	Passes in a ComplexFraction to add with the object at hand
	 * @return Returns reduced sum of two Complex fractions
	 */
	public Number add(Number num) throws IllegalArgumentException {
		Fraction rSum;
		Fraction iSum;
		ComplexFraction c = new ComplexFraction(0, 1, 0, 1);

		if(num instanceof ComplexFraction){
			rSum = (Fraction) ((ComplexFraction)num).getReal().add(getReal());
			iSum = (Fraction) ((ComplexFraction)num).getImaginary().add(getImaginary());

			
			c.setReal(rSum);
			c.setImaginary(iSum);

		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;
	}

	@Override
	/**
	 * Subtract Method
	 * @param	Passes in a ComplexFraction to subtract with the object at hand
	 * @return Returns reduced difference of two Complex fractions
	 */
	public Number subtract(Number num)throws IllegalArgumentException {
		Fraction rDiff;
		Fraction iDiff;
		ComplexFraction c = new ComplexFraction(0, 1, 0, 1);

		if(num instanceof ComplexFraction){
			rDiff = (Fraction) ((ComplexFraction)num).getReal().subtract(getReal());
			iDiff = (Fraction) ((ComplexFraction)num).getImaginary().subtract(getImaginary());

			c.setReal(rDiff);
			c.setImaginary(iDiff);

		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;
	}

	@Override
	/**
	 * Multiply Method
	 * @param	Passes in a ComplexFraction to multiply with the object at hand
	 * @return Returns reduced product of two Complex fractions
	 */
	public Number multiply(Number num)throws IllegalArgumentException {
		Fraction foilT1;
		Fraction foilT2;
		Fraction foilT3;
		Fraction foilT4;
		ComplexFraction c = new ComplexFraction(0,1,0,1);

		if(num instanceof ComplexFraction){
			foilT1 = (Fraction) real.multiply(((ComplexFraction)num).getReal());
			foilT2 = (Fraction) real.multiply(((ComplexFraction)num).getImaginary());
			foilT3 = (Fraction)	imaginary.multiply(((ComplexFraction)num).getReal());
			foilT4 = (Fraction) imaginary.multiply(((ComplexFraction)num).getImaginary());

			c.setReal((Fraction)foilT1.subtract(foilT4));
			c.setImaginary((Fraction)foilT2.add(foilT3));
		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");
		
		return c;
	}


	@Override
	/**
	 * Divide Method
	 * @param	Passes in a ComplexFraction to divide with the object at hand
	 * @return Returns reduced quotient of two Complex fractions
	 */
	public Number divide(Number num) {
		ComplexFraction numerator = new ComplexFraction(0,1,0,1);
		Fraction denominator = new Fraction(0,1);
		ComplexFraction c = new ComplexFraction(0,1,0,1);

		ComplexFraction n2 = (ComplexFraction) num;
		if(num instanceof ComplexFraction){
			numerator = (ComplexFraction) this.multiply(getConjugate(((ComplexFraction)num)));
			denominator = (Fraction)(((ComplexFraction)num).getReal().multiply(((ComplexFraction)num).getReal())).add(((ComplexFraction)num).getImaginary().multiply(((ComplexFraction)num).getImaginary()));
			
			c.setReal((Fraction)numerator.getReal().divide(denominator));
			c.setImaginary((Fraction)numerator.getImaginary().divide(denominator));
		}else throw new IllegalArgumentException("Complex Number(s) not inputted.");

		return c;


	}
	
	/**
	 * Gets Conjugate of a Complex Fraction
	 * @param c	Passed Complex Fraction
	 * @return	Returns conjugate
	 */
	public ComplexFraction getConjugate(ComplexFraction c){
	
		int img = -1 * (c.getImaginary().getNumerator());
		
		ComplexFraction conj = new ComplexFraction(c.getReal().getNumerator(),c.getReal().getDenominator(),img,c.getImaginary().getDenominator());
		
		return conj;
	}

	/**
	 * Gets Real portion of Complex Fraction
	 * @return	Returns real portion of Complex Fraction
	 */
	public Fraction getReal(){
		return real;
	}
	/**
	 * Gets imaginary portion of ComplexFraction
	 * @return Returns imaginary portion of Complex Fraction
	 */
	public Fraction getImaginary(){
		return imaginary;
	}
	/**
	 * Sets real portion of complex fraction
	 * @param f	Passed in fraction
	 */
	public void setReal(Fraction f){
		real.setNumerator(f.getNumerator());
		real.setDenominator(f.getDenominator());
	}
	/**
	 * Sets imaginary portion of complex fraction
	 * @param f	Passed in fraction
	 */
	public void setImaginary(Fraction f){
		imaginary.setNumerator(f.getNumerator());
		imaginary.setDenominator(f.getDenominator());
	}
	
	/**
	 * toString method for printing	
	 * @param operation	Operation being performed
	 * @return Returns string outputted to user
	 */
	public String toString(String operation){
		String str = "";
		if(this.getImaginary().getNumerator() > 0){
			if(this.getReal().isDenominatorOne() && this.getImaginary().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "+" + this.getImaginary().getNumerator() + "i");
			}else if(this.getImaginary().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "/" +  this.getReal().getDenominator() +  "+" +  this.getImaginary().getNumerator() + "i");
			}else if(this.getReal().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "+" +    this.getImaginary().getNumerator() + this.getImaginary().getDenominator() + "i");
			}else{
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "/" +  this.getReal().getDenominator() + "+" +  this.getImaginary().getNumerator() +  "/" +  this.getImaginary().getDenominator() + "i");
			}
		}else {
			if(this.getReal().isDenominatorOne() && this.getImaginary().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() +  this.getImaginary().getNumerator() + "i");
			}else if(this.getImaginary().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "/" +  this.getReal().getDenominator() +   this.getImaginary().getNumerator() + "i");
			}else if(this.getReal().isDenominatorOne()){
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() +   this.getImaginary().getNumerator() + this.getImaginary().getDenominator() + "i");
			}else{
				str =("The " + operation + " of the two Complex Numbers is " + this.getReal().getNumerator() + "/" +  this.getReal().getDenominator()  +  this.getImaginary().getNumerator() +  "/" +  this.getImaginary().getDenominator() + "i");
			}
		}
		return str;
	}


}



