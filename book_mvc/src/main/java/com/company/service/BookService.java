package com.company.service;

import java.util.List;

import com.company.domain.BookDTO;

public interface BookService {
	public List<BookDTO> getList();
	
	public BookDTO getRow(String code);

	public boolean insertBook(BookDTO dto);

	//public boolean updateBook(String code, String price);
	
	
	
	
	
	
	
	
}	
