package com.board.dao;

//List(레코드 여러개 담을 객체),Map(검색분야,검색어)
import java.util.List;
import java.util.Map;

import com.board.domain.MyBoardVO;

public interface MyBoardDao {

	//1.글 목록보기
	public List<MyBoardVO> list(Map<String,Object>map);
	
	//2. 총레코드수(검색어에 맞는 레코드수까지 포함)
	public int getRowCount(Map<String,Object>map);
	
	//3.최대값 번호 구하기
	public int getNewSeq();
	
	//4.자료실의 글쓰기
	public void insert(MyBoardVO board);
	
	//5.글상세보기
	public MyBoardVO selectBoard(Integer seq);//~(int seq)
	
	//6.게시물 번호에 해당하는 조회수 증가
	public void updateHit(Integer seq);
	
	//7.글수정하기
	public void update(MyBoardVO board);
	
	//8.글 삭제하기
	public void delete(Integer seq);
	
}
