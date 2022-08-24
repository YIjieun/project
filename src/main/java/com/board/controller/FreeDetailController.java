package com.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.FreeBoardDao;
import com.board.dao.FreeReplyDao;
import com.board.domain.FreeBoardVO;
import com.board.domain.FreeReplyVO;
import com.board.domain.R2BoardVO;
import com.board.domain.R2ReplyVO;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Component
@Controller
public class FreeDetailController {
	
	private Logger log=Logger.getLogger(this.getClass());//로그객체 생성구문
	
	@Autowired
	private FreeBoardDao boardDao;//byType을 이용해서 BoardDao객체를 자동으로 의존주입
	
	@Autowired
	private FreeReplyDao replyDao;
	
	//String->페이지만 이동, 페이지가 이동하면서 데이터도 함께 전달(ModelAndView)
	//board/detail.do?seq=4->boardView.jsp
	@RequestMapping("/board/freeBoardDetail.do")
	public ModelAndView process(@RequestParam("board_num") int board_num,HttpSession session, 
																							HttpServletResponse response, HttpServletRequest req) {

		if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
			log.debug("board_num=>"+board_num);//System.out.println("seq=>"+seq);
		}
		//1.조회수 증가
		boardDao.updateHit(board_num);
		
		FreeBoardVO board=boardDao.selectBoard(board_num);
		//글내용에 \r\n  aaaa \r\n->메서드가 있다.<pre></pre>
		//board.setF_content(StringUtil.parseBr(board.getF_content()));//지금은 사용X
		//로그인이 완성되면 위에 걸로 session으로 id받아옴
		String mem_id = (String) session.getAttribute("mem_id");
		System.out.println("detail mem_id"+mem_id);
		//아이디로 작성자를 찾는 부분 SQL id 사용.
		String writer = boardDao.findOne(mem_id);

		//추가
		List<FreeReplyVO> reply=replyDao.list(board_num);
		
		// 로그인한 member table의 mem_id의 정보(MemberVO를 가져와도 됨)
		FreeBoardVO voboard = new FreeBoardVO();
		 //board.setMem_id(mem_id);
		 //mem_id 정보를 통해 작성자(닉네임)을 board99 객체에 작성자로 set해줌.
		voboard.setWriter(writer);
		
		ModelAndView mav=new ModelAndView("freeBoardDetail");
		mav.addObject("board",board);
		mav.addObject("voboard", voboard);
		mav.addObject("reply",reply);
		//추가
		mav.addObject("board_num",board_num);
		//1.이동할페이지명 2.전달할키명 3.전달할값
		return mav;
	}
	
	//댓글등록
	@RequestMapping(value="/board/freeReply.do")
	public ModelAndView submit(@ModelAttribute("FreeReplyVO")  FreeReplyVO fvo,
			                       @RequestParam(value="free_reply" ,defaultValue="1") String free_reply,HttpSession session, 
			                       HttpServletResponse response, HttpServletRequest req){
		
		String mem_id = (String) session.getAttribute("mem_id");
		System.out.println("detail mem_id"+mem_id);
		String writer = replyDao.findOne1(mem_id);
		
		 FreeReplyVO voboard = new FreeReplyVO();
		 //board.setMem_id(mem_id);
		 voboard.setWriter(writer);
		 System.out.println("컨트롤러writer"+writer);
		 
		// FreeBoardVO fvoboard=new FreeBoardVO();
		
		
		if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
			System.out.println("/board/freeReply.do 요청중");//?을 출력X
			log.debug("FreeReplyVO"+fvo);//?를 출력가능(select~where num=?)
			log.debug("free_reply=>"+free_reply);
			//로그객체명.debug(출력대상자)
		}
		
		System.out.println("fvo.getWriter()=>"+fvo.getWriter());
		System.out.println("replyDao.getNewRnum()=>"+replyDao.getNewRnum());
		
		//최대값 +1
		int newRnum=replyDao.getNewRnum()+1;
		System.out.println("newRnum=>"+newRnum);
		
		fvo.setBoard_num(fvo.getBoard_num());
		//fvo.setMem_id(fvo.getMem_id());
		//fvo.setWriter(fvo.getWriter());
		System.out.println("fvo.setWriter=>"+fvo.getWriter());
		fvo.setR_content(free_reply);
		
		//게시물번호=>계산->저장
		fvo.setR_num(newRnum);
		
		ModelAndView mav = new ModelAndView("redirect:/board/freeBoardDetail.do?board_num="+fvo.getBoard_num());
		mav.addObject("voboard", voboard);
		
		replyDao.insert(fvo);
		//return "redirect:/board/freeBoardDetail.do?board_num="+fvo.getBoard_num();
		return mav;
	}
	
	//댓글삭제
	@RequestMapping(value="/board/delete2.do")
	/*
	public String delete(@ModelAttribute("FreeReplyVO")  FreeReplyVO fvo,
            @RequestParam("r_num") int r_num){ */
	
	public String delete(@RequestParam("board_num") int board_num,
                                  @RequestParam("r_num") int r_num){	
		
		if(log.isDebugEnabled()) {
			log.debug("r_num=>"+r_num);
			log.debug("board_num=>"+board_num);
		}
		replyDao.delete2(r_num);
		return "redirect:/board/freeBoardDetail.do?board_num="+board_num;
	}
	//추가->글상세보기와 연관(다운로드)
	/*
	 * @RequestMapping("/board/file.do") public ModelAndView
	 * download(@RequestParam("f_img") String f_img) { //다운로드 받을 파일의 위치와 이름 File
	 * downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+f_img); //2. 스프링에서 다운로드 받는 뷰를
	 * 따로 작성->AbstractView를 상속받은 뷰클래스에게 전달 //1.다운로드받을 뷰객체 2.모델객체명(키),3.전달할값(다운로드받을
	 * 파일명) //1) 이동할 페이지 X (jsp 페이지 X) return new
	 * ModelAndView("downloadView","downloadFile",downloadFile); }
	 */
	
	
}
