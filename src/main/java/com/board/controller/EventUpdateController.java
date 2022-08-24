package com.board.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger; //로그객체를 불러오겠다고 선언한 부분
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.EventBoardDao;
import com.board.domain.EventVO;
import com.board.util.FileUtil;
import com.board.validator.BoardDeleteValidator;

@Component
@Controller
public class EventUpdateController {

	//로그객체 생성문
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private EventBoardDao eventBoardDao;//자동적으로 Setter Methdo호출X (의존성객체 넣어줌)
	
	//1.글수정 폼으로 이동(GET방식)->반환값(단순 페이지 이동=>String)
	//페이지이동->데이터 출력->ModelAndView
	@RequestMapping(value="/board/eventUpdate.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("event_code") int event_code) { //메서드명은 임의로 작성
		System.out.println("다시 처음부터 값을 입력을 받기위해서(초기화) form()호출됨");
		EventVO eventVO=eventBoardDao.selectBoard(event_code);
		//1.이동할페이지명(확장자생략),2.키명.3.전달할값
		return new ModelAndView("eventUpdate","command",eventVO);
	}
	
	//2.입력해서 유효성검사->에러발생
	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/board/eventUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") EventVO com,
			                       BindingResult result) {
	  
		  if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
			  System.out.println("/board/eventUpdate.do 요청중(post)");//? 을 출력X
			  log.debug("EventVO:"+com); //? 을 출력 가능(select ~ where num=?)
	          //로그객체명.debug(출력대상자)
		  }

		  //변경전의 데이터를 불러오기->board(비밀번호)=웹상에서의 입력비밀번호
			/* EventVO board; */
		  EventVO board=null;
		  String oldFileName="";//변경전 파일명
		  	System.out.println("com.getEvent_code()=>"+com.getEvent_code());//0
		  board=eventBoardDao.selectBoard(com.getEvent_code());
		  	System.out.println("/board/eventUpdate.do에서의 board=>"+board);
		  
		  	//기본파일명->업로드된파일이 존재->기존파일 삭제->새로운파일 세팅 업로드돼야한다.
			  oldFileName=board.getEvent_image();//DB상의 원래 기존파일명
			  	System.out.println("board.getEvent_image()=>"+board.getEvent_image());
			  //업로드되어있다면
			  if(!com.getUpload().isEmpty()) {
				 try {
				  com.setEvent_image(FileUtil.rename(com.getUpload().getOriginalFilename()));
				 }catch(Exception e) {e.printStackTrace();}
			  }else {//새로운 파일로 업로드 하지 않은경우(기존파일은 덮어쓰기)
				  com.setEvent_image(oldFileName);
			  }
			 
			  //글수정 호출
			  eventBoardDao.update(com);//DB상에 반영(<insert>~</insert>)
			  
			  //실제로 upload폴더로 업로드한 파일을 전송(복사)
			  if(!com.getUpload().isEmpty()) {
				  try {
				  File file=new File(FileUtil.UPLOAD_PATH+"/"+com.getEvent_image());
				  //물리적으로 데이터전송(파일전송)
				  com.getUpload().transferTo(file);//파일업로드위치로 전송
				  }catch(IOException e) {
					  e.printStackTrace();
				  }catch(Exception e2) {
					  e2.printStackTrace();
				  }
		       //기존파일은 삭제하는 구문이 필요
				if(oldFileName!=null) {
					FileUtil.removeFile(oldFileName);
				}
		     }// if(!com.getUpload().isEmpty()) {

		return  "redirect:/board/eventList.do";		
	}	

	//삭제
	@RequestMapping(value="/board/deleteBoard.do")
	public String processDelete(@RequestParam("event_code") int event_code) {//@RequestParam("event_code") int event_code->어노테이션

		 EventVO board=null;
         board=eventBoardDao.selectBoard(event_code);
		
		if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
			log.debug("event_code=>"+event_code);
				System.out.println("event_code=>"+event_code);
		}
		
		if(board.getEvent_image()!=null) {
	            FileUtil.removeFile(board.getEvent_image());
	    }

		eventBoardDao.delete(event_code);
		
		return "redirect:/board/eventList.do";
	}	
	
}
