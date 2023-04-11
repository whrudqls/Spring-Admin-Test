package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.NoticeVO;

@Repository
public class NoticeDao implements NoticeInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addnotice(NoticeVO vo) {
		ss.insert("notice.add", vo);
	}

	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = ss.selectList("notice.list");
		return list;
	}
	
	@Override
	public void del(int num) {
		ss.delete("notice.del", num);		
	}
	
	@Override
	public NoticeVO detail(int num) {		
		return ss.selectOne("notice.detail", num);
	}	

	@Override
	public void modify(NoticeVO vo) {
		ss.update("notice.modify",vo);				
	}

}
