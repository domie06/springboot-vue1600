package com.yjkj.framework.rbac.wage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.wage.model.Wage;
import com.yjkj.framework.rbac.wage.service.inte.WageService;
@Service
public class WageServiceImpl extends BaseService implements WageService {

	
	@Override
	public Pager informationLoad(Pager pager,Wage Wage,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("wage", Wage);
		List<Wage> list = this.wageDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Wage));
		return pager;
	}
	
	@Override
	public Pager informationLoadMy(Pager pager,Wage Wage,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Wage.setUser_id(userInfo.getId());
		map.put("pager", pager);
		map.put("wage", Wage);
		List<Wage> list = this.wageDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Wage));
		return pager;
	}
	
	@Override
	public Pager informationLoadRecommend(Pager pager,Wage Wage,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Wage.setRecommend_id(userInfo.getRecommend().getId());
		map.put("pager", pager);
		map.put("wage", Wage);
		List<Wage> list = this.wageDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Wage));
		return pager;
	}

	@Override
	public List<Wage> informationLoadAll(Wage Wage) throws Exception {
		List<Wage> list = this.wageDao.informationLoadAll(Wage);
		return list;
	}
	

	@Override
	public Integer count(Wage Wage) throws Exception {
		Integer count = this.wageDao.count(Wage);
		return count;
	}

	@Override
	public Wage informationLoadOne(Wage Wage) throws Exception {
			Wage = this.wageDao.informationLoadOne(Wage);
		return Wage;
	}

	@Override
	public void informationDelete(Wage Wage) throws Exception {
			this.wageDao.informationDelete(Wage);

	}

	@Override
	public void informationAdd(Wage Wage) throws Exception {
		Wage.setIncome(Wage.getBase()+Wage.getBonus()+Wage.getOvertime()-Wage.getLate()-Wage.getOld_age()-Wage.getMedical()-Wage.getHouse()-Wage.getTax());
			Wage.setId(Regular.createId());
			Wage.setCreatetime(CreatDate.getDate());
			this.wageDao.informationAdd(Wage);

	}

	@Override
	public void informationUpade(Wage Wage) throws Exception {
			this.wageDao.informationUpdate(Wage);
	}

}
