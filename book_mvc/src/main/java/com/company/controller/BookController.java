package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.domain.BookDTO;
import com.company.service.BookService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/book/*")
public class BookController {

	@Autowired
	private BookService service;
	
	//insert.jsp 보여주는 컨트롤러 생성
	@GetMapping("/insert")
	public void insertGet() {
		log.info("insert 폼 요청");
	}
	
	
	// 새 도서 입력
	// 도서 입력 성공 시 전체 목록보기로 이동 시키기
	@PostMapping("/insert")
	public String insertPost(BookDTO insertDto) {
		log.info("도서 입력 "+insertDto);
		
		try {
			if (service.insertBook(insertDto)) {
				return "redirect:list";
			}
		} catch (Exception e) {
			return "/book/insert";
		}
		return "/book/insert";		
	}
	
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("전체 리스트 요청");
		List<BookDTO> list = service.getList();
		
		//log.info(""+list);
		model.addAttribute("list", list);  // == request.setAttribute() void는 그대로 주소 찾아가는 것
		
		// /book/list => jsp 찾는데 사용됨
		
	}
	
	//  /book/read에 응답하는 컨트롤러
	@GetMapping("/read")
	public void readGet(String code, Model model) {
		log.info("read 요청 "+code);
		
		BookDTO dto = service.getRow(code);
		
		model.addAttribute("dto", dto);
	}
	
}
