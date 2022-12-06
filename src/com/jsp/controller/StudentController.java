package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		ArrayList<Student> a1=new ArrayList<Student>();
		Student s1=new Student();
		s1.setId(3);
		s1.setName("Pratik");
		s1.setEmail("Pratik@gmail.com");
		s1.setGender("Male");
		s1.setCno("1234567899");
		
		Student s2=new Student();
		s2.setId(4);
		s2.setName("Pranav");
		s2.setEmail("Pranav@gmail.com");
		s2.setGender("Male");
		s2.setCno("1234567899");
		
		Student s3=new Student();
		s3.setId(5);
		s3.setName("Vicky");
		s3.setEmail("Vicky@gmail.com");
		s3.setGender("Male");
		s3.setCno("1234567899");
		
		a1.add(s1);
		a1.add(s2);
		a1.add(s3);
		
		StudentDao studentDao=new StudentDao();
		//studentDao.saveStudent(student);
		//studentDao.UpdateName(student);
		//studentDao.DeleteStudent(student);
		//studentDao.UpdateStudent(student);
		studentDao.addMultipleStudents(a1);
	}
}
