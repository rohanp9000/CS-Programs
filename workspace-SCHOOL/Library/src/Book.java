/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: Used to create Book Objects and print
 *
 * @version 11/30/17
 * @author Rohan Prasad
 */

import BreezySwing.Format;

public class Book extends Item {

	private String author;// Author of the Book

	/**
	 * Constructor
	 * @param title	Title of book
	 * @param author	Author of Book
	 */
	public Book(String title, String author){
		super(title);
		this.author = author;
	}

	/**
	 * Checks Values (Error Check)
	 * @param title	Title of Book
	 * @param author	Author of Book
	 * @throws IllegalArgumentException	If the values are invalid
	 */
	public static void checkValues(String title, String author)throws IllegalArgumentException{
		if(title.equals("")){
			throw new IllegalArgumentException("Title is Invalid");
		}else if(author.equals("")){
			throw new IllegalArgumentException("Author is Invalid");
		}

	}

	/**
	 * Mutator Method
	 * @param author	Author to change
	 */
	public void setAuthor(String author){
		this.author = author;
	}

	/**
	 * Accessor Method
	 * @return Returns author
	 */
	public String getAuthor(){
		return author;
	}

	/**
	 * Print Method
	 * @return String of values
	 */
	public String print(){
		String str = "";
		str = Format.justify('l', "TITLE: " + getTitle(), 35) + 
				Format.justify('l', "\t AUTHOR: "+ author, 35);

		return str;
	}

	@Override
	/**
	 * CompareTo
	 * @param	Object o
	 * @return	Equality of two objects
	 */
	public int compareTo(Object o) {
		final int EQUAL = 0;
		final int AFTER = 1;
		final int BEFORE = -1;

		int equality = EQUAL;

		if(! (o instanceof Book )){
			throw new IllegalArgumentException (this.getTitle() + " is not a Book");

		}else{

			if(((Book)(o)).getAuthor().compareTo(getAuthor()) == 0){
				equality = EQUAL;
			}else if(((Book)(o)).getAuthor().compareTo(getAuthor()) < 0){
				equality = BEFORE;
			}else equality = AFTER;

			return equality;
		}
	}
}




