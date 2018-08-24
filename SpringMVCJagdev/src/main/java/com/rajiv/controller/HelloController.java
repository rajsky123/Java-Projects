package com.rajiv.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController{

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/hello.jagdev")
	public ModelAndView hello(@RequestParam("nm") String myName,@RequestParam("pl") String myPlace)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", myName);
		mv.addObject("place",myPlace);
		mv.setViewName("welcome");
		return mv;
	}

}
