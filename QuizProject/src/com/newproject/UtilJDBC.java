package com.newproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJDBC {
	
	
	public static Connection getconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/projecttabledb?characterEncoding=utf-8";
			 con=DriverManager.getConnection(url, "root", "Root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return con;            
	}

}
