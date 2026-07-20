package org.tns.java.assignment.row7collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentManager {
	private Map<Integer, Student> studentMap;
	private SortedSet<Student> studentSet;
	private List<Student> studentsList;
	private Scanner sc;
	public StudentManager() {
		sc = new Scanner(System.in);
		studentMap = new TreeMap<>();
		studentSet = new TreeSet<Student>((s1, s2) -> {
			double dif = s1.getGrade() - s2.getGrade();
			if(dif == 0) return s1.getSid() - s2.getSid();
			return (dif > 0) ? -1 : 1;
		});
		studentsList = new ArrayList<>();
	}
	public void insertStudent(Student student) {
		int studentId = student.getSid();
		if(studentMap.containsKey(studentId)) {
			System.out.println("Student with ID " + studentId + " already present.");
			System.out.println("1. Insert with another ID");
			System.out.println("2. Don't insert record");
			System.out.println("3. Override the record with new student");
			System.out.print("Enter your option : ");
			int op = sc.nextByte();
			
			if (op == 1) {
				System.out.print("Enter new ID : ");
				int newStudentId = sc.nextInt();
				student.setSid(newStudentId);
				insertStudent(student);
			} else if (op == 2) {
				System.out.println("Student insertion failed");
			} else if (op == 3) {
				Student previousStudent = studentMap.get(studentId);
				studentSet.remove(previousStudent);
				studentSet.add(student);
				studentsList.remove(previousStudent);
				studentsList.add(student);
				studentMap.put(studentId, student);
				System.out.println("Student updated at ID " + studentId);
			} else {
				System.out.println("Invalid option. Please choose proper option");
			}
		} else {
			studentSet.add(student);
			studentMap.put(studentId, student);
			studentsList.add(student);
			System.out.println("Student inserted with ID " + studentId + " successfully");
		}
	}
	
	public Student getStudent(int studentId)  {
		return (studentMap.containsKey(studentId)) ? studentMap.get(studentId) : null;
	}
	
	public void displayStudentsById()  {
		for(Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
			Integer studentId = entry.getKey();
			Student student = entry.getValue();
			System.out.println("Student-ID : " + studentId + " => " + student);
		}
	}
	
	public void displayStudentsByGrade() {
		for(Student student : studentSet) {
			System.out.println(student);
		}
	}
	
	public void groupStudentsByClass() {
		Map<Integer, List<Student>> map = studentsList
				.stream()
				.collect(Collectors
						.groupingBy(student -> student.getCls()));
		
		for(Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
			System.out.println("class " + entry.getKey() + " :");
			for(Student student : entry.getValue()) {
				System.out.println(student);
			}
		}
	}
	
	public void removeStudent(int studentId) {
		if(!studentMap.containsKey(studentId)) {
			System.out.println("Student with ID " + studentId + " not present");
			return;
		}
		Student student = studentMap.get(studentId);
		studentsList.remove(student);
		studentSet.remove(student);
		studentMap.remove(studentId);
		System.out.println("Student with ID "  + studentId + " removed successfully");
	}
	
	public List<Student> topStudents(int n)  {
		if(n > studentSet.size()) {
			System.out.println("There are only " + studentSet.size() + " nummber of Students.");
			return new ArrayList<>(studentSet);
		}
		return studentSet
				.stream()
				.limit(n)
				.toList();
	}
	
	public List<Student> filterStudentsByGrade(double grade) {
		return studentsList
				.stream()
				.filter(student -> student.getGrade() >= grade)
				.toList();
	}
	
	public List<String> getListOfStudentsName() {
		return studentsList
				.stream()
				.map(student -> student.getName())
				.toList();
	}
	
	public double findAverageGrade() {
		double sum = studentsList
				.stream()
				.map(student -> student.getGrade())
				.reduce(0.0, (acc, grade) -> acc + grade);
		return sum / studentsList.size();
	}
}
