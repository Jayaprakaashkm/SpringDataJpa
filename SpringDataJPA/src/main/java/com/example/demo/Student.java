package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="s_name")
	private String name;
	private int age;
	private String address;
	
	@OneToOne(
			mappedBy = "student",
			cascade = CascadeType.ALL)
	private StudentProfile studentProfile;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	@JsonBackReference
	private School school;

	public StudentProfile getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Student() {
	}
	
	
	
	public Student(Integer id, String name, int age, String address, StudentProfile studentProfile, School school) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.studentProfile = studentProfile;
		this.school = school;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}


	

}
