package com.board.domain;


import java.sql.Date;//테이블의 필드로써의 날짜자료형

//import java.util.Date;//보편적인 작성날짜

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class FreeReplyVO {
	
	private int r_num,board_num;
	private String mem_id,writer,r_content;
	private int ref,re_step,re_level;
	private Date r_write_date;//작성날짜
	
	
	public int getR_num() {
		return r_num;
	}


	public void setR_num(int r_num) {
		this.r_num = r_num;
		System.out.println("setR_num()호출됨");
	}


	public int getBoard_num() {
		return board_num;
	}


	public void setBoard_num(int board_num) {
		this.board_num = board_num;
		System.out.println("setBoard_num()호출됨");
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
		this.r_content = r_content;
		System.out.println("setR_content()호출됨");
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FreeReplyVO[r_num="+r_num+",board_num="+board_num+",mem_id="
				   +mem_id+",writer="+writer+",r_content="
				   +r_content+",ref="+ref+",re_step="+re_step+",re_level="
				   +re_level+",r_write_date="+r_write_date+"]";
	}
}
