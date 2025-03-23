package com.yjkj.framework.rbac.recommend.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.recommend.model.Recommend;
import com.yjkj.framework.rbac.recommend.service.inte.RecommendService;
@Service
public class RecommendServiceImpl extends BaseService implements RecommendService {

	
	@Override
	public Pager informationLoad(Pager pager,Recommend Recommend,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("recommend", Recommend);
		List<Recommend> list = this.recommendDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Recommend));
		return pager;
	}

	@Override
	public List<Recommend> informationLoadAll(Recommend Recommend) throws Exception {
		List<Recommend> list = this.recommendDao.informationLoadAll(Recommend);
		return list;
	}
	

	@Override
	public Integer count(Recommend Recommend) throws Exception {
		Integer count = this.recommendDao.count(Recommend);
		return count;
	}

	@Override
	public Recommend informationLoadOne(Recommend Recommend) throws Exception {
			Recommend = this.recommendDao.informationLoadOne(Recommend);
		return Recommend;
	}

	@Override
	public void informationDelete(Recommend Recommend) throws Exception {
			this.recommendDao.informationDelete(Recommend);

	}

	@Override
	public void informationAdd(Recommend Recommend) throws Exception {
			Recommend.setId(Regular.createId());
			Recommend.setCreatetime(CreatDate.getDate());
			this.recommendDao.informationAdd(Recommend);

	}

	@Override
	public void informationUpade(Recommend Recommend) throws Exception {
			this.recommendDao.informationUpdate(Recommend);
	}

}
