import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



public class Student extends User implements Pupil 
{
	
		

	static ArrayList<Student> StudentList = new ArrayList<Student>(); //instantiate a new Student object Arraylist
	
	public Student(String firstname, String lastname, String username, String password) {
		super(firstname, lastname, username, password);
		StudentList.add(this);
	}
	
	public static ArrayList<Student> getStudentList() //allow all the other classes to fetch the StudentList
	{
		return StudentList;
	}
	
	
	private ArrayList<String> EnrolledCourses = new ArrayList<String>();
	
	static ArrayList<Course> CourseList = Main.getCourseList();
	

	
	public void Register() { //allow students to register to a course
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the name of the class would you like to Register to : \n");
		String Class = scan.nextLine();
		
		
		
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if ((CourseList.get(i).getMaximum_Students() > CourseList.get(i).getCurrent_Students()) 
					&& (CourseList.get(i).getCourse_Name().equals(Class))) //iterate through all the courses while checking to see if the user input name matches
			{
				getEnrolledCourses().add(Class);
				CourseList.get(i).addTo_List_Of_Names((this.getFirstName() + " " + this.getLastName()));
				CourseList.get(i).Increment_Current_Students();

			//System.out.println(CourseList.get(i).getCourse_Name());
			}
		}
		
	}
	
public void Withdraw() { //allows students to withdraw from a course
	Scanner scan = new Scanner(System.in);
	
	System.out.print("Enter the name of the class would you like to Withdraw from : \n");
	String Class = scan.nextLine();
	
		
		
		
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if ((CourseList.get(i).getMaximum_Students() > CourseList.get(i).getCurrent_Students()) 
					&& (CourseList.get(i).getCourse_Name().equals(Class)))
			{
				EnrolledCourses.remove(new String(Class));
				CourseList.get(i).subFrom_List_Of_Names((this.getFirstName() + " " + this.getLastName()));
				CourseList.get(i).Reduce_Current_Students();

			}
		}
		
	}

public ArrayList<String> getEnrolledCourses() 
{
	return EnrolledCourses;
}

public void setEnrolledCourses(ArrayList<String> enrolledCourses) 
{
	EnrolledCourses = enrolledCourses;
}
	
	
public static void PrintCourseList() 
{
	for (int i = 0; i <= CourseList.size()-1; i++)
	{
		System.out.println(CourseList.get(i).getCourse_Name());
	}
}




}
