package CRUD;
import java.util.*;
import java.sql.*;


public class signIn {
	public static String generateOTP(int length) {  
	    String numbers = "0123456789";  
	    Random rndm_method = new Random();  
	    char[] otp = new char[length];  
	    for (int i = 0; i < length; i++) {  
	        otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));  
	    }  
	    return new String(otp);  
	}  
	public static void StoreData(String name,String Dob,String gender,long mobileNumber, String password) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?user=root&&password=root");
			PreparedStatement p=con.prepareStatement("insert into userdata values(?,?,?,?,?)");
			p.setString(1, name);
			p.setString(2, Dob);
			p.setString(3, gender);
			p.setLong(4, mobileNumber);
			p.setString(5, password);
			p.executeUpdate();
			
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
	static Scanner sc=new Scanner(System.in);
	public static void SignIn() {
		Main_dto d=new 	Main_dto();
		System.err.println("Sign In Here \n  \n  ");
		System.out.println("Enter your Full Name : ");
		 String name=sc.next();
		for(int i=0;i<name.length();i++) {
			char ch=name.charAt(i);
			if((ch>='0'&&ch<='9')||(!(ch>=65&&ch<90||ch>='a'&&ch<='z'))) {
				System.err.println("Please Enter valid Name");
				name=sc.next();
			}
			d.setName(name);
			System.out.println("Enter your DOB");
			String dob=sc.next();
			d.setDOB(dob);
			System.out.println("Enter you gender");
			String gender=sc.next();
			d.setGender(gender);
			System.out.println("Enter your Mobile No:");
			long number=sc.nextLong();
			String n=signIn.generateOTP(6);
			
				System.out.println("your Otp is "+ n);
			
			
			System.out.println("Please Enter otp");
			String n1=sc.next();
			if(n.equals(n1)) {
				d.setMobileNo(number);
				System.out.println(" your mobile number validated sucessfully");
			}
			System.out.println("Enter your password");
			String password=sc.next();
			System.out.println(" Re Enter your password");
			String password1=sc.next();
			if(password.equals(password1)) {
				d.setPassword(password);
			}
			else {
				System.out.println("Your passwords doesnt match \n Enter your password again carefully");
				System.out.println("Enter your password");
				 password=sc.next();
				System.out.println(" Re Enter your password");
			    password1=sc.next();
				if(password.equals(password1)) {
					d.setPassword(password);
			 }
			}
			
			signIn.StoreData(d.getName(), d.getDOB(), d.getGender(), d.getMobileNo(), d.getPassword());
			System.out.println("You have signed up Sucessfuflly");
			 Welcome.main(null);
			
		}
		
	}


}
