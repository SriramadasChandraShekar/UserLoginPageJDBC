package CRUD;
import java.util.*;
import java.sql.*;

public class Profile {
	static Scanner sc=new Scanner(System.in);
	public static void profile(Connection con,PreparedStatement p, ResultSet r) {
		try {
			System.err.println("Welcome to website "+r.getString(1));
		
		System.out.println("1:See your Profile \n2:Delete your profile \n3:Update your profile \n4:LogOut from your profile ");
		int a=sc.nextInt();
		switch (a) {
		case 1: {
			System.out.println("your profile data");
			con.prepareStatement("select * from userdata where mobileNO='"+r.getLong(4)+"'");
		r=p.executeQuery();
			if(r.next()) {
		        System.out.println(r.getString(1));
		        System.out.println(r.getString(2));
		        System.out.println(r.getString(3));
		        System.out.println(r.getLong(4));
		        System.out.println(r.getString(5));
		        break;
			}
		}
		case 2:{
			System.out.println("Do you really want to delete your profile \n please enter YES to delete profile otherwise NO");
			String s1=sc.next();
			if(s1.equalsIgnoreCase("yes")){
			PreparedStatement p1=con.prepareStatement("delete from userdata where mobileNumber='"+r.getLong(4)+"' and password='"+r.getString(5)+"'");
				p1.execute();
				System.out.println("you have sucessfully deleted your profile\nThank You :) 🎉🎉🎉🎉🎉🎉");
				Welcome.main(null);
			}
			else if(s1.equalsIgnoreCase("no")){
				profile(con,p,r);
				
			}
			else {
				System.out.println("Enter Wrong Key");
				profile(con,p,r);
				break;
			}
		}
		case 3:{
			Update.update(con, p, r);
			break;
		}
		case 4:
			System.out.println("Thank you!☺️   \n Visit Again!🤗");
			Welcome.main(null);
		default:
			System.out.println("Entered Incorrect key");
			profile(con, p, r);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
