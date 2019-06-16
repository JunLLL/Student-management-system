package com.ssm.model;

import java.util.HashSet;
import java.util.Set;
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String name;
	private String sex;
	private String birthday;
	private String professional;
	private String password;
	private Set<Course> courses = new HashSet<Course>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer id,String password) {
		this.id = id;
		this.password = password;
	}

	/** full constructor */
	public Teacher(Integer id, Course course, String name, String sex,
			String birthday, String professional, String password,
			Set<Course> courses) {
		this.id = id;
		this.course = course;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.professional = professional;
		this.password = password;
		this.courses = courses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}