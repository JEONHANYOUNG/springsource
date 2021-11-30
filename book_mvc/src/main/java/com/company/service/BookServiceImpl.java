package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BookDTO;
import com.company.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookDTO> getList() {
		return mapper.list();
	}

	@Override public BookDTO getRow(String code) { 
		return mapper.read(code);
	}

	@Override
	public boolean insertBook(BookDTO insertdto) {
		return mapper.insert(insertdto) > 0? true:false;
	}
  
	
	

}