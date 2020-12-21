package com.packtpub.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@RequestMapping("/users")
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	 @RequestMapping(params = "create")
	    public String createForm(Model uiModel) {
	        return "customer/register";
	    }

	

}
