package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.NoticeVO;

public interface NoticeInter {
    public void addnotice(NoticeVO vo);//�������� �߰�
    public List<NoticeVO> noticeList(); //����Ʈ ����    
    public void del(int num); //Delete
    public NoticeVO detail(int num); //Detail	   
	public void modify(NoticeVO vo); //Update
 }
