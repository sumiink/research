package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberDao;
	
	@RequestMapping("loginConfirm.do")
	public ModelAndView loginConfirm(MemberVO vo, HttpSession session, ModelAndView mv) {
		vo = memberDao.loginCheck(vo);
		if(vo.getName() != null) {
			session.setAttribute("email", vo.getEmail());
			mv.addObject("message","님 환영합니다ㅏㅏㅏㅏㅏㅏㅏㅏ.");
			mv.addObject("member", vo);
		}else {
			mv.addObject("message","님 존재하지 않는 회원입니다.");
		}
		mv.setViewName( "redirect:home");
		return mv;
	}
	
}
