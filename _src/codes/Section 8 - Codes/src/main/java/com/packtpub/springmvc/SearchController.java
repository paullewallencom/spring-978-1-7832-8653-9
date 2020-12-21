package com.packtpub.springmvc;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/products")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	@Autowired
	ProductService productService;
	@Autowired 
	CategoryService categoryService; 
	@Autowired
    ProductSearchValidator productSearchValidator;
	
	
    @InitBinder  
    private void initBinder(WebDataBinder binder) {  
        binder.setValidator(productSearchValidator); 
        binder.setAllowedFields("name", "category");
    }
	
	@RequestMapping(value="/search")
	public String searchForm(Model model) {
		model.addAttribute("product", new Product());
		
        return "product/search";
    }
	
	@RequestMapping
	public String processSearch(@Valid Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "product/search";
		}
		
		List<Product> results = productService.findProducts(product);
		if (results.size() < 1) {
			bindingResult.rejectValue("name", "notFound", "Sorry, no results found");
            return "product/search";
        }
		if (results.size() == 1) {
			product = results.get(0);
            return "redirect:/products/product/" + product.getId();
		}
		else {
            model.addAttribute("results", results);
            return "product/search";
		}
        
    }
	
	@ModelAttribute("categories")
	public List<Category> fetchAllCategories() {
		return categoryService.getAllCategories();
	}
	

	
}
