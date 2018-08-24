package com.rajiv.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController implements org.springframework.web.servlet.mvc.Controller{

	

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", req.getParameter("nm"));
		mv.addObject("place",req.getParameter("pl"));
		mv.setViewName("welcome");
		return mv;
	}

}
