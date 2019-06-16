package com.ssm.mapper;

import com.ssm.model.Admin;
import com.ssm.model.Student;
import com.ssm.model.Teacher;

public interface LoginMapper {

	public Student checkStudentLogin(Student student);
	public Teacher checkTeacherLogin(Teacher teacher);
	public Admin checkAdminLogin(Admin admin);
}
