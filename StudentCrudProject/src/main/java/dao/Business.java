package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Student;

public class Business {
static Connection con=null;
static PreparedStatement pstmt=null;
static ResultSet rs=null;

static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudy_wave","root","Vitthal@123");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public int addStudent(Student s) {
	String query="insert into student_info values(?,?,?,?)";
	int count=0;
	try {
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,s.getStudentId());
		pstmt.setString(2,s.getStudentName());
		pstmt.setString(3,s.getStudentBranch());
		pstmt.setInt(4,s.getStudentStd());
		
		count=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public int removeStudent(Student s) {
	String query="delete from student_info where student_id=?";
	int count=0;
	try {
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,s.getStudentId());
		count=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public ArrayList<Student> dispayStudent(){
	String query="select * from student_info";
	ArrayList<Student> stu=new ArrayList<Student>();
	try {
		pstmt=con.prepareStatement(query);
		rs=pstmt.executeQuery();
		
		
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String branch=rs.getString(3);
			int std=rs.getInt(4);
			
			Student s1=new Student();
			s1.setStudentId(id);
			s1.setStudentName(name);
			s1.setStudentBranch(branch);
			s1.setStudentStd(std);
			
			stu.add(s1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return stu;
}
}
