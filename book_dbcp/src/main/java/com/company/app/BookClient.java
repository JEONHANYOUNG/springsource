package com.company.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.domain.BookDTO;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {
	 ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

	//서비스 호출
	//BookService service = new BookServiceImpl();
    BookService service = (BookService)	ctx.getBean("bookServiceImpl");
    
    //새로운 도서 입력
    BookDTO insertDto = new BookDTO("1007", "스프링", "구멍가게", 32000);
    System.out.println(service.insertBook(insertDto)?"입력성공":"입력실패");  
    
         
    //도서 정보 수정   
    //System.out.println(service.updateBook("1006", 40000)?"수정성공":"수정실패");
    
    //도서 삭제  
    //System.out.println(service.deleteBook("1005")?"삭제성공":"삭제실패");
    
    		
    		
	//전체 리스트 결과를 호출
	List<BookDTO> list = service.getList();

	System.out.println("코드       제목         작가        가격");
	System.out.println("------------------------------------------");
	for (BookDTO book : list) { 
		System.out.print(book.getCode()+"\t");
		System.out.print(book.getTitle()+"\t");
		System.out.print(book.getWriter()+"\t");
		System.out.print(book.getPrice()+"\n");
	}
  }
}
