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
		mav.addObject("example", "This is in the and  aaaaa");
		mav.addObject("profiles", "Go dfsdsfdfssdfdsfdfsdfs!!!");
		mav.setViewName("index");
		return mav;
	}
}
