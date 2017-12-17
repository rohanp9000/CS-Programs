import BreezySwing.Format;

/**
 * AP Computer Science B Block
 * Student.java
 * Purpose: This class creates the student objects
 *
 * @version 10/27/17
 * @author Rohan Prasad
 */

public class Student {

	private String name;//Name of Student
	private int age;//Age of Student
	private int grade;//Grade of Student
	private final static int AGEMIN = 1;//Constant that holds minimum student age
	private final static int AGEMAX = 21;//Constant that holds maximum student age
	private final static int GRADEMIN = 1;//Constant that holds minimum student grade
	private final static int GRADEMAX = 12;//Constant that holds maximum student grade
	private static int stuCount;

	/**
	 * Constructor
	 * @param nm	Name of Student
	 * @param age1	Age of Student
	 * @param grd	Grade of Student
	 */
	public Student(String nm, int age1, int grd){

		name = nm;
		age = age1;
		grade = grd;
		stuCount++;

	}
	/**
	 * Gets Name
	 * @return	Name of Student
	 */
	public String getName(){
		return name;
	}
	/**
	 * Gets Age
	 * @return	Age of Student
	 */
	public int getAge(){
		return age;
	}
	/**
	 * Gets Grade
	 * @return	Grade of Student 
	 */
	public int getGrade(){
		return grade;
	}
	/**
	 * Checks if input is valid
	 * @param age	Age of Student
	 * @param name	Name of Student	
	 * @throws IllegalArgumentException	Used to throw exception when input is invalid
	 */
	public static void isInpValid(int age, int grade, String name) throws IllegalArgumentException{
		if(name.isEmpty()){
			throw new IllegalArgumentException("Name entered is invalid. Please try again.");
		}
			else if((grade < GRADEMIN || grade > GRADEMAX)){
			throw new IllegalArgumentException("Grade entered is invalid. Please try again.");
		}else if(age < AGEMIN || age > AGEMAX){
			throw new IllegalArgumentException("Age entered is invalid. Please try again.");

		}

	}
	/**
	 * Gets Count
	 * @return	Count/Number of Students in the array
	 */
	public static int getCount(){
		return stuCount;
	}
	/**
	 * To String Method
	 */
	public String toString(){
		String returnValue = Format.justify('l', "NAME:", 6) +
				Format.justify('l', getName(), 20) +
				Format.justify('l', "Age:", 5) +
				Format.justify('l', getAge(), 4) + 
				Format.justify('l', "Grade:", 7) + 
				Format.justify('l', getGrade(), 4); 

		
		return returnValue +  "\n";
	}
}


