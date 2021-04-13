package com.rj.bd.pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.pay.dao.PayMapper;
import com.rj.bd.pay.entity.Pay;

@Service("payServiceImpl")
public class PayServiceImpl implements IPayService{

	@Autowired
	public PayMapper payMapper;
	
	public List<Map<String, Object>> queryPay() {
		
		return payMapper.queryPay();
	}

	public void addPay(Pay y) {
		
		 payMapper.addPay(y);
	}

	public void deletePay(Pay pay) {
		
		payMapper.deletePay(pay);
	}

	public Map queryPayById(String id) {
		
		return payMapper.editPayById(id);
		
	}

	public void editPay(Pay pay) {
		
		payMapper.editPay(pay);
		
	}

}
