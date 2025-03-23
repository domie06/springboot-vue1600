package com.yjkj.framework.rbac.recommend.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.recommend.model.Recommend;

public interface RecommendService {

	public Pager informationLoad(Pager pager,Recommend Recommend,HttpSession session) throws Exception;
	
	public List<Recommend> informationLoadAll(Recommend Recommend) throws Exception;
	
	public Integer count(Recommend Recommend) throws Exception;
	
	public Recommend informationLoadOne(Recommend Recommend) throws Exception;
	
	public void informationDelete(Recommend Recommend) throws Exception;
	
	public void informationAdd(Recommend Recommend) throws Exception;
	
	public void informationUpade(Recommend Recommend) throws Exception;
	
}
