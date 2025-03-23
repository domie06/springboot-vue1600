package com.yjkj.framework.rbac.wage.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.wage.model.Wage;

public interface WageDao {

	public List<Wage> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Wage> informationLoadAll(Wage Wage) throws Exception;
	
	public Integer count(Wage Wage) throws Exception;
	
	public Wage informationLoadOne(Wage Wage) throws Exception;
	
	public void informationDelete(Wage Wage) throws Exception;
	
	public void informationAdd(Wage Wage) throws Exception;
	
	public void informationUpdate(Wage Wage) throws Exception;
	
}
