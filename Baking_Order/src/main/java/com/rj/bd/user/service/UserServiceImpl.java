package com.rj.bd.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.user.dao.UserMapper;
import com.rj.bd.user.entity.User;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	public UserMapper userMapper;

	public List<User> queryAll() {
		return userMapper.queryAll();
	}

	public void del(String id) {
		userMapper.del(id);
	}

	public void add(User user) {
		userMapper.add(user);
	}

	public User queryUserById(String id) {
		return userMapper.queryUserById(id);
	}

	public void update(User user) {
		userMapper.update(user);
	}
}
