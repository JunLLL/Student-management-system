package com.ssm.model;

import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private String clazz;
	private String birthday;
	private String password;
	
	private Set<Score> scores = new HashSet<Score>(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer id,String password) {
		this.id = id;
		this.password = password;
	}

	/** full constructor */
	public Student(Integer id, String name, String sex, String clazz,
			String birthday, String password, Set<Score> scores) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.clazz = clazz;
		this.birthday = birthday;
		this.password = password;
		this.scores = scores;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getClazz() {
		return this.clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Score> getScores() {
		return this.scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}