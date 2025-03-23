package com.yjkj.framework.rbac.recommend.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.recommend.model.Recommend;
import com.yjkj.framework.rbac.recommend.service.impl.RecommendServiceImpl;
import com.yjkj.framework.rbac.recommend.service.inte.RecommendService;

@Controller
@RequestMapping("/recommend")
public class RecommendController {
	
	@Autowired
	private RecommendService recommendService = new RecommendServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Recommend Recommend,HttpSession session) {
		try {
		pager = this.recommendService.informationLoad(pager,Recommend,session);
		model.addAttribute("recommendList", pager);
		model.addAttribute("recommend", Recommend);
		return "jsp/RecommendTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Recommend Recommend,Model model) {
		
		try {
			Recommend = this.recommendService.informationLoadOne(Recommend);
			model.addAttribute("recommend", Recommend);
			return "jsp/Recommend";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Recommend Recommend,Model model) {
		
		try {
			
			this.recommendService.informationAdd(Recommend);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Recommend Recommend,Model model) {
		
		try {
			this.recommendService.informationDelete(Recommend);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Recommend Recommend,Model model) {
		
		try {
			this.recommendService.informationUpade(Recommend);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
