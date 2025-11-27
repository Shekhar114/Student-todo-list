package com.student.service;

import java.util.List;


import com.student.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public void updateStudent(Student student);
	
	public Student findByIdStudent(int id);
	
	public void deleteStudent(int id);
	
}
