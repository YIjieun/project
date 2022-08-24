package com.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;//로그를 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.FreeBoardDao;
import com.board.domain.FreeBoardVO;
import com.board.domain.R2BoardVO;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Component
@Controller
public class FreeWriteController {

	//로그객체 생성문
	//private Logger log=Logger.getLogger(ListController.class);//로그를 처리할 클래스명
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private FreeBoardDao boardDao;//자동적으로 Setter Method호출X(의존성객체 넣어줌)
	

	//1. 글쓰기 폼으로 이동(GET방식)
	@RequestMapping(value="/board/freeBoardWrite.do",method=RequestMethod.GET)
	public ModelAndView form(HttpSession session, HttpServletResponse response, HttpServletRequest req)  {//메서드명은 임의로 작성
		 System.out.println("다시 처음부터 값을 입력을 받기 위해서(초기화) form()호출됨.");
		
		//로그인이 완성되면 위에 걸로 session으로 id받아옴 (위에걸로 변경)
		 String mem_id = (String) session.getAttribute("mem_id");	
		 System.out.println("writer mem_id"+mem_id);
		 String writer = boardDao.findOne(mem_id);
		 
		 FreeBoardVO board = new FreeBoardVO();
		 //board.setMem_id(mem_id);
		 board.setWriter(writer);

		ModelAndView mav = new ModelAndView("freeBoardWrite");
		mav.addObject("findOne", board);
	
		return mav;//return "이동할페이지명"//definition name과 동일
	}
	
	//2. 에러메시지출력->다시 초기화가 가능하게 설정->@ModelAttribute("커맨드객체 별칭")
	@ModelAttribute("FreeBoardVO")
	public FreeBoardVO forBacking() {//반환형(DTO형 or VO형)임의의 메서드명
		System.out.println("forBacking()호출됨");
		return new FreeBoardVO();//return new UserVO
	}
	//3.입력해서 유효성검사->에러발생
	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/board/freeBoardWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("FreeBoardVO") FreeBoardVO com,
									BindingResult result){
	
			if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
				System.out.println("/board/freeBoardWrite.do 요청중(post)");//?을 출력X
				log.debug("FreeBoardVO"+com);//?를 출력가능(select~where num=?)
				//로그객체명.debug(출력대상자)
			}
		//유효성검사
		//new BoardValidator().validate(com,result);
		//에러정보가 있다면
		//if(result.hasErrors()) {
		//	return form();//"boardWrite"->"boardWrite.jsp"로 이동하라
		//}
		//글쓰기 및 업로드=>입출력=>예외처리
		try {
			String newName="";//업로드한 파일이 변경된 파일명을 저장
			//업로드 되어 있다면
			if(!com.getUpload().isEmpty()) {
				//탐색기에서 선택한 파일->getOriginalFileName() aaaa.txt->123456
				newName=FileUtil.rename(com.getUpload().getOriginalFilename());
				System.out.println("newName=>"+newName);
				//DTO에 변경=>테이블에서도 변경저장
				com.setF_img(newName);//springboard2->filename필드명
			}
			//최대값 +1
			int newSeq=boardDao.getNewSeq()+1;
			System.out.println("newSeq=>"+newSeq);
			//게시물번호=>계산->저장
			com.setBoard_num(newSeq);//1->2
			boardDao.insert(com);//DB상에서 반영(<insert>~</insert>)
			//실제로 upload폴더로 업로드한 파일을 전송(복사)
			if(!com.getUpload().isEmpty()) {
				File file=new File(FileUtil.UPLOAD_PATH+"/"+newName);
				//물리적으로 데이터전송(파일전송)
				com.getUpload().transferTo(file);//파일업로드 위치로 전송
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
			
		//return "redirect:/요청명령어";=>retrun "이동할 페이지";
		return "redirect:/board/freeBoardList.do";
	}
}
