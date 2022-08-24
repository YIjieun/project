package com.board.dao;

//List(레코드 여러개 담을 객체),Map(검색분야,검색어)
import java.util.List;
import com.board.domain.EventVO;

public interface EventBoardDao {

	//1.글 목록보기
	public List<EventVO> list();

	//2.최대값 번호 구하기
	public int getNewSeq();
	
	//3. 글상세보기
	public EventVO selectBoard(int event_code);

	 //4. 글쓰기
	public void insert(EventVO board);
	public String getManager_id(String id);
	
	//7.글 수정하기
	public void update(EventVO board);

	//8.글 삭제하기
	public void delete(int event_code);	

	
}



	//1.글 목록보기
	//public List<EventVO> list(Map<String,Object>map);

	//2. 총레코드수(검색어에 맞는 레코드수까지 포함)
	//public int getRowCount(Map<String,Object>map);

	//6.게시물번호에 해당하는 조회수 증가
	//public void updateHit(Integer seq);