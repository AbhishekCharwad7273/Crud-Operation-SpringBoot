package com.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudoperation.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
