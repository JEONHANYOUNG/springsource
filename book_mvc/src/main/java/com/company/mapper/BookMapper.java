package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BookDTO;

public interface BookMapper {

	public List<BookDTO> list(); // 전체 도서 
	 
	public BookDTO read(String code); // 특정 도서

	public int insert(BookDTO insertdto);

	//public int update(@Param("code") String code, @Param("price") String price);
	
}
