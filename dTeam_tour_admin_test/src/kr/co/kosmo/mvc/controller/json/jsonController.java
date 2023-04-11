package kr.co.kosmo.mvc.controller.json;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/josn")
public class jsonController {
/*
	@RequestMapping(value = "/mychart")
	public String chartForm() {
		return "chart/mychart";
	}
*/
	/*
	@RequestMapping(value = "/donutchart")
	public String donutchart() {
		return "chart/donutchart";
	}
*/
	
	@RequestMapping(value = "/memJson")
	public String memJson() {
		return "json/memJson";
	}

	@RequestMapping(value = "/memListJson")
	public String memListJson() {
		return "json/memListJson";
	}
	
	
	@RequestMapping(value = "/hoJson")
	public String hoJson() {
		return "json/hoJson";
	}

	@RequestMapping(value = "/hoListJson")
	public String hoListJson() {
		return "json/hoListJson";
	}
	
/*
	@RequestMapping(value = "/surveyDonutchartAjax")
	public String surveyDonutchartAjax() {
		
		return "chart/surveyDonutchartAjax";
	}
*/
}
