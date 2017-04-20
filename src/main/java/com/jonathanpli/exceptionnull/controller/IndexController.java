package com.jonathanpli.exceptionnull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Routes root and error pages to their respective URLs. Also contains the fallback case.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	/**
	 * Fallback and index page routing.
	 * @return
	 */
	@RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST } )
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("title", "Exception Null");
		mav.addObject("description", "Exception Null is the new coding platform to teach you how to become a better programmer!");
		mav.setViewName("index");
		return mav;
	}
}
