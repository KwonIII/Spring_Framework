package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC5 {// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	@RequestMapping("/getYoilMVC5")
//	public String main(@ModelAttribute("myDate") MyDate date, Model model) {	//�Ʒ��� ����
		public String main(@ModelAttribute MyDate date, Model model) {

	
		
		// 1. ��ȿ�� �˻�
		if (!isValid(date))
			return "yoilError";

		// 2. ���� ���
//		char yoil = getYoil(date);
		
		//3. ����� ����� Model�� ����
//		model.addAttribute("myDate",date);
//		model.addAttribute("yoil",yoil);
		
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
	
	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(),date.getMonth(),date.getDay());
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}