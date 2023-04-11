package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.co.kosmo.mvc.vo.AdminDTO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.SearchVO;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyCountVO;
import kr.co.kosmo.mvc.vo.SurveyVO;


//Dao단은 @Repository사용 = Dao를 빈으로 등록 시켜준다. => 자원 핸들링 영역에 특화되어  있음
//싱글톤으로

@Repository
public class AdminDao implements AdminDaoInter {
	@Autowired
	private SqlSessionTemplate ss; // kosmo-web.xml에 정의한 bean byname, setter필요 없음

	@Override // admin 회원가입
	public void addadmin(AdminDTO vo) {
		ss.insert("admin.addadmin", vo);
	}

	@Override // admin 회원가입 창에서 id중복 누르기
	public int idcheck(String maid) {
		return ss.selectOne("admin.idchk", maid);
	}

	@Override // admin 로그인
	public AdminDTO login(AdminDTO vo) {
		return ss.selectOne("admin.login", vo);
	}
/////////////////////////////////////////////////////////////////////
	
	@Override // admin 로그 기록 뽑기
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("admin.adlogin_in", vo);
	}
	
/////////////////////////////////////////////////////////////////////
	
	@Override//mem json id 검색
	public MemberVO memjson(String mid) {
		return ss.selectOne("admin.memjson",mid);
	}

	@Override//mem json 리스트
	public List<MemberVO> memlistJson() {
		List<MemberVO> list = ss.selectList("admin.memjsonlist");
		return list;
	}
///////////////////////////////////////////////////////////////////

	@Override//ho json id 검색
	public HostVO hojson(String hid) {		
		return ss.selectOne("admin.hostjson",hid);
	}

	@Override//ho json 리스트
	public List<HostVO> holistJson() {		
		List<HostVO> list = ss.selectList("admin.hostjsonlist");
		return list;
	}
	
///////////////////////////////////////////////////////////////////
	
	@Override//mem search & page
	public int memgetCnt() {
		return ss.selectOne("admin.memtotalCount");
	}

	@Override//mem search & page
	public List<MemberVO> memgetList(SearchVO vo) {
		List<MemberVO> list = ss.selectList("admin.memlistpage",vo);
		return list;
	}

///////////////////////////////////////////////////////////////////
	
	@Override//ho search & page
	public int hogetCnt() {
		return ss.selectOne("admin.hototalCount");
	}

	@Override//ho search & page
	public List<HostVO> hogetList(SearchVO vo) {
		List<HostVO> list = ss.selectList("admin.holistpage",vo);
		return list;
	}

///////////////////////////////////////////////////////////////////	
	
	@Override
	public void addnotice(NoticeVO vo) {
		ss.insert("admin.addnotice", vo);
	}

	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = ss.selectList("admin.noticelist");
		return list;
	}
	
	@Override
	public void noticeDel(int num) {
		ss.delete("admin.noticedel", num);		
	}
	
	@Override
	public NoticeVO noticeDetail(int num) {		
		return ss.selectOne("admin.noticedetail", num);
	}	

	@Override
	public void noticeModify(NoticeVO vo) {
		ss.update("admin.noticecmodify",vo);				
	}
	
	@Override//notice search & page
	public int noticegetCnt() {
		return ss.selectOne("admin.noticetotalCount");
	}

	@Override//notice search & page
	public List<NoticeVO> noticegetList(SearchVO vo) {
		List<NoticeVO> list = ss.selectList("admin.noticelistpage",vo);
		return list;
	}	
	
///////////////////////////////////////////////////////////////////
	
    public void addSurvey(SurveyVO vo) {//설문조사 문항 추가
        ss.insert("admin.addsurvey", vo);
    }

    //subContent
    //insertAll => List
    //List로 보내서 SQL문에서 for문으로 하나씩 빼서 처리함
    public void addSurveyContent(List<SurveyContentVO> list) {
        ss.insert("admin.addcontent", list);
    }
  
    public List<SurveyVO> listSurvey() {//설문조사 리스트보기
        return ss.selectList("admin.listSurvey");
    }

    public SurveyVO surveyDetail(int num) {//설문조사 상세보기
        SurveyVO vo = ss.selectOne("admin.surveyDetail", num);
        List<SurveyContentVO> list = vo.getSubvey();
        System.out.println("SurveyContentVO Size"+list.size());
        return vo;
    }
   
    public void updateSurveyCnt(SurveyContentVO subvo) {//설문조사 수정하기
        ss.update("admin.updateSurveyCnt", subvo);
    }

    public void addsc(SurveyCheckVO scvo) {////클라이언트가 컨텐츠 선택하기// 트랜 잭션 처리 한 맵퍼 2개
        ss.insert("admin.addsurveychk", scvo);
    }
    public int surveycheck(SurveyCheckVO scvo) {//어떤 컨텐츠 선택했는지 확인// 트랜 잭션 처리 한 맵퍼 2개
        return ss.selectOne("admin.surveychk",scvo);
    }

    public SurveyCountVO getcount(int num) {//성비 구하기 
        return ss.selectOne("admin.genderc",num);
    }
    
///////////////////////////////////////////////////////////////////

}
