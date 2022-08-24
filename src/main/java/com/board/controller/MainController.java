package com.board.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.EventBoardDao;
import com.board.dao.MainDao;
import com.board.domain.EventVO;
import com.board.domain.R1BoardVO;
import com.board.domain.R2BoardVO;

@Component
@Controller
//@RequestMapping(value="/board/Main.do")
public class MainController {

		 private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private EventBoardDao eventboardDao; //자동적으로 Setter Method호출X(의존성객체 넣어줌)
	
	@Autowired
	private MainDao mainDao;

		// 1. 이벤트
		@RequestMapping(value="/board/Main.do",method = RequestMethod.GET)
		public ModelAndView EventBoardList() throws Exception {	
		
		List<EventVO> list=null;	 // 이벤트
		List<R2BoardVO> getDescRe_main=null; // 회원
		List<R1BoardVO> getDescRe_main2=null; // 관리자
		
		list=eventboardDao.list(); // 이벤트
		getDescRe_main=mainDao.getDescRe_main(); // 회원
		getDescRe_main2=mainDao.getDescRe_main2(); // 관리자
	
		ModelAndView mav=new ModelAndView("Main");
		
		mav.addObject("list", list); // 이벤트
		mav.addObject("getDescRe_main", getDescRe_main); // 회원
		mav.addObject("getDescRe_main2", getDescRe_main2); // 회원
        
		return mav;				
	}
		
		 
		
		
		
}
