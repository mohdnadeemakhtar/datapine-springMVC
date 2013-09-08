package com.datapine.web.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.datapine.domain.User;
import com.datapine.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(String email, String password,
			HttpSession session) {
		ModelAndView modelAndView = null;
		User userMessage = null;
		User user = userService.login(email, password);
		if (user != null) {
			modelAndView = new ModelAndView("home");
			userMessage = user;
			session.setAttribute("userID", user.getId());
		} else {
			modelAndView = new ModelAndView("login");
			userMessage = null;
		}
		modelAndView.addObject("userMessage", userMessage);
		return modelAndView;
	}

	@RequestMapping(value = "/user/add/process", method = RequestMethod.POST)
	public ModelAndView registerUser(String email, String password, String userName, String gender, HttpSession session) {
		User user = userService.register(email, password, userName, gender);
		ModelAndView modelAndView = null;
		if(null != user){
			modelAndView = new ModelAndView("home");
			session.setAttribute("userID", user.getId());
			modelAndView.addObject("userMessage", user);
			return modelAndView;
		}
		modelAndView = new ModelAndView("user_registration");
		modelAndView.addObject("user_registration", new User());
		return modelAndView;
	}

	@RequestMapping(value = "/user/list")
	public ModelAndView listUsers(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		Iterator<User> users = userService.listOfUsers();
		modelAndView.addObject("users", IteratorUtils.toList(users));
		modelAndView.addObject("userID", session.getAttribute("userID"));
		return modelAndView;
	}

	@RequestMapping(value = "/user/home/{id}", method = RequestMethod.GET)
	public ModelAndView userHomePage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		User user = userService.getUser(id.longValue());
		modelAndView.addObject("userMessage", user);
		return modelAndView;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUser(id.longValue());
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/update/{id}", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute User user, @PathVariable Integer id,HttpSession session) {
		System.out.println("Update user " +session.getAttribute("userID"));
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		userService.updateUser(user);
		String message = "User was successfully edited.";
		Iterator<User> users = userService.listOfUsers();
		modelAndView.addObject("users", IteratorUtils.toList(users));
		modelAndView.addObject("userID", session.getAttribute("userID"));
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		userService.deleteUser(id.longValue());
		String message = "User was successfully deleted.";
		Iterator<User> users = userService.listOfUsers();
		modelAndView.addObject("users", IteratorUtils.toList(users));
		modelAndView.addObject("userID", session.getAttribute("userID"));
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("login");
		session.invalidate();
		userService.logout();
		modelAndView.addObject("message", "Successfully Logout !");
		return modelAndView;
	}


}
