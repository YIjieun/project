package com.board.domain;

import java.sql.Date;//테이블의 필드로써의 날짜자료형

import org.springframework.web.multipart.MultipartFile;
//import java.util.Date;//보편적인 작성날짜

//테이블의 필드와 연관이 있는 클래스(DTO or VO)
public class R1BoardVO {
	
	private int board_num; //게시글번호
	private String mem_id,manager_id,title,writer2,category,cook1,cook2;//회원 id,관리자 id,제목,작성자,카테고리,메인사진,재료,순서,
	private int click,heart,re_view;//게시판분류코드,조회수
	private Date postdate;//작성날짜
	//추가
	private MultipartFile upload;//업로드할때 필요로하는 객체
	private String main_img;//업로드한 파일명
	
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
		System.out.println("setMem_id()호출됨=>"+mem_id);
	}
	
	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
		System.out.println("setManager_id()호출됨=>"+manager_id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = convert(title);
		System.out.println("setTitle()호출됨=>"+title);
	}

	public String getWriter2() {
		return writer2;
	}

	public void setWriter2(String writer2) {
		this.writer2 = writer2;
		System.out.println("setWriter2()호출됨=>"+writer2);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		System.out.println("setCategory()호출됨=>"+category);
	}

	public String getCook1() {
		return cook1;
	}

	public void setCook1(String cook1) {
		this.cook1 = convert(cook1);
		System.out.println("setCook1()호출됨=>"+cook1);
	}

	public String getCook2() {
		return cook2;
	}

	public void setCook2(String cook2) {
		this.cook2 = convert(cook2);
		System.out.println("setCook2()호출됨=>"+cook2);
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
		System.out.println("setClick()호출됨=>"+click);
	}
	
	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
		System.out.println("setHeart()호출됨=>"+heart);
	}

	public int getRe_view() {
		return re_view;
	}

	public void setRe_view(int re_view) {
		this.re_view = re_view;
		System.out.println("setRe_view()호출됨=>"+re_view);
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

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = convert(main_img);
		System.out.println("setMain_img()호출됨=>"+main_img);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "R1BoardVO[board_num="+board_num+",mem_id="+mem_id
				   +",manager_id="+manager_id+",click="+click+",heart="+heart
				   +",title="+title+",writer2="+writer2+"category="+category
				   +",main_img="+main_img+",cook1="+cook1+",cook2="+cook2
				   +",re_view="+re_view+",postdate="+postdate
				   +",upload="+upload+"]";
	}
	//추가
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
}
