package com.rj.bd.Distribution.service;

import java.util.List;

import com.rj.bd.Distribution.entity.Kuaidi;

public interface IDistributionService {

	List<Kuaidi> queryAll();

	void add(Kuaidi kuaidi);

	void del(String e_id);

	Kuaidi queryById(String e_id);

	void update(Kuaidi kuaidi);

}
