package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import kr.co.kosmo.mvc.dao.AdminDaoInter;
import kr.co.kosmo.mvc.vo.AdminDTO;


@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private AdminDaoInter adminInter;

	// �α��� : loginForm���� �̵�
	@RequestMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}

	
	@PostMapping(value = "/loginProcess") // ���� �α��� ���̺� ����� �αױ�ϵ� ������
	public ModelAndView loginfuckProcess(HttpSession session,HttpServletRequest request,AdminDTO vo,@RequestHeader("User-Agent") String userAgent) {
		AdminDTO dto = adminInter.login(vo);// �ٷ� ��� �Ұ��� �ϹǷ� dto�� �ְ� ����Ѵ�. => set
		// �α��� ���� ���� Ȯ���Ϸ��� �Ϻη� ������
		// 0,1�� ��ȯ�ϴ°�(������ ��Ʈ ������ �����-count) �ƴ϶� name,id �� ��ȯ��(���� �ɾ��ֱ�����)�̱⶧���� vo(dto)��
		// �����ϰ� �ذ���
		ModelAndView mav = new ModelAndView("main/mainbody");
		if (dto == null) {// �α��� ����
			System.out.println("����!!");
		} else {// �α��� ����
			session.setAttribute("sessionMaid", dto.getMaid());
			session.setAttribute("sessionMapwd", dto.getMapwd());
			System.out.println("����!!");
			System.out.println("sessionMaid : "+ dto.getMaid());
			System.out.println("sessionMapwd : "+ dto.getMapwd());
		}
		return mav;
	}

	// �α׾ƿ� : ��������� => Main���� �̵�
	@GetMapping(value = "/logoutProcess")
	public ModelAndView logoutfuckProcess(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionMaid");
		session.removeAttribute("sessionMapwd");
		System.out.println("�α׾ƿ�!!");

		return mav;
	}



}