import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public abstract class User 
{
	
	private String FirstName;
	private String LastName;
	private String Username;
	private String Password;
	
	
	
	
	public String getFirstName() // getter and setter for first name
	{
		return FirstName;
	}

	public void setFirstName(String firstName) 
	{
		this.FirstName = firstName;
	}

	public String getLastName() // getter and setter for last name
	{
		return LastName;
	}

	public void setLastName(String lastName) 
	{
		this.LastName = lastName;
	}
	
	public String getUsername() //getter and setter for the user name.
	{
		return Username;
	}
	
	public void setUsername(String username)
	{
		this.Username = username;
	}
	
	public String getPassword() // getter and setter for the password
	{
		return Password;
	}
	
	public void setPassword(String password)
	{
		this.Password = password;
	}
	
	public User(String firstname, String lastname, String username, String password)
	{
		this.FirstName = firstname;
		this.LastName = lastname;
		this.Username = username;
		this.Password = password;	
	}//User constructor that serves the needs of the student and admin classes
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	