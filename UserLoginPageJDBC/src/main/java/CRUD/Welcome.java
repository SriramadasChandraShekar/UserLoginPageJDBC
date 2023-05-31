package CRUD;
import java.util.*;

public class Welcome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Instagram \n press 1 to Sign In \n press to 2 Login  ");
		int n=sc.nextInt();
		if(n==1) {
			signIn.SignIn();
		}
		else if(n==2) {
			Login.ValidateLogin();
		}
		
	}

}
