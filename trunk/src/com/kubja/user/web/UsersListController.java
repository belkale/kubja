package com.kubja.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.kubja.user.service.UserSecurity;
import com.kubja.user.service.UserManager;

public class UsersListController extends AbstractController {

	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("userslist");
		String login = UserSecurity.getLoggedInUser();
		mav.addObject("usersList", userManager.getAllUsers());
		mav.addObject("user", login);
		return mav;
	}

}
