package com.rj.bd.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.user.service.IUserService;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
	
	//就提交这里吧
	public IUserService userService;
}
