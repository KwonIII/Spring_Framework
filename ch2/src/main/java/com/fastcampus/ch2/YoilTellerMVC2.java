package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC2 {// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	@RequestMapping("/getYoilMVC2")
//		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public ModelAndView main(@RequestParam(required=true)int year, 
			@RequestParam(required=true)int month, 
			@RequestParam(required=true)int day, Model model) throws IOException {

		//1. ModelAndView를 생성하고, 기본 뷰를 지정
		ModelAndView mv = new ModelAndView();
		// 1. 유효성 검사
//		if (!isValid(year, month, day))
//			return "yoilError";

		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		//3. 계산한 결과를 ModelAndView에 저장
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		//4. 결과를 보여줄 view를 지정
		mv.setViewName("yoil"); //뷰으 이름을 지정
		
		return mv;
		
//		return "yoil"; // /WEB-INF/views/yoil.jsp

	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
