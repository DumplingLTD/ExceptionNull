package com.jonthanpli.exceptionnull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Autowired
	Environment env;

	@RequestMapping
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("example", "This is in the and  aaaaa");
		mav.addObject("profiles", "Go dfsdsfdfssdfdsfdfsdfs!!!");
		mav.setViewName("index");
		return mav;
	}
}
