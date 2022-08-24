package com.board.dao;

import java.util.List;

import com.board.domain.R1BoardVO;
import com.board.domain.R2BoardVO;

public interface MainDao {
	
	//1 회원 게시판 조회수 높은거 8개 불러오기
		public List<R2BoardVO> getDescRe_main();
		
	//1 관리자 게시판 조회수 높은거 6개 불러오기
		public List<R1BoardVO> getDescRe_main2();
		
		

}
