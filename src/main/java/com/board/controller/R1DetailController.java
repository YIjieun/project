package com.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;//JSON객체를 만드는데 사용
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.R1BoardDao;
import com.board.domain.R1BoardVO;

@Component
@Controller
public class R1DetailController {
	
	private Logger log=Logger.getLogger(this.getClass());//로그객체 생성구문
	
	@Autowired
	private R1BoardDao boardDao;//byType을 이용해서 BoardDao객체를 자동으로 의존주입
	
	//String->페이지만 이동, 페이지가 이동하면서 데이터도 함께 전달(ModelAndView)
	//board/detail.do?seq=4->boardView.jsp
	@RequestMapping("/board/r1BoardDetail.do")
	public ModelAndView process(@RequestParam("board_num") int board_num,HttpSession session, 
																								HttpServletResponse response, HttpServletRequest req) {
		//@RequestParam("seq") int seq->어노테이션
		//int seq=Integer.parseInt(request.getParameter("seq"));->자바코드
		//?,?
		if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
			log.debug("board_num=>"+board_num);//System.out.println("seq=>"+seq);
		}
		//1.조회수 증가
		boardDao.updateHit(board_num);
		R1BoardVO board=boardDao.selectBoard(board_num);
		//글내용에 \r\n  aaaa \r\n->메서드가 있다.<pre></pre>
		//board.setCook2(StringUtil.parseBr(board.getCook2()));//지금은 사용X
		
		String manager_id = (String) session.getAttribute("manager_id");
		System.out.println("detailController의 manager_id"+manager_id);
		
		String writer2 = boardDao.findOne55(manager_id);
		
		R1BoardVO board55 = new R1BoardVO();
		board55.setWriter2(writer2);
		
		
		/*ModelAndView mav=new ModelAndView("boardView");
		mav.addObject("board",board);//${board}
		return mav; */   //1.이동할페이지명 2.전달할키명 3.전달할값
		return new ModelAndView("r1BoardDetail","board",board);
		
	}
	
	  //public String transferGood~
	@RequestMapping("/board/clickHeart.do")
	@ResponseBody
	public String transferGood(@RequestParam(value="board_num",defaultValue="5") int board_num,
			                                 @RequestParam(value="mem_id",defaultValue="") String mem_id,
			                                 @RequestParam(value="click",defaultValue="0") int click){ //추가
		System.out.println("/board/clickHeart.do의 중에서 board_num=>"+board_num+",mem_id=>"+mem_id+",click=>"+click);
		//추가
		JSONObject obj = new JSONObject();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("board_num", board_num);
		hashmap.put("mem_id", mem_id);
		
		int result = boardDao.checkLike(hashmap);//좋아요할 갯수=>1 (안눌른경우)
		System.out.println("result의 값 확인=>"+result);//1
		
		if(result == 1) { //빈하트일 때 누름 -> 하트로 변경
			//mainService.downLike(boardNo);
			boardDao.updateHeart(board_num);
			boardDao.check_ok(hashmap);//0->1
		} else { //하트일 때 누름 -> 빈하트로 변경(1->0)
			boardDao.deleteHeart(board_num);
			boardDao.check_cancel(hashmap);
		}
	
		 int clickCheck=boardDao.getCheck(hashmap);//현재 클릭의 상태
		//하트수 값 구해오기
		 String goodsu=String.valueOf(boardDao.backgood(board_num));
	     System.out.println("goodsu=>"+goodsu);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		  obj.put("goodsu", goodsu);
		  obj.put("result", result);
		  obj.put("clickCheck", clickCheck);
		 

		System.out.println(map);

		return obj.toJSONString();//return obj.toJSONString();
	}
}
