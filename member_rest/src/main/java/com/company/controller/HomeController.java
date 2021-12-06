package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("/index 요청");
		
		return "index";
	}
	

	@GetMapping("/insert")
	public String insert(){
		log.info("insert 요청");
		return "/rest/insert";
		
	}
	
	@GetMapping("/changePwd")
	public String changePwd() {
		log.info("changePwd.jsp 요청");
		return "/rest/changePwd";
	}
	
	@GetMapping("/leave")
	public String leaveGet() {
		log.info("leave.jsp 요청");
		return "/rest/leave";
	}
	
	
}
