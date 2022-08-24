package com.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.R1BoardDao;
import com.board.domain.R1BoardVO;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Component
@Controller 
public class R1UpdateController {

	//로그객체생성문
	private Logger log=Logger.getLogger(this.getClass());//this.getClass()->현재클래스명
	
	@Autowired
	private R1BoardDao boardDao;//자동으로 Setter Method 호출X=>의존성객체 넣어줌(byType)
	
	//1.글수정 폼으로 이동(GET방식)->반환값(단순 페이지이동=>String)
	//페이지이동 되는데 -> 데이터도 DB연결해서 출력해서 보여줘야한다면=>ModelAndView)
	@RequestMapping(value="/board/r1BoardUpdate.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("board_num") int board_num) { //메서드명은 임의로 작성
		
		System.out.println("다시 처음부터 값을 입력받기 위해서(초기화) form()호출됨");
		System.out.println("board_num=>"+board_num);
		R1BoardVO R1BoardVO=boardDao.selectBoard(board_num);
		System.out.println("R1BoardVO의 객체"+R1BoardVO);
		//1.이동할 페이지명(확장자생략) 2.키명 3.전달할값
		return new ModelAndView("r1BoardUpdate","command",R1BoardVO);
	}
	
	//2.입력해서 유효성 검사->에러발생
	//BindingResult->유효성검사때문에 필요=>에러정보객체를 저장시키는 역할
	@RequestMapping(value="/board/r1BoardUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") R1BoardVO com,HttpSession session) {
	    
			if(log.isDebugEnabled()) { //로그객체가 디버깅모드상태인지 아닌지를 체크
			System.out.println("/board/r1BoardUpdate.do 요청중(post");//?을 출력X
			log.debug("R1BoardVO:"+com); //log.debug메서드 사용
			//로그객체명.debug(출력대상자)
		}
		//유효성 검사
		/*new BoardValidator().validate(com,result);
		//에러정보가 있다면
		/*
		 * if(result.hasErrors()) { return "r1BoardUpdate"; //그대로 다시 이동해서 입력을 받을 수
		 * 있도록(편집) }
		 */
		//변경전의 데이터를 불러오기 ->board(비밀번호)=웹상에서의 입력비밀번호
		R1BoardVO board=null;
		String oldFileName=""; //변경전 파일명
		board=boardDao.selectBoard(com.getBoard_num());
		//비밀번호 체크(DB상의 암호!=웹상에서의 입력한 암호)
			/*
			 * 기본파일명->업로드된 파일이 존재->기존 파일 삭제->새로운 파일로 세팅 업로드돼야한다.
			 */
			oldFileName=board.getMain_img(); //DB상에 원래 기존파일명
			//업로드 되어있다면
			if(!com.getUpload().isEmpty()) {
				try {
				com.setMain_img(FileUtil.rename(com.getUpload().getOriginalFilename()));
				}catch(Exception e) {e.printStackTrace();}
			}else{ //새로운 파일로 업로드 하지 않는 경우(기존파일은 덮어쓰기)
				com.setMain_img(oldFileName);
			}
			
			//글수정 호출
			boardDao.update(com);//DB상에 반영(<insert>~</insert>)
			//실제로 upload폴더로 업로드한 파일을 전송(복사)
			if(!com.getUpload().isEmpty()) {
				try {
				File file=new File(FileUtil.UPLOAD_PATH+"/"+com.getMain_img());
				//물리적으로 데이터전송(파일전송)
				com.getUpload().transferTo(file);//파일업로드 위치로 전송
				}catch(IOException e) {
					e.printStackTrace();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				//기존파일은 삭제하는 구문 필요
				if(oldFileName!=null) {
					FileUtil.removeFile(oldFileName);
				}
			} //if(!com.getUpload().isEmpty()) {
		
		return "redirect:/board/r1BoardList.do";
	}
	//삭제
		@RequestMapping("/board/r1BoardDelete.do")
		public String process2(@RequestParam("board_num") int board_num) {
			
			R1BoardVO board=null;
	         board=boardDao.selectBoard(board_num);
	         System.out.println("post방식으로의 board=>"+board);

			if(log.isDebugEnabled()) { //로그객체가 작동중이라면(디버그상태)
				log.debug("board_num=>"+board_num);
			}
			 if(board.getMain_img()!=null) {
		            FileUtil.removeFile(board.getMain_img());
		    }

			boardDao.delete(board_num);
			
			return "redirect:/board/r1BoardList.do";
		}
}








