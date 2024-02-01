package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC {// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	@RequestMapping("/getYoilMVC")
//		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public ModelAndView main(@RequestParam(required=true)int year, 
			@RequestParam(required=true)int month, 
			@RequestParam(required=true)int day, Model model) throws IOException {

		//1. ModelAndView�� �����ϰ�, �⺻ �並 ����
		ModelAndView mv = new ModelAndView();
		// 1. ��ȿ�� �˻�
//		if (!isValid(year, month, day))
//			return "yoilError";

		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		
		//3. ����� ����� ModelAndView�� ����
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("day",day);
		mv.addObject("yoil",yoil);
		
		//4. ����� ������ view�� ����
		mv.setViewName("yoil"); //���� �̸��� ����
		
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
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}