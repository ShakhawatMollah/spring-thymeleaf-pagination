package com.shakhawat.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shakhawat.pagination.domain.service.VisitorService;

@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;

	@RequestMapping("/visitors")
	public String list(ModelMap model, @SortDefault("firstName") @PageableDefault(size = 10) Pageable pageable){
		
		model.addAttribute("visitors", visitorService.getAllVisitors(pageable));
		
		return "visitor_list";
	}
	
}
