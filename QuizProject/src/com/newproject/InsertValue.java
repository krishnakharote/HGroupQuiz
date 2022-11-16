package com.newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertValue {
public static void table(String name, int marks,int id,String grade) throws SQLException {
		
		Scanner sc=new Scanner(System.in);	
	
		Connection con=UtilJDBC.getconnection();
		String query="insert into result(name ,marks,id,grade) values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,name);
	ps.setInt(2, marks);
	ps.setInt(3,id);
	ps.setString(4, grade);
	int i=ps.executeUpdate();
		}


public static void getresult() throws SQLException {
	System.out.println("Enter your id");
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	
	Connection con=UtilJDBC.getconnection();
	String query="select*from result where id=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	//if(ResultSet rs=ps.executeQuery())
	ResultSet rs =ps.executeQuery();
	System.out.println();
	if(!rs.next()) {
		System.out.println("Invalid ID");
	}
	else {
		System.out.println("Id:"+rs.getInt(1)+"\nName:"+rs.getString(2)+"\nMarks:"+rs.getInt(3)+"\nGrade:"+rs.getString(4));
	}
}



public static void meritlist() throws SQLException {
	Connection con=UtilJDBC.getconnection();
	String query="select*from result order by marks desc";
	PreparedStatement ps=con.prepareStatement(query);
	ResultSet rs =ps.executeQuery();
	//DBTablePrinter.
     while(rs.next()) {	System.out.println("Id:"+rs.getInt(1)+"\tName:"+rs.getString(2)+"\t"+"Grade:"+rs.getString(4)+"\t  "+"Marks:"+rs.getInt(3));
}}

	
}
