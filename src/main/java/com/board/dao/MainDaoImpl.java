package com.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.board.domain.R1BoardVO;
import com.board.domain.R2BoardVO;

@Service("MainDaoImpl")
public class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {
	
	// 회원: 메인에 조회수 8개 추가
		public List<R2BoardVO> getDescRe_main() {
			List<R2BoardVO> getDescRe_main=getSqlSession().selectList("selectMax_main");
			System.out.println("회원: 조회수 높은거 가져오기");
			return getDescRe_main;
		}
				
	// 관리자 :	메인에 조회수 6개 추가
		public List<R1BoardVO> getDescRe_main2() {
			List<R1BoardVO> getDescRe_main2=getSqlSession().selectList("selectMax_main2");
			System.out.println("관리자: 조회수 높은거 가져오기");
			return getDescRe_main2;
		}

}
