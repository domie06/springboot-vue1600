package com.yjkj.framework.rbac.userInfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjkj.framework.rbac.userInfo.model.UserInfo;



public interface UserInfoDao {

	public UserInfo loginUser(@Param("loginName")String loginName,@Param("loginPassword")String loginPassword);
	
	public UserInfo queryOne(@Param("id")String id);
	
	public List<UserInfo> Query(Map<String,Object> map);
	
	public List<UserInfo> queryAll();
	
	public void userDelete(@Param("id")String id);
	
	public Integer queryCount(UserInfo userInfo);
	
	public void userAdd(
					UserInfo userInfo);
	public void userUpdate(
					UserInfo userInfo);
	
}
