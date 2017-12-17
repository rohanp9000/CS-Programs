/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This is an abstract class that is the super class of Book and Periodical
 *
 * @version 11/30/17
 * @author Rohan Prasad
 */

public abstract class Item implements Comparable {

	private String title;//Title of item

	/**
	 * Constructor
	 * @param title	Title of item
	 */
	public Item(String title){
		this.title = title;
	}

	/**
	 * Acessor method for Title
	 * @return
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Set Title of Item
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Print Method
	 * @return	String of values
	 */
	abstract String print();
	/**
	 * compareTo Method
	 */
	public abstract int compareTo(Object o) throws IllegalArgumentException;


}
