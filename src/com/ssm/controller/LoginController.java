package com.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.model.Admin;
import com.ssm.model.Teacher;
import com.ssm.service.LoginService;
import com.ssm.service.impl.LoginServiceImpl;
import com.ssm.model.Student;

/**
 * ��¼��֤�����ࣺ����ѧ������ʦ������Ա�ĵ�¼��֤
 * 
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	private Student student;
	private Teacher teacher;
	private Admin admin;
	
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@RequestMapping("loginAction")
	public String loginAction(@RequestParam String username,@RequestParam String password,@RequestParam Integer type,HttpServletRequest request) {
		
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		System.out.println("type=" + type);

		if (type == 0) {// ѧ����¼��֤
			//int id = Integer.parseInt(username);
			student = loginService.checkStudentLogin(new Student(Integer.parseInt(username), password));
			if (student != null) {
				//�������session����
				request.getSession().setAttribute("student", student);
				//map.put("student", student);
				
				return "student/studentIndex";
			} else
				return "login";
		} else if (type == 1) {// ��ʦ��¼��֤
			//int id = Integer.parseInt(username);
			teacher = loginService.checkTeacherLogin(new Teacher(Integer.parseInt(username), password));
			if (teacher != null) {
				request.getSession().setAttribute("teacher", teacher);
				return "teacher/teacherIndex";
			} else
				return "login";
		} else {// ����Ա��¼��֤
			admin = loginService.checkAdminLogin(new Admin(username, password));
			if (admin != null) {
				request.getSession().setAttribute("admin", admin);
				return "behind/adminIndex";
			} else
				return "login";
		}
	}
}
