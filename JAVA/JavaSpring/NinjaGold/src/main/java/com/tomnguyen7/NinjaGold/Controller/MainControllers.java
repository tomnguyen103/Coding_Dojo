package com.tomnguyen7.NinjaGold.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {
	@GetMapping("/Gold")
	public String index(HttpSession session) {
		if(session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/process_money")
	public String process(@RequestParam("client_choice") String location, HttpSession session) {
		Random randomNum = new Random();
		Integer num = 0;
		
		if(location.equals("farm")) {
			num = randomNum.nextInt(20-10+1)+10;
		}else if(location.equals("cave")) {
			num = randomNum.nextInt(10-5+1)+5;
		}else if(location.equals("house")) {
			num = randomNum.nextInt(5-2+1)+2;
		}else if(location.equals("casino")) {
			num = randomNum.nextInt(50+50+1)-50;
		}
		session.setAttribute("totalGold", (Integer) session.getAttribute("totalGold")+num); 
		System.out.println(num);
		
		return "redirect:/Gold";
	}
	
}
