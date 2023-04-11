package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	//Aop가 적용되어서 /main/index.jsp에서 ${today} 사용 가능 !
	@RequestMapping(value= {"/","/main"})
	public ModelAndView main() {
		//return "main/index";
		ModelAndView mav = new ModelAndView("main/mainbody");
		return mav;
	}
}
