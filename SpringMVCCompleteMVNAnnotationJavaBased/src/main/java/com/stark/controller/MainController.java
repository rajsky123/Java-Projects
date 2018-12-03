package com.stark.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stark.dao.StudentDao;
import com.stark.model.StudentDetail;


@Controller
@Component

public class MainController {
	
	@Autowired
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@RequestMapping("/")
	public String homePage(){
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		

		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if(logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");
		
		return "login";
	}
	
	@RequestMapping(value ="/loginSuccess")
	public ModelAndView loginSuccess(){
		ModelAndView mv= new ModelAndView("welcome");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			StudentDetail student = studentDao.loginStudent(auth.getName());
			
			mv.addObject("student", student);		
		return mv;
	}

	@RequestMapping("/register")
	public String regPage(Model model){
		model.addAttribute("student",new StudentDetail());
		return "register";
	}
	
	@RequestMapping("/registerSuccess")
	public ModelAndView registerSuccess(@ModelAttribute("student") StudentDetail student){
		student.setEnabled(true);
		student.setRole("ADMIN");
		getStudentDao().registerStudent(student);
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	@ModelAttribute
	public void headerMessage(Model model)
	{
	  model.addAttribute("headerMessage","welcome to stark technology");
	  List<String> graduationType=new ArrayList<String>();
	  graduationType.add("B.TECH");
	  graduationType.add("M.TECH");
	  graduationType.add("PHD");
	  graduationType.add("M.SC");
	  graduationType.add("MCA");
	  
	  List<String> stream=new ArrayList<String>();
	  stream.add("CSE"); 
	  stream.add("EEE");
	  stream.add("ECE");
	  stream.add("MEC");
	  stream.add("CHE");
	  
	  model.addAttribute("graduationType",graduationType);
	  model.addAttribute("stream",stream);
	}
}
