package com.rj.bd.Distribution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.bd.Distribution.dao.DistributionMapper;
import com.rj.bd.Distribution.entity.Kuaidi;

@Service("DistributionService")
public class DistributionServiceImpl implements IDistributionService{
	
	@Autowired
	public DistributionMapper distributionMapper;

	public List<Kuaidi> queryAll() {
		return distributionMapper.queryAll();
	}

	public void add(Kuaidi kuaidi) {
		distributionMapper.add(kuaidi);
	}

	public void del(String e_id) {
		distributionMapper.del(e_id);
	}

	public Kuaidi queryById(String e_id) {
		return distributionMapper.queryById(e_id);
	}

	public void update(Kuaidi kuaidi) {
		distributionMapper.update(kuaidi);
	}
}
