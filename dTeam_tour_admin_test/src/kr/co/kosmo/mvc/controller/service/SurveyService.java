package kr.co.kosmo.mvc.controller.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.kosmo.mvc.dao.AdminDao;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

//컨드롤러에서 Dao대신에 선언! => 트랜잭션 처리를 위해 단위처리!
//Dao에 두 메서드를 Service로 묶기
@Service//aop(관점지향프로그래밍)을 이용해 비지니스 로직과 핵심 로직을 분리해서 사용
public class SurveyService {
    @Autowired
    private AdminDao adminDao;

    //<tx:annotation-driven transaction-manager="tm"/> => @Transactional
    //@Transactional 적용 후 각각 메서드 적용 후 commit됨!
    //모델에서 받아온 각 데이터를 Dao에 각각 전달해서 단위처리를 하기위한 메서드

    @Transactional//트랜잭션 처리(단위) -  공통 로직 뺀것 (한 방에 커밋 롤백 하려고 )
    public void addSurvey(SurveyVO vo,List<SurveyContentVO> list) {
    	adminDao.addSurvey(vo); //commit X
    	adminDao.addSurveyContent(list); //commit X
        //commit됨!
    }
    

    public List<SurveyVO> listSurvey() {//리스트 뽑기
        return adminDao.listSurvey();
    }

    
    //관리자가 보는 설문조사 디테일(유저가 어떤 항목을 선택했는지 등 -> 파이널로 쿼리문은 어느정도 있음
    public SurveyVO adminDetail(int num) {
        return adminDao.surveyDetail(num);
    }

    @Transactional//서베이 수정
    public void updateSurveyCntck(SurveyContentVO subvo, SurveyCheckVO scvo) {
    	adminDao.updateSurveyCnt(subvo);
    	adminDao.addsc(scvo);
    }
    
    
}