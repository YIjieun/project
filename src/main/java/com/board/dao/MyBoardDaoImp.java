package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.board.domain.MyBoardVO;

//SqlSessionDaoSupport 상속받는 이유->SqlSession객체를 자동으로 반환 getSqlSession()
//@Component
//@Repository
//@Service("빈즈로 등록할 객체의 id구분자 지정")
@Service("boardImp")
public class MyBoardDaoImp extends SqlSessionDaoSupport implements MyBoardDao {
	   //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
	   //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
		
	//검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<MyBoardVO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub				//Board.selectList(O)
		List<MyBoardVO> list=getSqlSession().selectList("selectList",map);
		System.out.println("ListDaoImpl 테스트중입니다.~");
		return list;
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub //->Object->Integer->int로 변환
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount",map);
	}
	//최대값 (Object->Integer->int)
	public int getNewSeq() {
		// TODO Auto-generated method stub
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq의 newseq->"+newseq);
		return newseq;
	}
	
	//자료실의 글쓰기
	public void insert(MyBoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBoard",board);
	}	
	
	//DetailController에서 호출
	public MyBoardVO selectBoard(Integer seq) {
		// TODO Auto-generated method stub
		return (MyBoardVO)getSqlSession().selectOne("selectBoard",seq);
	}
	
	//조회수
	public void updateHit(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",seq);
	}
	
	//글수정하기
	public void update(MyBoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateBoard", board);//null->값 전달유무 확인
	}
	
	//글 삭제하기
	public void delete(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBoard", seq);
	}	
	
}
