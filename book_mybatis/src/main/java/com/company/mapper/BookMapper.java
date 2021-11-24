package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.BookDTO;

public interface BookMapper {
	public BookDTO read(String code); //BookMapper.xml에 입력한 것과 맞춰야 함 
	public List<BookDTO> list();
	public int insert(BookDTO dto);
	public int update(@Param("code") String code, @Param("price") int price);
	public int delete(String code);
	
}
