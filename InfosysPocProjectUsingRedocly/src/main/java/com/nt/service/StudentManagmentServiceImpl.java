package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repo.StudentRepo;

@Service("studentService")
public class StudentManagmentServiceImpl implements StudentManagementService {
	
	@Autowired
	private StudentRepo repo;

	@Override
	public Student registerStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public List<Student> findAllStudentDetails() {
		// TODO Auto-generated method stub
		return (List<Student>) repo.findAll();
	}

	@Override
	public Optional<Student> findStudentbyId(Long id) {
		return repo.findById(id);
	}

	@Override
	public String deleteStudentbyId(Long sid) {
		repo.deleteById(sid);
		return "Studnet with Id "+sid+"Info id Will be Delete";
	}

	@Override
	public String deleteALlStudent() {
		repo.deleteAll();
		return "All Student Info Deleted";
	}

	@Override
	public Student updateStudentDetails(Student student) {
		return repo.save(student);
	}

}
