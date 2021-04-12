package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentModel {
	@Id
	private String studentId;
	private String studentName;
	private int studentClass;
	private char studentSection;
	private String rollNo;
	private boolean feesPaid;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public char getStudentSection() {
		return studentSection;
	}
	public void setStudentSection(char studentSection) {
		this.studentSection = studentSection;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public boolean isFeesPaid() {
		return feesPaid;
	}
	public void setFeesPaid(boolean feesPaid) {
		this.feesPaid = feesPaid;
	}
	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", studentClass="
				+ studentClass + ", studentSection=" + studentSection + ", rollNo=" + rollNo + ", feesPaid=" + feesPaid
				+ "]";
	}
}
