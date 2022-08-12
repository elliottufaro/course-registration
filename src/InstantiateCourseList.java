import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

public class InstantiateCourseList implements Serializable  // extends Course 
{
	ArrayList<String[]> CourseList = new ArrayList<String[]>();	

	public InstantiateCourseList() 
	{
			String line = "";
			String splitBy = "\n";
			
			try
			{
				BufferedReader BR = new BufferedReader(new FileReader("/Users/elliottufaro/Desktop/MyUniversityCourses .csv"));
				while((line=BR.readLine())!=null) 
				{
					String x[] = line.split(",");
					CourseList.add(x);
				}
			}
			catch (IOException e)   
			{  
				e.printStackTrace();
			}  
	}
	
	public ArrayList<Course> getInitialCourseList(){
ArrayList<Course> SuperCourseList = new ArrayList<Course>();
		
		for (int i = 2; i <= CourseList.size()-1; i++) 
		{
			
		ArrayList<String> List_Of_Names = new ArrayList<String>();
			
		SuperCourseList.add(new Course(CourseList.get(i)[0], CourseList.get(i)[1], Integer.parseInt(CourseList.get(i)[2]),
		Integer.parseInt(CourseList.get(i)[3]), List_Of_Names, CourseList.get(i)[5], Integer.parseInt(CourseList.get(i)[6]), CourseList.get(i)[7]));
			
		}
		return SuperCourseList;
	}	
	
}
