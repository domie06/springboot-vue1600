package com.yjkj.framework.rbac.attence.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.attence.model.Attence;

public interface AttenceService {

	public Pager informationLoad(Pager pager,Attence Attence,HttpSession session) throws Exception;
	
	public Pager informationLoadMy(Pager pager,Attence Attence,HttpSession session) throws Exception;
	
	public List<Attence> informationLoadAll(Attence Attence) throws Exception;
	
	public Integer count(Attence Attence) throws Exception;
	
	public Attence informationLoadOne(Attence Attence) throws Exception;
	
	public void informationDelete(Attence Attence) throws Exception;
	
	public void informationAdd(Attence Attence) throws Exception;
	
	public void informationUpade(Attence Attence) throws Exception;
	
}
