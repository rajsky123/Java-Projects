package com.shopping.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categorydao;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categorydao.list());
		return mv;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*Method to show all products*/
	
	@RequestMapping(value= {"show/all/products"})
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		//passing a list of categories
		mv.addObject("categories", categorydao.list());
		return mv;
	}
	
	@RequestMapping(value= {"show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		//categoryDao a fetch a single category
		Category category=null;
		category=categorydao.getById(id);
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		//passing a list of categories
		mv.addObject("categories", categorydao.list());
		//passing a single category
		mv.addObject("category", category);
		return mv;
	}
	
}
