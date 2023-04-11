package kr.co.kosmo.mvc.controller.json;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.kosmo.mvc.dao.AdminDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;

//@Controller -> 스트링 컨테이너가 Model로 선택해서 
//현재 시스템에서는 InternalResourceViewResolver를 통해서 지정한
//view로 forward 방식으로 이동한다.
//@RestController -> CustomView를 사용해서 지정한 view를 즉,
//jsp를 사용하지 않고 데이터를 응답할 수 있기 때문에 
//주로 JSON으로 response할 때 주로 사용함
//JSON과 같은 데이터를 서비스하기 위한 컨트롤러이다. - ajax에 서 사용


@RestController // 단순한 메시지만 다루기 위해
public class jsonRestController {
	
	@Autowired
	private AdminDaoInter adminDaoInter;
	/*
	// 해당 요청이 오면 가상 view에다가 반환 받은 값을 전달해서 응답 처리를 해준다
	// produces = "text/html;charset=euc-kr" => Content-Type을 지정하는 속성	
	*/
	
	// json object type -> javascript object로  변환
	// 키 값을 때버리는게 제이슨 파스
	// 서버측 제이슨 파스 는 name:'a' 자바로 바꾸면 'name':'a'	
	// application/json 제이슨으로	나타내주라는 뜻
	@RequestMapping(value = "/memJsonview", produces = "application/json;charset=utf-8")//맴버 dept제이슨 데모//맴버 한명을 선택시 그 맴버에 대한 디테일이 나온다
	public MemberVO memJsonObject(String mid) {
		try {
			System.out.println("mid => " + mid);
			MemberVO vo = adminDaoInter.memjson(mid);
			System.out.println(vo);
			return vo;
		} catch (Exception e) {
			MemberVO vo = new MemberVO();
			vo.setMid("없음");
			return vo;
		}
	}

	//모델앤 뷰가 없는 이유?
	//원래 Controller는 모델 앤 뷰를 이용해서 forward를 이용해 바로 경로를 지정해줬지만	
	//@RestController -> CustomView를 사용해서 지정한 view를 즉,
	//jsp를 사용하지 않고 데이터를 응답할 수 있기 때문에 
	//주로 JSON으로 response할 때 주로 사용함
	//ajax과 햇갈리지 않기 - ajaxsms 자바스크립 영역에서 다룸
	@RequestMapping(value = "/memListJsonview", produces = "application/json;charset=utf-8")//맴버 제이슨 리스트 데모//클릭을 하면 맴버목록이 다 나온다
	public List<MemberVO> memListJson() {			
		List<MemberVO> list = adminDaoInter.memlistJson();		
		return list;
	}
	
	@RequestMapping(value = "/hoJsonview", produces = "application/json;charset=utf-8")//맴버 dept제이슨 데모//맴버 한명을 선택시 그 맴버에 대한 디테일이 나온다
	public HostVO hoJsonObject(String hid) {
		try {
			System.out.println("hid => " + hid);
			HostVO vo = adminDaoInter.hojson(hid);
			System.out.println(vo);
			return vo;
		} catch (Exception e) {
			HostVO vo = new HostVO();
			vo.setHid("없음");
			return vo;
		}	
	}
	
	@RequestMapping(value = "/hoListJsonview", produces = "application/json;charset=utf-8")//맴버 제이슨 리스트 데모//클릭을 하면 맴버목록이 다 나온다
	public List<HostVO> hoListJson() {			
		List<HostVO> list = adminDaoInter.holistJson();		
		return list;
	}

}
