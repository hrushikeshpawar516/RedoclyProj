package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {

}
