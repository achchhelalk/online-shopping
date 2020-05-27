package net.kzm.onlineshopping.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;



@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		System.out.println("Tfd");
		ModelAndView mv = new ModelAndView("page");
		System.out.println("Tfd");
		mv.addObject("title","Home");
		System.out.println("Tfd"+categoryDAO.list());
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome",true);	

		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");	
		mv.addObject("userClickAbout",true);	

		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");	
		mv.addObject("userClickContact",true);	

		return mv;
	}

	/*
	 * Method to load all the products
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");

		//passing the list of categories
			mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts",true);	

		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//Fetch a single category
			Category category=null;
		category = categoryDAO.get(id);
		mv.addObject("title",category.getName());

		//passing the list of categories
			mv.addObject("categories", categoryDAO.list());

		//passing single of categories
			mv.addObject("category", category);
			System.out.println("Category:"+category.getName());
		mv.addObject("userClickcategoryProducts",true);	

		return mv;
	}
	/*@RequestMapping(value ="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting) {
		if (greeting==null) {
			greeting="hello value is taken";
		}
		ModelAndView iv = new ModelAndView("page");
		mv.addObject("greeting",greeting);	

	//	return iv;
	}
	 */

	/*@RequestMapping(value ="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if (greeting==null) {
			greeting="hello value is taken";
		}
		ModelAndView pa = new ModelAndView("page");
		mv.addObject("greeting",greeting);	

		//return pa;
		}
	 */
}



