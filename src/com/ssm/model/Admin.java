package com.ssm.model;

public class Admin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String username;
	private String password;
	private String name;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Admin(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}