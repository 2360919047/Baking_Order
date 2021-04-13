package com.rj.bd.pay.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.rj.bd.pay.entity.Pay;

public interface PayMapper {

	@Select("select * from pay")
	List<Map<String, Object>> queryPay();

	@Select("insert into pay (pay_id,pay_name,remarks) values (#{pay_id},#{pay_name},#{remarks})")
	void addPay(Pay y);
	
	@Select("delete from pay where pay_id=#{pay_id}")
	void deletePay(Pay pay);

	@Select("select * from pay where pay_id=#{id}")
	Map editPayById(String id);
	
	@Select("update pay set pay_name=#{pay_name},remarks=#{remarks} where pay_id=#{pay_id}")
	void editPay(Pay pay);

}
