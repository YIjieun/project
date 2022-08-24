package com.board.dao;

import org.springframework.stereotype.Component;

import com.board.domain.MemberVO;

@Component
public interface MemberDao {
	
	// 회원가입
	public void register(MemberVO vo);
	
	//아이디 중복확인
	public int idCheck(String mem_id);
	
	//닉네임 중복확인
	public int writerCheck(String writer);

	// 로그인
	public MemberVO login(MemberVO vo);

	// 암호찾기
	public MemberVO findPassword(MemberVO vo);
	
	// 관리자 로그인
	public MemberVO login2(MemberVO vo);

	//추가(회원수정할 데이터 찾기)
	public MemberVO updateMemberView(String mem_id);//select * from member where mem_id=?
	
	//추가2(회원수정할 메서드)
	public void updateMember(MemberVO vo);//수정버튼을 눌렀을때 수정해주는 메서드 호출

}

