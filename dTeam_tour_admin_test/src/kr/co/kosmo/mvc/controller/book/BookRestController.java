package kr.co.kosmo.mvc.controller.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.vo.BookVO;

@RestController
public class BookRestController {
	@Autowired
	private BookService reservationsvc;

	// [{sub:연령대별~},Map]
	@RequestMapping(value = "/tourCountJson", produces = "application/json;charset=utf-8")
	public String tourCount(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = reservationsvc.tourCount(mnum);

		// 2. 제목 저장 => String
		String subject = "월 별 여행 비율";

		// 3. survey 데이터 저장 => Map
		// {2023-03:4},{2023-02:3}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<ReservationVO> 선언되었으므로 ReservationVO에 값 저장
		for (BookVO e : list) {
			// key : e.getSurveytitle()
			// value : e.getSurveycnt()
			map.put(e.getMonth(), e.getTcount());
		}

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {"2023-03":4},{"2023-02":3}...
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	
//수정예정==================================================================
/*	
	//예약리스트Top3
	@RequestMapping(value = "/reservlistTop3" , produces = "application/json;charset=utf-8")
	public String reservlistTop3(String mid) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = reservationsvc.reservlistTop3(mid);

		// 2. 예약Top3 데이터 저장 => Map
		// {예약 일시:~},{이용 일시:~},{이용 숙소:~}...
		Map<String, String> map = new HashMap<String, String>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<ReservationVO> 선언되었으므로 ReservationVO에 값 저장
		for (BookVO e : list) {
			// key : e.getSurveytitle()
			// value : e.getSurveycnt()
			//map.put("예약 일시", e.getRdate());
			//map.put("이용 일시S", e.getSday());
			map.put(e.getSday(), e.getEday());
			//map.put("이용 숙소", e.);
		}

		// 3. return반환 해줄 결과값 선언 => String
		String result = "";
		
		// 4. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "{\"name\" : \"" + result + "\"}";
			//result = "[{\"sub\":\"" +  + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return result;
	}
*/


}
