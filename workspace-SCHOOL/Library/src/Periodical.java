/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: Used to create Periodical objects and print them
 *
 * @version 11/30/17
 * @author Rohan Prasad
 */

import BreezySwing.Format;

public class Periodical extends Item{

	private int id;//Holds the issue number of periodical
	
	/**
	 * Constructor
	 * @param title	Title of Periodical
	 * @param id	Issue Number of Periodical
	 */
	public Periodical(String name, int id){
		super(name);
		this.id = id;
	}
	
	/**
	 * Checks Values (Error Check)
	 * @param title	Title of Periodical
	 * @param id	Issue Number of Periodical
	 * @throws IllegalArgumentException	If the values are invalid
	 */
	public static void checkValues(String title, int id)throws IllegalArgumentException{
		if(title.equals("")){
			throw new IllegalArgumentException("Title is Invalid");
		}else if(id <= 0){
			throw new IllegalArgumentException("Issue Number is Invalid");
		}

	}
	
	/**
	 * Mutator Method
	 * @param id	Issue Number to change
	 */
	public void setID(int id){
		this.id = id;
	}
	
	/**
	 * Accessor Method
	 * @return	Returns ID
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * Print Method
	 * @return	String of Values
	 */
	public String print(){
		String str = "";
		str = Format.justify('l', "TITLE: " + getTitle(), 35) + 
				Format.justify('l', "\t ID: "+ id, 35);
		
		return str;
	}
	
	/**
	 * CompareTo
	 * @param	Object o
	 * @return	Equality of two objects
	 */
	public int compareTo(Object o)throws IllegalArgumentException {

		if(! (o instanceof Periodical )){
			throw new IllegalArgumentException (this.getTitle() + " is not a Periodical");
			
		}else return ((Periodical)(o)).getID() - getID();
	}
}

