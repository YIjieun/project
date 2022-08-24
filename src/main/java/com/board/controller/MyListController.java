package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;//로그를 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.MyBoardDao;
import com.board.domain.MyBoardVO;
import com.board.util.PagingUtil; //페이징처리패키지

@Component
@Controller
public class MyListController {

	//로그객체 생성문
	//private Logger log=Logger.getLogger(ListController.class);//로그를 처리할 클래스명
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private MyBoardDao boardDao;//자동적으로 Setter Method호출X(의존성객체 넣어줌)
	
	@RequestMapping("/board/MyPage.do")
	public ModelAndView process(
		@RequestParam(value="pageNum",defaultValue="1") int currentPage,//페이지번호
		@RequestParam(value="keyField",defaultValue="") String keyField,//검색분야
		@RequestParam(value="keyWord",defaultValue="") String keyWord//검색어		
			) {
			if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
				System.out.println("/board/MyPage.do 요청중");//?을 출력X
				log.debug("currentPage"+currentPage);//?를 출력가능(select~where num=?)
				log.debug("keyField"+keyField);
				log.debug("keyWord"+keyWord);
			}
			//검색분야,검색어를 ->parameterType="map"(Map객체)
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);
			//총레코드수 또는 검색된 글의 총레코드수
			int count=boardDao.getRowCount(map);
			System.out.println("MyListController 클래스의 count=>"+count);
		//페이징처리(1.현재페이지 2. 총레코드수 3. 페이지당 게시물수 4. 블럭당 페이지수 5. 요청명령어지정)
		PagingUtil page=new PagingUtil(currentPage,count,3,3,"MyPage.do");
		
		//start=>페이지당 맨 첫번째 나오는 게시물번호, end=>마지막 게시물 번호
		map.put("start", page.getStartCount());//<->map.get("start")=>#{start}
		map.put("end", page.getEndCount());//<->map.get("end")=>#{end}
		
		List<MyBoardVO> list=null;
		if(count>0) {
			list=boardDao.list(map);//keyField,keyWord,start,end
		}else {
			list=Collections.EMPTY_LIST;//0 적용
		}
		
		ModelAndView mav=new ModelAndView("MyPage");//boardList.jsp 에서 찾아서 뿌린다
		mav.addObject("count",count);//총레코드수
		mav.addObject("list", list);//검색된 레코드리스트
		mav.addObject("pagingHtml",page.getPagingHtml());//<a href="~?>링크문자열
		
		return mav;
	}
}
