package com.zayd.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zayd.dojosAndNinjas.models.Dojo;
import com.zayd.dojosAndNinjas.models.Ninja;
import com.zayd.dojosAndNinjas.services.DojoService;
import com.zayd.dojosAndNinjas.services.NinjaService;

@Controller
public class NinjasController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
//	I think this is the equivalent of autowired
//		private final NinjaService ninjaService;
//		
//		public NinjasController(NinjaService ninjaService) {
//			this.ninjaService = ninjaService;
//		}
	
//	Dojo add page
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/createDojo.jsp";
	}
	
//	Post method that adds the new dojo to the database
	@RequestMapping(value="/dojos/createnew", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo/error.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
//	Show all ninjas for a dojo
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo selectedDojo = dojoService.findDojo(id);
		List<Ninja> ninjas = selectedDojo.getNinjas();
		model.addAttribute("selectedDojo", selectedDojo);
//		model.addAttribute("ninjas", ninjas);
		return "ninjas/show.jsp";
	}
	
	
//	Ninjas ---------------------------------------
	
//	Form to craete a new ninja
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojosList = dojoService.allDojos();
		model.addAttribute("dojosList", dojosList);
		return "ninjas/createNinja.jsp";
	}
	
//	Post method to add the new ninja to the database
	@RequestMapping(value="/ninjas/createnew", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "ninjas/error.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	
	
	

}
