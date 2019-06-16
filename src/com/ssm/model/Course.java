package com.ssm.model;

import java.util.HashSet;
import java.util.Set;


public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	private Set<Score> scores = new HashSet<Score>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Teacher teacher, String name, Set<Teacher> teachers,
			Set<Score> scores) {
		this.teacher = teacher;
		this.name = name;
		this.teachers = teachers;
		this.scores = scores;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Score> getScores() {
		return this.scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}