package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.R1BoardVO;

@Service("r1BoardDaoImp")
public class R1BoardDaoImp extends SqlSessionDaoSupport implements R1BoardDao {
	  //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
	  //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
		
	//검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<R1BoardVO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub				//Board.selectList(O)
		List<R1BoardVO> list=getSqlSession().selectList("selectList3",map);
		System.out.println("ListDaoImpl 테스트중입니다.~");
		return list;
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub //->Object->Integer->int로 변환
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount3",map);
	}
	
	//최대값 구하기(Object->Integer->int)
	public int getNewSeq() {
		// TODO Auto-generated method stub
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq3");
		System.out.println("getNewSeq의 newseq=>"+newseq);
		return newseq;
	}
	
	
	//자료실의 글쓰기
	public void insert(R1BoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBoard3",board);	
	}
	//글 상세보기(레코드 한개)
	public R1BoardVO selectBoard(Integer board_num) {
		// TODO Auto-generated method stub
		//BoardCommand command=
		//(BoardCommand)getSqlSession().selectOne("selectBoard",seq);
		 //return command;
	return (R1BoardVO)getSqlSession().selectOne("selectBoard3",board_num);
	           //Object->BoardCommand
	}
	//조회수 
	public void updateHit(Integer board_num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit3",board_num);
	}
	
	//글 수정하기
	public void update(R1BoardVO board) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateBoard3",board);//null->값전달유무확인
	}
	
	//글 삭제하기
	public void delete(Integer board_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBoard3",board_num);
	}
	
	/*
	//이건 뭘까
	public String getManager_id(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("search id");
	}
	
	*/
	//추가
	public List<R1BoardVO> getDescRe_view() {
		// TODO Auto-generated method stub
		List<R1BoardVO> list=getSqlSession().selectList("selectMax_review3");
		System.out.println("조회수가 증가되는것을 가져오기~");
		return list;
	}
	
	//좋아요 추가
		public void updateHeart(Integer board_num) {
			// TODO Auto-generated method stub
			getSqlSession().update("updateHeart",board_num);
		}
		 public void deleteHeart(Integer board_num) {
			// TODO Auto-generated method stub
			 getSqlSession().update("deleteHeart",board_num);
		}
		//좋아요 수
		public int backgood(Integer board_num) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("clickHeart",board_num);
		}
		//좋아요 대상확인
		public int checkLike(HashMap<String, Object> hashmap) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("checkLike",hashmap);
		}
		//체크(처음 좋아요 누른경우)
		public void check_ok(Map<String, Object> hashmap) {
			// TODO Auto-generated method stub
			getSqlSession().update("check_ok",hashmap);
				}
		//체크(다시 좋아요 누른경우)
		public void check_cancel(Map<String, Object> hashmap) {
			// TODO Auto-generated method stub
			getSqlSession().update("check_cancel",hashmap);
		}
		public int getCheck(Map<String, Object> hashmap) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("selectCheck",hashmap);
				}
		
		public String findOne55(String manager_id) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("findOne55",manager_id);
		}
		public void updateMem_id(Map<String, Object> map) {
			// TODO Auto-generated method stub
			getSqlSession().update("updateMem_id",map);
		}
}
