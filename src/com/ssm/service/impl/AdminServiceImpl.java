package com.ssm.service.impl;

import java.util.List;

import com.ssm.mapper.AdminMapper;
import com.ssm.model.Admin;
import com.ssm.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminMapper adminMapper;
	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public List<Admin> getAdmin() {
		return adminMapper.getAdmin();
	}

}
