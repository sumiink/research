package co.micol.prj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptClass implements HandlerInterceptor {

	@Override // controller동작전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String email = (String) session.getAttribute("email");
			if(email != null)
			return true;
		}
		System.out.println("로그인이 안됨");
		response.sendRedirect(request.getContextPath()+ "/login.do");
	return false;
	}

	@Override // controller동작후
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("컨트롤 동작 후  - preHandle");

	}

	@Override // view page 끝난후
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("뷰페이지 동작 후 - 잘동작되었당");
	}

}
