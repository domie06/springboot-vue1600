package com.yjkj.framework.rbac.userInfo.service.inte;

import java.util.List;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public interface UserInfoService {

	public UserInfo login(String loginName,String loginPassword);
	
	public UserInfo queryOne(String id);
	
	public List<UserInfo> queryAll();
	
	public Pager Query(Pager pager,UserInfo user);
	
	public void userDelete(String id);
	
	public Integer queryCount(UserInfo userInfo);
	
	public void userAdd(
				UserInfo userInfo);
	
	public void userUpdate(
			UserInfo userInfo);
	
}
