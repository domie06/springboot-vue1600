package com.yjkj.framework.rbac.userInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.rbac.userInfo.dao.UserInfoDao;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao userInfoDao;
	@Override
	public UserInfo login(String loginName, String loginPassword) {
		UserInfo userinfo = userInfoDao.loginUser(loginName, loginPassword);
		if(userinfo==null){
			throw new RuntimeException("用户名或密码错误!");
		}
		return userinfo;
	}
	@Override
	public void userAdd(UserInfo userInfo) {
		try{
			userInfo.setId(Regular.createId());
			this.userInfoDao.userAdd(userInfo);
		}catch (RuntimeException e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public UserInfo queryOne(String id) {
		UserInfo user = this.userInfoDao.queryOne(id);
		return user;
	}
	@Override
	public List<UserInfo> queryAll() {
		List<UserInfo> list = this.userInfoDao.queryAll();
		return list;
	}
	@Override
	public Pager Query(Pager pager, UserInfo user) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("user", user);
		List<UserInfo> list = this.userInfoDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有用户");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(user));
		return pager;
	}
	@Override
	public void userDelete(String id) {
		try{
			this.userInfoDao.userDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public Integer queryCount(UserInfo userInfo) {
		Integer count = this.userInfoDao.queryCount(userInfo);
		return count;
	}
	@Override
	public void userUpdate(UserInfo userInfo) {
		try{
			this.userInfoDao.userUpdate(userInfo);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

}
