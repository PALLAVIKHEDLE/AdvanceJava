package com.apex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apex.beans.Order;
import com.apex.beans.User;
import com.apex.dao.OrderDAO;
import com.apex.service.UserService;

@Controller
public class applicationController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public ModelAndView userRegistration() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		modelAndView.addObject("message", "Welcome to User Registration!!");
		return modelAndView;
	}

	@RequestMapping(value = "/registrationSucceed", method = RequestMethod.POST)
	public ModelAndView registrationSucceed(@ModelAttribute User user) {
		String result = userService.registerUser(user);
		ModelAndView modelAndView = new ModelAndView();
		if (result == null) {
			modelAndView.setViewName("orderDetails");

			// Fetch the list of orders
			List<Order> orders = orderDAO.getAllOrders();

			// Add orders to the model
			modelAndView.addObject("orderList", orders);
			modelAndView.addObject("message",
					"Welcome, Registration Succeeded, now You have access for Order Details!!");
		} else {
			modelAndView.setViewName("registration");
			modelAndView.addObject("message", result);
		}
		return modelAndView;
	}
}
