package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public Student updateStudent(Student student);
	
	public void deleteStudent(int id);
	
}
