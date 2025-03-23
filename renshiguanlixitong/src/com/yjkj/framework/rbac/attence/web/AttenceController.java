package com.yjkj.framework.rbac.attence.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.attence.model.Attence;
import com.yjkj.framework.rbac.attence.service.impl.AttenceServiceImpl;
import com.yjkj.framework.rbac.attence.service.inte.AttenceService;

@Controller
@RequestMapping("/attence")
public class AttenceController {
	
	@Autowired
	private AttenceService attenceService = new AttenceServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Attence Attence,HttpSession session) {
		try {
		pager = this.attenceService.informationLoad(pager,Attence,session);
		model.addAttribute("attenceList", pager);
		model.addAttribute("attence", Attence);
		return "jsp/AttenceTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadMy")
	public String informationLoadMy(Pager pager,Model model,Attence Attence,HttpSession session) {
		try {
		pager = this.attenceService.informationLoadMy(pager,Attence,session);
		model.addAttribute("attenceList", pager);
		model.addAttribute("attence", Attence);
		return "jsp/MyAttenceTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Attence Attence,Model model) {
		
		try {
			Attence = this.attenceService.informationLoadOne(Attence);
			model.addAttribute("attence", Attence);
			return "jsp/Attence";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Attence Attence,Model model) {
		
		try {
			
			this.attenceService.informationAdd(Attence);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Attence Attence,Model model) {
		
		try {
			this.attenceService.informationDelete(Attence);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Attence Attence,Model model) {
		
		try {
			this.attenceService.informationUpade(Attence);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
