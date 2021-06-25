package co.micol.prj.survey.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.survey.vo.AnsweredData;

@Controller
@RequestMapping("/survey")		//호출시 survey 뒤에온다
public class SurveyController {
	@GetMapping
	public String form() {
		return "survey/surveyForm";
	}
	@PostMapping
//	public String submti(@ModelAttribute("ansData") AnsweredData data, AnsweredData data) {
	public String submti(Model model, AnsweredData data) {
		//db 저장 루틴을 처리한다.
		model.addAttribute("ansData", data);		//@ModelAttribute 동작시 없어도됨.
		return "survey/submitted";
	}
}
