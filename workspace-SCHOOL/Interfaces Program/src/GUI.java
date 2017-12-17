/**
 * AP Computer Science B Block
 * GUI.java
 * Purpose: This class produces the interface and inputs values from the User
 *
 * @version 12/18/17
 * @author Rohan Prasad
 */


import BreezySwing.*;
import javax.swing.*;

public class GUI extends GBFrame {

	private JButton fraction;//Fraction Interface Button
	private JButton complex;//Complex Interface Button


	private DoubleField realNumerator1;//Holds value of numerator 1
	private DoubleField imaginaryNumerator1;//Holds value of imaginary numerator 1
	private IntegerField realDenominator1;//Holds value of real denominator

	private DoubleField realNumerator2;//Holds value of numerator 2
	private DoubleField imaginaryNumerator2;//Holds value of imaginary numerator2
	private IntegerField realDenominator2;//Holds value of real denominator 2
	private IntegerField imaginaryDenominator1;//Holds value of imaginary denominator
	private IntegerField imaginaryDenominator2;//Holds value of imaginary denominator 2

	private JTextArea outputField;//Output Field

	private JButton add;//Add button
	private JButton subtract;//Subtract Button
	private JButton multiply;//Multiply Button
	private JButton divide;//Divide Button

	/**
	 * Constructor
	 */
	public GUI(){

		fraction = addButton("Fraction", 6, 2, 1, 1);
		complex = addButton("Complex", 6, 4, 1, 1);

		realNumerator1 = addDoubleField(0, 1, 1, 1, 1);
		imaginaryNumerator1 = addDoubleField(0, 1, 2, 1, 1);
		realDenominator1 = addIntegerField(0, 2, 1, 1, 1);
		imaginaryDenominator1 = addIntegerField(0, 2, 2, 1, 1);

		realNumerator2 = addDoubleField(0, 1, 4, 1, 1);
		imaginaryNumerator2 = addDoubleField(0, 1, 5, 1, 1);
		realDenominator2 = addIntegerField(0, 2, 4, 1, 1);
		imaginaryDenominator2 = addIntegerField(0, 2, 5, 1, 1);

		realNumerator1.setText("");
		realNumerator2.setText("");
		imaginaryNumerator1.setText("");
		imaginaryNumerator2.setText("");
		realDenominator1.setText("");
		realDenominator2.setText("");
		imaginaryDenominator1.setText("");
		imaginaryDenominator2.setText("");

		add = addButton("Add", 4, 1, 1, 1);
		subtract = addButton("Subtract", 4, 2, 1, 1);
		multiply = addButton("Multiply", 4, 3, 1, 1);
		divide = addButton("Divide", 4, 4, 1, 1);

		outputField = addTextArea("", 5, 1, 5, 1);

		complex.setEnabled(false);


	}

	/**
	 * ButtonClicked Method
	 * @param	button 	Button clicked
	 */
	public void buttonClicked(JButton button){
		if(button == fraction){
			imaginaryNumerator1.setVisible(false);
			imaginaryNumerator2.setVisible(false);
			fraction.setEnabled(false);
			complex.setEnabled(true);
			imaginaryDenominator1.setVisible(false);
			imaginaryDenominator2.setVisible(false);
		}
		if(button == complex){
			imaginaryNumerator1.setVisible(true);
			imaginaryNumerator2.setVisible(true);
			complex.setEnabled(false);
			fraction.setEnabled(true);
			imaginaryDenominator1.setVisible(true);
			imaginaryDenominator2.setVisible(true);

		}

		if(button == add){
			addOperation();
		}

		if(button == subtract){
			subtractOperation();
		}
		if(button == multiply){
			multiplyOperation();
		}
		if(button == divide){
			divideOperation();
		}

	}

	/**
	 * Covers button clicked instances for the add operation
	 */
	private void addOperation() {
		if(isComplex()){
			//Complex is Enabled
			if(realDenominator1.getText().isEmpty() && realDenominator2.getText().isEmpty()){
				try{
					ComplexNumber cn1 = new ComplexNumber(realNumerator1.getNumber(), imaginaryNumerator1.getNumber());
					ComplexNumber cn2 = new ComplexNumber(realNumerator2.getNumber(), imaginaryNumerator2.getNumber());
					ComplexNumber cn3 = new ComplexNumber(0,0);

					cn3 = (ComplexNumber)cn1.add(cn2);

					outputField.setText(cn3.toString("difference"));
					clearFields();

				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}else{
				try{
					ComplexFraction c1 = new ComplexFraction((int)realNumerator1.getNumber(), realDenominator1.getNumber(), (int)imaginaryNumerator1.getNumber(), imaginaryDenominator1.getNumber());
					ComplexFraction c2 = new ComplexFraction((int)realNumerator2.getNumber(), realDenominator2.getNumber(), (int)imaginaryNumerator2.getNumber(), imaginaryDenominator2.getNumber());
					ComplexFraction c3 = new ComplexFraction (0,1,0,1);

					c3 = (ComplexFraction)c1.add(c2);

					outputField.setText(c3.toString("sum"));	
					clearFields();
				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}

		}else if(!isComplex()){
			//Fraction is Enabled

			try{
				Fraction f1 = new Fraction((int)realNumerator1.getNumber(),realDenominator1.getNumber());
				Fraction f2 = new Fraction((int)realNumerator2.getNumber(),realDenominator2.getNumber());
				Fraction f3 = new Fraction(0,1);

				f3 = (Fraction)f1.add(f2);

				outputField.setText(f3.toString("sum"));
				clearFields();
			}catch(Exception e){
				messageBox(e.getMessage());
			}

		}
	}

	/**
	 * Covers button clicked instances for the subtract operation
	 */
	private void subtractOperation() {
		if(isComplex()){
			//Complex is Enabled
			if(realDenominator1.getText().isEmpty() && realDenominator2.getText().isEmpty()){
				try{
					ComplexNumber cn1 = new ComplexNumber(realNumerator1.getNumber(), imaginaryNumerator1.getNumber());
					ComplexNumber cn2 = new ComplexNumber(realNumerator2.getNumber(), imaginaryNumerator2.getNumber());
					ComplexNumber cn3 = new ComplexNumber(0,0);

					cn3 = (ComplexNumber)cn1.subtract(cn2);

					outputField.setText(cn3.toString("difference"));
					clearFields();

				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}else{
				try{
					ComplexFraction c1 = new ComplexFraction((int)realNumerator1.getNumber(), realDenominator1.getNumber(), (int)imaginaryNumerator1.getNumber(), imaginaryDenominator1.getNumber());
					ComplexFraction c2 = new ComplexFraction((int)realNumerator2.getNumber(), realDenominator2.getNumber(), (int)imaginaryNumerator2.getNumber(), imaginaryDenominator2.getNumber());
					ComplexFraction c3 = new ComplexFraction (0,1,0,1);

					c3 = (ComplexFraction)c1.subtract(c2);

					outputField.setText(c3.toString("difference"));	
					clearFields();
				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}

		}else if(!isComplex()){
			//Fraction is Enabled
			try {
				Fraction f1 = new Fraction((int)realNumerator1.getNumber(),realDenominator1.getNumber());
				Fraction f2 = new Fraction((int)realNumerator2.getNumber(),realDenominator2.getNumber());
				Fraction f3 = new Fraction(0,1);

				f3 = (Fraction)f1.subtract(f2);

				outputField.setText(f3.toString("difference"));
				clearFields();
			} catch(Exception e){
				messageBox(e.getMessage());
			}
		}
	}

	/**
	 * Covers button clicked instances for multiply operation
	 */
	private void multiplyOperation() {
		if(isComplex()){
			//Complex is Enabled
			if(realDenominator1.getText().isEmpty() && realDenominator2.getText().isEmpty()){
				try{
					ComplexNumber cn1 = new ComplexNumber(realNumerator1.getNumber(), imaginaryNumerator1.getNumber());
					ComplexNumber cn2 = new ComplexNumber(realNumerator2.getNumber(), imaginaryNumerator2.getNumber());
					ComplexNumber cn3 = new ComplexNumber(0,0);

					cn3 = (ComplexNumber)cn1.multiply(cn2);

					outputField.setText(cn3.toString("difference"));
					clearFields();

				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}else{
				try{
					ComplexFraction c1 = new ComplexFraction((int)realNumerator1.getNumber(), realDenominator1.getNumber(), (int)imaginaryNumerator1.getNumber(), imaginaryDenominator1.getNumber());
					ComplexFraction c2 = new ComplexFraction((int)realNumerator2.getNumber(), realDenominator2.getNumber(), (int)imaginaryNumerator2.getNumber(), imaginaryDenominator2.getNumber());
					ComplexFraction c3 = new ComplexFraction (0,1,0,1);

					c3 = (ComplexFraction)c1.multiply(c2);

					outputField.setText(c3.toString("product"));	
					clearFields();
				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}
		}else if(!isComplex()){
			//Fraction is Enabled
			try{
				Fraction f1 = new Fraction((int)realNumerator1.getNumber(),realDenominator1.getNumber());
				Fraction f2 = new Fraction((int)realNumerator2.getNumber(),realDenominator2.getNumber());
				Fraction f3 = new Fraction(0,1);

				f3 = (Fraction)f1.multiply(f2);

				outputField.setText(f3.toString("product"));
				clearFields();
			}catch(Exception e){
				messageBox(e.getMessage());
			}
		}

	}

	/**
	 * covers buttonClicked instances for division operation
	 */
	private void divideOperation() {
		if(isComplex()){
			//Complex is Enabled
			if(realDenominator1.getText().isEmpty() && realDenominator2.getText().isEmpty()){
				try{
					ComplexNumber cn1 = new ComplexNumber(realNumerator1.getNumber(), imaginaryNumerator1.getNumber());
					ComplexNumber cn2 = new ComplexNumber(realNumerator2.getNumber(), imaginaryNumerator2.getNumber());
					ComplexNumber cn3 = new ComplexNumber(0,0);

					cn3 = (ComplexNumber)cn1.divide(cn2);

					outputField.setText(cn3.toString("difference"));
					clearFields();

				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}else{
				try{
					ComplexFraction c1 = new ComplexFraction((int)realNumerator1.getNumber(), realDenominator1.getNumber(), (int)imaginaryNumerator1.getNumber(), imaginaryDenominator1.getNumber());
					ComplexFraction c2 = new ComplexFraction((int)realNumerator2.getNumber(), realDenominator2.getNumber(), (int)imaginaryNumerator2.getNumber(), imaginaryDenominator2.getNumber());
					ComplexFraction c3 = new ComplexFraction (0,1,0,1);

					c3 = (ComplexFraction)c1.divide(c2);

					outputField.setText(c3.toString("quotient"));	
					clearFields();
				}catch(Exception e){
					messageBox(e.getMessage());
				}
			}

		}else if(!isComplex()){
			//Fraction is Enabled
			try{
				Fraction f1 = new Fraction((int)realNumerator1.getNumber(),realDenominator1.getNumber());
				Fraction f2 = new Fraction((int)realNumerator2.getNumber(),realDenominator2.getNumber());
				Fraction f3 = new Fraction(0,1);

				f3 = (Fraction)f1.divide(f2);

				outputField.setText(f3.toString("quotient"));
				clearFields();
			}catch(Exception e){
				messageBox(e.getMessage());
			}

		}
	}

	/**
	 * Determines if complex interface is on
	 * @return	If complex is on or off
	 */
	private boolean isComplex(){
		if(fraction.isEnabled()){
			return true;
		}
		else return false;
	}



	/**
	 * Clears fields of GUI
	 */
	private void clearFields(){
		realNumerator1.setText("");
		realNumerator2.setText("");
		realDenominator1.setText("");
		realDenominator2.setText("");
		imaginaryNumerator1.setText("");
		imaginaryNumerator2.setText("");
		imaginaryDenominator1.setText("");
		imaginaryDenominator2.setText("");
	}

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]){
		GUI GUI = new GUI();
		GUI.setSize(800,800);
		GUI.setVisible(true);
		
	
	}


}

