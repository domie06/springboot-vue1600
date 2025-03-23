package com.yjkj.framework.rbac.attence.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


public class Attence extends BaseModel{
	
	private String user_id;
	private String attence_date;
	private String start_time;
	private String end_time;
	private String remark;
	private UserInfo userInfo;
	
	public String getAttence_date() {
		return attence_date;
	}
	public void setAttence_date(String attence_date) {
		this.attence_date = attence_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
