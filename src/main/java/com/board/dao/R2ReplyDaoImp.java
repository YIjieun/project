package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.R2ReplyVO;

//SqlSessionDaoSupport 상속받는 이유->SqlSession객체를 자동으로 반환 getSqlSession()
//@Component
//@Repository
//@Service("빈즈로 등록할 객체의 id구분자 지정")
@Service("R2ReplyDaoImp")
public class R2ReplyDaoImp extends SqlSessionDaoSupport implements R2ReplyDao {
	  //SqlSession sqlSession; =>Setter Method 작성->getSqlSession()
	  //ListController에서 호출->keyField,keyWord,start,end(페이징처리)
	
			//검색분야에 따른 검색어까지 조회(페이징 처리) 
	 public List<R2ReplyVO> list(int board_num) { 
			  // TODO Auto-generated method stub //Board.selectList(O)
		List<R2ReplyVO> list=getSqlSession().selectList("selectList99",board_num);
	    System.out.println("R2ReplyDaoImp 테스트중입니다.~"); 
	    return list; 
	  }
	 
	//최대값 구하기(Object->Integer->int)
		public int getNewRnum() {
				// TODO Auto-generated method stub
				int newrnum=(Integer)getSqlSession().selectOne("getNewRnum99");
				System.out.println("getNewRnum의 newrnum=>"+newrnum);
				return newrnum;
		}
		
		//자료실의 글쓰기
		public void insert(R2ReplyVO vo) {
			// TODO Auto-generated method stub
			getSqlSession().insert("insertReply99",vo);	
			System.out.println("R2Reply의 insert()호출중..."+vo);
		}
		
		//글 삭제하기
		public void delete(Integer r_num) {
			// TODO Auto-generated method stub
			getSqlSession().delete("deleteReply99",r_num);
			System.out.println("deleteReply 테스트중입니다."+r_num);
		}
		 
		  public int getRowCount(Map<String, Object> map) { 
		  // TODO Auto-generated method stub //->Object->Integer->int로 변환
		  System.out.println("getRowCount()호출됨!"); 
		  return getSqlSession().selectOne("selectCount",map); 
		  }
}
