package kr.co.kosmo.mvc.controller.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.kosmo.mvc.dao.AdminDao;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

//����ѷ����� Dao��ſ� ����! => Ʈ����� ó���� ���� ����ó��!
//Dao�� �� �޼��带 Service�� ����
@Service//aop(�����������α׷���)�� �̿��� �����Ͻ� ������ �ٽ� ������ �и��ؼ� ���
public class SurveyService {
    @Autowired
    private AdminDao adminDao;

    //<tx:annotation-driven transaction-manager="tm"/> => @Transactional
    //@Transactional ���� �� ���� �޼��� ���� �� commit��!
    //�𵨿��� �޾ƿ� �� �����͸� Dao�� ���� �����ؼ� ����ó���� �ϱ����� �޼���

    @Transactional//Ʈ����� ó��(����) -  ���� ���� ���� (�� �濡 Ŀ�� �ѹ� �Ϸ��� )
    public void addSurvey(SurveyVO vo,List<SurveyContentVO> list) {
    	adminDao.addSurvey(vo); //commit X
    	adminDao.addSurveyContent(list); //commit X
        //commit��!
    }
    

    public List<SurveyVO> listSurvey() {//����Ʈ �̱�
        return adminDao.listSurvey();
    }

    
    //�����ڰ� ���� �������� ������(������ � �׸��� �����ߴ��� �� -> ���̳η� �������� ������� ����
    public SurveyVO adminDetail(int num) {
        return adminDao.surveyDetail(num);
    }

    @Transactional//������ ����
    public void updateSurveyCntck(SurveyContentVO subvo, SurveyCheckVO scvo) {
    	adminDao.updateSurveyCnt(subvo);
    	adminDao.addsc(scvo);
    }
    
    
}