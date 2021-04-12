package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentModel;
import com.example.repository.StudentRepository;

@RestController
public class Controller {

	@Autowired
	StudentRepository StudentRepo;
	
	//save new student details
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody StudentModel student) {
		StudentRepo.save(student);
	}
	
	//get all the students
	@GetMapping("/getAllStudents")
	public List<StudentModel> getAllStudents(){
		return (List<StudentModel>) StudentRepo.findAll();
	}
	
	//get single student
	@GetMapping("/getStudent/{id}")
	public Optional<StudentModel> getStudent(@PathVariable String id) {
		return StudentRepo.findById(id);
	}
	
	//change the fees status of a particular student
	@PostMapping("/feesStatus")
	public void changeFeesStatus(@RequestBody LinkedHashMap<String,Object> data) {
		Optional<StudentModel> a = StudentRepo.findById(data.get("studentId").toString());
		if(!a.isEmpty()){
			if(data.get("status").toString().equals("true")) {
				a.get().setFeesPaid(true);			
			}else{
				a.get().setFeesPaid(false);
			}
			StudentRepo.save(a.get());
		}
	}
	
	//delete a student
	@GetMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable String id) {
		StudentRepo.deleteById(id);
	}
	
	//update Student
	@PostMapping("/editStudent/{id}")
	public void updateStudent(@RequestBody LinkedHashMap<String,Object> data,@PathVariable String id) {
		var a = StudentRepo.findById(id);
		if(!a.isEmpty()) {
			if(data.get("feesPaid").toString().equals("true")) {
				a.get().setFeesPaid(true);			
			}else{
				a.get().setFeesPaid(false);
			}
			a.get().setRollNo(data.get("rollNo").toString());
			a.get().setStudentClass(Integer.parseInt(data.get("studentClass").toString()));
			a.get().setStudentName(data.get("studentName").toString());
			a.get().setStudentSection((char)data.get("studentSection").toString().charAt(0));
			
			StudentRepo.save(a.get());
		}
	}
}
