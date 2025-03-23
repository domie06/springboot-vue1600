package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.attence.dao.AttenceDao;
import com.yjkj.framework.rbac.recommend.dao.RecommendDao;
import com.yjkj.framework.rbac.wage.dao.WageDao;

@Service
public class BaseService {
	
	@Autowired
	public RecommendDao recommendDao;
	
	@Autowired
	public WageDao wageDao;
	
	@Autowired
	public AttenceDao attenceDao;
	
	
	
	
	
	

}
