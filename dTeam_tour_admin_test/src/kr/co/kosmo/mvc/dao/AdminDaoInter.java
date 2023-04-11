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
	
	public void addadmin(AdminDTO vo);// Insert니깐 반환 x 인자값만 있음//admin 회원가입
	public AdminDTO login(AdminDTO vo); //admin login
	public int idcheck(String maid); //admin IdCheck
	public void addLoginLogging(MyLoginLoggerDTO vo);//admin Login_Log : AOP에서 사용
	
/////////////////////////////////////////////////////////////////////	
	
	public MemberVO memjson(String mid);//json mem id 체크
    public List<MemberVO> memlistJson();//json 사용	memList 뽑기        
    
/////////////////////////////////////////////////////////////////////    
    
	public HostVO hojson(String hid);//json host id 체크
    public List<HostVO> holistJson();//json 사용	hoList 뽑기

/////////////////////////////////////////////////////////////////////  
    
	public int memgetCnt();//mem 페이징
	public List<MemberVO> memgetList(SearchVO vo);//mem 페이징 리스트
	
/////////////////////////////////////////////////////////////////////	
	
	public int hogetCnt();//ho 페이징
	public List<HostVO> hogetList(SearchVO vo);//ho 페이징 리스트
	
/////////////////////////////////////////////////////////////////////
	
    public void addnotice(NoticeVO vo);//공지사항 추가
    public List<NoticeVO> noticeList(); //리스트 보기    
    public void noticeDel(int num); //Delete
    public NoticeVO noticeDetail(int num); //Detail	   
	public void noticeModify(NoticeVO vo); //Update
	public int noticegetCnt();//notice 페이징
	public List<NoticeVO> noticegetList(SearchVO vo);//notice 페이징 리스트
	
/////////////////////////////////////////////////////////////////////	
	


}
