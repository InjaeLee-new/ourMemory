package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;

@Controller
public class MemberLoginController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = ourMemoryService.memberLogin(request.getParameter("id"));
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=loginPro");
		
		// servlet에서 session 관리를 위해 선언
		HttpSession session = request.getSession();
		if(result > 0) {
			session.setAttribute("isLogin", "login!");
		} else {
			session.setAttribute("isLogin", null);
		}
		
		return modelAndView;
	}
}
