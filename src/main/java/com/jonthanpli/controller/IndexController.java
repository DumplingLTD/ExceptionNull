package com.jonthanpli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("example", "This is in the example");
		mav.setViewName("index");
		return mav;
	}
}
