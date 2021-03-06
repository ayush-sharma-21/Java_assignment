package com.greycampus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greycampus.entity.Customer;
import com.greycampus.service.CustomerService;

@Controller
@RequestMapping(path = "/find")
public class DispayController {

	@Autowired
	private CustomerService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String findCustomer() {
		return "findCustomerForm.jsp";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView findCustomerForm(Customer customer) {
//		if (errors.hasErrors()) {
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("findCustomerForm.jsp");
//			return modelAndView;
//		}
		List<Customer> customerList = employeeService.find(customer);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("findCustomer.jsp");
		modelAndView.addObject("customer", customerList);
		return modelAndView;
	}

}