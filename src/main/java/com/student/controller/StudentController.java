package com.student.controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentServiceImp;




@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImp studentService;
	
	//1. find All data from database and show the tables
	@GetMapping("/students")
	public String listOfStudent(Model model) {
	    
	    model.addAttribute("students",studentService.findAllStudent());
	    return "student";
	}
//		@GetMapping("/students")
//		public String listOfStudent(Model model) {
//			
//			model.addAttribute("students",studentService.findAllStudent());
//			
//			return "student";
//		}
		
	
	
	
		//2. create new student and save the database
				@GetMapping("/students/new")
				public String createStudent(Model model) {
					
					Student student = new Student();
					
					model.addAttribute("student",student);
					return "createStudent";
				}
				
				
				//2. create new student and save the database
				@PostMapping("/AddNewStudent")
				public String saveStudent(@ModelAttribute("student") Student student1) {
					
					studentService.saveStudent(student1);
					
					
					return "redirect:/students";
				}
				
					
	
}
