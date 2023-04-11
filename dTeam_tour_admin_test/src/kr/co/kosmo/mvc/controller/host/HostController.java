package kr.co.kosmo.mvc.controller.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.HostDaoInter;

@Controller
@RequestMapping(value = "/host")
public class HostController {
	@Autowired
	private HostDaoInter hostdao;
	
	//회원가입 : signupForm으로 이동
	@GetMapping(value = "/hostSignup")
	public String hostsignUpForm() {
		return "host/hostSignup";
	}
	
	//회원가입 : Form에서 작성한 데이터 저장  => 메인으로 이동
	@PostMapping(value = "/signUpProcess")
	public void name1() {
		
	}
}
