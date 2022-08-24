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

import com.board.dao.FreeBoardDao;
import com.board.domain.FreeBoardVO;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Component
@Controller
public class FreeUpdateController {

	//로그객체 생성문
	private Logger log=Logger.getLogger(this.getClass());//현재 클래스명을 불러와서 지정
	
	
	@Autowired
	private FreeBoardDao boardDao; //자동적으로 Setter Method 호출X (의존성객체 넣어줌)
	
	
	//1.글수정 폼으로 이동(GET방식) -> 반환값(단순 페이지 이동=> String)
	//페이지이동-> 데이터 출력->ModelAndView
	@RequestMapping(value="/board/freeBoardUpdate.do",method=RequestMethod.GET)
	public ModelAndView form (@RequestParam("board_num") int board_num) { //메소드명은 임의로 작성
		
		System.out.println("다시 처음부터 값을 입력을 받기위해서(초기화) form()호출됨");
		System.out.println("board_num=>"+board_num);
		FreeBoardVO freeBoardVO=boardDao.selectBoard(board_num);
		System.out.println("freeBoardVO객체=>"+freeBoardVO);//null?
		//1.이동할페이지명(확장자생략), 2.키명 3.전달할 값
		return new ModelAndView("freeBoardUpdate","vo",freeBoardVO);
	}
	
	
	//2.입력해서 유효성검사-> 에러발생
	//BindingResult-> 유효성검사때문에 필요=>에러정보객체를 저장
	@RequestMapping(value="/board/freeBoardUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("freeBoardVO")FreeBoardVO com) {
		
	
		if(log.isDebugEnabled()) { //로그객체가 디버깅모드상태인지 아닌지를 체크
			System.out.println("/board/freeBoardUpdate.do 요청중(post)"); //? 을 출력X
			log.debug("FreeBoardVO:"+com); //? 을 출력가능(select ~ where num=?)

		}
		
		//변경전의 데이터를 불러오기->board(비밀번호)=웹상에서의 입력비밀번호
		FreeBoardVO board=null;
		String oldFileName="";//변경전 파일명
		board=boardDao.selectBoard(com.getBoard_num());
		System.out.println("post방식으로의 board=>"+board);
		oldFileName=board.getF_img(); //DB상의 원래 기존파일명 
			//업로드되어있다면
			if(!com.getUpload().isEmpty()) {
				try {
					com.setF_img(FileUtil.rename(com.getUpload().getOriginalFilename()));
				}catch(Exception e) {e.printStackTrace();}
			}else { //새로운 파일로 업로드 하지 않은 경우(기존파일은 덮어쓰기)
				com.setF_img(oldFileName);
			}

			//글수정 호출
			boardDao.update(com);//DB상에 반영(<update>~</update>)
			
			
			//실제로 upload폴더로 업로드한 파일을 전송(복사)
			if(!com.getUpload().isEmpty()) {
				try {
				File file=new File(FileUtil.UPLOAD_PATH+"/"+com.getF_img());
				//물리적으로 데이터전송(파일전송)
				com.getUpload().transferTo(file);//파일업로드 위치로 전송
				}catch(IOException e) {
					e.printStackTrace();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			//기존파일은 삭제하는 구문이 필요
				if(oldFileName!=null) {
					FileUtil.removeFile(oldFileName);
				}
			}//if(!com.getUpload().isEmpty()) {
			//}else 암호가 맞다면 
		return "redirect:/board/freeBoardList.do";
	}
	
	//삭제
		@RequestMapping("/board/freeBoardDelete.do")
		public String processDelete(@RequestParam("board_num") int board_num) {
			
			FreeBoardVO board=null;
			board=boardDao.selectBoard(board_num);
			System.out.println("post방식으로의 board=>"+board);
			
			if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
				log.debug("board_num=>"+board_num);//System.out.println("seq=>"+seq);
			}
			
			
			if(board.getF_img()!=null) {
				FileUtil.removeFile(board.getF_img());
			}
			
			boardDao.delete(board_num);
			
			return "redirect:/board/freeBoardList.do";
		}
}
