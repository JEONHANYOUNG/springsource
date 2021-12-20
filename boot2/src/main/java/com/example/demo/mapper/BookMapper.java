package com.example.demo.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.domain.BookDTO;

@Mapper
public interface BookMapper {

	public List<BookDTO> list(); // 전체 도서 
	 
	public BookDTO read(String code); // 특정 도서

	public int insert(BookDTO insertdto); // 도서 추가

	public int delete(String code); // 도서 삭제
	
	public int update(BookDTO updateDto); // 도서 가격 수정
	
}
