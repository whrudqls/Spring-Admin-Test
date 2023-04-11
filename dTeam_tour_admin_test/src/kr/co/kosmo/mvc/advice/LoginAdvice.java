package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.AdminDaoInter;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

@Component
//@Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
//빈 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미이다.
//@Component 어노테이션은 기본적으로 타입기반의 자동주입 어노테이션이다. 
//@Autowired, @Resource와 비슷한 기능을 수행한다고 할 수 있겠다.
@Aspect
//@Aspect 어노테이션을 이용해서 공통으로 적용할 기능을 구현해준다
//Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재사용하겠다는 것이 AOP의 취지다.
public class LoginAdvice {
	private String userAgent;
	@Autowired
	private AdminDaoInter adminDaoInter;
	@Around("execution(* kr.co.kosmo.mvc.controller.login.LoginController.loginfuck*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		System.out.println("동작 1");
		ModelAndView rpath = null;
		//메서드의 이름을 가져와서 로그인, 로그아웃 구분
		String methodName= jp.getSignature().getName();
		System.out.println("method : "+methodName);		
		//step2 ) joinpoint로 부터 타켓 객체의 ㅣ메서드의 인자값 받아오기
		Object[] fd = jp.getArgs();
		//for(Object e : fd) {
		//	System.out.println(e.getClass().getName());
		//}
		if(methodName.equals("loginfuckProcess")) {			
			try {
				rpath = (ModelAndView) jp.proceed();//login 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}			
			//getArgs : 세션 ,request,DTO,userAgent - 3개 
			HttpSession session = (HttpSession) fd[0];
			userAgent = (String) fd[3];			
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			String uid = (String) session.getAttribute("sessionMaid");
			System.out.println("agent : "+userAgent);
			System.out.println("reip : "+userAgent);
			System.out.println("uid : "+uid);
			//로그인 정보를 DB에 넣기
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setAdlogid(uid);
			System.out.println("vo.setAdlogid(uid) : "+vo.getAdlogid());
			vo.setAdlogstatus("login");
			System.out.println("vo.setAdlogstatus(login) : "+vo.getAdlogstatus());
			vo.setAdlogip(reip);			
			vo.setAdlogagent(userAgent);			
			adminDaoInter.addLoginLogging(vo);
		}else if (methodName.equals("logoutfuckProcess")) {
			//getArgs : 세션,request -2개	
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionMaid");
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			//로그아웃 정보를 DB에 넣기
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setAdlogid(uid);
			vo.setAdlogstatus("logout");
			vo.setAdlogip(reip);
			vo.setAdlogagent(userAgent);
			adminDaoInter.addLoginLogging(vo);			
			try {
				rpath = (ModelAndView) jp.proceed();//logout 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}			
		}
		System.out.println("동작 2");
		return rpath;
	}

}
