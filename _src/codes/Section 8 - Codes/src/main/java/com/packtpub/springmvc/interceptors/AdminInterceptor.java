package com.packtpub.springmvc.interceptors;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.packtpub.springmvc.chocolatestore.model.Customer;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	private List<String> adminUserIds = new ArrayList<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		logger.info("In preHandle");
		Customer loggedInUser = (Customer) request.getSession().getAttribute("loggedInUser");
		if (loggedInUser != null) {
			if (adminUserIds.contains(loggedInUser.getId())) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath());
		return false;
	}

	public List<String> getAdminUserIds() {
		return adminUserIds;
	}

	public void setAdminUserIds(List<String> adminUserIds) {
		this.adminUserIds = adminUserIds;
	}

}
