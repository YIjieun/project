package com.board.dao;

import java.util.HashMap;
//List(레코드 여러개 담을 객체),Map(검색분야,검색어)
import java.util.List;
import java.util.Map;

import com.board.domain.R1BoardVO;

public interface R1BoardDao {

	//1.글 목록보기
	public List<R1BoardVO> list(Map<String,Object>map);
	
	//1-1 조회수가 높은 항목3개 구해주는 메서드
	public List<R1BoardVO> getDescRe_view();
	
	//2. 총레코드수(검색어에 맞는 레코드수까지 포함)
	public int getRowCount(Map<String,Object>map);
	
	//3.최대값 번호 구하기
	public int getNewSeq();
		
	//4. 자료실의 글쓰기
	public void insert(R1BoardVO board);
	
	//5. 글상세보기
	public R1BoardVO selectBoard(Integer board_num);
	  
	//6.게시물번호에 해당하는 조회수 증가
	public void updateHit(Integer board_num);
	
	//7.글 수정하기
	public void update(R1BoardVO board);
	
	//8.글삭제하기
	public void delete(Integer board_num);
	
	//9.좋아요 +1
	public void updateHeart(Integer board_num);
	
	//10. 좋아요 -1
	public void deleteHeart(Integer board_num);
	
	//11.좋아요 증가,감소값 가져오기
	public int  backgood(Integer board_num);
	
	//12.로그인 O ,board_num O인 경우의 좋아요 대상갯수 확인
	public int checkLike(HashMap<String, Object> hashmap);
	
	//13.click값을 변경시켜주는 메서드 선언
	public void check_ok(Map<String,Object>hashmap);
		
	public void check_cancel(Map<String,Object>hashmap);
		
	//14.check(현재값)을 구해주는 메서드
	public int getCheck(Map<String,Object>hashmap);
	
	//아이디로 작성자 찾기
	public String findOne55(String manager_id);
	
	public void updateMem_id(Map<String,Object>map);
	
}
