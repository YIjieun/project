package com.board.domain;

import java.util.Date;

public class MemberVO {
	private String mem_id,writer,passwd,name,phone;
	private Date mem_date;
	private int grade;
	
	// 관리자
	private String manager_id,passwd2,writer2;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id.trim();
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer.trim();
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	// 관리자
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
		System.out.println("manager_id 출력");
	}
	public String getPasswd2() {
		return passwd2;
	}
	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
		System.out.println("passwd2 출력");
	}
	public String getWriter2() {
		return writer2;
	}
	public void setWriter2(String writer2) {
		this.writer2 = writer2;
	}
	

} 
	

