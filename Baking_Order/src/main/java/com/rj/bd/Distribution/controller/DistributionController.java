package com.rj.bd.Distribution.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.Distribution.entity.Kuaidi;
import com.rj.bd.Distribution.service.IDistributionService;

@Controller
@ResponseBody
@RequestMapping("/Distribution")
public class DistributionController {
	
	@Autowired
	public IDistributionService distributionService;
	
	@RequestMapping("/query")
	public Map<String, Object> queryAll(){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		List<Kuaidi> list = distributionService.queryAll();
		
		if (list==null||list.size()==0) {
			json.put("code", "-1");
			json.put("msg", "请求失败");
			return json;
		}
		json.put("code", "200");
		json.put("msg", "请求成功");
		json.put("data", list);
		return json;
	}
	
	@RequestMapping("/add")
	public Map<String, Object> add(HttpServletRequest request,Kuaidi kuaidi){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String e_name = request.getParameter("e_name");
		String e_describe = request.getParameter("e_describe");
		
		if (e_name==null||e_name.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入名字");
			return json;
		}
		if (e_describe==null||e_describe.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入描述");
			return json;
		}
		
		kuaidi.setE_id(UUID.randomUUID().toString());
		kuaidi.setE_name(e_name);
		kuaidi.setE_describe(e_describe);
		
		distributionService.add(kuaidi);
		
		json.put("code", "200");
		json.put("msg", "请求成功");
		
		return json;
	}
	
	@RequestMapping("/delete")
	public Map<String, Object> del(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String e_id = request.getParameter("e_id");
		
		if (e_id==null||e_id.length()==0) {
			json.put("code", "-1");
			json.put("msg", "200");
			return json;
		}
		
		distributionService.del(e_id);
		
		json.put("code", "200");
		json.put("msg", "请求成功");
		
		return json;
	}
	
	@RequestMapping("/editPage")
	public Map<String, Object> editPage(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String e_id = request.getParameter("e_id");
		
		if (e_id==null||e_id.length()==0) {
			json.put("code", "-1");
			json.put("msg", "请选择");
			return json;
		}
		
		Kuaidi kuaidi = distributionService.queryById(e_id);
		
		if (kuaidi==null) {
			json.put("code", "-1");
			json.put("msg", "获取失败");
			return json;
		}
		
		json.put("code", "200");
		json.put("msg", "获取成功");
		json.put("data", kuaidi);
		return json;
	}
	
	@RequestMapping("/edit")
	public Map<String, Object> edit(HttpServletRequest request){
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		String e_name = request.getParameter("e_name");
		String e_describe = request.getParameter("e_describe");
		
		if (e_name==null||e_name.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入名字");
			return json;
		}
		if (e_describe==null||e_describe.equals("")) {
			json.put("code", "-1");
			json.put("msg", "请输入描述");
			return json;
		}
		
		Kuaidi kuaidi = new Kuaidi();
		kuaidi.setE_name(e_name);
		kuaidi.setE_describe(e_describe);
		
		distributionService.update(kuaidi);
		
		json.put("code", "200");
		json.put("msg", "获取成功");
		return json;
	}
}
