package com.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//로그인
	@GetMapping("/signin")  
	public void signin() {
		log.info("로그인 페이지 요청 ");
		// /member/signin
	}
	
	
	// loginPost()
	@PostMapping("/signin")
	public String loginPost(LoginDTO loginDto, HttpSession session) {
		log.info("login 요청 "+loginDto);
		
	  loginDto = service.login(loginDto);
	
	  session.setAttribute("loginDto", loginDto);
	
	  return "redirect:/"; //  새롭게 주소를 타고 들어가는 것
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) { //세션 연결해주는 역할
		log.info("logout 요청");
		 
		session.invalidate(); // 세션 모두 해제(session.removeAttribute("loginDto");
		
		return "redirect:/";
	}
	
	// /changePwd : changePwd.jsp 보여주는 컨트롤러
	@GetMapping("/changePwd")
	public void changePwd() {
		log.info("changePwd.jsp 요청");
		
	}
	
	// /changePwd(POST) + 폼에서 넘기는 값 가져오기(ChangeDTO)
	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDto, HttpSession session) {
		log.info("비밀번호 변경 요청 "+ changeDto);
	
	
	//비밀번호 변경 요청
	// ① userid 가져오기
	LoginDTO loginDto = (LoginDTO)session.getAttribute("loginDto");
	changeDto.setUserid(loginDto.getUserid());
	
	if(service.changePwd(changeDto)) {
		//비밀번호 변경이 되면 기존의 세션 해제
		//signin 페이지 보여주기
		session.invalidate();

		return "redirect:/member/signin";
	}

	//변경 실패 시 changePwd로 보여주기
	return "redirect:/member/changPwd";
	
	}
	
	//회원탈퇴 폼 보여주기
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("leave.jsp 요청");
	}
	
	//회원탈퇴
	@PostMapping("/leave")
	public String leavePost(LoginDTO leaveDto,HttpSession session) {
		//userid, password
		log.info("탈퇴 요청 "+leaveDto);
		
		if (service.leave(leaveDto)) {
			//세션 해제
		session.invalidate(); // 특수문자+숫자+영문을 섞어서 사용해야함
		
		return "redirect:/";
		}
		return "redirect:/member/leave"; // 탈퇴 실패시 
		}
}
