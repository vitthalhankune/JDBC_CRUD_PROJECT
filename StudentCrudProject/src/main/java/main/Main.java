package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Business;
import dto.Student;

public class Main {
	static Scanner sc =new Scanner(System.in);
public static void main(String[] args) {
	boolean exit=true;
	while(exit) {
		System.out.println("Enter choice\n1.Add Student\n2.Remove Student\n3.Display Stuent\n4.Exit");
		int choice=sc.nextInt();
		if (choice==1) {
			addStudent1();
		}
		else if(choice==2) {
			removeStudent1();
		}
		else if(choice==3) {
			showStudent();
		}
		else if(choice==4) {
			exit=false;
		}
		}
		
	}

static void addStudent1() {
	System.out.println("Enter Student Id :");
	int id=sc.nextInt();
	System.out.println("Enter Student Name :");
	String name=sc.next();
	System.out.println("Enter Studen Branch :");
	String branch=sc.next();
	System.out.println("Enter Student Std. :");
	int std=sc.nextInt();
	
	Student s=new Student();
	s.setStudentId(id);
	s.setStudentName(name);
	s.setStudentBranch(branch);
	s.setStudentStd(std);
	
	Business b=new Business();
	int count=b.addStudent(s);
	System.out.println(count+" record inserted.");
	}

static void removeStudent1() {
	System.out.println("Enter Student Id For Remove Student :");
	int id=sc.nextInt();
	
	Student s=new Student();
	s.setStudentId(id);
	
	Business b=new Business();
	int count=b.removeStudent(s);
	System.out.println(count+" one record deleted");
}

static void showStudent() {
	Business b = new Business();
	ArrayList<Student> data=b.dispayStudent();
	for(Student s:data) {
		System.out.println(s);
	}
}
}

