package com.zayd.omikujiform;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/omikuji")
	public String index(Model model) {
//		int[] nums = new int[21];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=5; i<=25; i++) {
			nums.add(i);
//			int j = 0;
//			nums[j] = i;
//			j++;
		}
		
		//Add nums to your view model here
		model.addAttribute("numsFromMyController", nums);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processLogin(@RequestParam(value="number") Integer number, 
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="creature") String creature,
			@RequestParam(value="comment") String comment, HttpSession session) {
			
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("creature", creature);
			session.setAttribute("comment", comment);
			
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping(value="/omikuji/show") 
	public String omikuji(HttpSession session, Model model) {
//		model.addAttribute("number", (Integer) session.getAttribute("number"));
//		model.addAttribute("city", session.getAttribute("city"));
//		model.addAttribute("person", session.getAttribute("person"));
//		model.addAttribute("hobby", session.getAttribute("hobby"));
//		model.addAttribute("creature", session.getAttribute("creature"));
//		model.addAttribute("comment", session.getAttribute("comment"));
		return "omikuji.jsp";
		
	}
	
	

}
