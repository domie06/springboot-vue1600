package com.yjkj.framework.rbac.wage.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


public class Wage extends BaseModel{
	
	private String user_id;
	private String month;
	private Integer base;
	private Integer bonus;
	private Integer overtime;
	private Integer late;
	private Integer old_age;
	private Integer medical;
	private Integer house;
	private Integer tax;
	private Integer income;
	private String recommend_id;
	private UserInfo userInfo;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getBase() {
		return base;
	}
	public void setBase(Integer base) {
		this.base = base;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	public Integer getOvertime() {
		return overtime;
	}
	public void setOvertime(Integer overtime) {
		this.overtime = overtime;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getOld_age() {
		return old_age;
	}
	public void setOld_age(Integer old_age) {
		this.old_age = old_age;
	}
	public Integer getMedical() {
		return medical;
	}
	public void setMedical(Integer medical) {
		this.medical = medical;
	}
	public Integer getHouse() {
		return house;
	}
	public void setHouse(Integer house) {
		this.house = house;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getRecommend_id() {
		return recommend_id;
	}
	public void setRecommend_id(String recommend_id) {
		this.recommend_id = recommend_id;
	} 
	
	
	
	
}
