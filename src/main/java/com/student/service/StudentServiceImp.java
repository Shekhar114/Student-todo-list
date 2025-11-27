package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		
		return studentRepository.findAll();
	}

	

	@Override
	public void deleteStudent(int id) {
	 studentRepository.deleteById(id);
	}

	@Override
	public Student findByIdStudent(int id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void updateStudent(Student student) {
	
		studentRepository.save(student);
	}

	





	
	
}
