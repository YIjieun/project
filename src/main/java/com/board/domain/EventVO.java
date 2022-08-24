package com.board.domain;

import java.sql.Date;

//import java.util.Date; //보편적인 작성날짜

import org.springframework.web.multipart.MultipartFile;

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class EventVO {
	
	private int event_code;
	private String manager_writer,e_title,e_content,event_yn,event_image ,e_write_date,event_date; //업로드한 파일명
	
	private MultipartFile upload; //업로드할때 필요로하는 객체(sql 쓰는거아님)
	
	public int getEvent_code() {
		return event_code;
	}
	public void setEvent_code(int event_code) {
		this.event_code = event_code;
		System.out.println("setEvent_code() 호출: "+event_code);
	}
	public String getManager_id() {
		return manager_writer;
	}
	public void setManager_id(String manager_id) {
		this.manager_writer = manager_id;
		System.out.println("setManager_id() 호출: "+manager_id);
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
		System.out.println("setE_title() 호출: "+e_title);
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
		System.out.println("setE_content() 호출: "+e_content);
	}
	public String getEvent_yn() {
		return event_yn;
	}
	public void setEvent_yn(String event_yn) {
		this.event_yn = event_yn;
		System.out.println("setEvent_yn() 호출: "+event_yn);
	}
	public String getEvent_image() {
		return event_image;
	}
	public void setEvent_image(String event_image) {
		this.event_image = event_image;
		System.out.println("setEvent_image() 호출: "+event_image);
	}
	public String getE_write_date() {
		return e_write_date;
	}
	public void setE_write_date(String e_write_date) {
		this.e_write_date = e_write_date;
		System.out.println("setE_write_date() 호출: "+e_write_date);
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
		System.out.println("setEvent_date() 호출: "+event_date);
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("setUpload() 호출: "+upload);
	}
	
}
