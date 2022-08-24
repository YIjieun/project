package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.EventBoardDao;
import com.board.domain.EventVO;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Component
@Controller
public class EventDetailController {
	
	private Logger log=Logger.getLogger(this.getClass());//로그객체 생성구문
	
	@Autowired
	private EventBoardDao eventBoardDao;//byType을 이용해서 BoardDao객체를 자동으로 의존주입
	
	@RequestMapping("/board/eventDetail.do") // board/eventDetail.do?seq=4->eventView.jsp
	public ModelAndView process(@RequestParam("event_code") int event_code) {//@RequestParam("event_code") int event_code->어노테이션

		if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
			log.debug("event_code=>"+event_code);
			System.out.println("event_code=>"+event_code);
		}
		EventVO board=eventBoardDao.selectBoard(event_code);
		board.setE_content(StringUtil.parseBr(board.getE_content()));
	
		return new ModelAndView("eventView","board",board); //1.이동할페이지명 2.전달할키명 3.전달할값
	}

}
