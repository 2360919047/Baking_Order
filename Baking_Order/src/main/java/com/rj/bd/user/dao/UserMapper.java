package com.rj.bd.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.user.entity.User;

@Repository("userMapper")
public interface UserMapper {

	@Select("select * from user")
	List<User> queryAll();

	@Delete("delete from user where id = #{id}")
	void del(String id);
	
	@Insert("insert into user (id,name,tel,address,remarks) values (#{id},#{name},#{tel},#{address},#{remarks})")
	void add(User user);

	@Select("select * from user where id=#{id}")
	User queryUserById(String id);

	@Update("update user set name=#{name},tel=#{tel},address=#{address},remarks=#{remarks} where id=#{id}")
	void update(User user);
	
	
	
}
