/**
 * AP Computer Science B Block
 * Number.java
 * Purpose: This interface contains the methods used in Fraction/ComplexFraction/Complex Number classes
 *
 * @version 12/18/17
 * @author Rohan Prasad
 */

public interface Number {
	/**
	 * Addition Method
	 * @param num	Passed Number
	 * @return Returns sum of two numbers
	 */
	 public Number add(Number num);
	 /**
	  * Subtraction Method
	  * @param num	Passed Number
	  * @return	Returns difference of two numbers
	  */
	 public Number subtract(Number num);
	 /**
	  * Multiply Method
	  * @param num	Passed Number
	  * @return	Returns product of two numbers
	  */
	 public Number multiply(Number num);
	 /**
	  * Divide Method
	  * @param num	Passed Number
	  * @return	Returns quotient of two numbers
	  */
	 public Number divide(Number num);
}
