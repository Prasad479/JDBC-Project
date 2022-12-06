package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.util.HelperClass;

public class StudentDao {
	HelperClass helperClass = new HelperClass();

	// method to save student
	public void saveStudent(Student student) {
		String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
		Connection connection = helperClass.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getGender());
			preparedStatement.setString(5, student.getCno());

			preparedStatement.execute();
			System.out.println("All Good");

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateName(Student student) {
		String sql = "UPDATE student SET name=? WHERE id=?";
		Connection connection = helperClass.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getId());

			preparedStatement.execute();
			System.out.println("Name updated");
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeleteStudent(Student student) {
		String sql = "DELETE FROM student WHERE id=?";
		Connection connection = helperClass.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());

			preparedStatement.execute();
			System.out.println("Student Deleted");
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateStudent(Student student) {
		String url = "UPDATE student SET name=?,email=?,gender=?,cno=? WHERE id=?";
		Connection connection = helperClass.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(url);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getCno());
			preparedStatement.setInt(5, student.getId());

			int a=preparedStatement.executeUpdate();
			if(a>0) {
				System.out.println("Student Updated");
				System.out.println(a);
			}else {
				System.out.println("Student not updated");
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMultipleStudents(List<Student> students) {
		Connection connection = helperClass.getConnection();
		String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
		for( Student student:students) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getGender());
			preparedStatement.setString(5, student.getCno());
			
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			System.out.println("All Good");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
