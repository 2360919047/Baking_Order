package com.rj.bd.manager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.manager.dao.ManagerMapper;
import com.rj.bd.manager.entity.Manager;
@Service("managerService")
public class ManagerServiceImpl implements IManagerService{
	
	@Autowired
	public ManagerMapper managerMapper;

	public Manager queryUserNameAndPassword(String username, String password) {
		return managerMapper.queryUserNameAndPassword(username,password);
	}

	public void updateToken(String token, Integer id) {
		managerMapper.updateToken(token,id);
	}

	
	
	
	
}
