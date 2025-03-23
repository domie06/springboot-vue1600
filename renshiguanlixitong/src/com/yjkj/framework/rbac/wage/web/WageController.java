package com.yjkj.framework.rbac.wage.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.wage.model.Wage;
import com.yjkj.framework.rbac.wage.service.impl.WageServiceImpl;
import com.yjkj.framework.rbac.wage.service.inte.WageService;

@Controller
@RequestMapping("/wage")
public class WageController {
	
	@Autowired
	private WageService wageService = new WageServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Wage Wage,HttpSession session) {
		try {
		pager = this.wageService.informationLoad(pager,Wage,session);
		model.addAttribute("wageList", pager);
		model.addAttribute("wage", Wage);
		return "jsp/WageTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadMy")
	public String informationLoadMy(Pager pager,Model model,Wage Wage,HttpSession session) {
		try {
		pager = this.wageService.informationLoadMy(pager,Wage,session);
		model.addAttribute("wageList", pager);
		model.addAttribute("wage", Wage);
		return "jsp/MyWageTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadRecommend")
	public String informationLoadRecommend(Pager pager,Model model,Wage Wage,HttpSession session) {
		try {
		pager = this.wageService.informationLoadRecommend(pager,Wage,session);
		model.addAttribute("wageList", pager);
		model.addAttribute("wage", Wage);
		return "jsp/RecommendWageTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Wage Wage,Model model) {
		
		try {
			Wage = this.wageService.informationLoadOne(Wage);
			model.addAttribute("wage", Wage);
			return "jsp/Wage";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Wage Wage,Model model) {
		
		try {
			
			this.wageService.informationAdd(Wage);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Wage Wage,Model model) {
		
		try {
			this.wageService.informationDelete(Wage);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Wage Wage,Model model) {
		
		try {
			this.wageService.informationUpade(Wage);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
