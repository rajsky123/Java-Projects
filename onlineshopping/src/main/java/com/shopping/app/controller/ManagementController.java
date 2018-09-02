package com.shopping.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;
import com.shopping.app.dto.Product;
import com.shopping.app.productdao.ProductDao;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ProductDao productdao;
	
	@GetMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation)
	{
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct=new Product();
		
		//set few fields
		
		nProduct.setActive(true);
		nProduct.setSupplierId(1);
		mv.addObject("product", nProduct);
		
		if(operation!=null)
		if(operation.equals("product"))
		{
			mv.addObject("message", "Product submitted successfully!");
		}
		
		
		return mv;
	}
	
	//handle product submission
	@PostMapping("/products")
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,Model model)
	{
		//check for any errors
		if(result.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Product Submission Failed");
			return "page";
		}
		
		
		productdao.add(mProduct);
		//add a new product record
		return "redirect:/manage/products?operation=product";
	}
	
	
	//fetching all the categories for all the request
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categorydao.list();
	}
	
}
