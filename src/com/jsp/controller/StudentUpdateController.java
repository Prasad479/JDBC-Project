package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentUpdateController {
	public static void main(String[] args) {
		Student s=new Student();
		s.setName("Bikas");
		s.setEmail("Bikas@gmail.com");
		s.setGender("Male");
		s.setCno("12345678");
		s.setId(4);
		
		StudentDao studentDao=new StudentDao();
		studentDao.UpdateStudent(s);
	}
}
