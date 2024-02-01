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
public class YoilTellerMVC4 {// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	@RequestMapping("/getYoilMVC4")
//		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(MyDate date, Model model) {

		//1. ModelAndView�� �����ϰ�, �⺻ �並 ����
//		ModelAndView mv = new ModelAndView();
		
		// 1. ��ȿ�� �˻�
		if (!isValid(date))
			return "yoilError";

		// 2. ���� ���
		char yoil = getYoil(date);
		
		//3. ����� ����� ModelAndView�� ����
		model.addAttribute("myDate",date);
		
		model.addAttribute("yoil",yoil);
		
		//4. ����� ������ view�� ����
		return "yoil"; // /WEB-INF/views/yoil.jsp

	}

	private boolean isValid(MyDate date) {
		
		return isValid(date.getYear(),date.getMonth(),date.getDay());
	}
	private boolean isValid(int year, int month, int day) {   
		// TODO Auto-generated method stub
		return true;
	}
	
	private char getYoil(MyDate date) {
		return getYoil(date.getYear(),date.getMonth(),date.getDay());
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}