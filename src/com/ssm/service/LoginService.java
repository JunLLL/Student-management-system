package com.ssm.service;

import com.ssm.model.Admin;
import com.ssm.model.Student;
import com.ssm.model.Teacher;

public interface LoginService {
	public Student checkStudentLogin(Student student);// ѧ����¼��֤

	public Teacher checkTeacherLogin(Teacher teacher);// ��ʦ��¼��֤

	public Admin checkAdminLogin(Admin admin);// ����Ա��¼��֤
}
