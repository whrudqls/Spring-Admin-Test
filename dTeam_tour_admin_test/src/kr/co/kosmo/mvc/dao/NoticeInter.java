package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.NoticeVO;

public interface NoticeInter {
    public void addnotice(NoticeVO vo);//공지사항 추가
    public List<NoticeVO> noticeList(); //리스트 보기    
    public void del(int num); //Delete
    public NoticeVO detail(int num); //Detail	   
	public void modify(NoticeVO vo); //Update
 }
