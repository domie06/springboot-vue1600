package com.yjkj.framework.rbac.web;



import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.recommend.service.inte.RecommendService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;


@Controller
@RequestMapping("/request")
public class RequestController {
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private UserInfoService us = new UserInfoServiceImpl();
	
	@Autowired
	private RecommendService rs;
	
	@RequestMapping("/login")
	public String login() throws IOException {
		return "jsp/Login";
		
	}
	@RequestMapping("/recommendAdd")
	public String recommendAdd() {
		
		return "jsp/RecommendAdd";
		
	}
	@RequestMapping("/wageAdd")
	public String wageAdd(Model model) {
		
		model.addAttribute("user", this.us.queryAll());
		return "jsp/WageAdd";
		
	}
	@RequestMapping("/attenceAdd")
	public String attenceAdd(Model model) {
		
		model.addAttribute("user", this.us.queryAll());
		return "jsp/AttenceAdd";
		
	}
	@RequestMapping("/index")
	public String main() {
		return "jsp/iframemain";
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate(String id,Model model) {
		model.addAttribute("id", id);
		return "jsp/PassUpdate";
	}

	@RequestMapping("/right")
	public String index() {
		return "jsp/index";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "jsp/top";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		model.addAttribute("recommend", this.rs.informationLoadAll(null));
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
}
