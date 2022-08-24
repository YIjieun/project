package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;//로그를 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.R1BoardDao;
import com.board.domain.R1BoardVO;
import com.board.util.PagingUtil;

@Component
@Controller
public class R1ListController {

	//로그객체 생성문
	//private Logger log=Logger.getLogger(ListController.class);//로그를 처리할 클래스명
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private R1BoardDao boardDao;//자동적으로 Setter Method호출X(의존성객체 넣어줌)
	
	@RequestMapping("/board/r1BoardList.do")
	public ModelAndView process(HttpSession session,
		@RequestParam(value="pageNum",defaultValue="1") int currentPage,//페이지번호
		@RequestParam(value="keyField",defaultValue="") String keyField,//검색분야
		@RequestParam(value="keyWord",defaultValue="") String keyWord//검색어														
			
			) {
		String id = (String)session.getAttribute("manager_id");
		System.out.println("manager_id=>"+id);
			if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
				System.out.println("/board/r1BoardList.do 요청중");//?을 출력X
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
			System.out.println("ListController 클래스의 count=>"+count);
		//페이징처리(1.현재페이지 2. 총레코드수 3. 페이지당 게시물수 4. 블럭당 페이지수 5. 요청명령어지정)
		PagingUtil page=new PagingUtil(currentPage,count,10,10,"r1BoardList.do");
		
		//start=>페이지당 맨 첫번째 나오는 게시물번호, end=>마지막 게시물 번호
		map.put("start", page.getStartCount());//<->map.get("start")=>#{start}
		map.put("end", page.getEndCount());//<->map.get("end")=>#{end}
		
		List<R1BoardVO> list=null;
		//추가
		List<R1BoardVO> reviewList=null; //조회수
		if(count>0) {
			list=boardDao.list(map);//keyField,keyWord,start,end
			reviewList=boardDao.getDescRe_view();
			System.out.println("R1ListController의 list=>"+list);
			System.out.println("reviewList=>"+reviewList);
		}else {
			list=Collections.EMPTY_LIST;//0 적용
		}
		
		ModelAndView mav=new ModelAndView("r1BoardList");//boardList.jsp
		mav.addObject("count",count);//총레코드수
		mav.addObject("list", list);//검색된 레코드리스트
		//추가2
		mav.addObject("reviewList", reviewList);//검색된 조회수 증가 데이터 
		mav.addObject("pagingHtml",page.getPagingHtml());//<a href="~?>링크문자열
		
		return mav;
	}
}
