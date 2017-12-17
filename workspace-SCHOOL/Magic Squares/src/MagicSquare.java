/**
 * AP Computer Science B Block
 * MagicSquare.java
 * Purpose: This class is used to determine if the inputs form a magic square or not, and what the magic number is.
 *
 * @version 10/2/17
 * @author Rohan Prasad
 */

import BreezySwing.*;

public class MagicSquare {
	private int[][]values; //Holds values in array
	private boolean isErrorInput;//Determines if the array has any invalid inputs.

	/**
	 * Constructor
	 */
	public MagicSquare() {
		isErrorInput = false;

	}
	/**
	 * This method pulls the values from the Integer Fields, and puts them in an array of integers
	 * @param size	Size of the array
	 * @param inputFields	Array of input fields (IntegerFields) which the data is typed into
	 * @return	Returns the array of values in a 2 dimensional int array
	 */
	public int[][] pullValues(int size, IntegerField[][] inputFields){
		values = new int[size][size];
		isErrorInput = false;

		for(int i = 0; i < inputFields.length; i ++) {

			for (int j = 0; j < inputFields[0].length; j++) {

				values[i][j] = inputFields[i][j].getNumber();
				if(values[i][j] < 0){
					isErrorInput = true;
					break;
				}
			}
			if(isErrorInput){
				break;
			}
		
		}
		return values;
	}
	/**
	 * 
	 * @param matrix	Array holding the values for the square
	 * @return			Returns the magic number
	 */
	public int isMagicSquare(int [][] matrix){
		if(rowSum(matrix) && colSum(matrix) && diaSum(matrix)) {
			return magicNumber(matrix);
		}else return -1;
	}
	/**
	 * 
	 * @param matrix	Array holding the values for the square
	 * @return			Whether the row sum is consistent throughout
	 */
	public boolean rowSum(int [][] matrix) {
		boolean a = false;

		for(int row = 0; row < matrix.length; row ++) {
			int sum = 0;

			for(int col = 0; col < matrix.length; col++) {
				sum += matrix[row][col];
			

			}
			if(sum != this.magicNumber(matrix)) {
				a = false;
				break;
			}else a = true;

		}
		return a;
	}
	/**
	 * 
	 * @param matrix	Array holding the values for the square
	 * @return			Whether the column sum is consistent throughout
	 */
	public boolean colSum(int [][] matrix) {
		boolean a = false;

		for(int col = 0; col < matrix.length; col ++) {
			int sum = 0;

			for(int row = 0; row < matrix.length; row++) {
				sum += matrix[row][col];

			}
			if(sum != this.magicNumber(matrix)) {
				a = false;
				break;
			}else a = true;

		}
		return a;
	}
	/**
	 * 
	 * @param matrix	Array holding the values for the square
	 * @return			Whether the diagonal sum is consistent throughout
	 */
	public boolean diaSum(int [][] matrix) {
		boolean a = false;
		int matrixLength = matrix.length;
		int sum1 = 0;
		for (int dia = 0; dia < matrix.length; dia++) {
			sum1 += matrix[dia][dia];
		}
		if(sum1 != this.magicNumber(matrix)) {
			a = false;

		}else a = true;

		int sum2 = 0;
		for (int dia = 0; dia < matrix.length; dia++) {
			sum2 += matrix[matrixLength-1][dia];
			matrixLength--;
		}
		if(sum2 != this.magicNumber(matrix)) {
			a = false;

		}else a = true;


		return a;
	}
	/**
	 * Gets value of Error true or false
	 * @return	Returns the value of Error as a boolean.
	 */
	public boolean getIsErrorValid(){
		return isErrorInput;
	}

	/**
	 * 
	 * @param matrix	Array holding the values for the square
	 * @return			Returns the sum of a row to use as sample
	 */
	public int magicNumber(int [][] matrix) {
		int sum = 0;
		for(int col = 0; col < matrix.length; col++) {
			sum += matrix[1][col];
		}
		return sum;	
	}

}




