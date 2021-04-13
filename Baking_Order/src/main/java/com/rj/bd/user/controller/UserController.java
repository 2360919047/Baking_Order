package com.rj.bd.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rj.bd.user.entity.User;
import com.rj.bd.user.service.IUserService;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public IUserService userService;
	
	private String id;
	User user = new User();
	
	@RequestMapping("/query")
	public Map<String, Object> query(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		List<User> list = userService.queryAll();
		
		if (list==null||list.size()==0) {
			json.put("code", "-10");
			json.put("msg", "暂无用户");
			return json;
		}
		json.put("code", "200");
		json.put("msg", "获取成功");
		json.put("data", list);
		return json;
	}
	
	@RequestMapping("/delete")
	public Map<String, Object> del(HttpServletRequest request){
		Map<String, Object> json = new HashMap<String, Object>();
		
		String id = request.getParameter("id");
		
		if (id==null||id.length()==0) {
			json.put("code", "-1");
			json.put("msg", "请选择");
			return json;
		}
		
		userService.del(id);
		
		json.put("code", "200");
		json.put("msg", "删除成功");
		
		return json;
	}
	
	@RequestMapping("/add")
	public Map<String, Object> add(User user,HttpServletRequest request){
		Map<String, Object> json = new HashMap<String, Object>();
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String remarks = request.getParameter("remarks");
				
		/**/
		if (name==null||name.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入姓名");
			return json;
		}
		if (tel==null||tel.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入电话");
			return json;
		}
		if (address==null||address.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入地址");
			return json;
		}
		if (remarks==null||remarks.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入备注");
			return json;
		}
		user.setId(UUID.randomUUID().toString());
		user.setName(name);
		user.setTel(tel);
		user.setAddress(address);
		user.setRemarks(remarks);
		userService.add(user);
		
		json.put("code", "200");
		json.put("msg", "请求成功");
		
		return json;
	}
	
	@RequestMapping("editPage")
	public Map<String, Object> editPage(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		String id = request.getParameter("id");
		
		if (id==null||id.length()==0) {
			json.put("code", "-1");
			json.put("msg", "请选择user");
			return json;
		}
		
		User user = userService.queryUserById(id);
		
		if (user==null) {
			json.put("code", "-1");
			json.put("msg", "获取失败");
			return json;
		}
		json.put("code", "200");
		json.put("msg", "获取成功");
		json.put("data", user);
		
		
		return json;
	}
	
	@RequestMapping("edit")
	public Map<String, Object> edit(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String remarks = request.getParameter("remarks");
		
		if (name==null||name.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入姓名");
		}
		if (tel==null||tel.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入电话");
		}
		if (address==null||address.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入地址");
		}
		if (remarks==null||remarks.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入备注");
		}
		
		User user = new User();
		user.setName(name);
		user.setTel(tel);
		user.setAddress(address);
		user.setRemarks(remarks);
		
		userService.update(user);
		
		json.put("code", "200");
		json.put("msg", "请求成功");
		
		return json;
	}
}
