package com.rj.bd.manager.service;

import com.rj.bd.manager.entity.Manager;

public interface IManagerService {

	Manager queryUserNameAndPassword(String username, String password);

	void updateToken(String token, Integer id);
	
	
}
