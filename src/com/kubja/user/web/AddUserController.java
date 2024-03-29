package com.kubja.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.kubja.user.domain.Address;
import com.kubja.user.domain.User;
import com.kubja.user.service.UserSecurity;
import com.kubja.user.service.UserManager;

public class AddUserController extends SimpleFormController {
	private UserManager userManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User u = (User)command;
		User userDb = userManager.getUserByLogin(u.getLogin());
		if(userDb != null){
			String login = UserSecurity.getLoggedInUser();
			if(!login.equals(u.getLogin())){
				throw new AccessDeniedException(login + " not allowed to update " + u.getLogin());
			}
			userManager.updateUser(u);
		} else {
			userManager.addUser(u);
		}
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String username = request.getParameter("id");
		User u;
		if(username != null && !username.trim().isEmpty()){
			String login = UserSecurity.getLoggedInUser();
			if(!username.equals(login)){
				throw new AccessDeniedException(login + " not allowed to update " + username);
			}
			
			u = userManager.getUserByLogin(username);
			if(u == null){
				throw new IllegalArgumentException("Invalid id:" + username);
			}
			if(u.getAddress() == null){
				u.setAddress(new Address());
			}
		} else {
			u = new User();
		}
		return u;
	}
	
}
