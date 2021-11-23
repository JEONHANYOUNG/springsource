package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.BoardDTO;
import com.company.persistence.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired // 만들어 놓은 것을 주입해달라는 의미
	private BoardDAO dao;
	
	@Override
	public boolean insertBoard(BoardDTO insertDto) {
		return dao.insert(insertDto);
	}

	@Override
	public BoardDTO getRow(int bno) {
		return dao.getRow(bno);
	}

	@Override
	public List<BoardDTO> getRows() {
		return dao.list();
	}

	@Override
	public boolean update(BoardDTO updateDto) {
		return dao.update(updateDto);
	}

	@Override
	public boolean deleteBoard(int bno) {
		return dao.deleteBoard(bno);
	}
}
