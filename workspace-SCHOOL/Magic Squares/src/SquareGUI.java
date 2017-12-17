/**
 * AP Computer Science B Block
 * SquareGUI.java
 * Purpose: This class is used to display a GUI to the user, and print values requested.
 *
 * @version 10/2/17
 * @author Rohan Prasad
 */

import BreezySwing.*;
import javax.swing.*;

public class SquareGUI extends GBFrame {
	MagicSquare sqr;
	int size = 0;
	private JButton b2;//button for 2x2
	private JButton b3;//button for 3x3
	private JButton b4;//button for 4x4
	private JButton b5;//button for 5x5
	private JButton b6;//button for 6x6
	private JButton b7;//button for 7x7
	private JButton b8;//button for 8x8

	private JLabel dimension;//Displays the choice of dimensions

	private JButton inputButton;//Used to input the final values

	IntegerField[][] inputFields;//2 Dimensional array of IntegerFields
	int [] [] values;//2 Dimensional array that holds the values;


	/**
	 * Constructor
	 */
	public SquareGUI(){
		sqr = new MagicSquare();
		b2 = addButton("2x2", 1, 1, 1, 1);
		b3 = addButton("3x3", 1, 2, 1, 1);
		b4 = addButton("4x4", 1, 3, 1, 1);
		b5 = addButton("5x5", 1, 4, 1, 1);
		b6 = addButton("6x6", 1, 5, 1, 1);
		b7 = addButton("7x7", 1, 6, 1, 1);
		b8 = addButton("8x8", 1, 7, 1, 1);

		dimension = addLabel("Click the button for which dimension you would like your Magic Square to be:", 1, 1, 1, 1);

		inputButton = addButton("Submit: ", 9, 2, 1, 1);


		inputButton.setVisible(false);

	}

	/**
	 * ButtonClicked Method
	 * @param button	Button clicked
	 */
	public void buttonClicked (JButton button){
		if(button == b2){
			this.buttonVisibility();
			size = 2;
			this.printInputFields(size);
		}

		if(button == b3){
			this.buttonVisibility();
			size = 3;
			this.printInputFields(size);
		}

		if(button == b4){
			this.buttonVisibility();
			size = 4;
			this.printInputFields(size);
		}

		if(button == b5){
			this.buttonVisibility();
			size = 5;
			this.printInputFields(size);
		}

		if(button == b6){
			this.buttonVisibility();
			size = 6;
			this.printInputFields(size);
		}

		if(button == b7){
			this.buttonVisibility();
			size = 7;
			this.printInputFields(size);
		}

		if(button == b8){
			this.buttonVisibility();
			size = 8;
			this.printInputFields(size);
		}
		if(button == inputButton) {
			checkSquare(size);

		}
	}

	/**
	 * Sets visibility of certain elements
	 */
	public void buttonVisibility(){
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		b8.setVisible(false);
		dimension.setVisible(false);
		inputButton.setVisible(true);

	}

	/**
	 * Prints the integer fields.
	 * @param size	Dimensions of square
	 */
	public void printInputFields(int size){
		inputFields = new IntegerField[size][size];

		for(int i = 0; i < inputFields.length; i ++) {

			for (int j = 0; j < inputFields[0].length; j++) {

				inputFields[i][j] = addIntegerField(0,i+2,j+1,1,1);

			}
		}
	}


	/**
	 * Pulls values from integer fields and displays whether square is magic or not.
	 * @param size	Dimensions of square
	 * 
	 */
	public void checkSquare(int size) {
		sqr.pullValues(size, inputFields);
		
		if(sqr.getIsErrorValid()){
			messageBox("One of your inputs is invalid. Please reinput and try again.");
		}else{
			if(sqr.isMagicSquare(sqr.pullValues(size, inputFields)) == -1){

				this.messageBox("This is not a magic square!!!!");
				System.exit(0);
			}else {
				this.messageBox("Yes, this is a magic square, with magic number: " + sqr.isMagicSquare(sqr.pullValues(size, inputFields)) );
				System.exit(0);
			}
		}
	}
	/**
	 * Main Method
	 */
	public static void main(String args[]){
		SquareGUI GUI = new SquareGUI();
		GUI.setSize(1500,1000);
		GUI.setVisible(true);
	}

}


