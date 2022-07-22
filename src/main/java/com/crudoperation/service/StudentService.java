package com.crudoperation.service;

import java.util.List;

import com.crudoperation.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(Integer id);
	Student updateStudent(Student student,Integer id);
	void deleteStudent(Integer id);
}
