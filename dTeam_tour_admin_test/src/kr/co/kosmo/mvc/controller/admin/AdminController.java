package kr.co.kosmo.mvc.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.AdminDao;
import kr.co.kosmo.mvc.dao.AdminDaoInter;
import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.AdminDTO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.SearchVO;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminDaoInter adminDaoInter;
	
	@Autowired
	private SurveyService surveyservice;
	
	@Autowired
	private AdminDao adminDao;

	// ==========================page처리하기=======================
	private int nowPage = 1; // 현재 페이지 값 -> 메뉴페이지와 연동되는 변수
	private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block
	private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
	private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
	private int totalPage; // 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock; // 전체 블럭 수
	private int beginPerPage; // 각 페이지별 시작 게시물의 index값
	private int endPerPage;
	// ==========================================================

	// adminSignUpForm 회원가입으로 이동
	@GetMapping(value = "/adminSignUpForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("admin/adminSignUpForm");
		return mav;
	}

	// 회원가입 성공시 main으로 넘어감
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(AdminDTO vo) {
		adminDaoInter.addadmin(vo);
		// ModelAndView mav = new ModelAndView("main/mainbody");
		return "redirect:/main";
	}
	
/////////////////////////////////////////////////////////////////////////////

	// requestMapping을 하는 이유: search일 경우 post로 올 수 있기 때문에 method를 설정하지 않음
	@RequestMapping("/memboardList")
	public String memBoardList(Model model, String cPage, SearchVO vo) {
		System.out.println("********************************");
		String searchValue = vo.getSearchValue();
		String searchType = vo.getSearchType();
		totalRecord = adminDaoInter.memgetCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);
		// nowPage의 값에서 SQL문의 #{begin} , #{end} 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// 데이터 전송해보기
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<MemberVO> list = adminDaoInter.memgetList(vo);
		// 페이지 블록안에 페이지 반복 시키기 위한 startPage , endPage를 구해서
		// view로 전달해야 함.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage의 연산의 범위가 우리가 구한 totalPage값 미만이라면
		// totalPage의 값으로 대입시킨다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View에 forward로 전송할 데이터
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("searchType", searchType);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock);
		model.addAttribute("totalPage", totalPage);
		return "member/memList";
	}

/////////////////////////////////////////////////////////////////////////////
	
	// requestMapping을 하는 이유: search일 경우 post로 올 수 있기 때문에 method를 설정하지 않음
	@RequestMapping("/hoboardList")
	public String hoBoardList(Model model, String cPage, SearchVO vo) {
		System.out.println("********************************");
		String searchValue = vo.getSearchValue();
		String searchType = vo.getSearchType();
		totalRecord = adminDaoInter.hogetCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);
		// nowPage의 값에서 SQL문의 #{begin} , #{end} 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// 데이터 전송해보기
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<HostVO> list = adminDaoInter.hogetList(vo);
		// 페이지 블록안에 페이지 반복 시키기 위한 startPage , endPage를 구해서
		// view로 전달해야 함.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage의 연산의 범위가 우리가 구한 totalPage값 미만이라면
		// totalPage의 값으로 대입시킨다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View에 forward로 전송할 데이터
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("searchType", searchType);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock);
		model.addAttribute("totalPage", totalPage);
		return "host/hostList";
	}

/////////////////////////////////////////////////////////////////////////////	
	
	// ModelAndView 버전
	@RequestMapping(value = "/addnotice") // noticeaddform 실행 후 리스트로 넘어감
	public ModelAndView addnoticet(NoticeVO vo) {
		ModelAndView mav = new ModelAndView("notice/noticeList");// 모델 뷰에 이동 뷰 경로 셋
		adminDaoInter.addnotice(vo);// addnotice 안에 들어있는 vo를 인터에 저장
		List<NoticeVO> list = adminDaoInter.noticeList();
		mav.addObject("list", list); // request.setAttribute 같은 기능//모델뷰(이동할 뷰에) 리스트 때려 넣음
		System.out.println("공지 추가하고 리스트로 넘어감");
		return mav;// void가 아닌 반환형이 모델뷰이기에 반환해줌
	}
	
	@GetMapping(value = "/noticelist")	
	public ModelAndView noticelist() {
		List<NoticeVO> list = adminDaoInter.noticeList();
		ModelAndView mav = new ModelAndView("notice/noticeList");		
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping(value = "/noticeaddform") // 글을 작성하는 뷰(폼)
	public String noticeform() {
		System.out.println("글작성하는 곳입니다");
		return "notice/noticeaddForm";
	}

	@RequestMapping(value = "/noticeDetail")
	public String noticecDetail(Model m, int num) {
		NoticeVO vo = adminDaoInter.noticeDetail(num);
		m.addAttribute("vo", vo);
		return "notice/noticeDetail";
	}
	
	@RequestMapping(value = "/noticedelete")
	public String noticeDelete(int num) {
		adminDaoInter.noticeDel(num);
		System.out.println("공지 삭제하고 리스트로 넘어감");
		return "redirect:noticelist";//반환할 url 설정
	}

	@GetMapping(value = "/noticeupdateForm") // 수정할 것들 적는 뷰(폼)
	public ModelAndView noticeUpdateForm(int num) {
		ModelAndView mav = new ModelAndView("notice/updateForm");
		mav.addObject("num",num);
		System.out.println("수정하기 폼으로 넘어옴");
		return mav;
	}

	@RequestMapping("/updateProcess")
	public String update(NoticeVO vo) {
		adminDaoInter.noticeModify(vo);	
		System.out.println("수정 후 리스트로 넘어감");
		return "redirect:noticelist";
	}
	
	// requestMapping을 하는 이유: search일 경우 post로 올 수 있기 때문에 method를 설정하지 않음
	@RequestMapping("/noticeboardList")
	public String noticeBoardList(Model model, String cPage, SearchVO vo) {
		System.out.println("********************************");
		String searchValue = vo.getSearchValue();
		String searchType = vo.getSearchType();
		totalRecord = adminDaoInter.noticegetCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);
		// nowPage의 값에서 SQL문의 #{begin} , #{end} 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// 데이터 전송해보기
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<NoticeVO> list = adminDaoInter.noticegetList(vo);
		// 페이지 블록안에 페이지 반복 시키기 위한 startPage , endPage를 구해서
		// view로 전달해야 함.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage의 연산의 범위가 우리가 구한 totalPage값 미만이라면
		// totalPage의 값으로 대입시킨다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View에 forward로 전송할 데이터
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("searchType", searchType);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock);
		model.addAttribute("totalPage", totalPage);
		return "notice/noticeList";
	}
	
/////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/surveyForm")//설문조사 추가해주는 뷰(폼) - 어드민
	public String surform() {
		return "survey/surveyAddform";
	}

	@RequestMapping(value = "/addsurvey")//설문조사 추가 후 리스트로 가기
	//설문등록 후 등록하기 누르면 실행 - 어드민
	//트랜잭션으로 survey테이브라 surveycontent테이블(Insert All)에 같이 들어감
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		//httpHttpServletRequest request : 폼에서 surveytitle 넘어올때 파라미터값 받기위해
		String[] surveytitle = request.getParameterValues("surveytitle"); //subtitle을 배열로 저장
		
		//DB에 전달하기 위한 List 만들기
		List<SurveyContentVO> list = new ArrayList<>();
		char stype = 'A';
		for (String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle : "+e);
			list.add(sv);
			stype++; //알파벳 증가
		}
		System.out.println("제목(Sub) : "+vo.getSub());		
		//surveyVO에 설문 타이틀을 저장한 List<SurveyContentVO> 인자로 전달
		vo.setSubvey(list);
		
		//service에 값 전달 => DB에 연결됨!
		surveyservice.addSurvey(vo, list);		
		ModelAndView mav = new ModelAndView("redirect:surveylist");
		return mav;
	}
	
	@RequestMapping(value = "/surveylist")//설문조사 리스트
	//어드민은 수정 삭제시 필요 ,맴버는 참여시 필요
    public ModelAndView surveylist() {
        ModelAndView mav = new ModelAndView("survey/surveyList");
        List<SurveyVO> list = surveyservice.listSurvey();
        mav.addObject("list", list);
        return mav;
	}
	
	@RequestMapping(value = "/surveyAdminDetail")//설문조사 관리자 디테일
    public ModelAndView surveyDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        System.out.println("어드민 디테일 작동");
        return mav;
	}

	
	//맴버가 설문조사 하나를 제출했을 시 디테일 페이지로 이동
	//리스트에서 제목에 하이퍼링크 걸려 있음<th><a href="surveyDetail?num=${e.num }">${e.num }<a/></th>
	//관리자가 보는 설문조사 디테일(유저가 어떤 항목을 선택했는지 등 -> 파이널로 쿼리문은 어느정도 있음
	@RequestMapping(value = "/surveyDetail")
    public ModelAndView surveyClientDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);        
        return mav;
	}
	

	@PostMapping(value = "/addSurveyClient")//서비스의 트랜잭션 처리된 메서드 호출, 설문조사 컨텐츠 선택 후 리스트로 가기
	//클라이언트가 설문조사 응답시 선택한것을 볼 수 있는 것 - 어드민
    public String clientSurveyAdd(Model m, SurveyContentVO subvo, SurveyCheckVO scvo) {
		int cnt = adminDao.surveycheck(scvo);
		System.out.println(cnt);
		if(cnt==0) {
			System.out.println("Subcode : "+subvo.getSubcode());
			System.out.println("Subtype : " + subvo.getSubtype());
			System.out.println("Scid : " + scvo.getScid());
			System.out.println("Sccode : " + scvo.getSccode());
			System.out.println("Subtype : "+ scvo.getSubtype());
			surveyservice.updateSurveyCntck(subvo,scvo);			
		}else {
			System.out.println("else에 걸림");
		}
		 return "redirect:surveylist";
	}
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////
	
	
}
