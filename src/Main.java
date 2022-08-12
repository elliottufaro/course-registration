import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.File;





public class Main implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	public static InstantiateCourseList Y = new InstantiateCourseList(); //populate an array list with all of the information from the csv file
	public static ArrayList<Course>  CourseList = Y.getInitialCourseList();
	public static ArrayList<Student> StudentList = Student.getStudentList();
	public static void main(String[] args) 
	{
		System.out.print (new File("CourseList.ser" ).exists()); //check to see if the "CourseList.ser" file exists. if not skip deserialization
		if (new File("CourseList.ser" ).exists()) {
			
		
	
		try{ 
			  //FileInputSystem recieves bytes from a file
		      FileInputStream fis = new FileInputStream("CourseList.ser");
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);	      
		      		      CourseList = (ArrayList<Course>)ois.readObject();
		      ois.close();
		      fis.close();
		    }
		    catch(IOException ioe) {
		    	ArrayList<Course>  CourseList = Y.getInitialCourseList();
				ArrayList<Student> StudentList = Student.getStudentList();
		       ioe.printStackTrace();
		       return;
		    }
		catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		       return;
		     }
		
		}
		else { //if "CourseList.ser" doesnt exist populate the CoursList with the csv file.
			ArrayList<Course>  CourseList = Y.getInitialCourseList();
			ArrayList<Student> StudentList = Student.getStudentList();
		}
		


		
		menu(); //method for getting user input
		
		
		
		ArrayList<Course> courselist = null;
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("CourseList.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
			oos.writeObject(CourseList);
			
			//Close both streams
			oos.close();
			fos.close();
			System.out.println("Course serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
		
	
	public static void printCourseList() //prints out the course list
	{
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			System.out.println(CourseList.get(i).getCourse_Name());
		}
	}
	
	
	public static void printNonFullCourseList()//prints all the non-full courses
	{
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if (CourseList.get(i).getMaximum_Students()!=CourseList.get(i).getCurrent_Students()){
			System.out.println(CourseList.get(i).getCourse_Name());
		}
		}
	}
	
	public static void printFullCourseList() //prints all the full courses
	{
	
		for (int i = 0; i <= CourseList.size()-1; i++)
		{
			if (CourseList.get(i).getMaximum_Students()==CourseList.get(i).getCurrent_Students())
			{
				System.out.println(CourseList.get(i).getCourse_Name());
			}
		}
	
	}
	
	
	public static ArrayList<Course> getCourseList() { //will return to the course list to all the other classes that need to manipultate it
		return CourseList;
	}
	
	public static void printStudentList() {
		for(int i = 0; i<=StudentList.size() - 1; i++) {
			System.out.println(StudentList.get(i).getFirstName());
		}
	}
	

	
	
	public static void menu(){
	
		
		String action = "0";
		String Username = "0";
		String Password = "0";
		

		while ((action.equals("E")==false)) 
		{
			Scanner scan = new Scanner(System.in);
						
			
			System.out.print("Enter the corresponding value to the type of user you would like to sign in as.\n" //provide the main menu
					+ "Student ................................. 1\n"
					+ "Administrator ........................... 2\n"
					+ "Exit the program ........................ E\n"
					+"User Type : \n");
		
			action = scan.nextLine();
			
			
			if (action.equals("1")) 	
			{
				while ((action.equals("E")==false))
				{
					System.out.println("Student Login (Enter \"E\" to go back to the main screen.)\n"+
									 "Username : ");
					Username = scan.nextLine();
					if (Username.equals("E")){
						break;
					}
					
					System.out.println("Password : ");
					Password = scan.nextLine();
					if (Password.equals("E")){
						break;
					}
					
					
					for (int i = 0; i <= StudentList.size()-1; i++)
					{
						if((StudentList.get(i).getUsername().equals(Username))&&
						(StudentList.get(i).getPassword().equals(Password))) 
						{
							while(true)
							{
								System.out.print("Hi " + StudentList.get(i).getFirstName() //provide a student menu
										+ ", enter the corresponding value to the action you would like to take.\n" 
										+ "View all courses ............................................... 1\n"
										+ "View all courses that are NOT FULL ............................. 2\n"
										+ "Register to a course ........................................... 3\n"
										+ "Withdraw from a course ......................................... 4\n"
										+ "View all courses that you are currenttly registered in ......... 5\n"
										+ "Exit ........................................................... E\n"
										+ "Action Type : ");
								String action2 = scan.nextLine();
								if(action2.equals("1")) 
								{
									System.out.print("\n");
									Student.PrintCourseList();
									System.out.print("\n");

								}
								if(action2.equals("2")) 
								{
									System.out.print("\n");
									printNonFullCourseList();
									System.out.print("\n");

								}
								if(action2.equals("3")) 
								{
									System.out.print("\n");
									StudentList.get(i).Register();
									System.out.print("\n");

								}
								if(action2.equals("4")) 
								{
									System.out.print("\n");
									StudentList.get(i).Withdraw();
									System.out.print("\n");

								}
								if(action2.equals("5"))
								{
									System.out.print("\n");
									System.out.print(StudentList.get(i).getEnrolledCourses());
									System.out.print("\n");

								}
								if(action2.equals("E"))
								{
									break;
								}
							}          
						}
					}	
				}
			}
			if (action.equals("2")) 
			{
				
				
				
				
				
				
				while ((action.equals("E")==false))
				{
					System.out.println("Admin Login (Enter \"E\" to go back to the main screen.)\n"+
									 "Username : ");
					Username = scan.nextLine();
					if (Username.equals("E")){
						break; //giving the ability to exit the login
					}
					
					System.out.println("Password : ");
					Password = scan.nextLine();
					if (Password.equals("E")){
						break;
					}
					
					
					
						if(Username.equals("Admin")&&Password.equals("Admin001")) //checking to see if the username and password are correct
						{
							while(true)
							{
								System.out.print("Hi Admin" //provide an Admin menu
										+ ", enter the corresponding value to the action you would like to take.\n" 
										+ "________________________COURSES MANAGEMENT________________________\n"
										+ "Create a course ................................................ 1\n"
										+ "Delete a course ................................................ 2\n"
										+ "Edit a course .................................................. 3\n"
										+ "Display a course ............................................... 4\n"
										+ "Register a student ............................................. 5\n"
										+ "\n"
										+ "_____________________________REPORTS______________________________\n"
										+ "View all courses ............................................... 6\n"
										+ "View all courses that ARE FULL ................................. 7\n"
										+ "Write to a file a list of courses that are full ................ 8\n"
										+ "View the students registered in a specific course .............. 9\n"
										+ "View the list of courses a student is registered to ............ 10\n"
										+ "Sort ........................................................... 11\n"
										
										+ "Exit ........................................................... E\n"
										+ "Action Type : ");
								String action2 = scan.nextLine();
								if(action2.equals("1")) 
								{
									System.out.print("\n");
									Admin.Create_Course();
									System.out.print("\n");

								}
								if(action2.equals("2")) 
								{
									System.out.print("\n");
									Admin.Delete_Course();
									System.out.print("\n");

								}
								if(action2.equals("3")) 
								{
									System.out.print("\n");
									Admin.EditCourse();
									System.out.print("\n");

								}
								if(action2.equals("4")) 
								{
									System.out.print("\n");
									Admin.DisplayCourse();
									System.out.print("\n");

								}
								if(action2.equals("5"))
								{
									System.out.print("\n");
									Admin.RegisterStudent();
									System.out.print("\n");

								}
								if(action2.equals("6"))
								{
									System.out.print("\n");
									Admin.PrintCourseList();
									System.out.print("\n");

								}
								if(action2.equals("7"))
								{
									System.out.print("\n");
									printFullCourseList() ;
									System.out.print("\n");
								}
								
								if(action2.equals("8"))
								{
									System.out.print("\n");
									Admin.writeToFileFullCourses();
									System.out.print("\n");									
								}
								
								if(action2.equals("9"))
								{
									System.out.print("\n");
									Admin.viewCourseEnrollment();
									System.out.print("\n");									
								}
								if(action2.equals("10"))
								{
									System.out.print("\n");
									Admin.studentCourseList(); 
									System.out.print("\n");									
								}
								if(action2.equals("11"))
								{
									System.out.print("\n");
									Admin.sortedCourseList();
									System.out.print("\n");									
								}
								if(action2.equals("12"))
								{
									System.out.print("\n");
									 printStudentList();
									System.out.print("\n");									
								}
								
								if(action2.equals("E"))
								{
									break;
								}
							}          
						}
						
				}
				
				
				
				
				
				
				
			}
		}
		
	}
	
	

}	
	


