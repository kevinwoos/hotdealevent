package com.garage.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotdealEventController {

	int flag;
	
	@RequestMapping("/index")
	public String index() {
		
		//return "redirect:/index2";
		
		return "index";
	}
	
	@RequestMapping("/index2")
	public ModelAndView index2(ModelAndView mav) {
		
		int res  = 0;
		
		for (int i = 0; i <= 10; i ++) {
			res += i;
		}
		
		mav.addObject("msg", "total: " + res);
		mav.setViewName("register");
		
		return mav;
	}
}
