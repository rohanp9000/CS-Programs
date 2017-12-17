/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class creates and operates on Fraction objects
 *
 * @version 12/18/17
 * @author Rohan Prasad
 */

public class Fraction implements Number {

	private int numerator;//Holds Numerator of Fraction
	private int denominator;//Holds Denominator of Fraction

	/**
	 * Constructor
	 * @param n	Numerator
	 * @param d	Denominator
	 * @throws IllegalArgumentException If denominator is zero
	 */
	public Fraction(int n, int d)throws IllegalArgumentException{
		numerator = n;
		if(d == 0){
			throw new IllegalArgumentException("Denominator cannot be zero");
		}else	denominator = d;
	}

	@Override
	/**
	 * Add Method
	 * @param	Passes in a fraction to add with the object at hand
	 * @return Returns reduced sum of two fractions
	 */
	public Number add(Number num) {
		int n3 = 0;
		int d3 = 1;
		Fraction f = new Fraction(0,1);


		if(num instanceof Fraction){
			n3 = (((Fraction)num).getNumerator() * getDenominator()) + (getNumerator() * ((Fraction)num).getDenominator());
			d3 = getDenominator() * ((Fraction)num).getDenominator();

			f.setNumerator(n3);
			f.setDenominator(d3);

		}

		return reduce(f);
	}

	@Override
	/**
	 * Subtract Method
	 * @param	Passes in a fraction to subtract with the object at hand
	 * @return Returns reduced difference of two fractions
	 */
	public Number subtract(Number num)throws IllegalArgumentException {
		int n3 = 0;
		int d3 = 1;
		Fraction f = new Fraction(0,1);

		if(num instanceof Fraction){
			n3 = ((getNumerator() * ((Fraction)num).getDenominator() - ((Fraction)num).getNumerator() * getDenominator()));
			d3 = getDenominator() * ((Fraction)num).getDenominator();

			f.setNumerator(n3);
			f.setDenominator(d3);
		}

		return reduce(f);
	}

	@Override
	/**
	 * Multiply Method
	 * @param	Passes in a fraction to multiply with the object at hand
	 * @return Returns reduced product of two fractions
	 */
	public Number multiply(Number num)throws IllegalArgumentException {
		Fraction f = new Fraction(0,1);


		if(num instanceof Fraction){
			if(getDenominator() == 0){
				throw new IllegalArgumentException ("Dividing by zero");
			}
			f.setNumerator(((Fraction)num).getNumerator() * getNumerator());
			f.setDenominator(((Fraction)num).getDenominator() * getDenominator());
		}
		return reduce(f);
	}

	@Override
	/**
	 * Divide Method
	 * @param	Passes in a fraction to divide with the object at hand
	 * @return Returns reduced quotient of two fractions
	 */
	public Number divide(Number num)throws IllegalArgumentException {
		Fraction f = new Fraction(0,1);


		if(num instanceof Fraction){
			if(getNumerator() == 0 || ((Fraction)num).getNumerator() == 0){
				throw new IllegalArgumentException ("Cannot divide by zero");
			}
			f.setNumerator(((Fraction)num).getDenominator() * getNumerator());
			f.setDenominator(((Fraction)num).getNumerator() * getDenominator());
		}
		return reduce(f);
	}

	/**
	 * Finds the GCF of two numbers
	 * @param a	Number 1 (Denominator 1)
	 * @param b	Number 2 (Denominator 2)
	 * @return Returns GCF
	 */
	public int gcf(int a, int b){
		return b == 0 ? a : gcf(b, a % b); 
	}

	/**
	 * Returns a reduced fraction
	 * @param f	Passed fraction
	 * @return	Returns reduced fraction
	 */
	public Fraction reduce(Fraction f){
		int gcf = gcf(f.getNumerator(), f.getDenominator());
		Fraction frac = new Fraction(0,1);

		frac.setNumerator(f.getNumerator()/gcf);
		frac.setDenominator(f.getDenominator()/gcf);

		//Used to bring sign to numerator
		if(frac.getDenominator() < 0){
			frac.setNumerator(frac.getNumerator()*-1);
			frac.setDenominator(frac.getDenominator()*-1);
		}

		return frac;
	}

	/**
	 * Checks if Denominator is one
	 * @return	True if denominator is one
	 */
	public boolean isDenominatorOne(){
		return getDenominator() == 1;
	}

	/**
	 * Sets Numerator
	 * @param n	Numerator
	 */
	public void setNumerator(int n){
		numerator = n;
	}
	/**
	 * Sets Denominator
	 * @param d	Denominator
	 */
	public void setDenominator(int d){
		denominator = d;
	}

	/**
	 * Gets Numerator
	 * @return	Numerator
	 */
	public int getNumerator(){
		return numerator;
	}
	/**
	 * Gets Denominator
	 * @return	Denominator
	 */
	public int getDenominator(){
		return denominator;
	}

	/**
	 * ToString method for printing
	 * @param operation	Operation being performed 
	 * @return	Returns String to user
	 */
	public String toString(String operation){
		String str = "";
		if(this.isDenominatorOne()){
			str =  ("The " + operation + " of the two fractions is " + this.getNumerator());
		}else{
			str = ("The " + operation + " of the two fractions is " + this.getNumerator() + "/" +  this.getDenominator());
		}

		return str;
	}

}
