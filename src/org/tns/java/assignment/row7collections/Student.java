package org.tns.java.assignment.row7collections;

public class Student {
	private int sid;
	private String name;
	private String school;
	private int age;
	private int cls;
	private double grade;
	public Student() { }
	public Student(int sid, String name, String school, int age, int cls, double grade) {
		this.sid = sid;
		this.name = name;
		this.school = school;
		this.age = age;
		this.cls = cls;
		this.grade = grade;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", school=" + school + ", age=" + age + ", cls=" + cls
				+ ", grade=" + grade + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		return this.sid == student.getSid();
	}
	@Override
	public int hashCode() {
		return this.sid;
	}
}
