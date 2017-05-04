package com.jonathanpli.exceptionnull.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * This controller handles the routing for the /learn path which includes language selection, module
 * selection, and module editing.
 */
@Controller
@RequestMapping(value = "/learn")
public class LearnController {

	/**
	 * Log in using "/login?login=[password]"
	 * Log out using "/logout"
	 * Access this page using "/learn/[string]/[string]/edit
	 */
	@RequestMapping(value="{language}/{module}/edit")
	public ModelAndView getModuleForEditing(
			@PathVariable("language") String language,
			@PathVariable("module") String module,
			HttpServletRequest request) {
		if (request.getSession().getAttribute(IndexController.SESSION_IS_LOGGED_IN) == null) {
			throw new AccessDeniedException("You don't have permission to view that");
		}

		ModelAndView result = new ModelAndView();
		result.addObject("language", language)
				.addObject("module", module);
		result.setViewName("learn/edit");
		return result;
	}
}
