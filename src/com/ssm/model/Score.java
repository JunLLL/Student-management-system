package com.ssm.model;


public class Score implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private Student student;
	private Double score;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(Course course, Student student, Double score) {
		this.course = course;
		this.student = student;
		this.score = score;
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

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}