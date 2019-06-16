package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.Admin;
import com.ssm.service.AdminService;

/**
 * ��¼��֤�����ࣺ����ѧ������ʦ������Ա�ĵ�¼��֤
 * 
 */
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("adminAction")
	public String adminAction(HttpServletRequest request) {
		List<Admin> admins=adminService.getAdmin();
		request.setAttribute("admins", admins);
		return "behind/adminInfo";
		
	}
}
