package com.rj.bd.manager.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.manager.entity.Manager;
@Repository("managerMapper")
public interface ManagerMapper {

	@Select("select * from manager where username=#{0} and password=#{1}")
	Manager queryUserNameAndPassword(String username, String password);

	@Update("update manager set token=#{0} where id=#{1} ")
	void updateToken(String token, Integer id);

	
	

	

	
	
}
