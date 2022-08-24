package com.board.dao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.board.domain.MemberVO;

@Component
@Service("MemberServiceImp")
public class MemberServiceImp implements MemberService { 
	
	@Autowired
	private MemberDao dao; 
	
	//1. 회원가입
	public void register(MemberVO vo) throws Exception {		
		dao.register(vo);	
	}
	
	// 아이디 중복확인
	public int idCheck(String mem_id) throws Exception {		
		return dao.idCheck(mem_id);
	}
	
	// 닉네임 중복확인
	public int writerCheck(String writer) throws Exception {		
		return dao.writerCheck(writer);
	}
	
	// 2. 로그인
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}
		
	// 암호찾기
	public MemberVO findPassword(MemberVO vo) {
		return dao.findPassword(vo);
	}
	
	// 3. 관리자 로그인
	public MemberVO login2(MemberVO vo) throws Exception {
		return dao.login2(vo);
	}
	
	//추가(회원수정할 데이터 찾기)
	//@Override
	public MemberVO updateMemberView(String mem_id) {
		// TODO Auto-generated method stub
		return dao.updateMemberView(mem_id);
	}
	
	//추가2(회원수정할 메서드)
	//@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.updateMember(vo);
	}	
}


