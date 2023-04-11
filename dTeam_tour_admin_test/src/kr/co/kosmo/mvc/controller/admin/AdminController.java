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

	// ==========================pageó���ϱ�=======================
	private int nowPage = 1; // ���� ������ �� -> �޴��������� �����Ǵ� ����
	private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block
	private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
	private int numPerPage = 10; // �� �������� ������ �Խù� ��
	private int pagePerBlock = 5; // �� ���� ������ ������ ��
	private int totalPage; // ��ü ������ �� => totalRecord/numPerPage
	private int totalBlock; // ��ü �� ��
	private int beginPerPage; // �� �������� ���� �Խù��� index��
	private int endPerPage;
	// ==========================================================

	// adminSignUpForm ȸ���������� �̵�
	@GetMapping(value = "/adminSignUpForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("admin/adminSignUpForm");
		return mav;
	}

	// ȸ������ ������ main���� �Ѿ
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(AdminDTO vo) {
		adminDaoInter.addadmin(vo);
		// ModelAndView mav = new ModelAndView("main/mainbody");
		return "redirect:/main";
	}
	
/////////////////////////////////////////////////////////////////////////////

	// requestMapping�� �ϴ� ����: search�� ��� post�� �� �� �ֱ� ������ method�� �������� ����
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
		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<MemberVO> list = adminDaoInter.memgetList(vo);
		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
		// view�� �����ؾ� ��.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View�� forward�� ������ ������
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
	
	// requestMapping�� �ϴ� ����: search�� ��� post�� �� �� �ֱ� ������ method�� �������� ����
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
		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<HostVO> list = adminDaoInter.hogetList(vo);
		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
		// view�� �����ؾ� ��.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View�� forward�� ������ ������
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
	
	// ModelAndView ����
	@RequestMapping(value = "/addnotice") // noticeaddform ���� �� ����Ʈ�� �Ѿ
	public ModelAndView addnoticet(NoticeVO vo) {
		ModelAndView mav = new ModelAndView("notice/noticeList");// �� �信 �̵� �� ��� ��
		adminDaoInter.addnotice(vo);// addnotice �ȿ� ����ִ� vo�� ���Ϳ� ����
		List<NoticeVO> list = adminDaoInter.noticeList();
		mav.addObject("list", list); // request.setAttribute ���� ���//�𵨺�(�̵��� �信) ����Ʈ ���� ����
		System.out.println("���� �߰��ϰ� ����Ʈ�� �Ѿ");
		return mav;// void�� �ƴ� ��ȯ���� �𵨺��̱⿡ ��ȯ����
	}
	
	@GetMapping(value = "/noticelist")	
	public ModelAndView noticelist() {
		List<NoticeVO> list = adminDaoInter.noticeList();
		ModelAndView mav = new ModelAndView("notice/noticeList");		
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping(value = "/noticeaddform") // ���� �ۼ��ϴ� ��(��)
	public String noticeform() {
		System.out.println("���ۼ��ϴ� ���Դϴ�");
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
		System.out.println("���� �����ϰ� ����Ʈ�� �Ѿ");
		return "redirect:noticelist";//��ȯ�� url ����
	}

	@GetMapping(value = "/noticeupdateForm") // ������ �͵� ���� ��(��)
	public ModelAndView noticeUpdateForm(int num) {
		ModelAndView mav = new ModelAndView("notice/updateForm");
		mav.addObject("num",num);
		System.out.println("�����ϱ� ������ �Ѿ��");
		return mav;
	}

	@RequestMapping("/updateProcess")
	public String update(NoticeVO vo) {
		adminDaoInter.noticeModify(vo);	
		System.out.println("���� �� ����Ʈ�� �Ѿ");
		return "redirect:noticelist";
	}
	
	// requestMapping�� �ϴ� ����: search�� ��� post�� �� �� �ֱ� ������ method�� �������� ����
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
		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// map.put("begin", beginPerPage);
		// map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		List<NoticeVO> list = adminDaoInter.noticegetList(vo);
		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
		// view�� �����ؾ� ��.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);
		// View�� forward�� ������ ������
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
	
	@RequestMapping(value = "/surveyForm")//�������� �߰����ִ� ��(��) - ����
	public String surform() {
		return "survey/surveyAddform";
	}

	@RequestMapping(value = "/addsurvey")//�������� �߰� �� ����Ʈ�� ����
	//������� �� ����ϱ� ������ ���� - ����
	//Ʈ��������� survey���̺�� surveycontent���̺�(Insert All)�� ���� ��
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		//httpHttpServletRequest request : ������ surveytitle �Ѿ�ö� �Ķ���Ͱ� �ޱ�����
		String[] surveytitle = request.getParameterValues("surveytitle"); //subtitle�� �迭�� ����
		
		//DB�� �����ϱ� ���� List �����
		List<SurveyContentVO> list = new ArrayList<>();
		char stype = 'A';
		for (String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle : "+e);
			list.add(sv);
			stype++; //���ĺ� ����
		}
		System.out.println("����(Sub) : "+vo.getSub());		
		//surveyVO�� ���� Ÿ��Ʋ�� ������ List<SurveyContentVO> ���ڷ� ����
		vo.setSubvey(list);
		
		//service�� �� ���� => DB�� �����!
		surveyservice.addSurvey(vo, list);		
		ModelAndView mav = new ModelAndView("redirect:surveylist");
		return mav;
	}
	
	@RequestMapping(value = "/surveylist")//�������� ����Ʈ
	//������ ���� ������ �ʿ� ,�ɹ��� ������ �ʿ�
    public ModelAndView surveylist() {
        ModelAndView mav = new ModelAndView("survey/surveyList");
        List<SurveyVO> list = surveyservice.listSurvey();
        mav.addObject("list", list);
        return mav;
	}
	
	@RequestMapping(value = "/surveyAdminDetail")//�������� ������ ������
    public ModelAndView surveyDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        System.out.println("���� ������ �۵�");
        return mav;
	}

	
	//�ɹ��� �������� �ϳ��� �������� �� ������ �������� �̵�
	//����Ʈ���� ���� �����۸�ũ �ɷ� ����<th><a href="surveyDetail?num=${e.num }">${e.num }<a/></th>
	//�����ڰ� ���� �������� ������(������ � �׸��� �����ߴ��� �� -> ���̳η� �������� ������� ����
	@RequestMapping(value = "/surveyDetail")
    public ModelAndView surveyClientDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);        
        return mav;
	}
	

	@PostMapping(value = "/addSurveyClient")//������ Ʈ����� ó���� �޼��� ȣ��, �������� ������ ���� �� ����Ʈ�� ����
	//Ŭ���̾�Ʈ�� �������� ����� �����Ѱ��� �� �� �ִ� �� - ����
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
			System.out.println("else�� �ɸ�");
		}
		 return "redirect:surveylist";
	}
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////
	
	
}
