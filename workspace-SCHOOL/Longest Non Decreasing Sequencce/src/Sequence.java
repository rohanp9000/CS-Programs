/**
 * AP Computer Science B Block
 * Sequence.java
 * Purpose: This class is used to determine which sequence is the longest, and what the contents of that sequence are.
 *
 * @version 10/17/17
 * @author Rohan Prasad
 */

public class Sequence {

	private int [] sequenceVals;
	private int seqCount;

	/**
	 * Constructor
	 * @param size	Used to initialize array
	 */
	public Sequence(int size){
		sequenceVals = new int[size];
		seqCount = 0;
	}
	/**
	 * Puts the numbers into sequences
	 * @param value	Value to put into sequence
	 */
	public void putNumber(int value){

		sequenceVals[seqCount] = value;
		seqCount++;
		
	}
	/**
	 * returns sequence requested
	 * @return	Returns requested sequence
	 */
	public int[] getSequence(){
		return sequenceVals;
		
	}
	/**
	 * Returns length of requested sequence
	 * @return	Returns request sequencelength
	 */
	public int getSequenceCount(){
		return seqCount;
	}
	/**
	 * To string method to convert the sequences into Strings for later use
	 */
	public String toString(){
		String str = "";
		for(int i = 0; i < seqCount; i++){
			str = str + sequenceVals[i] + " ";
		}
		return str;
	}
	
}
