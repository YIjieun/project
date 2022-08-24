package com.board.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.board.domain.MemberVO;

@Component
@Service("MemberDaoImpl")
 public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	 // 1. 가입
	public void register(MemberVO vo) {
		getSqlSession().insert("register",vo);	
	}
	
	// 아이디 중복 확인
	public int idCheck(String mem_id) {
		return getSqlSession().selectOne("idCheck", mem_id);
	}
	
	// 닉네임 중복 확인
	public int writerCheck(String writer) {
		return getSqlSession().selectOne("writerCheck", writer);
	}
	
	// 2. 로그인
	public MemberVO login(MemberVO vo) {		
		return (MemberVO)getSqlSession().selectOne("login",vo);
	}
	
	// 3. 암호찾기
	public MemberVO findPassword(MemberVO vo) {
		return getSqlSession().selectOne("findPassword", vo);
	}

	
	// 4. 관리자 로그인
	public MemberVO login2(MemberVO vo) {		
		return (MemberVO)getSqlSession().selectOne("login2",vo);
	}

	//추가(회원수정할 데이터 찾기)
	//@Override
	public MemberVO updateMemberView(String mem_id) {
		// TODO Auto-generated method stub
		return (MemberVO)getSqlSession().selectOne("findMember",mem_id);
	}
	
	//추가2(회원수정할 메서드)
	//@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateMember",vo);
	}

}
