/**
 * AP Computer Science B Block
 * PersonServer.java
 * Purpose: Holds the arrays of Objects of student and employees, and performs operations on them
 *
 * @version 10/27/17
 * @author Rohan Prasad
 */

public class PersonServer {

	private Student[] stuArray;//Holds student objects
	private Employee[] empArray;//Holds employee objects
	private final int EMPLOYEESIZE = 1000;
	private final int STUDENTSIZE = 1000;

	/**
	 * Constructor
	 */
	public PersonServer(){
		//Initializes arrays of objects
		stuArray = new Student[STUDENTSIZE];
		empArray = new Employee[EMPLOYEESIZE];
	}

	/**
	 * Adds Employee
	 * @param name	Name of Employee 
	 * @param age	Age of Employee
	 * @throws Throwable	Used to output if there is an error in Employee Information
	 */
	public void addEmployee(String name, int age)throws IllegalArgumentException{
		Employee.isInpValid(age, name);
		// No exception so continue to add employee to array
		empArray[Employee.getCount()] = new Employee(name, age);

	}
	/**
	 * Adds Student
	 * @param name	Name of Student 
	 * @param age	Age of Student
	 * @param grade	Grade of Student
	 * @throws Throwable	Used to output if there is an error in Student Information
	 */
	public void addStudent(String name, int age, int grade)throws IllegalArgumentException{
		Student.isInpValid(age, grade, name);
		// No exception so continue to add employee to array
		stuArray[Student.getCount()] = new Student(name, age, grade);

	}
	/**
	 * Returns all employee information to user
	 * @return	All Employee Information
	 */
	public String getAllEmpInformation(){
		String empInfo = "";
		for (int i = 0; i < Employee.getCount(); i++){
			empInfo += empArray[i].toString(); 
		}
		return empInfo;
	}
	/**
	 * Returns all student information to user
	 * @return	All Student Information
	 */
	public String getAllStuInformation(){
		String stuInfo = "";
		for (int i = 0; i < Student.getCount(); i++){
			stuInfo += stuArray[i].toString(); 
		}
		return stuInfo;
	}
	/**
	 * Returns the name(s) of people at an inputted age
	 * @param age	Age desired to find People
	 * @return	Names of those at given age
	 */
	public String nameAtAge(int age){
		String namesList = "";
		for(int i = 0; i< Student.getCount(); i++){
			if(stuArray[i].getAge() == age){
				namesList += stuArray[i].getName() + "\n";
			}

		}
		for(int i = 0; i< Employee.getCount(); i++){
			if(empArray[i].getAge() == age){
				namesList += empArray[i].getName() + "\n";
			}
		}
		return "Names: " + "\n" +namesList;

	}
	/**
	 * Returns the number of each type of person
	 * @return	String containing the number of each person
	 */
	public String getPersons(){
		return "Number of Employees: " + Employee.getCount() + "\n" + "Number of Students: " + Student.getCount();
	}
	
}
