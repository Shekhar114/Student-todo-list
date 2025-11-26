package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StudentController {
	
	
// 1. Making a custom welcome page	
	@GetMapping("/")
	public String showWelocomePage() {
		return "student";
	}
	
	
// 2.Add the Student
	@GetMapping("/students/new")
	public String mappingNewStudentAdded() {
		return "createStudent";
	}
// 3. Update the student
	
	@GetMapping("/student/edit")
	public String updateStudent() {
		return "editStudent";
	}

}
