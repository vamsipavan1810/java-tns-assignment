package org.tns.java.assignment.row7collections;

import java.util.List;
import java.util.Scanner;

public class StudentDriver {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		StudentManager studentManager = new StudentManager();
		boolean execute = true;
		int studentId = 1;
		while(execute) {
			System.out.println("\n\nChoose an option :");
			System.out.println("1. Add Student");
			System.out.println("2. Get student by id");
			System.out.println("3. Get students by grade");
			System.out.println("4. Group students by class");
			System.out.println("5. Find top-n students");
			System.out.println("6. Filter students by grade");
			System.out.println("7. Display list of students names");
			System.out.println("8. Find average of all students");
			System.out.println("9. Stop Execution (exit)");
			System.out.print("\nEnter your option : ");
			int op = sc.nextByte();
			switch(op) {
				case 1: {
					System.out.println("Enter details of student : ");
					System.out.print("Enter student name : ");
					String name = sc.next();
					System.out.print("Enter school name : ");
					String school = sc.next();
					System.out.print("Enter student age : ");
					int age = sc.nextInt();
					System.out.print("Enter student class : ");
					int cls = sc.nextInt();
					System.out.print("Enter student grade : ");
					double grade = sc.nextDouble();
					Student student = new Student(studentId, name, school, age, cls, grade);
					studentManager.insertStudent(student);
					studentId++;
					break;
				}
				case 2: {
					System.out.print("Enter student ID : ");
					int sid  = sc.nextInt();
					Student student = studentManager.getStudent(sid);
					System.out.println((student == null) ? "Student not found with ID " + sid : student);
					break;
				}
				case 3: {
					studentManager.displayStudentsByGrade();
					break;
				}
				case 4: {
					studentManager.groupStudentsByClass();
					break;
				}
				case 5: {
					System.out.print("Enter n value : ");
					int n = sc.nextInt();
					List<Student> topNList = studentManager.topStudents(n);
					for(Student student : topNList) {
						System.out.println(student);
					}
					break;
				}
				case 6: {
					System.out.print("Enter the minimum grade : ");
					double baseGrade = sc.nextDouble();
					List<Student> filteredList = studentManager.filterStudentsByGrade(baseGrade);
					for(Student student : filteredList) {
						System.out.println(student);
					}
					break;
				}
				case 7: {
					List<String> names = studentManager.getListOfStudentsName();
					for(String name : names) {
						System.out.println(name);
					}
					break;
				}
				case 8: {
					double average = studentManager.findAverageGrade();
					System.out.println("Average of all students is : " + average);
					break;
				}
				case 9: {
					execute = false;
					break;
				}
				default : {
					System.out.println("INVALID OPTION.");
				}
			}
		}
		sc.close();
	}
}
