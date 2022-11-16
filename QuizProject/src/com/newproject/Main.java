package com.newproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Questions q=new Questions();
		InsertValue iv=new InsertValue() ;
		Scanner sc=new Scanner(System.in);
		System.out.println("Select from the Following:");
		System.out.println();
		System.out.println("1)To start quiz");
		System.out.println("2)To Show results");
		System.out.println("3)To Show Merit List");
		System.out.println("4)To exit");
		int select=sc.nextInt();
		
		if(select==1) {
			System.out.println("Please enter your name");
		    String name=sc.next();
		    System.out.println("Please enter your id");
		    int id=sc.nextInt();
			System.out.println("Hello "+name+"!!! Lets start quiz");
			System.out.println();
			try {
				Thread.sleep(500);
				Questions.showQst();
				int marks=q.count;
				String grade=q.grade;
				iv.table(name,marks,id,grade);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(select==2) {
			try {
				iv.getresult();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(select==3) {
			iv.meritlist();
		}else if(select==4) {
			System.out.println("Thank you");
		}else {
			System.out.println("Invalid option:");
		}	
	}System.out.println("changes done");
}
