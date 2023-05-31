package CRUD;

import java.util.*;
import java.sql.*;
public class Login {
	static Scanner sc=new Scanner(System.in);
	public static void check(long number, String password) {
		Connection con=null;
		ResultSet r=null;
		PreparedStatement p=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?user=root&&password=root");
			
			 p=con.prepareStatement("select * from userdata where MobileNumber='"+number+"' || password='"+password+"'");
		 r=p.executeQuery();
		if(r.next()) {
			long number1=r.getLong(4);
			String s=r.getNString(5);
			if(number1==number) {
				if(s.equals(password)) {
					Profile.profile(con, p, r);
				}
				else {
					System.out.println("your have Entered incorrect password /nselect below number \n1=>Do you want to SignIn again with correct password \n2=> Forgot Password");
					int a=sc.nextInt();
					if(a==1) {
						signIn.SignIn();
					}
					else if(a==2) {
						forgotPassword(r,con);
					}
				}
			}
		}
		
		else {
			System.out.println("you have entered wrong Mobile No or password");
			Login.ValidateLogin();
		}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void forgotPassword(ResultSet r,Connection con) {
		System.out.print("Enter your Mobile NO: ");
		long n=sc.nextLong();
		String s1=signIn.generateOTP(6);
		try {
			if(n==r.getLong(4)) {
				System.out.println("Please Enter the OTP that you have received \n your OTP is "+s1);
				String s2=sc.next();
				if(s1.equals(s2)){
					System.out.println("your mobile Number validated sucessufully");
					System.out.println("please Enter a new password");
					String password=sc.next();
					System.out.println("Re-Enter the Password");
					String password1=sc.next();
					if(password.equals(password1)) {
					PreparedStatement p1=con.prepareStatement("update userdata set password='"+password+"' where mobileNumber="+r.getLong(4)+"");
						p1.execute();
						System.out.println("Your Reset Password has been sucessfull \n please Login");
	                       Welcome.main(null);
					}
					else {
						System.out.println("you have entered password doesn't match re-entered password ");
						forgotPassword(r, con);
					}
				}
				else {
					System.out.println("Incorrect OTP");
					forgotPassword(r, con);
				}
		
			}
			else {
				System.out.println("your mobile number doesn't registered with your website \n or Enter a valid Mobile NO :");
				forgotPassword(r, con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ValidateLogin() {
		System.out.println("Enter your Mobile NO:");
		long number=sc.nextLong();
		System.out.println("Enter your Password :");
		String password=sc.next();
		Login.check(number, password);
		
	}
	

}
