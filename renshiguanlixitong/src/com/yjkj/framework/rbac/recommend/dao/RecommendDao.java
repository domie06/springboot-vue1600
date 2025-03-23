package com.yjkj.framework.rbac.recommend.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.recommend.model.Recommend;

public interface RecommendDao {

	public List<Recommend> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Recommend> informationLoadAll(Recommend Recommend) throws Exception;
	
	public Integer count(Recommend Recommend) throws Exception;
	
	public Recommend informationLoadOne(Recommend Recommend) throws Exception;
	
	public void informationDelete(Recommend Recommend) throws Exception;
	
	public void informationAdd(Recommend Recommend) throws Exception;
	
	public void informationUpdate(Recommend Recommend) throws Exception;
	
}
