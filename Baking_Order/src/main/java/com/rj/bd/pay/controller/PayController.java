package com.rj.bd.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rj.bd.pay.entity.Pay;
import com.rj.bd.pay.service.IPayService;
import com.rj.bd.utils.Kuayu;

@Controller
@ResponseBody
@RequestMapping("/pay")
public class PayController {
	@Autowired
	public IPayService payService;
	public Map<String, Object> map;
	@RequestMapping("/queryPay")
	public List<Map<String, Object>> queryPay(HttpServletResponse response){
		
		// 指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 跨域 Header
		response.setHeader("Access-Control-Allow-Headers", "*");
		// 允许请求的类型 post get 这些
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setCharacterEncoding("utf-8");
		// 设置返回的文件类型
		response.setContentType("application/json;charset=UTF-8");
		
		List<Map<String, Object>> list = payService.queryPay();
		
		return list;
	}
	
	@RequestMapping("/addPay")
	public Map<String, Object> addPay(Pay y,HttpServletRequest request){
		String pay_name = request.getParameter("pay_name");
		String remarks = request.getParameter("remarks");
		String picture = null;
		
		//Pay y = new Pay();
		y.setPay_id(UUID.randomUUID().toString().substring(0, 5));
		y.setPay_name(pay_name);
		y.setRemarks(remarks);
		Map<String, Object> json = new HashMap<String, Object>();
		payService.addPay(y);
		json.put("msg", "保存成功");

		return json;
	}
	
	@RequestMapping("/deletePay")
	public Map<String, Object> deletePay(Pay pay ,HttpServletRequest request ){
		Map<String, Object > json = new HashMap<String, Object>();
		
		String pay_id = request.getParameter("pay_id");
		//pay.setPay_id(pay_id);
		
		//String id = "3f45";
		pay.setPay_id(pay_id);
	    payService.deletePay(pay);
		json.put("msg", "删除成功");
		return json;
	}
	
	@RequestMapping("/editPayPath")
	public Map<String, Object> editPayPath(HttpServletRequest request){
		Map<String, Object> json = new HashMap<String, Object>();
		String id = request.getParameter("pay_id");
		
		map = payService.queryPayById(id);
		System.out.println("map:"+map);
		return map;
	}
	@RequestMapping("/editPay")
	public Map<String, Object> editPay(Pay pay, HttpServletRequest request){
		Map<String, Object> json = new HashMap<String, Object>();
 		
		String pay_id = request.getParameter("pay_id");
		String pay_name = request.getParameter("pay_name");
		String remarks = request.getParameter("remarks"); 
		
		pay.setPay_id(pay_id);
		pay.setPay_name(pay_name);
		pay.setRemarks(remarks);
		
		payService.editPay(pay);
		
		json.put("code", 200);
		json.put("msg","修改成功");
		return json;
	}
}
