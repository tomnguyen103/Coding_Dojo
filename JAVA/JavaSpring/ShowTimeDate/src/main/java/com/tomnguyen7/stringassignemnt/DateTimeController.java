package com.tomnguyen7.stringassignemnt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateTimeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM, yyyy");
		Date currentDate = new Date();
//		System.out.println(currentDate);
		model.addAttribute("date", dateFormat.format(currentDate));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		
		DateFormat timeFormat = new SimpleDateFormat("HH:mm a");
		Date currentDate = new Date();
		model.addAttribute("time", timeFormat.format(currentDate));
		return "time.jsp";
	}

}
