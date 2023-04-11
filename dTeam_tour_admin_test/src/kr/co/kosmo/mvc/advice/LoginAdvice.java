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
//@Component ������̼��� �̿��ϸ� Bean Configuration ���Ͽ� Bean�� ���� ������� �ʾƵ� ����� �� �ִ�.
//�� �����ü�� �� Ŭ���� ��ü���ٰ� �� �� �ִٴ� �ǹ��̴�.
//@Component ������̼��� �⺻������ Ÿ�Ա���� �ڵ����� ������̼��̴�. 
//@Autowired, @Resource�� ����� ����� �����Ѵٰ� �� �� �ְڴ�.
@Aspect
//@Aspect ������̼��� �̿��ؼ� �������� ������ ����� �������ش�
//Aspect�� ���ȭ�ϰ� �ٽ����� ����Ͻ� �������� �и��Ͽ� �����ϰڴٴ� ���� AOP�� ������.
public class LoginAdvice {
	private String userAgent;
	@Autowired
	private AdminDaoInter adminDaoInter;
	@Around("execution(* kr.co.kosmo.mvc.controller.login.LoginController.loginfuck*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		System.out.println("���� 1");
		ModelAndView rpath = null;
		//�޼����� �̸��� �����ͼ� �α���, �α׾ƿ� ����
		String methodName= jp.getSignature().getName();
		System.out.println("method : "+methodName);		
		//step2 ) joinpoint�� ���� Ÿ�� ��ü�� �Ӹ޼����� ���ڰ� �޾ƿ���
		Object[] fd = jp.getArgs();
		//for(Object e : fd) {
		//	System.out.println(e.getClass().getName());
		//}
		if(methodName.equals("loginfuckProcess")) {			
			try {
				rpath = (ModelAndView) jp.proceed();//login �޼��� ȣ��
			} catch (Throwable e) {
				e.printStackTrace();
			}			
			//getArgs : ���� ,request,DTO,userAgent - 3�� 
			HttpSession session = (HttpSession) fd[0];
			userAgent = (String) fd[3];			
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			String uid = (String) session.getAttribute("sessionMaid");
			System.out.println("agent : "+userAgent);
			System.out.println("reip : "+userAgent);
			System.out.println("uid : "+uid);
			//�α��� ������ DB�� �ֱ�
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setAdlogid(uid);
			System.out.println("vo.setAdlogid(uid) : "+vo.getAdlogid());
			vo.setAdlogstatus("login");
			System.out.println("vo.setAdlogstatus(login) : "+vo.getAdlogstatus());
			vo.setAdlogip(reip);			
			vo.setAdlogagent(userAgent);			
			adminDaoInter.addLoginLogging(vo);
		}else if (methodName.equals("logoutfuckProcess")) {
			//getArgs : ����,request -2��	
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionMaid");
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			//�α׾ƿ� ������ DB�� �ֱ�
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setAdlogid(uid);
			vo.setAdlogstatus("logout");
			vo.setAdlogip(reip);
			vo.setAdlogagent(userAgent);
			adminDaoInter.addLoginLogging(vo);			
			try {
				rpath = (ModelAndView) jp.proceed();//logout �޼��� ȣ��
			} catch (Throwable e) {
				e.printStackTrace();
			}			
		}
		System.out.println("���� 2");
		return rpath;
	}

}
