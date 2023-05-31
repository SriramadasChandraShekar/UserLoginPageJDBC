package CRUD;
import java.sql.*;
import java.util.*;

public class Update {
	static Main_dto m=new Main_dto();
	static Scanner sc=new Scanner(System.in);
	public static void update(Connection con,PreparedStatement p,ResultSet r) throws SQLException {
		System.out.println("Select below to Update the Details \n1=>Name \n2=>DOB \n3=>Gender \n4=>Mobile Number \n5=>Password");
		int a=sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("Enter your mobile Number to change your Name");
			long number=sc.nextLong();
			String s=signIn.generateOTP(6);
			if(number==r.getLong(4)) {
				System.out.println("we got request to change your Name, your OTP to change Mobile Number is "+s + "\nEnter OTP to validate your mobile Number:");
				String s1=sc.next();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println("your Mobile Number validated Successfully \n Enter your New Name");
			         String name=sc.next();
			         m.setName(name);
						PreparedStatement p1=con.prepareStatement("update userdata set name='"+m.getName()+"' where mobileNumber='"+r.getLong(4)+"'");
						p1.executeUpdate();
						System.out.println("Your Name Updated successfully");
						 System.out.println("1=>Back to update other details \n2=>Back to your profile \n3=>Back to LoginIn");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 update(con, p, r);
			        	 }
			        	 else if(a1==2) {
			        		Profile.profile(con, p1, r);
			        	 }
			        	 else if(a1==3) {
			        		 Welcome.main(null);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
					}                            
				}
			break;
		case 2:
			System.out.println("Enter your mobile Number to change your DOB");
			 number=sc.nextLong();
			 s=signIn.generateOTP(6);
			if(number==r.getLong(4)) {
				System.out.println("we got request to change your DOB, your OTP to change Mobile Number is "+s + "\nEnter OTP to validate your mobile Number:");
				String s1=sc.next();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println("your Mobile Number validated Successfully \n Enter your New DOB");
			         String dob=sc.next();
			         m.setDOB(dob);
						PreparedStatement p1=con.prepareStatement("update userdata set dob='"+m.getDOB()+"' where mobileNumber='"+r.getLong(4)+"'");
						p1.executeUpdate();
						System.out.println("Your DOB Updated successfully");
						 System.out.println("1=>Back to update other details \n2=>Back to your profile \n3=>Back to LoginIn");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 update(con, p, r);
			        	 }
			        	 else if(a1==2) {
			        		Profile.profile(con, p1, r);
			        	 }
			        	 else if(a1==3) {
			        		 Welcome.main(null);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
						
					}                            
				}
			break;
		case 3:
			System.out.println("Enter your mobile Number to change your Gender");
			 number=sc.nextLong();
			 s=signIn.generateOTP(6);
			if(number==r.getLong(4)) {
				System.out.println("we got request to change your Gender, your OTP to change Mobile Number is "+s + "\nEnter OTP to validate your mobile Number:");
				String s1=sc.next();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println("your Mobile Number validated Successfully \n Enter your New Gender \n if do not wish to declear your Gender you can make it null");
			         String gender=sc.next();
			         m.setGender(gender);
						PreparedStatement p1=con.prepareStatement("update userdata set dob='"+m.getGender()+"' where mobileNumber='"+r.getLong(4)+"'");
						p1.executeUpdate();
						System.out.println("Your Gender Updated successfully");
						 System.out.println("1=>Back to update other details \n2=>Back to your profile \n3=>Back to LoginIn");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 update(con, p, r);
			        	 }
			        	 else if(a1==2) {
			        		Profile.profile(con, p1, r);
			        	 }
			        	 else if(a1==3) {
			        		 Welcome.main(null);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
					}                            
				}
			break;
		case 4:
			System.out.println("Enter your mobile Number to change your Mobile Number");
			 number=sc.nextLong();
		      s=signIn.generateOTP(6);
			if(number==r.getLong(4)) {
				System.out.println("we got request to change mobile Number, your OTP to change Mobile Number is "+s + "\nEnter OTP to validate your mobile Number:");
				String s1=sc.next();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println("your Mobile Number validated Successfully \n Enter your New Mobile Number");
					long number1=sc.nextLong();
					m.setMobileNo(number1);
					String otp=signIn.generateOTP(6);
					System.out.println("Your OTP is "+otp+"\nEnter a OTP to validate your New Number");
					String otp1=sc.next();
					if(otp.equalsIgnoreCase(otp1)) {
						System.out.println("your Mobile Number validated sucessfully");
						PreparedStatement p1=con.prepareStatement("update  userdata set MobileNumber='"+m.getMobileNo()+"' where MobileNumber='"+r.getLong(4)+"'");
						p1.executeUpdate();
						System.out.println("Your Mobile Number Updated successfully");
						 System.out.println("1=>Back to update other details \n2=>Back to your profile \n3=>Back to LoginIn");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 update(con, p, r);
			        	 }
			        	 else if(a1==2) {
			        		Profile.profile(con, p1, r);
			        	 }
			        	 else if(a1==3) {
			        		 Welcome.main(null);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
					}
					else {
						System.out.println("you have Entered Incorrect Otp");
						update(con, p, r);
					}
					                               
				}
				else {
					System.out.println("you have Entered Incorrect Otp");
					update(con, p, r);
			}
			}
			else {
				System.out.println("your mobile Number does't match our records");
				update(con, p, r);
			}

			break;
		case 5:
			System.out.println("Enter your mobile Number to change your password");
			 number=sc.nextLong();
			 s=signIn.generateOTP(6);
			if(number==r.getLong(4)) {
				System.out.println("we got request to change your password, your OTP to change Mobile Number is "+s + "\nEnter OTP to validate your mobile Number:");
				String s1=sc.next();
				if(s.equalsIgnoreCase(s1)) {
					System.out.println("your Mobile Number validated Successfully \n Enter your old passoword");
			         String Opassword=sc.next();
			         if(Opassword.equals(r.getString(5))) {
			        	 System.out.println("Enter New password");
			        	 String password1=sc.next();
			        	 m.setPassword(password1);
			        	 System.out.println("Re-Enter New password");
			        	 String password2=sc.next();
			        	 if(m.getPassword().equals(password2)) {
						PreparedStatement p1=con.prepareStatement("update userdata set password='"+m.getPassword()+"' where mobileNumber='"+r.getLong(4)+"'");
						p1.executeUpdate();
						System.out.println("Your password Updated successfully");
						 System.out.println("1=>Back to update other details \n2=>Back to your profile \n3=>Back to SignIn");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 update(con, p, r);
			        	 }
			        	 else if(a1==2) {
			        		Profile.profile(con, p1, r);
			        	 }
			        	 else if(a1==3) {
			        		 Welcome.main(null);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
					}  
			        	 else {
			        		 System.out.println("your password doesn't match with Re-entered password");
			        		 Update.update(con, p, r);
			        	 }
				}
			         else {
			        	 System.out.println("Incorrect Old password");
			        	 System.out.println("have you forgot your password /n oryou have goto your profile \n1=>forgot password \n2=>Back to update other details \n3=>Back to your profile");
			        	 int a1=sc.nextInt();
			        	 if(a1==1) {
			        		 Login.forgotPassword(r, con);
			        	 }
			        	 else if(a1==2) {
			        		update(con, p, r);
			        	 }
			        	 else if(a1==3) {
			        		 Profile.profile(con, p, r);
			        	 }
			        	 else {
			        		 System.out.println("Incorrect key word");
			        		 update(con, p, r);
			        	 }
			         }
				}
			}
			break;

		default:
			System.out.println("please enter valid key");
			Update.update(con, p, r);
			break;
          }
	}
}
