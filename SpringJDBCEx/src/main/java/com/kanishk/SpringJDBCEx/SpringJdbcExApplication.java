package com.kanishk.SpringJDBCEx;

import com.kanishk.SpringJDBCEx.model.Student;
import com.kanishk.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student obj = context.getBean(Student.class);
		obj.setRollNo(104);
		obj.setName("Navin");
		obj.setMarks(78);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(obj);

		List<Student> students = service.getAllStudents();
		System.out.println(students + " -> are all the added students");

	}

}
