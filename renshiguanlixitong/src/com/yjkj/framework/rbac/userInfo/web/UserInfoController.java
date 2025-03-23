package com.yjkj.framework.rbac.userInfo.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.recommend.service.inte.RecommendService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;


@Controller
@RequestMapping("/user")
public class UserInfoController {
	@Autowired
	private UserInfoService uis = new UserInfoServiceImpl();
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();
	
	@Autowired
	private RecommendService rs;
	
	@RequestMapping("/login")
	public String login(String loginName,String loginPassword,String code,String controller,Model model,HttpSession session){
		try{	
			UserInfo userInfo = this.uis.login(loginName, loginPassword);
			session.setAttribute("User", userInfo);
			return "redirect:../request/index";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			model.addAttribute("loginName", loginName);
			model.addAttribute("loginPassword", loginPassword);
			return "jsp/Login";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
			session.removeAttribute("User");
			return "jsp/Login";
	}
	@RequestMapping("/logoutAdmin")
	public String logoutAdmin(HttpSession session){
			session.removeAttribute("Admin");
			return "jsp/LoginAdmin";
	}
	@RequestMapping("/userAdd")
	public String userAdd(UserInfo user,Model model){
			try{
				this.uis.userAdd(user);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userUpdate")
	public String userUpdate(UserInfo user,Model model){
			try{
				this.uis.userUpdate(user);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userDelete")
	public String userDelete(String id,Model model){
			try{
				this.uis.userDelete(id);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/queryOne")
	public String queryOne(String id,Model model){
		try{
			model.addAttribute("recommend", this.rs.informationLoadAll(null));
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (Exception e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/queryOwn")
	public String queryOwn(String id,Model model,HttpSession session){
		try{
			
			UserInfo user = (UserInfo) session.getAttribute("User");
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/query")
	public String query(Pager pager,UserInfo user,Model model){
		try{
		model.addAttribute("pager", this.uis.Query(pager, user));
		model.addAttribute("user",user);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserTable";
	}
}
