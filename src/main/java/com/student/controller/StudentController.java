package com.student.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	
		//2. create new student and save the database
				@GetMapping("/students/new")
				public String createStudent(Model model) {
					
					Student student = new Student();
					
					model.addAttribute("student",student);
					return "createStudent";
				}
				
				
				//3. create new student and save the database
				@PostMapping("/AddNewStudent")
				public String saveStudent(@ModelAttribute("student") Student student1) {
					
					studentService.saveStudent(student1);
					
					
					return "redirect:/students";
				}
				
				
				//4. Update the student 
				
				@GetMapping("/student/edit/{id}")
				public String showEditPages(Model model,@PathVariable int id) {
					
					Student student = new Student();
					model.addAttribute("student",studentService.findByIdStudent(id));
					return "editStudent";
				}
					
//				@PostMapping("/updateStudent/{id}")
//				public String updateStudent(@ModelAttribute("student") Student student2,@PathVariable int id) {
//					Student existingStudent = studentService.findByIdStudent(id);
//					
//					existingStudent.setId(student2.getId());
//					existingStudent.setName(student2.getName());
//					existingStudent.setDob(student2.getDob());
//					existingStudent.setEmail(student2.getEmail());
//					existingStudent.setContact(student2.getContact());
//					existingStudent.setClassName(student2.getClassName());
//					
//					studentService.updateStudent(existingStudent);
//					return "redirect:/students";
//				}
				@PostMapping("/updateStudent/{id}")
				public String updateStudent(@ModelAttribute("student") Student student2,
				                            @PathVariable int id) {

				    Student existingStudent = studentService.findByIdStudent(id);

				    // ❌ remove this - never modify ID
				    // existingStudent.setId(student2.getId());

				    existingStudent.setName(student2.getName());
				    existingStudent.setDob(student2.getDob());
				    existingStudent.setEmail(student2.getEmail());
				    existingStudent.setContact(student2.getContact());
				    existingStudent.setClassName(student2.getClassName());

				    studentService.updateStudent(existingStudent);

				    return "redirect:/students";
				}
				
				@GetMapping("/student/delete/{id}")
				public String deleteStudent(@PathVariable int id) {
					Student existingStudent = studentService.findByIdStudent(id);
					studentService.deleteStudent(id);
					return "redirect:/students";
				}
				
				
}
