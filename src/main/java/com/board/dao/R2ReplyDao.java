package com.board.dao;

import java.util.List;

import com.board.domain.R2ReplyVO;

public interface R2ReplyDao {
	//글상세보기에서 댓글리스트 조회하기
	public List<R2ReplyVO> list(int board_num);
	
	//1.최대값 번호 구하기
   public int getNewRnum();
	//2.생성
	public void insert(R2ReplyVO vo);
	
	//삭제
	public void delete(Integer r_num);
	
}