package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.domain.R2BoardVO;

public interface R2BoardDao {

		//1.글 목록보기
		public List<R2BoardVO> list(Map<String,Object>map);
		
		//1-1 조회수가 높은 항목3개 구해주는 메서드
		public List<R2BoardVO> getDescRe_view();
		
		//2. 총레코드수(검색어에 맞는 레코드수까지 포함)
		public int getRowCount(Map<String,Object>map);
		
		//3.최대값 번호 구하기
		public int getNewSeq2();
		
		//4. 자료실의 글쓰기
		public void insert(R2BoardVO board);		
		
		//글쓰기 추가 > 이부분 없어도 돌아갔는데 여러명의 회원 아이디를 불러와야되면 필요할수도 있어서 일단 주석했습니다 안돌아가면 풀어서 사용해주세용
		//public String getMem_id(String id);
			
		//5. 글상세보기
		public R2BoardVO selectBoard2(Integer board_num);
		  
		//6.게시물번호에 해당하는 조회수 증가
		public void updateHit(Integer board_num);
		
		//7.글 수정하기
		public void update(R2BoardVO board);
		
		//8.글삭제하기
		public void delete(Integer board_num);
		
		//좋아요 총갯수  
		public int checkLike99(HashMap<String, Object> hashmap);
		 //좋아요증가 
		public void upLike99(int board_num);
		//좋아요등록
		public void insertLikeInfo99(HashMap<String, Object> hashmap);
		//좋아요감소
		public void downLike99(int board_num);
		//좋아요삭제
		public void deleteLikeInfo99(HashMap<String, Object> hashmap);
		//최종상태값
		public int likeCnt99(int board_num);
		//아이디로 작성자 찾기
		public String findOne99(String mem_id);
	
}
