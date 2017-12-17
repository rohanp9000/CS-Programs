/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class holds the array of items and interacts with it
 *
 * @version 11/30/17
 * @author Rohan Prasad
 */

public class Manager {

	private final int ARRAYSIZE = 10;//Size of array
	private Item[] itemArray;//Array that holds all items
	private int numItems;//Count of items in array

	/**
	 * Constructor
	 */
	public Manager(){
		numItems = 0;
		itemArray = new Item[ARRAYSIZE];
	}

	/**
	 * AddItem method; Adds items to array
	 * @param item	Item to add
	 * @throws IllegalArgumentException If the array is full
	 */
	public void addItem(Item item)throws IllegalArgumentException{
		if(numItems == ARRAYSIZE){
			throw new IllegalArgumentException("Array Full!");
		}
		else{
			itemArray[numItems] = item;
			numItems++;
		}
	}

	/**
	 * Prints books
	 * @return	Returns string of book listing
	 * @throws IllegalArgumentException	Throws exception if there are no books
	 */
	public String printBooks()throws IllegalArgumentException{
		String str = "";
		for(int i = 0; i< numItems; i++){
			if(itemArray[i] instanceof Book){ 
				str+= itemArray[i].print() + "\n";
			}
		}
		if(str.equals("")){
			throw new IllegalArgumentException ("There are no Books.");
		}else return str;
	}

	/**
	 * Prints Periodicals
	 * @return	String of periodical listings
	 * @throws IllegalArgumentException	If there are no Periodicals
	 */
	public String printPeriodicals()throws IllegalArgumentException{
		String str = "";
		for(int i = 0; i< numItems; i++){
			if(itemArray[i] instanceof Periodical){ 
				str += itemArray[i].print() + "\n";
			}
		}
		if(str.equals("")){
			throw new IllegalArgumentException ("There are no Periodicals.");
		}else return str;
	}

	/**
	 * Print All
	 * @return	String of all items in the array
	 * @throws IllegalArgumentException	If there are no items in the array
	 */
	public String printAll()throws IllegalArgumentException{
		String str = "";
		for(int i = 0; i< numItems; i++){
			str+= itemArray[i].print() + "\n";
		}
		if(str.equals("")){
			throw new IllegalArgumentException ("There are no Items.");
		}else return str;
	}

	/**
	 * Compares Items in Array
	 * @param itemPassed	Item passed into method for comparison
	 * @return	Returns String of comparisons with other objects
	 * @throws IllegalArgumentException	Throws exception if there is a type mismatch or if there aren't any items
	 */
	public String compareItems(Item itemPassed) throws IllegalArgumentException{
		String str = "";
		
		for (int i = 0; i < numItems; i++){
			try{
				if(itemPassed.compareTo(itemArray[i]) == 0){
					str += itemArray[i].getTitle() + " is equal to " + itemPassed.getTitle() + "\n";

				}
				else if(itemPassed.compareTo(itemArray[i]) < 0){
					str += itemArray[i].getTitle() + " is before " + itemPassed.getTitle() + "\n";


				}
				else if(itemPassed.compareTo(itemArray[i]) > 0){
					str += itemArray[i].getTitle() + " is after " + itemPassed.getTitle() + "\n";

				}
			}catch(IllegalArgumentException e){
				str += e.getMessage();
			}
		}


		if(str.isEmpty()){
			throw new IllegalArgumentException("No items found");

		}else return str;

	}

	/**
	 * Removes all Items from the Array
	 */
	public void removeAll(){
		for(int i = 0; i< numItems; i++){
			itemArray[i] = null;
		}
		numItems = 0;
	}
	/**
	 * Removes all Books from array
	 */
	public void removeBooks(){
		for(int i = 0; i< numItems; i++){
			if(itemArray[i] instanceof Book){
				itemArray[i] = null;
			}

		}
		rePackArray();
	}
	/**
	 * Removes all Periodicals from array
	 */
	public void removePeriodicals(){
		for(int i = 0; i< numItems; i++){
			if(itemArray[i] instanceof Periodical){
				itemArray[i] = null;
			}

		}
		rePackArray();
	}

	/**
	 * Fills in Null values in the array
	 */
	public void rePackArray(){
		Item itemCopy[] = new Item[ARRAYSIZE];
		int copyCount = 0;

		for(int i = 0; i < numItems; i++){
			if(itemArray[i] != null){
				itemCopy[copyCount] = itemArray[i];
				copyCount++;
			}
		}

		itemArray = itemCopy;
		numItems = copyCount;
	}





}

