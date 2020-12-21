package com.packtpub.springmvc;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("category", new Category());
		return "category/create";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "category/register";
		}
		categoryService.saveCategory(category);
		return "redirect:/categories/category/" + category.getId();
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") @Valid Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "category/register";
		}
		categoryService.updateCategory(category);
		return "redirect:/categories/category/" + category.getId();
	}
	@RequestMapping(value = "/category/{id}")
	public ModelAndView getCategory(@PathVariable("id") Long categoryId) {
		Category category = categoryService.findCategoryEagerly(categoryId);
		return new ModelAndView("category/view", "category", category);
		
	}
	
	@RequestMapping(value = "/category/{id}/edit", method = RequestMethod.GET)
	public String editCategory(@PathVariable("id") Long categoryId,
			Map<String, Object> model) {
		Category category = categoryService.findCategory(categoryId);
		model.put("category", category);
		return "category/edit";
	}

}
