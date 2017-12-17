import BreezySwing.Format;

/**
 * AP Computer Science B Block
 * Employee.java
 * Purpose: This class creates the employee objects
 *
 * @version 10/27/17
 * @author Rohan Prasad
 */

public class Employee {

	private String name;//Name of Employee
	private int age;//Age of employee
	private final static int AGEMIN = 16;//Constant age; Min age for a valid employee
	private static int empCount;//Number of employees in database


	/**
	 * Constructor
	 * @param nm	Name of Employee
	 * @param age1	age of employee
	 */
	public Employee(String nm, int age1){

		name = nm;//Sets name to nm
		age = age1;//Sets age to age1
		empCount++;//Increases count of employee, because another employee object is being added

	}
	/**
	 * Gets Name
	 * @return	Name of Employee
	 */
	public String getName(){
		return name;
	}
	/**
	 * Gets Age
	 * @return	Age of Employee
	 */
	public int getAge(){
		return age;
	}

	/**
	 * Checks if input is valid
	 * @param age	Age of Employee
	 * @param name	Name of Employee	
	 * @throws IllegalArgumentException	Used to throw exception when input is invalid
	 */
	public static void isInpValid(int age, String name)throws IllegalArgumentException{
		if(name.isEmpty()){
			throw new IllegalArgumentException("Name entered is invalid. Please try again.");
		
			
		}else if(age < AGEMIN){
			throw new IllegalArgumentException("Age entered is invalid. Please try again.");

		}

	}

	
	/**
	 * Gets Count
	 * @return	Count/Number of employees in the array
	 */
	public static int getCount(){
		return empCount;
	}
	/**
	 * To String Method
	 */
	public String toString(){
		String returnValue = Format.justify('l', "NAME:", 6) +
				Format.justify('l', getName(), 20) +
				Format.justify('l', "Age:", 5) +
				Format.justify('l', getAge(), 4); 

		
		return returnValue +  "\n";
	}
}


