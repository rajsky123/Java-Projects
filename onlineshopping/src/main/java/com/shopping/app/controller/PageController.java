package com.shopping.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;
import com.shopping.app.dto.Product;
import com.shopping.app.exception.ProductNotFoundException;
import com.shopping.app.productdao.ProductDao;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ProductDao productdao;

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
	
	/*viewing a single product */
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView getSingleProduct(@PathVariable("id") int id)throws ProductNotFoundException
	{
		ModelAndView mv=new ModelAndView("page");
		
		Product product=productdao.get(id);
		
		if(product==null)throw new ProductNotFoundException();
		
		//set the view count
		product.setViews(product.getViews()+1);
		
		//update the view count
		productdao.update(product);
		//---------------------------
		
		mv.addObject("title",product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;

}
	
}
