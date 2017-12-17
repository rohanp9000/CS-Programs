/**
 * AP Computer Science B Block
 * StaticGUI.java
 * Purpose: This class holds the GUI elements and interacts with the user. 
 *
 * @version 10/27/17
 * @author Rohan Prasad
 */

import BreezySwing.*;
import javax.swing.*;

public class StaticGUI extends GBFrame {
	
	private JTextArea outputField;//Field to output information
	
	private JTextField empName;//TextField that takes in Employee Name
	private IntegerField empAge;//IntegerField that takes in the employee age
	
	private JTextField stuName;//TextField that takes in Student Name
	private IntegerField stuAge;//IntegerField that takes in Student Age
	private IntegerField stuGrade;//IntegerField that takes in Student Grade
	
	private JLabel directions;//Directions to use program
	
	private JButton inputStu;//Button to input Student Information
	private JButton inputEmp;//Button to input Employee Information
	private JButton empInfo;//Button to output all Employee Information
	private JButton stuInfo;//Button to output all Student Information
	private JButton age;//Button to output all people at a certain age
	private JButton numPpl;//Button to return the number of each type
	
	PersonServer ps = new PersonServer();
	
	
	/**
	 * Constructor
	 */
	public StaticGUI(){
		//Initializes the GUI elements
		directions = addLabel("Choose whether you want to input Employee or Student First", 1, 1, 1, 1);
		
		empName = addTextField("Name", 2, 1, 1, 1);
		empAge = addIntegerField(0, 2, 2, 1, 1);
		
		stuName = addTextField("Name", 2 ,4, 1, 1);
		stuAge = addIntegerField(0, 2 ,5, 1, 1);
		stuGrade = addIntegerField(0, 2 ,6, 1, 1);
		
		inputEmp = addButton("Input Employee", 3, 1, 1, 1);
		inputStu = addButton("Input Student", 3, 4,1, 1);
		
		empInfo = addButton("All Employee Info", 4, 1, 1, 1);
		stuInfo = addButton("All Student Info", 4, 2, 1, 1);		
		age = addButton("All Names Given Age", 4, 3, 1, 1);
		numPpl = addButton("Number of total people", 4, 4, 1, 1);
		
		outputField = addTextArea("", 6, 1, 7, 1);
	}
	/**
	 * Actions if buttons are clicked
	 * @param button	Button Object that is clicked
	 */
	public void buttonClicked(JButton button)throws IllegalArgumentException{
		//Input Student Data Button
		if(button == inputStu){
			try {
				ps.addStudent(stuName.getText(), stuAge.getNumber(), stuGrade.getNumber());
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage()); 
			}
			stuName.setText("");
			stuAge.setNumber(0);
			stuGrade.setNumber(0);
		}
		//Input Employee Data Button
		if(button == inputEmp){
			try {
				ps.addEmployee(empName.getText(), empAge.getNumber());
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}
			empName.setText("");
			empAge.setNumber(0);
		
		}
		//Output All Employee Information
		if(button == empInfo){
			outputField.setText(ps.getAllEmpInformation());
		}
		//Output All Student Information
		if(button == stuInfo){
			outputField.setText(ps.getAllStuInformation());
		}
		//Output All People at Certain Age
		if(button == age){
			int age = Integer.parseInt(outputField.getText());
			outputField.setText( ps.nameAtAge(age));
		}

		//Output each type of person
		if(button == numPpl){
			outputField.setText(ps.getPersons());
		}
	}
	/**
	 * Main Method
	 */
	public static void main(String args[]){
		StaticGUI GUI = new StaticGUI();
		GUI.setSize(1500,1400);
		GUI.setVisible(true);
	}



}
