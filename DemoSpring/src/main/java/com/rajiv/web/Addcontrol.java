package com.rajiv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Addcontrol {
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("p1") int i,@RequestParam("p1") int j)
	{   int k=i+j;
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", k);
		mv.setViewName("result.jsp");
		return mv;
	}

}
