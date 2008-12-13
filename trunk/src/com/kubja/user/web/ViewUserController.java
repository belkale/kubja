package com.kubja.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.kubja.user.domain.User;
import com.kubja.user.service.UserManager;

public class ViewUserController extends AbstractController {
	private UserManager userManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse resp) throws Exception {
		String login = request.getParameter("id");
		User u = userManager.getUserByLogin(login);
		if(u == null){
			throw new IllegalArgumentException("Invalid user login " + login);
		}
		
		ModelAndView mav = new ModelAndView("viewuser");
		mav.addObject("user", u);
		return mav;
	}

}
