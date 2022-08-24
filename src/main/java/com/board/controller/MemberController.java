package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dao.MemberService;
import com.board.domain.MemberVO;

@Component
@Controller
	public class MemberController {
	
		//로그객체 생성문
	private Logger log=Logger.getLogger(this.getClass());//현재클래스명을 불러와서 지정
	
	@Autowired
	private MemberService memberService;
	
		// 회원가입 get
		@RequestMapping(value = "/board/register.do", method = RequestMethod.GET)
		public String getRegister() throws Exception {
			log.info("get register");
			return "register";
		}
		
		// 아이디	중복 확인
		@RequestMapping(value = "/board/memberIdChk.do", method = RequestMethod.POST)
		@ResponseBody
		public String memberIdChk(String mem_id) throws Exception{			
			int result = memberService.idCheck(mem_id);
			
			log.info("결과값 = " + result);
			
			if(result == 1) {				
				return "fail";	// 중복 아이디가 존재				
			} else {
				return "success";	// 중복 아이디 x				
			}				
		}
		
		// 닉네임	중복 확인
				@RequestMapping(value = "/board/writerChk.do", method = RequestMethod.POST)
				@ResponseBody
				public String writerChk(@RequestParam("writer") String writer) throws Exception{			

					int result = memberService.writerCheck(writer);
					
					log.info("결과값 = " + result);
					
					if(result == 1) {				
						return "fail";	// 중복 닉네임 존재				
					} else {
						return "success";	// 중복 닉네임 x				
					}					
				}
		
		// 회원가입 post
		@RequestMapping(value = "/board/register.do", method = RequestMethod.POST)
		public String postRegister(MemberVO vo) throws Exception {
			log.info("post register");
			
			memberService.register(vo);		
			return "/login";
		}
		
		// 로그인 get
		@RequestMapping(value = "/board/login.do", method = RequestMethod.GET)
			public String getLogin() throws Exception {
				log.info("get login");
				return "login";
			}		
	
		// 로그인 post
		@RequestMapping(value = "/board/login.do", method = RequestMethod.POST)
		public String login(MemberVO vo, Model model ,HttpServletRequest req) throws Exception{
			log.info("post login");
			
			HttpSession session = req.getSession();
			MemberVO login = memberService.login(vo);			
			String mem_id = null;
			
			if(login == null) { // 틀리면
				session.setAttribute("member", null);
				model.addAttribute("msg", false);
				log.info("login == null");
				return "login";
	
			}else {
				session.setAttribute("member",login);
				session.setAttribute("mem_id", login.getMem_id());
		
				System.out.println("mem_id=>"+mem_id);
				log.info("login != null");
			}		
			return  "redirect:/";		
		}

		// 로그아웃
		@RequestMapping(value = "/board/logout.do", method = RequestMethod.GET)
		public String logout(HttpSession session) throws Exception{		
			session.invalidate();		
			return "redirect:/";
		}
	 
		// 비밀번호 찾기 페이지로 이동
		@RequestMapping(value="/board/FindPassword.do",method = RequestMethod.GET)
		public String findPasswordView() throws Exception{
			log.info("get FindPassword");
			return "FindPassword";
		}
		
	    // 비밀번호 찾기 실행
		@RequestMapping(value="/board/find_password.do", method=RequestMethod.POST)
		public String findPasswordAction(MemberVO vo, Model model) {
			MemberVO user = memberService.findPassword(vo);
			
			log.info("post find_password");
			
			if(user == null) { 
				model.addAttribute("check", 1);
			} else { 
				model.addAttribute("check", 0);
				model.addAttribute("passwd", user.getPasswd());
			}
			
			return "FindPassword";
		}
	
		
		// 관리자 로그인 get
		@RequestMapping(value = "/board/manager.do", method = RequestMethod.GET)
		public String getLogin2() throws Exception {
			log.info("get login2");
			return "/manager";
		}		

		// 관리자 로그인 post
		@RequestMapping(value = "/board/manager.do", method = RequestMethod.POST)
		public String login2(MemberVO vo, Model model ,HttpServletRequest req) throws Exception{
			log.info("post login2");
			
			HttpSession session = req.getSession();
			MemberVO login2 = memberService.login2(vo);			

			if(login2 == null) { // 틀리면
				session.setAttribute("member2", null);
				model.addAttribute("msg2", false);
				log.info("login2 == null");
				return "manager";
	
			}else {
				session.setAttribute("member2",login2);
				session.setAttribute("manager_id", login2.getManager_id());//이부분빠져 있었음..(추가필요)
				log.info("login2 != null");
			}		
			return  "redirect:/";		
			
			}
			
		//회원수정을 할 데이터 불러오기
		@RequestMapping(value = "/board/findMemberView.do")
		public ModelAndView findMember(@RequestParam("mem_id") String mem_id) throws Exception {
			log.info("findMember() 호출됨=>"+mem_id);
			MemberVO member=memberService.updateMemberView(mem_id);
			return new ModelAndView("MyUpdate","member",member);//이동할 페이지, 키명,찾아서 전달할 레코드
		}
		
		//회원수정하는 경우
		//public String submit(@ModelAttribute("command") BoardCommand com, BindingResult result) {
		@RequestMapping(value = "/board/updateMember.do")
		public String submit(@ModelAttribute("member") MemberVO vo) throws Exception {//vo대신에 연결해서 사용될 객체명("member")
			log.info("submit()호출됨 ");
			memberService.updateMember(vo);
			return "redirect:/board/findMemberView.do?mem_id="+vo.getMem_id(); 
		}
	}

		
		
		
		
		
		
		
		
		

		




	

