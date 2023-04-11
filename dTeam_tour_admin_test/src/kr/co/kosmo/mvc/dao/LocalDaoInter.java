package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.LocalVO;

public interface LocalDaoInter {
	public void addlocalBoard (LocalVO vo); //Insert
	public List<LocalVO> getList (); //List
	public LocalVO detailLocal(int num); //Detail
	public void delLocal(int num); //Delete
	public void localmodify(LocalVO vo); //Update	
	public LocalVO chartForReview(int num); //¸®ºä¿ë Â÷Æ®	
}
