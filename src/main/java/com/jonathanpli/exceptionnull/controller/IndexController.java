package com.jonathanpli.exceptionnull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Routes root and error pages to their respective URLs. Also contains the fallback case.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
	// TODO(#15): Remove when proper login/logout is implemented.
	private static final String PASSWORD = "omg it's a password!";
	public static final String SESSION_IS_LOGGED_IN = "user-is-logged-in";

	/**
	 * Fallback and index page routing.
	 * @return
	 */
	@RequestMapping(value = "*")
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	// TODO(#15): Remove when proper login/logout is implemented.
	/**
	 * A simple login
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(value = "login") String login,
			HttpServletRequest request) {
		if (login.equals(PASSWORD)) {
			request.getSession().setAttribute(SESSION_IS_LOGGED_IN, true);
		}
		return getIndex();
	}

	// TODO(#15): Remove when proper login/logout is implemented.
	/**
	 * A simple logout.
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute(SESSION_IS_LOGGED_IN);
		return getIndex();
	}
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard() {
		ModelAndView result = new ModelAndView();
		result.setViewName("dashboard");
		return result;
	}
}
