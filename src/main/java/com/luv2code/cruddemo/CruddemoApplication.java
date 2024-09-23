package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	private String theLastName;
	Student theStudent;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner ->{
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//findAllStudent(studentDAO);

			//findByLastName(studentDAO);

			//findByLastName(studentDAO,theLastName);

			//update(studentDAO, theStudent);

			//delete(studentDAO);

		};
	}

	private void delete(StudentDAO studentDAO){
		/*
		int studentId=4;
		System.out.println("Deleting the student Id: " +studentId);
		studentDAO.delete(studentId);
		 */
		System.out.println("Enter the student id you want to delete");
		int studentId=sc.nextInt();
		System.out.println("Deleting the student Id: " +studentId);
		studentDAO.delete(studentId);

	}

	/* update the student */
	 private void update(StudentDAO studentDAO, Student theStudent){
		 /*
		int studentId=1;
		System.out.println("Finding the student with id 1: ");
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating the student");
		myStudent.setFirstName("Amandeep");
		studentDAO.update(myStudent);
		System.out.println("Updated the student");
		  */

		 System.out.println("Enter the student id you want to update");
		 int studentId= sc.nextInt();
		 System.out.println("Finding the student with the given id: ");
		 Student myStudent = studentDAO.findById(studentId);
		 myStudent.setFirstName("Sandeep");
		 studentDAO.update(myStudent);
		 System.out.println("Updated the student");

	 }


	/* give a list of all the students having a last name given by the user*/
	private void findByLastName(StudentDAO studentDAO, String theLastName){
		System.out.println("Enter the last name you want to find");
		theLastName=sc.nextLine();

		List<Student> theStudents = studentDAO.findByLastName(theLastName);
		for(Student tempstudent:theStudents){
			System.out.println(tempstudent);
		}
	}

	/*Get a list of all the students having a specified surname*/
	private void findByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName();
		for(Student tempstudent:theStudents){
			System.out.println(tempstudent);
		}
	}

	/*Get a list of all the students*/
	private void findAllStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempstudent:theStudents){
			System.out.println(tempstudent);
		}
	}


	/* Reading students from the database*/
	private void readStudent(StudentDAO studentDAO) {
		/*
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student("Kartik","Sharda","Kartik@gmail.com");
		System.out.println("Saving a new student into the database...");
		studentDAO.save(tempStudent);
		// retrieve student based on the id: primary key
		int theId = tempStudent.getId();
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);

		 */

		System.out.println("Enter the id of the student you want to retrieve");
		int id= sc.nextInt();
		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);
		System.out.println("Found the student: " + myStudent);
	}


    /* Creating students and adding it to the database*/
	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Shruti", "Saxena", "shruti@gmail.com");
		Student tempStudent2 = new Student("Jigyasa", "Sharma", "jigyasa@gmail.com");
		Student tempStudent3 = new Student("Harshita", "Garg", "harshita@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		/*
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Sandeep", "Papola", "Sandeep@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		 */

		System.out.println("Creating new student object ...");
		System.out.println("Enter First Name:");
		String firstname=sc.nextLine();
		System.out.println("Enter Last Name :");
		String lastname=sc.nextLine();
		System.out.println("Enter Email Address :");
		String email=sc.nextLine();

		Student tempStudent = new Student(firstname, lastname, email);
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}







