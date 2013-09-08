package com.datapine.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.datapine.domain.User;

@Controller
public class HomeController {

	/**
	 * Called at the start of Application and return Login page.
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView showWelcome() {
		return new ModelAndView("login");
	}
	
	/**
	 * Render User Registration page. 
	 * @return
	 */
	@RequestMapping(value = "/registered")
	public ModelAndView registerUserPage() {
		ModelAndView modelAndView = new ModelAndView("user_registration");
		modelAndView.addObject("user_registration", new User());
		return modelAndView;
	}
	
}
