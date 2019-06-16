package com.ssm.service;

import com.ssm.model.Admin;
import com.ssm.model.Student;
import com.ssm.model.Teacher;

public interface LoginService {
	public Student checkStudentLogin(Student student);// 学生登录验证

	public Teacher checkTeacherLogin(Teacher teacher);// 教师登录验证

	public Admin checkAdminLogin(Admin admin);// 管理员登录验证
}
