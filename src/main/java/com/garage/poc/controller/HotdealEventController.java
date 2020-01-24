package com.garage.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotdealEventController {

	int flag;
	
	@RequestMapping("/index2")
	public String index() {
		
		//return "redirect:/index2";
		
		return "index";
	}
	
	@RequestMapping("/index")
	public ModelAndView index2(ModelAndView mav) {
		
		int res  = 0;
		
		for (int i = 0; i <= 10; i ++) {
			res += i;
		}
		
		
		mav.addObject("msg", "total: " + res);
		mav.setViewName("index");
		log.info(mav.toString());
		
		return mav;
	}
	
	
	@RequestMapping("/index3")
	public ModelAndView index3(ModelAndView mav) {
		
	
		mav.addObject("result_code", "200");
		mav.addObject("result_msg", "SUCCESS");
		mav.addObject("data", " \"event_id\":\r\n" + 
				"\"2020011301\", \"phone_num\": \"01012345678\", \"name\": \"홍길동\"");
		mav.setViewName("index");
		log.info(mav.toString());
		
		return mav;
	}	
	
	/*
	 * { "result_code": 200, "result_msg": "SUCCESS", "data": { "event_id":
	 * "2020011301", "phone_num": "01012345678", "name": "홍길동" } }
	 */
}
