package com.springbootcourse.cruddemo;

import com.springbootcourse.cruddemo.dao.StudentDAO;
import com.springbootcourse.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// readAllStudents(studentDAO);
			// readStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {

		System.out.println(studentDAO.deleteAll());
	}



	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id

		int studentId = 1;
		Student student = studentDAO.findById(studentId);


		// change first name to Scooby

		student.setFirstName("John");
		// Update the student
		studentDAO.update(student);
		// display the updated student
		System.out.println(student);
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {

		// get list of students

		List<Student> students = studentDAO.findByLastName("Doe");

		// display list of students

		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void readAllStudents(StudentDAO studentDAO) {

		// get a list of students

		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object

		System.out.println("Creating a new student object...");
		Student student = new Student("Daffy", "Duck", "Daffy@gmail.com");

		// save the student

		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display the id of the saved student

		int id = student.getId();
		System.out.println("Saved student. Generated Id: "+ id);

		// retrieve student based on the id: primary key

		Student readStudent = studentDAO.findById(id);

		// display student

		System.out.println("Read student: " + readStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student object...");
		Student student = new Student("John", "Doe", "JohnDoe@mail.com");
		Student student1 = new Student("Jane", "Doe", "JaneDoe@mail.com");
		Student student2 = new Student("Mary", "Rose", "MaryRose@mail.com");


		//save the student objects

		System.out.println("Saving the student...");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("John", "Doe", "JohnDoe@mail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		//display the id of the saved student
		System.out.println("Saved student. Generated Id: " + student.getId());


	}

}

