/**
 * AP Computer Science B Block
 * SequenceServer.java
 * Purpose: This class holds the array of sequences and is used to calculate and return the longest Non-Decreasing sequence
 *
 * @version 10/17/17
 * @author Rohan Prasad
 */

public class SequenceServer {

	private String sequence;//Holds the longest sequence
	private Sequence[] sequences;//Holds the list of all sequences
	private int seqObjCnt;//Holds the index of the sequence

	/**
	 * Constructor
	 */
	public SequenceServer(){

		sequence = "";
		seqObjCnt = 0;

	}

	/**
	 * This method returns the longest Non-Decreasing Sequence
	 * @param values	Array of values inputted
	 * @return	Returns the longest non decreasing sequence as a string
	 */
	public String getLongestDecreasingSequence(int[] values){
		clear();
		init(values.length);

		for(int i = 0; i < values.length; i++){

			if(i == 0){
				sequences[seqObjCnt] = new Sequence(values.length);
				sequences[seqObjCnt].putNumber(values[i]);
				continue;
			}

			if(values[i] >= values[i-1]){
				sequences[seqObjCnt].putNumber(values[i]);	

			}else{
				seqObjCnt++;
				sequences[seqObjCnt] = new Sequence(values.length);
				sequences[seqObjCnt].putNumber(values[i]);

			}

		}

		determineLongestSequence();

		return sequence;


	}
	/**
	 * Determines the longest decreasing sequence
	 */
	private void determineLongestSequence(){
		int greatestNumber = 0;
		for(int i = 0; i <= seqObjCnt; i++){
			if(i == 0){
				sequence = sequences[i].toString();
				greatestNumber = sequences[i].getSequenceCount(); 
				continue;
			}

			if(sequences[i].getSequenceCount() > greatestNumber){
				sequence = sequences[i].toString();
				greatestNumber = sequences[i].getSequenceCount(); 
			}else if(sequences[i].getSequenceCount() == greatestNumber){
				sequence = sequence + "\n" + sequences[i].toString();
			}else{
			}
		}
	}

	/** 
	 * Clears values and resets indexes 
	 */
	public void clear(){
		for(int i = 0; i <= seqObjCnt; i++){
			if(sequences != null){
				sequences = null;

			}
		}

		seqObjCnt = 0;

	}
	/**
	 * Initializes the array of size inputted
	 * @param size	Dimension of array
	 */
	private void init(int size){
		sequences = new Sequence[size];

	}
}
