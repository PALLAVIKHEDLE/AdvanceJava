package com.apex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apex.beans.Student;
import com.apex.beans.User;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndview = new ModelAndView();

		modelAndview.setViewName("welcome");
		modelAndview.addObject("Message", "Welcome to Spring MVC Project!!");
		return modelAndview;
	}

	@RequestMapping(value = "/displayObject", method = RequestMethod.GET)
	public ModelAndView getObject() {
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.setViewName("showObject");
		User user = new User();
		user.setName("Ram");
		user.setAge("35");
		user.setCity("Fremont");

		modelAndview.addObject("user", user);
		return modelAndview;

	}

	@RequestMapping(value = "/showQueryParameter", method = RequestMethod.GET)
	public ModelAndView getQueryParameter(
			@RequestParam(value = "id", required = false, defaultValue = "RAM") String id) {
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.setViewName("queryParameter");
		modelAndview.addObject("Message", "Welcome to Spring MVC Project!!");
		modelAndview.addObject("id", id);
		return modelAndview;
	}

//	@RequestMapping(value = "/studentForm", method = RequestMethod.GET)
//	public ModelAndView studentForm() {
//		ModelAndView modelAndview = new ModelAndView();
//
//		modelAndview.setViewName("form");
//
//		return modelAndview;
//	}

	@RequestMapping(value = "/studentForm", method = RequestMethod.GET)
	public String studentForm(ModelMap modelMap) {
		modelMap.addAttribute("message", "This is Student Form ");

		return "form";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView modelAndview = new ModelAndView();

		modelAndview.setViewName("displayStudent");

		modelAndview.addObject("student", student);

		return modelAndview;
	}

}
