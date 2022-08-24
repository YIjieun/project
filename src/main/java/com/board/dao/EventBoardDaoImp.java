package com.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.EventVO;

//SqlSessionDaoSupport 상속받는 이유->SqlSession객체를 자동으로 반환 getSqlSession()
@Service("EventBoardDaoImp") //@Service("빈즈로 등록할 객체의 id구분자 지정")
public class EventBoardDaoImp extends SqlSessionDaoSupport implements EventBoardDao {
	  //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
		
	// 1. 글 목록
	public List<EventVO> list() {
		List<EventVO> list=getSqlSession().selectList("selectList");
		System.out.println("ListDaoImpl 돌아가는지 테스트.~");
		return list;
	}
	
	// 2. 글 상세보기(레코드 한개)
		public EventVO selectBoard(int event_code) {
	
		return (EventVO)getSqlSession().selectOne("selectBoard",event_code);
		           //Object->EventVO
		}		
		
	// 3. 최대값 구하기(Object->Integer->int) 
	public int getNewSeq() {
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq()의 newseq=>"+newseq);
		return newseq;
	}		
		
	// 4. 글쓰기
	public void insert(EventVO board) {
		getSqlSession().insert("insertBoard",board);	
	}
	public String getManager_id(String id) {
		return getSqlSession().selectOne("search id");
	}
	
	// 5. 글 수정하기
	public void update(EventVO board) {
		getSqlSession().update("updateBoard",board);//null->값전달유무확인
	}

	// 6. 글 삭제하기
	public void delete(int event_code) {
		getSqlSession().delete("deleteBoard",event_code);
	}
	/*
	// 7. 메인에 최신순 4개 출력
	public void sendMain() {
		// TODO Auto-generated method stub
		
	}
	*/
}
/*
 // 총 레코드수
	public int getRowCount() {
		// TODO Auto-generated method stub //->Object->Integer->int로 변환
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount");
 
 * 조회수 
public void updateHit(Integer seq) {
	// TODO Auto-generated method stub
	getSqlSession().update("updateHit",seq);
}
*/
