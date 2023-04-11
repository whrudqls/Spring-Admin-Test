package kr.co.kosmo.mvc.controller.json;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.kosmo.mvc.dao.AdminDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;

//@Controller -> ��Ʈ�� �����̳ʰ� Model�� �����ؼ� 
//���� �ý��ۿ����� InternalResourceViewResolver�� ���ؼ� ������
//view�� forward ������� �̵��Ѵ�.
//@RestController -> CustomView�� ����ؼ� ������ view�� ��,
//jsp�� ������� �ʰ� �����͸� ������ �� �ֱ� ������ 
//�ַ� JSON���� response�� �� �ַ� �����
//JSON�� ���� �����͸� �����ϱ� ���� ��Ʈ�ѷ��̴�. - ajax�� �� ���


@RestController // �ܼ��� �޽����� �ٷ�� ����
public class jsonRestController {
	
	@Autowired
	private AdminDaoInter adminDaoInter;
	/*
	// �ش� ��û�� ���� ���� view���ٰ� ��ȯ ���� ���� �����ؼ� ���� ó���� ���ش�
	// produces = "text/html;charset=euc-kr" => Content-Type�� �����ϴ� �Ӽ�	
	*/
	
	// json object type -> javascript object��  ��ȯ
	// Ű ���� �������°� ���̽� �Ľ�
	// ������ ���̽� �Ľ� �� name:'a' �ڹٷ� �ٲٸ� 'name':'a'	
	// application/json ���̽�����	��Ÿ���ֶ�� ��
	@RequestMapping(value = "/memJsonview", produces = "application/json;charset=utf-8")//�ɹ� dept���̽� ����//�ɹ� �Ѹ��� ���ý� �� �ɹ��� ���� �������� ���´�
	public MemberVO memJsonObject(String mid) {
		try {
			System.out.println("mid => " + mid);
			MemberVO vo = adminDaoInter.memjson(mid);
			System.out.println(vo);
			return vo;
		} catch (Exception e) {
			MemberVO vo = new MemberVO();
			vo.setMid("����");
			return vo;
		}
	}

	//�𵨾� �䰡 ���� ����?
	//���� Controller�� �� �� �並 �̿��ؼ� forward�� �̿��� �ٷ� ��θ� ������������	
	//@RestController -> CustomView�� ����ؼ� ������ view�� ��,
	//jsp�� ������� �ʰ� �����͸� ������ �� �ֱ� ������ 
	//�ַ� JSON���� response�� �� �ַ� �����
	//ajax�� �ް����� �ʱ� - ajaxsms �ڹٽ�ũ�� �������� �ٷ�
	@RequestMapping(value = "/memListJsonview", produces = "application/json;charset=utf-8")//�ɹ� ���̽� ����Ʈ ����//Ŭ���� �ϸ� �ɹ������ �� ���´�
	public List<MemberVO> memListJson() {			
		List<MemberVO> list = adminDaoInter.memlistJson();		
		return list;
	}
	
	@RequestMapping(value = "/hoJsonview", produces = "application/json;charset=utf-8")//�ɹ� dept���̽� ����//�ɹ� �Ѹ��� ���ý� �� �ɹ��� ���� �������� ���´�
	public HostVO hoJsonObject(String hid) {
		try {
			System.out.println("hid => " + hid);
			HostVO vo = adminDaoInter.hojson(hid);
			System.out.println(vo);
			return vo;
		} catch (Exception e) {
			HostVO vo = new HostVO();
			vo.setHid("����");
			return vo;
		}	
	}
	
	@RequestMapping(value = "/hoListJsonview", produces = "application/json;charset=utf-8")//�ɹ� ���̽� ����Ʈ ����//Ŭ���� �ϸ� �ɹ������ �� ���´�
	public List<HostVO> hoListJson() {			
		List<HostVO> list = adminDaoInter.holistJson();		
		return list;
	}

}
