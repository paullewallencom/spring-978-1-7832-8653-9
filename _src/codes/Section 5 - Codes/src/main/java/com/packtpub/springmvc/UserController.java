package com.packtpub.springmvc;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("user", new Customer());
		return "customer/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "customer/register";
		}
		customerService.saveCustomer(customer);
		return "redirect:/users/user/" + customer.getUserId();
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") @Valid Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "customer/register";
		}
		customerService.updateCustomer(customer);
		return "redirect:/users/user/" + customer.getUserId();
	}
	@RequestMapping(value = "/user/{userId}")
	public String getUserProfile(@PathVariable("userId") String userId,
			Map<String, Object> model) {
		Customer customer = customerService.findCustomer(userId);
		model.put("user", customer);
		return "customer/view";
	}
	
	@RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.GET)
	public String editUserProfile(@PathVariable("userId") String userId,
			Map<String, Object> model) {
		Customer customer = customerService.findCustomer(userId);
		model.put("user", customer);
		return "customer/edit";
	}

}