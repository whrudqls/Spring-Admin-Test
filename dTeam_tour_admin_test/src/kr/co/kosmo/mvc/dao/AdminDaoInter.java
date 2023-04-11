package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.AdminDTO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.LoginLoggerDTO;

import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.SearchVO;

public interface AdminDaoInter {
	
/////////////////////////////////////////////////////////////////////
	
	public void addadmin(AdminDTO vo);// Insert�ϱ� ��ȯ x ���ڰ��� ����//admin ȸ������
	public AdminDTO login(AdminDTO vo); //admin login
	public int idcheck(String maid); //admin IdCheck
	public void addLoginLogging(MyLoginLoggerDTO vo);//admin Login_Log : AOP���� ���
	
/////////////////////////////////////////////////////////////////////	
	
	public MemberVO memjson(String mid);//json mem id üũ
    public List<MemberVO> memlistJson();//json ���	memList �̱�        
    
/////////////////////////////////////////////////////////////////////    
    
	public HostVO hojson(String hid);//json host id üũ
    public List<HostVO> holistJson();//json ���	hoList �̱�

/////////////////////////////////////////////////////////////////////  
    
	public int memgetCnt();//mem ����¡
	public List<MemberVO> memgetList(SearchVO vo);//mem ����¡ ����Ʈ
	
/////////////////////////////////////////////////////////////////////	
	
	public int hogetCnt();//ho ����¡
	public List<HostVO> hogetList(SearchVO vo);//ho ����¡ ����Ʈ
	
/////////////////////////////////////////////////////////////////////
	
    public void addnotice(NoticeVO vo);//�������� �߰�
    public List<NoticeVO> noticeList(); //����Ʈ ����    
    public void noticeDel(int num); //Delete
    public NoticeVO noticeDetail(int num); //Detail	   
	public void noticeModify(NoticeVO vo); //Update
	public int noticegetCnt();//notice ����¡
	public List<NoticeVO> noticegetList(SearchVO vo);//notice ����¡ ����Ʈ
	
/////////////////////////////////////////////////////////////////////	
	


}
