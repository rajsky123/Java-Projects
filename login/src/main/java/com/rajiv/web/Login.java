package com.rajiv.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rajiv.web.db.Validate;;

@Controller
public class Login {
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("name") String name,@RequestParam("pass") String password) throws Exception
	{  ModelAndView mv=new ModelAndView();
	String qry="Welcome "+name;
		if(new Validate().check(name,password))
		{
		   mv.addObject("welc", qry);
		   mv.setViewName("welcome.jsp");
		   return mv;
		}
		mv.setViewName("index.jsp");
		return mv;
	}

}
