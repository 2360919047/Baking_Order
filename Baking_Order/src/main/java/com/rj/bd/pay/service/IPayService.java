package com.rj.bd.pay.service;

import java.util.List;
import java.util.Map;

import com.rj.bd.pay.entity.Pay;

public interface IPayService {

	/**
	 * @desc  查询全部支付方式
	 * @return
	 */
	List<Map<String, Object>> queryPay();
	
	/**
	 * @desc 添加支付方式
	 * @param y
	 */
	void addPay(Pay y);
	
	/**
	 * @desc 删除一条支付方式
	 * @param pay
	 * @return
	 */
	void deletePay(Pay pay);

	/**
	 * @param id 
	 * @desc  查询一条
	 */
	void queryPayById(String id);

}
