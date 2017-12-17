/**
 * AP Computer Science B Block
 * SequenceGUI.java
 * Purpose: This class is used to display the GUI to the user, and input and output information.
 *
 * @version 10/17/17
 * @author Rohan Prasad
 */

import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
public class SequenceGUI extends GBFrame {

	private JTextField inputField;//Field used to input data from user
	private JTextArea outputField;//Field used to display Longest non Decreasing Sequence

	private JButton input;//Button to input values
	private JButton output;//Button to output longest non decreasing sequence

	private JButton reset;//Button to reset fields and values
	private JButton exit;//Button to close out of the program


	private int [] iValues;//Holds values inputted by user

	SequenceServer seq = new SequenceServer();

	/**
	 * Constructor
	 */
	public SequenceGUI(){

		//Initializes fields and buttons in GUI window
		inputField = addTextField("", 1, 1, 1, 1);
		outputField = addTextArea("", 3, 1, 1, 1);
		input = addButton("Input values: ", 2, 1, 1, 1);
		output = addButton("Output Longest Non-Decreasing Sequence: ", 4, 1, 1, 1);
		reset = addButton("Reset: ", 5, 1, 1, 1);
		exit = addButton("Exit Program ", 6, 1, 1, 1);

		//Sets initial status of some buttons and fields so they cannot be clicked without prior input
		output.setEnabled(false);
		outputField.setEnabled(false);
		reset.setEnabled(false);

	}
	/**
	 * This method is used to determine what action to take when a certain button is clicked in the GUI
	 */
	public void buttonClicked(JButton button){
		//Input button clicked
		if(button == input){
			//Clears outputfield
			outputField.setText("");

			if(inputField.getText().equals("")){
				messageBox("You must enter some values! Please try again.");

			}else{

				//Uses String Tokenizer in order to split up values inputted into field.
				StringTokenizer st = new StringTokenizer(inputField.getText(), ", ");
				int numTokens =  st.countTokens();
				iValues = new int[numTokens];

				//Separates the values and places them into int array
				for(int i = 0; st.hasMoreTokens() ; i++){
					iValues[i] = Integer.parseInt(st.nextToken()); 
					outputField.append(iValues[i] + " ");
				}
				//Re enables disabled buttons
				output.setEnabled(true);
				outputField.setEnabled(true);
				reset.setEnabled(true);
			}

		}
		//Output button clicked
		if(button == output){
			String outValue = seq.getLongestDecreasingSequence(iValues);
			//Prints value to outputfield
			outputField.append("\n" + "Longest Non-Decreasing Sequence(s): " + "\n" + outValue );
		}
		if(button == reset){
			inputField.setText("");
			outputField.setText("");
			seq.clear();
		}
		if(button == exit){
			this.messageBox("Goodbye.");
			System.exit(0);
		}
	}
	/**
	 * Main Method
	 */
	public static void main(String args[]){
		SequenceGUI GUI = new SequenceGUI();
		GUI.setSize(600,800);
		GUI.setVisible(true);
	}



}
