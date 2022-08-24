package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.FreeBoardVO;

//SqlSessionDaoSupport 상속받는 이유->SqlSession객체를 자동으로 반환 getSqlSession()
//@Component
//@Repository
//@Service("빈즈로 등록할 객체의 id구분자 지정")
@Service("freeBoardDaoImp")
public class FreeBoardDaoImp extends SqlSessionDaoSupport implements FreeBoardDao {
	  //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
	  //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
		
	//검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<FreeBoardVO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub				//Board.selectList(O)
		List<FreeBoardVO> list=getSqlSession().selectList("selectList4",map);
		System.out.println("ListDaoImpl 테스트중입니다.~");
		return list;
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub //->Object->Integer->int로 변환
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount4",map);
	}
	
	//최대값 구하기(Object->Integer->int)
	public int getNewSeq() {
		// TODO Auto-generated method stub
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq4");
		System.out.println("getNewSeq의 newseq=>"+newseq);
		return newseq;
	}
	
	//자료실의 글쓰기
	public void insert(FreeBoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBoard4",board);	
	}
	//글 상세보기(레코드 한개)
	public FreeBoardVO selectBoard(Integer board_num) {
		// TODO Auto-generated method stub
	return (FreeBoardVO)getSqlSession().selectOne("selectBoard4",board_num);
	           //Object->BoardCommand
	}
	//조회수 
	public void updateHit(Integer board_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit4",board_num);
	}
	
	//글 수정하기
	public void update(FreeBoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateBoard4",board);//null->값전달유무확인
	}
	
	//글 삭제하기
	public void delete(Integer board_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBoard4",board_num);
	}
	
	public String findOne(String mem_id) {
		return getSqlSession().selectOne("findOne",mem_id);
	}
}
