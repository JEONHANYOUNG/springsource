package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.MemberDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("/register/*")
@Log4j2
public class RegisterController {
	
	@Autowired
	private MemberService service;
	
	// registerGet()
	@GetMapping("/step1") // 바로 띄울려면 
	public void registerGet() { // void는 return을 받지 않는다!
		// register/step1
		log.info("step1 요청");
	}
	
	// step2()
	@PostMapping("/step2")  
	public String step2(boolean agree, RedirectAttributes rttr) {
		log.info("step2 요청 "+agree);
		
		if (!agree) { // step1 보여주기
			rttr.addFlashAttribute("check", "false");
			return "redirect:/register/step1";  //   http://localhost/register/step1
		}
		// step2 보여주기
		return "/register/step2";
	}
	
	@ResponseBody //리턴하는 값이 일반 데이터임(jsp 페이지 찾지마)
	@PostMapping("/checkId")
	public String IdCheck(String userid) {
		log.info("중복 아이디 검사 "+userid);
		
		if (service.dupId(userid)!=null) {
			return "false";    // WEB-INF/views/false.jsp(X)
		}
		return "true"; // WEB-INF/views/true.jsp(X)
	}
	
	@PostMapping("/step3") 
	public String step2Post(MemberDTO memberDTO) {
		log.info("회원가입 요청 "+memberDTO);
	
		try {
			if (!service.register(memberDTO)) {
				//회원가입 페이지로 이동
				return "/register/step2";
			} 
		} catch (Exception e) {
			//회원가입 페이지로 이동
			return "/register/step2";
		}
		
		// http://localhost:8080/register/step3
		// return "/member/signin" => jsp

		return "redirect:/member/signin";  
	}
	
	
	 // http://localhost:8080/register/step3 + GET
	// http://localhost:8080/register/step2 + GET
	// 405 - 허용되지 않는 메소드
	
	@GetMapping(value= {"/step2","/step3"})
	public String handleGet() {
		log.info("/step2","/step3 직접 요청");
		//return "redirect:/register/step1";
		return "redirect:/";
	
	}

	
	
}	 
