package com.yjkj.framework.rbac.attence.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.attence.model.Attence;
import com.yjkj.framework.rbac.attence.service.inte.AttenceService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
@Service
public class AttenceServiceImpl extends BaseService implements AttenceService {

	
	@Override
	public Pager informationLoad(Pager pager,Attence Attence,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("attence", Attence);
		List<Attence> list = this.attenceDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Attence));
		return pager;
	}
	
	@Override
	public Pager informationLoadMy(Pager pager,Attence Attence,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Attence.setUser_id(userInfo.getId());
		map.put("pager", pager);
		map.put("attence", Attence);
		List<Attence> list = this.attenceDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Attence));
		return pager;
	}

	@Override
	public List<Attence> informationLoadAll(Attence Attence) throws Exception {
		List<Attence> list = this.attenceDao.informationLoadAll(Attence);
		return list;
	}
	

	@Override
	public Integer count(Attence Attence) throws Exception {
		Integer count = this.attenceDao.count(Attence);
		return count;
	}

	@Override
	public Attence informationLoadOne(Attence Attence) throws Exception {
			Attence = this.attenceDao.informationLoadOne(Attence);
		return Attence;
	}

	@Override
	public void informationDelete(Attence Attence) throws Exception {
			this.attenceDao.informationDelete(Attence);

	}

	@Override
	public void informationAdd(Attence Attence) throws Exception {
			Attence.setId(Regular.createId());
			Attence.setCreatetime(CreatDate.getDate());
			List<Attence> list = this.attenceDao.check(Attence);
			if(!list.isEmpty()&&list.size()>0) {
				throw new RuntimeException("此人当日已打过卡");
			}
			this.attenceDao.informationAdd(Attence);

	}

	@Override
	public void informationUpade(Attence Attence) throws Exception {
			this.attenceDao.informationUpdate(Attence);
	}

}
