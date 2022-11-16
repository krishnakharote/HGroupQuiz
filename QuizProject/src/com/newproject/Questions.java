package com.newproject;
import java.io.Reader; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//import com.demo.UtilJDBC;

public class Questions {
	 static int count=0;
	 static String grade=null;
	
	public static void showQst() throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		Connection con=UtilJDBC.getconnection();
		String query="select*from quiz";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			//System.out.println(rs.getString(2));
			String c=sc.next();
			if(c.equals(rs.getString(2))){
				count++;
				System.out.println("correct");
			}else {
				System.out.println("incorrect");
			}
			System.out.println();
		}
		
		if(count>=8) {
			grade="A";
		}else if(count>5 && count<8) {
			grade="B";
		}else if(count==5) {
			grade="C";
		}else {
			grade="D";
		}
	
		System.out.println("score is: "+count);
		if(grade=="D") {
			System.out.println("Your Grade is "+grade+" (Fail)");
		}else {
			System.out.println("Your Grade is "+grade+" (Pass)");
		}
		
	}
	

}
