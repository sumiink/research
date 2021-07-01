package co.micol.prj.member.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		if (vo.getName() != null) {
			session.setAttribute("email", vo.getEmail());
			mv.addObject("message", "님 환영합니다ㅏㅏㅏㅏㅏㅏㅏㅏ.");
			mv.addObject("member", vo);
		} else {
			mv.addObject("message", "님 존재하지 않는 회원입니다.");
		}
		mv.setViewName("redirect:home");
		return mv;
	}

	@RequestMapping("memberList")
	public String memberList(Model model, @RequestParam(value = "state", defaultValue ="Y", required = false )String state) {
		model.addAttribute("members", memberDao.memberSelectList(state));
		return "member/memberList";
	}

	@RequestMapping("member/memberInsert")
	public String memberInsert() {
		return "member/memberInsert";
	}

	@RequestMapping("memberRegister.do")
	public String memberRegister(MemberVO vo, Model model) throws IOException,IllegalStateException {
		// 파일업로드 처리
		MultipartFile file = vo.getMultifile();
		String fileName = file.getOriginalFilename();
		//파일별명 만들기(파일 충돌대비) UUID
		UUID fileUuid = UUID.randomUUID();
		String aliasFileName = fileUuid.toString();
		vo.setFileUuid(aliasFileName); 		//파일 알리아스 명
		
		File target = new File("D:\\"+ aliasFileName);
		file.transferTo(target);						//파일저장
		//FileCopyUtils.copy(file.getBytes(),target); 	//파일저장
		vo.setFileName(fileName);
		vo.setFileUuid(aliasFileName);
			
		int n = memberDao.memberInsert(vo);
		String message = "";
		if (n != 0)
			message = "입력성공";
		else
			message = "입력실패";
		model.addAttribute("message", message);
		return "member/memberRegister";
	}
	
	@RequestMapping("fileDown.do")
	public String fileDown(@RequestParam("filePath")String filePath, 
			@RequestParam("fileName")String fileName, HttpServletResponse response) {
		System.out.println(filePath + "파일경로=======" + fileName);
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			file = new File("D:\\" + filePath);	//물리적위치 파일
			is = new FileInputStream(file);
			os = response.getOutputStream();
			fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setHeader("Content-Length","" +file.length());
			
			byte[]b = new byte[2048];
			int leng = 0;
			while((leng = is.read(b)) != -1) {
				os.write(b,0,leng);
			}
			is.close();
			os.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	     // System.out.println(filePath + "==============");
	      return "redirect:memberList";
	}
	
}
