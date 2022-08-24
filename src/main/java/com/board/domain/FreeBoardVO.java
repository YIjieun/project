package com.board.domain;

import java.sql.Date;//테이블의 필드로써의 날짜자료형

import org.springframework.web.multipart.MultipartFile;
//import java.util.Date;//보편적인 작성날짜

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class FreeBoardVO {
	
	private int board_num;
	private String mem_id,writer,f_title,f_category,f_content,f_img;
	private int f_view;//조회수
	private Date postdate;//작성날짜
	
	//추가
	private MultipartFile upload;//업로드할때 필요로하는 객체
	//private String filename;//업로드한 파일명
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
		System.out.println("setBoard_num()호출됨=>"+board_num);
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
		System.out.println("mem_id()호출됨=>"+mem_id);
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
		System.out.println("setWriter()호출됨=>"+writer);
	}
	public String getF_title() {
		return f_title;
	}
	public void setF_title(String f_title) {
		this.f_title = f_title;
		System.out.println("setF_title()호출됨=>"+f_title);
	}
	public String getF_category() {
		return f_category;
	}
	public void setF_category(String f_category) {
		this.f_category = f_category;
		System.out.println("setF_category()호출됨=>"+f_category);
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
		System.out.println("setF_content()호출됨=>"+f_content);
	}
	public String getF_img() {
		return f_img;
	}
	public void setF_img(String f_img) {
		this.f_img = f_img;
		System.out.println("setF_img()호출됨=>"+f_img);
	}
	public int getF_view() {
		return f_view;
	}
	public void setF_view(int f_view) {
		this.f_view = f_view;
		System.out.println("setF_view()호출됨=>"+f_view);
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
		System.out.println("setPostdate()호출됨=>"+postdate);
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("setUpload()호출됨=>"+upload);
	}
	/*
	 * public String getFilename() { return filename; } public void
	 * setFilename(String filename) { this.filename = filename; }
	 */
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FreeBoardVO[board_num="+board_num+",mem_id="+mem_id+",writer="
				   +writer+",f_title="+f_title+",f_category="+f_category+",f_content="
				   +f_content+",f_img="+f_img+",f_view="+f_view+",postdate="
				   +postdate+",upload="+upload+"]";
	}
}
