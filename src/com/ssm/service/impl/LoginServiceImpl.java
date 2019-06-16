package com.ssm.service.impl;


import com.ssm.mapper.LoginMapper;
import com.ssm.model.Admin;
import com.ssm.model.Student;
import com.ssm.model.Teacher;
import com.ssm.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginMapper loginMapper;
	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	@Override
	public Student checkStudentLogin(Student student) {
		
		return loginMapper.checkStudentLogin(student);
	}

	@Override
	public Teacher checkTeacherLogin(Teacher teacher) {
		return loginMapper.checkTeacherLogin(teacher);
	}

	@Override
	public Admin checkAdminLogin(Admin admin) {
		return loginMapper.checkAdminLogin(admin);
	}

}
