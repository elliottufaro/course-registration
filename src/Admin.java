import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;



public class Admin extends User implements Administrator 
{
	
	
	private static final long serialVersionUID = 1L;

	static ArrayList<Student> StudentList = Student.getStudentList(); //Acquire the StudentList from the student class
	
	static ArrayList<Course> CourseList = Main.getCourseList();
	Scanner scan = new Scanner(System.in);

	
	public Admin(String firstname, String lastname, String username, String password) 
	{
		super(firstname, lastname, username, password);		//Admin constructor
	}
	
	public static void RegisterStudent() { 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Student's Firstname : "); //gather all the necessary info to create a Student 
		String StudentFirstName = scan.nextLine();
		System.out.println("Enter the Student's Lastname : ");
		String StudentLastName = scan.nextLine();
		System.out.println("Enter the Student's Username : ");
		String StudentUserName = scan.nextLine();
		System.out.println("Enter the Student's Password : ");
		String StudentPassword = scan.nextLine();
		
		
		new Student(StudentFirstName, StudentLastName, StudentUserName, StudentPassword);
		
	}
	
	public static void studentCourseList() //print out a students enrollment list
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the student whose course list you would like to see : ");
		String StudentName = scan.nextLine();
		System.out.println();
		
		
		for (int i = 0; i <= StudentList.size()-1; i++)
		if ((StudentList.get(i).getFirstName()+" "+StudentList.get(i).getLastName()).equals(StudentName)) {
			System.out.println(StudentList.get(i).getEnrolledCourses());
		}
	}
	
	public static void sortedCourseList() //sort the courses by their number of students
	{
	

		int t = 0;
		int b = 0;
		
		while(b != CourseList.size()) 
		{
				for (int i = 0; i <= CourseList.size()-1; i++)
				{
					if (CourseList.get(i).getCurrent_Students() == t) 
					{
						b++;
						System.out.println(CourseList.get(i).getCourse_Name());

					}
				}
		   t++;	
		}
	}
		
	public static void Create_Course() //create a course method
	{
		Scanner scan = new Scanner(System.in);
		
	

		
		System.out.println("Please enter the Course Name : "); // gather the necessary info to create a course
		String CourseName = scan.nextLine();
		
		System.out.println("Please enter the Course ID : ");
		String CourseID = scan.nextLine();
		
		System.out.println("Please enter the Maximum number of Students : ");
		int MaximumStudents = Integer.parseInt(scan.nextLine());
		
		int CurrentStudents = 0;
		
		ArrayList<String> ListOfNames = null;
		
		System.out.println("Please enter the Course Instructor : ");
		String CourseInstructor = scan.nextLine();
		
		System.out.println("Please enter the Course Section Number : ");
		int CourseSectionNumber = Integer.parseInt(scan.nextLine());
		
		System.out.println("Please enter the Course Location : ");
		String CourseLocation = scan.nextLine();
		
		

		CourseList.add(new Course(CourseName, CourseID, MaximumStudents, CurrentStudents,
		ListOfNames, CourseInstructor, CourseSectionNumber, CourseLocation)); // add the new course to the CourseList
	}
	
	

	public static void PrintCourseList()
	{
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			System.out.println("Course name ................................. " +CourseList.get(i).getCourse_Name()+ "\n" + 
							   "Course ID ................................... " + CourseList.get(i).getCourse_ID()+"\n"+
					           "Number of Students Registered ............... " + CourseList.get(i).getCurrent_Students() +"\n"+
							   "Maximum Students that can Register .......... " + CourseList.get(i).getMaximum_Students() + "\n"+"\n");
		}
	}
	
	public static void Delete_Course() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the Course you would like to delete : "); //find out the name of the course that the user would like to delete
		String CourseName = scan.nextLine();
		
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if(CourseList.get(i).getCourse_Name().equals(CourseName)) {
				CourseList.remove(i);
			}
		}
	}
	
	public static void DisplayCourse() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Course ID of the course you like to Display : "); //recieve the input of the course the user would like to see displayed
		String CourseID = scan.nextLine();
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if(CourseList.get(i).getCourse_ID().equals(CourseID)) {
				System.out.println("Course name ................................. " + CourseList.get(i).getCourse_Name()+ "\n" + 
						   		   "Course ID ................................... " + CourseList.get(i).getCourse_ID()+"\n"+
				                   "Number of Students Registered ............... " + CourseList.get(i).getCurrent_Students() +"\n"+
						           "Maximum Students that can Register .......... " + CourseList.get(i).getMaximum_Students() + "\n"+
						           "List of Registered Students ................. " + CourseList.get(i).getList_Of_Names()+"\n"+
						           "Course Instructor ........................... " + CourseList.get(i).getCourse_Instructor()+"\n"+
						           "Course Section Number ....................... " + CourseList.get(i).getCourse_Section_Number() +"\n"+
						           "Course Location ............................. " + CourseList.get(i).getCourse_Location()+"\n"+"\n");
			}
		}
	}
	
	public static void EditCourse() 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the name of the course you would like to edit."
				+ " Please note that you cannot edit the Course's ID or Name. \n\nCourse Name : ");
		
		String CourseToEdit = scan.nextLine();
		
		System.out.println("\n");
		
		System.out.print("Enter the corresponding number to the element you would like to Edit \n" //offer the user to edit a course
				+ "Number of Students Registered ............... 1" + "\n"  //depending on which number they enter. Give a variety of different elements that can be changed
				+ "Maximum Students that can Register .......... 2" + "\n"  
				+ "List of Registered Students ................. 3" + "\n"  
				+ "Course Instructor ........................... 4" + "\n"  
				+ "Course Section Number ....................... 5" + "\n"  
				+ "Course Location ............................. 6" + "\n\n"
				+ "Element number :  "); 
		String element = scan.nextLine();
		
		if(element.equals("1"))
		{
			
			System.out.print("Enter a new number of Students Registered : "); // collect a new max off the user
			String number = scan.nextLine();
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) {
					CourseList.get(i).setCurrent_Students(Integer.parseInt(number));
							          
				}
			}
			
		}
		if(element.equals("2"))
		{
			
			System.out.print("Enter a new Maximum number of Students that can Register : "); //allow the user to alter the maximum number of students
			String number = scan.nextLine();
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) {
					CourseList.get(i).setMaximum_Students(Integer.parseInt(number));
							          
				}
			}
			
		}
		if(element.equals("3"))
		{
			System.out.print("Would you like to add(A) or remove(R) a name from the courselist : ");
			String AR = scan.nextLine();
			
			if (AR.equals("A")) {
				System.out.print("Enter the name of the person you would like to add : ");
				String name = scan.nextLine();
				
				for (int i = 0; i <= CourseList.size()-1; i++)
				{
					if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) 
					{
						CourseList.get(i).addTo_List_Of_Names(name);
								          
					}
					CourseList.get(i).Increment_Current_Students();
				}
				
			}
			
			if (AR.equals("R")) 
			{
				System.out.print("Enter the name of the person you would like to remove : ");
				String name = scan.nextLine();
				
				for (int i = 0; i <= CourseList.size()-1; i++)
				{
					if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) 
					{
						CourseList.get(i).subFrom_List_Of_Names(name);
								          
					}
					CourseList.get(i).Reduce_Current_Students();
				}
				
				
			}
		
		}
		if(element.equals("4"))
		{
			
			System.out.print("Enter a new Course Instructor : ");
			String name = scan.nextLine();
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) {
					CourseList.get(i).setCourse_Instructor(name);
							          
				}
			}
			
		}
		if(element.equals("5"))
		{
			
			System.out.print("Enter a new Section Number : ");
			String number = scan.nextLine();
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) {
					CourseList.get(i).setCourse_Section_Number(Integer.parseInt(number));
							          
				}
			}
			
		}
		if(element.equals("6"))
		{
			
			System.out.print("Enter a new Course Location : ");
			String location = scan.nextLine();
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if(CourseList.get(i).getCourse_Name().equals(CourseToEdit)) {
					CourseList.get(i).setCourse_Location(location);
							          
				}
			}
			
		}
		
	}
	
	public static void viewCourseEnrollment() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the Course whose registration list you wish to see : ");
		String CourseName = scan.nextLine();
		
		for (int i = 0; i <= CourseList.size()-1; i++) //iterate through the courses to see who is enrolled in a particular course
		{
			if(CourseList.get(i).getCourse_Name().equals(CourseName)) {
				System.out.println(CourseList.get(i).getList_Of_Names());
						          
			}
		}
		

		
	}
	
	public static void writeToFileFullCourses() //write the full courses to a file upon command
	{  
		try 
		{ 
			
			FileWriter writer = new FileWriter("FullCourses.txt"); 
			BufferedWriter BW = new BufferedWriter(writer); 
			
			
			
			
			for (int i = 0; i <= CourseList.size()-1; i++)
			{
				if (CourseList.get(i).getMaximum_Students()==CourseList.get(i).getCurrent_Students())
				{
				BW.write(CourseList.get(i).getCourse_Name());
				}
			}
			
			 
		BW.close(); System.out.println("succesfully written to a file"); 
		} catch (IOException ioe) { ioe.printStackTrace(); 
		} 
	}
	
	
	
	
	
	
	
	
}
	


