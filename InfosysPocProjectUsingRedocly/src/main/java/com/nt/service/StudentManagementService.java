package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Student;

public interface StudentManagementService {

	Student registerStudent(Student student);
	List<Student> findAllStudentDetails();
	Optional<Student>  findStudentbyId(Long id);
	String deleteStudentbyId(Long sid);
	String deleteALlStudent();
	Student updateStudentDetails(Student student);
	
}
