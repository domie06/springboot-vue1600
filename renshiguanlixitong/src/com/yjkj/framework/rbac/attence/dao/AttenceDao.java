package com.yjkj.framework.rbac.attence.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.attence.model.Attence;

public interface AttenceDao {

	public List<Attence> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Attence> informationLoadAll(Attence Attence) throws Exception;
	
	public List<Attence> check(Attence Attence) throws Exception;
	
	public Integer count(Attence Attence) throws Exception;
	
	public Attence informationLoadOne(Attence Attence) throws Exception;
	
	public void informationDelete(Attence Attence) throws Exception;
	
	public void informationAdd(Attence Attence) throws Exception;
	
	public void informationUpdate(Attence Attence) throws Exception;
	
}
