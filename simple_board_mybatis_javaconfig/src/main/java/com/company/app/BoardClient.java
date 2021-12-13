package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.config.BoardConfig;
import com.company.domain.BoardDTO;
import com.company.service.BoardService;

public class BoardClient {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoardConfig.class);
		BoardService service = (BoardService) ctx.getBean("boardService"); // 찾아오는 것
		
		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프링 프레임워크2");
//		insertDto.setContent("스프링 프레임워크 게시판2");
//		insertDto.setWriter("홍길동");
		
//		System.out.println(service.insertBoard(insertDto)?"입력성공":"입력실패");
		
		//하나 조회
		BoardDTO row = service.getRow(1462);
		
		System.out.print(row.getBno()+"\t");
		System.out.print(row.getTitle()+"\t");
		System.out.print(row.getContent()+"\t");
		System.out.print(row.getWriter()+"\t");
		System.out.print(row.getRegdate()+"\t");
		System.out.print(row.getUpdatedate()+"\n");
		
//		System.out.println();
		
		//수정하는 것
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setBno(21);
//		updateDto.setTitle("스프링 수정");
//		updateDto.setContent("DI란 무엇인가");
//		
//		System.out.println(service.updateBoard(updateDto)?"수정성공":"수정실패");
		
		//System.out.println(service.deleteBoard(101)?"삭제성공":"삭제실패");
		
		//System.out.println();
		
		//전체 조회
		List<BoardDTO> list = service.getRows();
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("bno\t     title\t               content\t                writer\t regdate\t updatedate");		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (BoardDTO dto:list) {
			System.out.print(dto.getBno()+"\t");
			System.out.print(dto.getTitle()+"\t");
			System.out.print(dto.getContent()+"\t");
			System.out.print(dto.getWriter()+"\t");
			System.out.print(dto.getRegdate()+"\t");
			System.out.print(dto.getUpdatedate()+"\n");
			
		}
		
	}

}