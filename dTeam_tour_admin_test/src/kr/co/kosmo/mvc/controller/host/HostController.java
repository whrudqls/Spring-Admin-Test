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
	
	//ȸ������ : signupForm���� �̵�
	@GetMapping(value = "/hostSignup")
	public String hostsignUpForm() {
		return "host/hostSignup";
	}
	
	//ȸ������ : Form���� �ۼ��� ������ ����  => �������� �̵�
	@PostMapping(value = "/signUpProcess")
	public void name1() {
		
	}
}
