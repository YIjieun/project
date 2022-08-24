package com.board.domain;

import java.sql.Date;//테이블의 필드로써의 날짜자료형

import org.springframework.web.multipart.MultipartFile;
//import java.util.Date;//보편적인 작성날짜

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class MyBoardVO {
	
	private String mem_id,writer,m_img,grade;//아이디,작성자,이미지,등급
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
		System.out.println("setMem_id()호출됨=>"+mem_id);
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
		System.out.println("setWriter()호출됨=>"+writer);
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
		System.out.println("setM_img()호출됨=>"+m_img);
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
		System.out.println("setGrade()호출됨=>"+grade);
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MyBoardVO[mem_id="+mem_id+"writer="+writer
				+"m_img="+m_img+"grade="+grade+"]";
	}
	
	
	
}
