package com.crudoperation.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.entity.Student;
import com.crudoperation.exception.ResourceNotFoundException;
import com.crudoperation.repository.StudentRepo;
import com.crudoperation.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepo studentRepo;
	
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}




	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}


	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}




	@Override
	public Student getStudentById(Integer id) {
		/*
		 Optional<Student> student=studentRepo.findById(id);
		 if(student.isPresent())
		 {
			 return student.get();
		 }
		 else
		 {
			 throw new  ResourceNotFoundException("Student","Id",id);
		 }
		*/
		
		return studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
	}




	@Override
	public Student updateStudent(Student student, Integer id) {
		
		//we need to check weather a Student id existing or not
		Student existingStudent=studentRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setPercentage(student.getPercentage());
		//save student updated data in database
		
		studentRepo.save(existingStudent);
		
		return existingStudent;
	}




	@Override
	public void deleteStudent(Integer id) {
		//we need to check weather a Student id existing or not
		
		studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
		
		
		 studentRepo.deleteById(id);
	}

}
