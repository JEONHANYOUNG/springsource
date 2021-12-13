package com.company.service;

import java.util.List;

import com.company.domain.BoardDTO;

public interface BoardService {//dao에 요청
	// 등록
	public boolean insertBoard(BoardDTO insertDto);
	// 삭제(로그인 게시판으로 변경할 것)
	public boolean deleteBoard(int bno);
	// 개별 조회
	public BoardDTO getRow(int bno);
	// 전체 조회
	public List<BoardDTO> getRows();
	// 수정
	public boolean updateBoard(BoardDTO updateDto);

}
