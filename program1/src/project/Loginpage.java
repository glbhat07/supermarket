package project;
import java.util.*;

public class Loginpage 
{
	String Password="Admin123";
	Scanner sc = new Scanner(System.in);

	void Login()
	{
		//Password="Admin123";
		System.out.println("Enter your Login Details");
		System.out.println("Enter Password");
		String PasswordMtch = sc.nextLine();
		if(Password.equals(PasswordMtch))
		{
		//Go to billing Page.
			System.out.println("Login Successful");
			System.out.println("");
		}
		
		else
		{
			System.out.println("Login Failed!!  "+"Password Mismatch");
			System.out.println("");
			System.out.println("Please Try again");
			System.out.println("");
			Login();
		}
	}
}	



