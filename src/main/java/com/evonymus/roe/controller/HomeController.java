package com.evonymus.roe.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evonymus.roe.model.Roe;
import com.evonymus.roe.service.RoeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
    @Autowired
	private RoeService roeService;
	
	public final RoeService getRoeService() {
		return roeService;
	}

	public final void setRoeService(RoeService roeService) {
		this.roeService = roeService;
	}

	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String getStartpage() {
		return "index";
	}
	
	@RequestMapping(value={"/listForDay"}, method=RequestMethod.GET)
	public String getListForDay(@RequestParam("date") Date date, Model model) {
		List<Roe>list = roeService.getListForDay(date);
		model.addAttribute("list", list);
		return "roe/listForDay";
	}
}
