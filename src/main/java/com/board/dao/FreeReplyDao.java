package com.board.dao;

import java.util.List;
import java.util.Map;


import com.board.domain.FreeReplyVO;

public interface FreeReplyDao {
	//글상세보기에서 댓글리스트 조회하기
	public List<FreeReplyVO> list(int board_num);
	
	//1.생성
	public void insert(FreeReplyVO vo);
	
	//최대값 번호 구하기
	public int getNewRnum();
		
	//삭제
	public void delete2(Integer r_num);
	
	public String findOne1(String mem_id);
	
}
