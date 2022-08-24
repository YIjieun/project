package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.FreeReplyVO;

//SqlSessionDaoSupport 상속받는 이유->SqlSession객체를 자동으로 반환 getSqlSession()
//@Component
//@Repository
//@Service("빈즈로 등록할 객체의 id구분자 지정")
@Service("freeReplyDaoImp")
public class FreeReplyDaoImp extends SqlSessionDaoSupport implements FreeReplyDao {
	  //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
	  //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
	
			//검색분야에 따른 검색어까지 조회(페이징 처리) 
			  public List<FreeReplyVO> list(int board_num) { 
			  // TODO Auto-generated method stub //Board.selectList(O)
			 List<FreeReplyVO> list=getSqlSession().selectList("selectList22",board_num);
			  System.out.println("FreeReplyDaoImp 테스트중입니다.~"); 
			  return list; 
			  }
	//최대값 구하기(Object->Integer->int)
			public int getNewRnum() {
				// TODO Auto-generated method stub
				int newrnum=(Integer)getSqlSession().selectOne("getNewRnum");
				System.out.println("getNewRnum의 newrnum=>"+newrnum);
				return newrnum;
			}
		
		//자료실의 글쓰기
		public void insert(FreeReplyVO vo) {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertReply",vo);	
		}
		
		//글 삭제하기
		public void delete2(Integer r_num) {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteReply",r_num);
			System.out.println("deleteReply 테스트중입니다."+r_num);
		}

		 
		 
		  public int getRowCount(Map<String, Object> map) { 
		  // TODO Auto-generated method stub //->Object->Integer->int로 변환
		  System.out.println("getRowCount()호출됨!"); 
		  return getSqlSession().selectOne("selectCount",map); 
		  }
		  
		  public String findOne1(String mem_id) {
				return getSqlSession().selectOne("findOne1",mem_id);
			}

}
