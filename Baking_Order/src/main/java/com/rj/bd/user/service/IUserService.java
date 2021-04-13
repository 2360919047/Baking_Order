package com.rj.bd.user.service;

import java.util.List;

import com.rj.bd.user.entity.User;

public interface IUserService {

	List<User> queryAll();

	void del(String id);

	void add(User user);

	User queryUserById(String id);

	void update(User user);

}
