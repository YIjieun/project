package com.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.R2BoardDao;
import com.board.dao.R2ReplyDao;
import com.board.domain.R2BoardVO;
import com.board.domain.R2ReplyVO;
import com.board.util.FileUtil;
import com.board.util.StringUtil;





@Component
@Controller
public class R2DetailController {
private Logger log=Logger.getLogger(this.getClass());//로그객체 생성구문
	
	@Autowired
	private R2BoardDao boardDao;//byType을 이용해서 BoardDao객체를 자동으로 의존주입
	
	@Autowired
	private R2ReplyDao replyDao;
	
	//String->페이지만 이동, 페이지가 이동하면서 데이터도 함께 전달(ModelAndView)
	//board/detail.do?seq=4->boardView.jsp
	@RequestMapping("/board/R2BoardDetail.do")
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
		
		//게시글에 대한 정보를 받아옴.
		R2BoardVO board=boardDao.selectBoard2(board_num);
		//글내용에 \r\n  aaaa \r\n->메서드가 있다.<pre></pre>
		//board.setCook2(StringUtil.parseBr(board.getCook2()));//지금은 사용X
		//String mem_id ="kkk";
		//로그인이 완성되면 위에 걸로 session으로 id받아옴
		String mem_id = (String) session.getAttribute("mem_id");
		System.out.println("detail mem_id"+mem_id);
		//아이디로 작성자를 찾는 부분 SQL id 사용.
		String writer = boardDao.findOne99(mem_id);
		//String mem_id = "nup";
		
		//추가
		List<R2ReplyVO> reply=replyDao.list(board_num);
		System.out.println("reply:"+reply);
		
		// 로그인한 member table의 mem_id의 정보(MemberVO를 가져와도 됨)
		 R2BoardVO board99 = new R2BoardVO();
		 //board.setMem_id(mem_id);
		 //mem_id 정보를 통해 작성자(닉네임)을 board99 객체에 작성자로 set해줌.
		 board99.setWriter(writer);
		
		 //ajax에서 보내준 json data로 받아오기 편하도록 key,value 형태인 map or hashmap 사용.
		 HashMap<String,Object> hashmap = new HashMap<String, Object>(); 
		  hashmap.put("board_num",board_num);
		  hashmap.put("mem_id", mem_id);
		  
		  //해당 게시물에 대하여 로그인한 id가 좋아요를 눌렀는지, 좋아요가 몇개인지 알기 위한 변수를 생성하고 저장한다.
		  //상태(빈하트 or 꽉찬 하트)
		  int like = boardDao.checkLike99(hashmap); 
		  //갯수
		  int likeCnt =boardDao.likeCnt99(board_num);

		  //board객체에 저장되어 있음.
		  board.setHeart(like);//상태
		  board.setLikestate(likeCnt);//갯수
		
			ModelAndView mav = new ModelAndView("R2BoardDetail");
			mav.addObject("board", board);
			mav.addObject("board99", board99);
			mav.addObject("reply", reply);
			// 추가
			mav.addObject("board_num", board_num);
			// 1.이동할페이지명 2.전달할키명 3.전달할값
			return mav;
		/*ModelAndView mav=new ModelAndView("boardView");
		mav.addObject("board",board);//${board}
		return mav;*/ //1.이동할페이지명 2.전달할키명 3.전달할값
		//return new ModelAndView("R2BoardDetail","board",board);
	}
	//댓글등록
	@RequestMapping(value="/board/R2Reply.do")
	public ModelAndView submit(@ModelAttribute("R2ReplyVO")  R2ReplyVO rvo,
			                       @RequestParam(value="r_content" ,defaultValue="세번째요청중") String r_content,HttpSession session, 
			                       HttpServletResponse response, HttpServletRequest req){
		
		String mem_id = (String) session.getAttribute("mem_id");
		System.out.println("detail mem_id"+mem_id);
		String writer = boardDao.findOne99(mem_id);
		
		 R2ReplyVO board99 = new R2ReplyVO();
		 //board.setMem_id(mem_id);
		 board99.setWriter(writer);
		
			
		if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
			System.out.println("/board/R2Reply.do 요청중");//?을 출력X
			log.debug("R2ReplyVO=>"+rvo);//?를 출력가능(select~where num=?)
			log.debug("r_content=>"+r_content);
			//로그객체명.debug(출력대상자)
		}
		System.out.println("rvo.getWriter()=>"+rvo.getWriter());
		System.out.println("replyDao.getNewRnum()=>"+replyDao.getNewRnum());
		//최대값 +1
		int newRnum=replyDao.getNewRnum()+1;
		System.out.println("newRnum=>"+newRnum);
		
		rvo.setBoard_num(rvo.getBoard_num());
		rvo.setMem_id(rvo.getMem_id());
		rvo.setWriter(rvo.getWriter());
		rvo.setR_content(r_content);

		//게시물번호=>계산->저장
		rvo.setR_num(newRnum);
	  
		ModelAndView mav = new ModelAndView("redirect:/board/R2BoardDetail.do?board_num="+rvo.getBoard_num());
		mav.addObject("board99", board99);
		
		replyDao.insert(rvo);
		return mav;
	}
	
	@RequestMapping(value="/board/delete.do")
	/*
	public String delete(@ModelAttribute("R2ReplyVO")  R2ReplyVO rvo,
            @RequestParam("r_num") int r_num){ */
	
	public String delete(@RequestParam("board_num") int board_num,
                                  @RequestParam("r_num") int r_num){	
		
		if(log.isDebugEnabled()) {
			log.debug("r_num=>"+r_num);
			log.debug("board_num=>"+board_num);
		}
		replyDao.delete(r_num);
		return "redirect:/board/R2BoardDetail.do?board_num="+board_num;
	}
	/*
	 //추가->글상세보기와 연관(다운로드)
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("main_img") String main_img) {
		//다운로드 받을 파일의 위치와 이름
		File downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+main_img);
		//2. 스프링에서 다운로드 받는 뷰를 따로 작성->AbstractView를 상속받은 뷰클래스에게 전달
		//1.다운로드받을 뷰객체  2.모델객체명(키),3.전달할값(다운로드받을 파일명)
		//1) 이동할 페이지 X (jsp 페이지 X)
		return new ModelAndView("downloadView","downloadFile",downloadFile);
	}
	*/
	// board like
			@ResponseBody
			@RequestMapping(value = "/board/boardLike.do", method = RequestMethod.POST)
			public String boardLike(int board_num, String mem_id) throws Exception {
				R2BoardVO board=boardDao.selectBoard2(board_num);
				
				System.out.println("like mem_id=>"+mem_id);
				
				HashMap<String, Object> hashmap = new HashMap<String, Object>();
				hashmap.put("board_num", board_num);
				hashmap.put("mem_id", mem_id);

				//상태
				int result = boardDao.checkLike99(hashmap);
				
				System.out.println("result=>"+result);
				
				if(result == 1) { //하트일 때 누름 -> 빈하트로 변경
					boardDao.downLike99(board_num);
					boardDao.deleteLikeInfo99(hashmap);
					result = 0;
				} else{ //빈하트일 때 누름 -> 하트로 변경
					boardDao.upLike99(board_num);
					boardDao.insertLikeInfo99(hashmap);	
					result = 1;
				}
				System.out.println("board.getHeart()"+board.getHeart());
				//System.out.println("board.getLikestate()"+board.getLikestate());
				//총 갯수
				int likeCnt = boardDao.likeCnt99(board_num);
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("likeCnt", likeCnt);
				map.put("result", result);

				System.out.println(map);

//				return map;
				return  JSONObject.toJSONString(map);
			}
	
}
