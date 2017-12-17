/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class produces the interface and inputs values from the User
 *
 * @version 11/30/17
 * @author Rohan Prasad
 */

import BreezySwing.*;
import javax.swing.*;
public class GUI extends GBFrame{

	private JLabel titleLabel;//Holds Label of Title
	private JLabel authorLabel;// Label of Author
	private JLabel issueNumber;//Label of issue number

	private JTextField titleField;// Title FIeld
	private JTextField authorField;//Author Field
	private IntegerField issueField;//Issue Number Field

	private JButton inBook;//Input book
	private JButton inPeriodical;//Input Periodical

	private JTextArea outputField;// Field for output

	private JButton printItems;//Prints all items
	private JButton printBooks;//Prints all books
	private JButton printPeriodicals;// Prints all periodicals

	private JButton compareBook;// Compares book entered to others
	private JButton comparePeriodical;//Compares periodical entered to others

	private JButton removeBooks;//Removes all books
	private JButton removePeriodicals;//Removes all periodicals
	private JButton removeAll;//Removes all items

	Manager mgr = new Manager();

	/**
	 * Constructor
	 */
	public GUI(){
		titleLabel = addLabel("TITLE: ", 1, 1, 1, 1);
		authorLabel = addLabel("AUTHOR: ", 1, 2, 1, 1);
		issueNumber = addLabel("ISSUE NUMBER: ", 1, 3, 1, 1);

		titleField = addTextField("", 2 ,1, 1, 1);
		authorField = addTextField("", 2, 2, 1 ,1);
		issueField = addIntegerField(0, 2, 3, 1, 1);
		issueField.setText("");

		inBook = addButton("Input Book", 3, 2, 1, 1);
		inPeriodical = addButton("Input Periodical", 3, 4, 1, 1);

		outputField = addTextArea("", 4, 1, 5, 1);

		printItems = addButton("Print All", 5, 2, 1, 1);
		printBooks = addButton("Print Books", 5, 3, 1, 1);
		printPeriodicals = addButton("Print Periodicals", 5, 4, 1, 1);
		compareBook = addButton("Compare Books", 6, 2 ,1 ,1);
		comparePeriodical = addButton("Compare Periodicals", 6, 3, 1, 1);

		removeBooks = addButton("Remove all Books", 7, 2, 1, 1);
		removePeriodicals = addButton("Remove all Periodicals", 7, 3, 1, 1);
		removeAll = addButton("Remove Everything", 7, 4, 1, 1);
	}

	/**
	 * ButtonClicked Method
	 * @param	button	Button clicked
	 */
	public void buttonClicked(JButton button){
		if(button == inBook){
			try {
				Book.checkValues(titleField.getText(), authorField.getText());
				Item b = new Book(titleField.getText(), authorField.getText());
				mgr.addItem(b);
				clearFields();


			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}

		}


		if(button == inPeriodical){
			try {
				Periodical.checkValues(titleField.getText(), issueField.getNumber());
				Item p = new Periodical(titleField.getText(), issueField.getNumber());
				mgr.addItem(p);
				clearFields();


			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}

		}

		if(button == printItems){
			try{
				outputField.setText(mgr.printAll());
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}

		if(button == printBooks){
			try{
				outputField.setText(mgr.printBooks());
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}

		if(button == printPeriodicals){
			try{
				outputField.setText(mgr.printPeriodicals());
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}
		if(button == compareBook){
			try {
				Book.checkValues(titleField.getText(), authorField.getText());
				Book b = new Book(titleField.getText(), authorField.getText());
				outputField.setText(mgr.compareItems(b));
				clearFields();


			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}

		}
		if(button == comparePeriodical){
			try {
				Periodical.checkValues(titleField.getText(), issueField.getNumber());
				Periodical p = new Periodical(titleField.getText(), issueField.getNumber());
				outputField.setText(mgr.compareItems(p));
				clearFields();


			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}

		}
		if(button == removeBooks){
			mgr.removeBooks();
		}
		if(button == removePeriodicals){
			mgr.removePeriodicals();
		}
		if(button == removeAll){
			mgr.removeAll();
		}



	}

	/**
	 * Clears all fields
	 */
	public void clearFields(){
		titleField.setText("");
		authorField.setText("");
		issueField.setText("");

	}
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]){
		GUI GUI = new GUI();
		GUI.setSize(1200,800);
		GUI.setVisible(true);
	}
}
