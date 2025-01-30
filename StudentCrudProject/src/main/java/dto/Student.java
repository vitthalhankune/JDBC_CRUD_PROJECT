package dto;

public class Student {
private int studentId;
private String studentName;
private String studentBranch;
private int studentStd;

public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentBranch() {
	return studentBranch;
}
public void setStudentBranch(String studentBranch) {
	this.studentBranch = studentBranch;
}
public int getStudentStd() {
	return studentStd;
}
public void setStudentStd(int studentStd) {
	this.studentStd = studentStd;
}

public String toString() {
	return studentId+"\t"+studentName+"\t"+studentBranch+"\t"+studentStd;
}

}
