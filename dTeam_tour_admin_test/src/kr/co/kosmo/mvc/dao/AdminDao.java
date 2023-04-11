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


//Dao���� @Repository��� = Dao�� ������ ��� �����ش�. => �ڿ� �ڵ鸵 ������ Ưȭ�Ǿ�  ����
//�̱�������

@Repository
public class AdminDao implements AdminDaoInter {
	@Autowired
	private SqlSessionTemplate ss; // kosmo-web.xml�� ������ bean byname, setter�ʿ� ����

	@Override // admin ȸ������
	public void addadmin(AdminDTO vo) {
		ss.insert("admin.addadmin", vo);
	}

	@Override // admin ȸ������ â���� id�ߺ� ������
	public int idcheck(String maid) {
		return ss.selectOne("admin.idchk", maid);
	}

	@Override // admin �α���
	public AdminDTO login(AdminDTO vo) {
		return ss.selectOne("admin.login", vo);
	}
/////////////////////////////////////////////////////////////////////
	
	@Override // admin �α� ��� �̱�
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("admin.adlogin_in", vo);
	}
	
/////////////////////////////////////////////////////////////////////
	
	@Override//mem json id �˻�
	public MemberVO memjson(String mid) {
		return ss.selectOne("admin.memjson",mid);
	}

	@Override//mem json ����Ʈ
	public List<MemberVO> memlistJson() {
		List<MemberVO> list = ss.selectList("admin.memjsonlist");
		return list;
	}
///////////////////////////////////////////////////////////////////

	@Override//ho json id �˻�
	public HostVO hojson(String hid) {		
		return ss.selectOne("admin.hostjson",hid);
	}

	@Override//ho json ����Ʈ
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
	
    public void addSurvey(SurveyVO vo) {//�������� ���� �߰�
        ss.insert("admin.addsurvey", vo);
    }

    //subContent
    //insertAll => List
    //List�� ������ SQL������ for������ �ϳ��� ���� ó����
    public void addSurveyContent(List<SurveyContentVO> list) {
        ss.insert("admin.addcontent", list);
    }
  
    public List<SurveyVO> listSurvey() {//�������� ����Ʈ����
        return ss.selectList("admin.listSurvey");
    }

    public SurveyVO surveyDetail(int num) {//�������� �󼼺���
        SurveyVO vo = ss.selectOne("admin.surveyDetail", num);
        List<SurveyContentVO> list = vo.getSubvey();
        System.out.println("SurveyContentVO Size"+list.size());
        return vo;
    }
   
    public void updateSurveyCnt(SurveyContentVO subvo) {//�������� �����ϱ�
        ss.update("admin.updateSurveyCnt", subvo);
    }

    public void addsc(SurveyCheckVO scvo) {////Ŭ���̾�Ʈ�� ������ �����ϱ�// Ʈ�� ��� ó�� �� ���� 2��
        ss.insert("admin.addsurveychk", scvo);
    }
    public int surveycheck(SurveyCheckVO scvo) {//� ������ �����ߴ��� Ȯ��// Ʈ�� ��� ó�� �� ���� 2��
        return ss.selectOne("admin.surveychk",scvo);
    }

    public SurveyCountVO getcount(int num) {//���� ���ϱ� 
        return ss.selectOne("admin.genderc",num);
    }
    
///////////////////////////////////////////////////////////////////

}
