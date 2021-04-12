package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.StudentModel;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, String>{

	void save(Optional<StudentModel> a);

}
