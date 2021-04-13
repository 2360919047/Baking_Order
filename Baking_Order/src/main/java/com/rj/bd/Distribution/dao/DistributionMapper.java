package com.rj.bd.Distribution.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.rj.bd.Distribution.entity.Kuaidi;

@Repository("distributionMapper")
public interface DistributionMapper {

	@Select("select * from kuaidi")
	List<Kuaidi> queryAll();

	@Insert("insert into kuaidi (e_id,e_name,e_describe) values (#{e_id},#{e_name},#{e_describe})")
	void add(Kuaidi kuaidi);

	@Delete("delete from kuaidi where e_id = #{e_id}")
	void del(String e_id);

	@Select("select * from kuaidi where e_id=#{e_id}")
	Kuaidi queryById(String e_id);

	@Update("update kuaidi set e_name=#{e_name},e_describe=#{e_describe} where e_id=#{e_id}")
	void update(Kuaidi kuaidi);

}
