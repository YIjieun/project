package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.MemberVO;
import com.board.domain.R2BoardVO;

@Service("R2BoardDaoImp")
public class R2BoardDaoImp extends SqlSessionDaoSupport implements R2BoardDao {

	//검색분야에 따른 검색어까지 조회(페이징 처리)
		public List<R2BoardVO> list(Map<String, Object> map) {
			//Board.selectList(O)
			List<R2BoardVO> list=getSqlSession().selectList("selectList2",map);
			System.out.println("ListDaoImpl 테스트중입니다.~");
			return list;
		}
		
		// 총레코드수(검색어에 맞는 레코드수까지 포함)
		public int getRowCount(Map<String, Object> map) {
			//->Object->Integer->int로 변환
			System.out.println("getRowCount()호출됨!");
			return getSqlSession().selectOne("selectCount",map);
		}
		
		//최대값 구하기(Object->Integer->int)
		public int getNewSeq2() {
			int newseq=(Integer)getSqlSession().selectOne("getNewSeq2");
			System.out.println("getNewSeq2의 newseq=>"+newseq);
			return newseq;
		}
		
		//자료실의 글쓰기
		public void insert(R2BoardVO board) {
			getSqlSession().insert("insertBoard2",board);	
		}
		/*
		// 글쓰기 추가
		public String getMem_id(String id) {
			return getSqlSession().selectOne("search id");
				}
		*/
		//글 상세보기(레코드 한개)
		public R2BoardVO selectBoard2(Integer board_num) {
			//BoardCommand command=
			//(BoardCommand)getSqlSession().selectOne("selectBoard",seq);
			 //return command;
		return (R2BoardVO)getSqlSession().selectOne("selectBoard2",board_num);
		           //Object->BoardCommand
		}
		
		// 게시물번호에 해당하는 조회수 증가 
		public void updateHit(Integer board_num) {
			getSqlSession().update("updateHit",board_num);
		}
		
		// 조회수가 높은 항목3개 구해주는 메서드
		public List<R2BoardVO> getDescRe_view() {
			List<R2BoardVO> list=getSqlSession().selectList("selectMax_review");
			System.out.println("조회수가 증가되는것을 가져오기~");
			return list;
		}
		
		//글 수정하기
		public void update(R2BoardVO board) {
			// TODO Auto-generated method stub
			getSqlSession().update("updateBoard2",board);//null->값전달유무확인
		}
		
		//글 삭제하기
		public void delete(Integer board_num) {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteBoard2",board_num);
		}
		
		
		public int checkLike99(HashMap<String, Object> hashmap) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("checkLike99",hashmap);
		}
		public void deleteLikeInfo99(HashMap<String, Object> hashmap) {
			// TODO Auto-generated method stub
			 getSqlSession().delete("deleteLikeInfo99",hashmap);
		}
		public void downLike99(int board_num) {
			// TODO Auto-generated method stub
			getSqlSession().selectOne("downLike99",board_num); 
		}
		public void insertLikeInfo99(HashMap<String, Object> hashmap) {
			// TODO Auto-generated method stub
			getSqlSession().update("insertLikeInfo99",hashmap);
		}
		public int likeCnt99(int board_num) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("likeCnt99",board_num);
		}
		public void upLike99(int board_num) {
			// TODO Auto-generated method stub
			getSqlSession().selectOne("upLike99",board_num); 
		}
		
		public String findOne99(String mem_id) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("findOne99",mem_id);
			
		}
		
}
