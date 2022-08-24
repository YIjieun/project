package com.board.domain;

import java.sql.Date;//테이블의 필드로써의 날짜자료형

//import java.util.Date;//보편적인 작성날짜

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class R2ReplyVO {
	
	private int board_num,r_num ; //게시글번호
	private String mem_id,writer,r_content;//회원 id,관리자 id,제목,작성자,카테고리,메인사진,재료,순서,
	private int ref ,re_step,re_level;//게시판분류코드,조회수
	private Date r_write_date;//작성날짜

	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
		System.out.println("setBoard_num()호출됨"+board_num);
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
		System.out.println("setR_num()호출됨"+r_num);
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
		System.out.println("setMem_id()호출됨"+mem_id);
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
		System.out.println("setWriter()호출됨"+writer);
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = convert(r_content);
		System.out.println("setR_content()호출됨"+r_content);
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public Date getR_write_date() {
		return r_write_date;
	}
	public void setR_write_date(Date r_write_date) {
		this.r_write_date = r_write_date;
	}
		//추가(시큐어코드=>보안)
	//이 클래스에서만 사용하기위해서 접근지정자 private <,>,(,)=>변경메서드
		private static String convert(String name) {
			if(name!=null){
		    	//2.입력받은 문자열중에서 자바스크립트 구문을 실행시킬수 있는 특수기호를 입력X(<,>)
		    	//문자열메서드->replaceAll(1.변경전문자열,2.변경후 문자열)
		    	
		    	name=name.replaceAll("<","&lt");
		    	name=name.replaceAll(">","&gt");
		    	//추가 eval(" " or ' ')
		    	name=name.replaceAll("\\(","&#40");
		    	name=name.replaceAll("\\)","&#41");
		    	//"test"  'test'
		    	name=name.replaceAll("\"","&quot");
		    	name=name.replaceAll("\'","&apos");
		    }else{ //name==null
		    	return null; //입력을 하지 않았다면 더 이상 실행X
		    }
			return name;
		}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "R2ReplyVO[board_num="+board_num
				   +",mem_id="+mem_id+",r_num "+r_num+",writer="+writer+"r_content="+r_content
				   +",ref="+ref+",re_step="+re_step+",re_level="+re_level+",r_write_date="+r_write_date+"]";
	}
}
