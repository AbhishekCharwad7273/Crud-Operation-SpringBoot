package com.crudoperation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperation.entity.Student;
import com.crudoperation.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	//build create Student Rest api
	@PostMapping("/")
	public ResponseEntity<Student>saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	//build All Student rest Api
	
	@GetMapping("/")
	public List<Student>getAllStudent()
	{
		return studentService.getAllStudent();
	}
	
	//build get Student by id rest api
	@GetMapping("{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable Integer id)
	{
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
		
	}
	
	//update student
	@PutMapping("{id}")
	public ResponseEntity<Student>updateStudent(@PathVariable Integer id,@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
	
	//delete Student
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Integer id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
		
	}
}
