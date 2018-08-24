package com.stark.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stark.dao.StudentDao;
import com.stark.model.StudentDetail;
import com.stark.model.Studentcredential;


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
	
	@RequestMapping("/login")
	public String loginPage(Model model)
	{
		model.addAttribute("studentCredential",new Studentcredential() );
		return "login";
	}
	
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") Studentcredential studentCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		StudentDetail student = getStudentDao().loginStudent(studentCredential.getName(), studentCredential.getPassword());
		if(student!= null){
			modelAndView.addObject("student", student);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}

	@RequestMapping("/register")
	public String regPage(Model model){
		model.addAttribute("student",new StudentDetail());
		return "register";
	}
	
	@RequestMapping("/registerSuccess")
	public ModelAndView registerSuccess(@ModelAttribute("student") StudentDetail student){
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
