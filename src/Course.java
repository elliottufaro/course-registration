import java.util.ArrayList;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.Serializable;


public class Course implements Serializable 
{
	
	private static final long serialVersionUID = 1L; //initialize all the necessary course variables
	private String Course_Name;
	private String Course_ID;
	private int Maximum_Students;
	private int Current_Students;
	private ArrayList<String> List_Of_Names = new ArrayList<String>();
	private String Course_Instructor;
	private int Course_Section_Number;
	private String Course_Location;
	
	
	public String getCourse_Name() //give the course variables getters and setters
	{
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) 
	{
		Course_Name = course_Name;
	}
	public String getCourse_ID() 
	{
		return Course_ID;
	}
	public void setCourse_ID(String course_ID) 
	{
		Course_ID = course_ID;
	}
	public int getMaximum_Students() 
	{
		return Maximum_Students;
	}
	public void setMaximum_Students(int maximum_Students) 
	{
		Maximum_Students = maximum_Students;
	}
	public int getCurrent_Students() 
	{
		return Current_Students;
	}
	public void setCurrent_Students(int current_Students) 
	{
		Current_Students = current_Students;
	}
	
	public void Increment_Current_Students() 
	{
		Current_Students++;
	}
	
	public void Reduce_Current_Students() 
	{
		Current_Students--;
	}
	
	public ArrayList<String> getList_Of_Names() 
	{
		return List_Of_Names;
	}
	public ArrayList<String> setList_Of_Names(ArrayList<String> List_Of_Names) 
	{
		return List_Of_Names;
	}
	public void addTo_List_Of_Names(String Name) 
	{
		List_Of_Names.add(Name);
	}
	public void subFrom_List_Of_Names(String Name) 
	{
		List_Of_Names.remove(new String(Name));
	}
	public String getCourse_Instructor() 
	{
		return Course_Instructor;
	}
	public void setCourse_Instructor(String course_Instructor) 
	{
		Course_Instructor = course_Instructor;
	}
	public int getCourse_Section_Number() 
	{
		return Course_Section_Number;
	}
	public void setCourse_Section_Number(int course_Section_Number) 
	{
		Course_Section_Number = course_Section_Number;
	}
	public String getCourse_Location() 
	{
		return Course_Location;
	}
	public void setCourse_Location(String course_Location) 
	{
		Course_Location = course_Location;
	}
	
	public Course(String CourseName, String CourseID, int MaximumStudents, 
		 int CurrentStudents, ArrayList<String> ListOfNames, String CourseInstructor, 
		 int CourseSectionNumber, String CourseLocation) //Course constructor that has all the necessary course parameters
	{
		this.Course_Name = CourseName;
		this.Course_ID = CourseID;
		this.Maximum_Students = MaximumStudents;
		this.Current_Students = CurrentStudents;
		this.setList_Of_Names(ListOfNames);
		this.Course_Instructor = CourseInstructor;
		this.Course_Section_Number = CourseSectionNumber;
		this.Course_Location = CourseLocation;
		
		
		
	}

	

	
	
	
	
}

	

