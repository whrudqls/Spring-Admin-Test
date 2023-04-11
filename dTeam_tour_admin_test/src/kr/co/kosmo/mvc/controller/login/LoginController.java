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

	// 로그인 : loginForm으로 이동
	@RequestMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}

	
	@PostMapping(value = "/loginProcess") // 추후 로그인 테이블 만들면 로그기록도 가능함
	public ModelAndView loginfuckProcess(HttpSession session,HttpServletRequest request,AdminDTO vo,@RequestHeader("User-Agent") String userAgent) {
		AdminDTO dto = adminInter.login(vo);// 바로 사용 불가능 하므로 dto에 넣고 사용한다. => set
		// 로그인 성공 여부 확인하려고 일부러 구분함
		// 0,1을 반환하는게(뽑으면 인트 값으로 줘야함-count) 아니라 name,id 가 반환값(세션 심어주기위해)이기때문에 vo(dto)를
		// 생성하고 준거임
		ModelAndView mav = new ModelAndView("main/mainbody");
		if (dto == null) {// 로그인 실패
			System.out.println("실패!!");
		} else {// 로그인 성공
			session.setAttribute("sessionMaid", dto.getMaid());
			session.setAttribute("sessionMapwd", dto.getMapwd());
			System.out.println("성공!!");
			System.out.println("sessionMaid : "+ dto.getMaid());
			System.out.println("sessionMapwd : "+ dto.getMapwd());
		}
		return mav;
	}

	// 로그아웃 : 세션지우기 => Main으로 이동
	@GetMapping(value = "/logoutProcess")
	public ModelAndView logoutfuckProcess(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionMaid");
		session.removeAttribute("sessionMapwd");
		System.out.println("로그아웃!!");

		return mav;
	}



}