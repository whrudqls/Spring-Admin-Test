package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.HostVO;

@Repository
public class HostDao implements HostDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addHost(HostVO vo) {
		ss.insert("host.addhost", vo);
	}

}
