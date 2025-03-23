package com.yjkj.framework.rbac.wage.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.wage.model.Wage;

public interface WageService {

	public Pager informationLoad(Pager pager,Wage Wage,HttpSession session) throws Exception;
	
	public Pager informationLoadMy(Pager pager,Wage Wage,HttpSession session) throws Exception;
	
	public Pager informationLoadRecommend(Pager pager,Wage Wage,HttpSession session) throws Exception;
	
	public List<Wage> informationLoadAll(Wage Wage) throws Exception;
	
	public Integer count(Wage Wage) throws Exception;
	
	public Wage informationLoadOne(Wage Wage) throws Exception;
	
	public void informationDelete(Wage Wage) throws Exception;
	
	public void informationAdd(Wage Wage) throws Exception;
	
	public void informationUpade(Wage Wage) throws Exception;
	
}
