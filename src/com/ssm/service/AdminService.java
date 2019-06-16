package com.ssm.service;

import java.util.List;

import com.ssm.model.Admin;

/**
 * 
 * 有关管理员信息管理的业务逻辑处理的接�?
 *
 */
public interface AdminService {
	//获取管理员信息列�?
	public List<Admin> getAdmin();
}
