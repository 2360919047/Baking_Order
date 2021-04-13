package com.rj.bd.manager.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.manager.entity.Manager;
import com.rj.bd.manager.service.IManagerService;

@Controller
@ResponseBody
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	public IManagerService managerService;
	
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		if (username==null||username.equals("")) {
			json.put("code", -1);
			json.put("msg", "请输入用户名");
			return json;
		}
		
		if (password==null||password.equals("")) {
			json.put("code", -1);
			json.put("msg", "请输入密码");
			return json;
		}
		
		Manager manager = managerService.queryUserNameAndPassword(username,password);
		
		if (manager==null) {
			json.put("code", -1);
			json.put("msg", "用户名或密码错误");
			return json;
		}
		
		System.out.println(username);
		System.out.println(password);
		//更新token
		String token = DigestUtils.md5Hex(username+password+request.getSession().getId());
		managerService.updateToken(token,manager.getId());
		
		json.put("code", 200);
		json.put("msg", "请求成功");
		json.put("token", token);
		System.out.println(token);
		return json;
	}
	
}
