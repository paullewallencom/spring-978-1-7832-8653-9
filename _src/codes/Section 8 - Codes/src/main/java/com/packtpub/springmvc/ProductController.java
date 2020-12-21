package com.packtpub.springmvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product/create";
	}
	
	@RequestMapping(params = "ftl")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.findAllProducts());
		return "productlist";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "product/register";
		}
		productService.saveProduct(product);
		return "redirect:/products/product/" + product.getId();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "product/register";
		}
		productService.updateProduct(product);
		return "redirect:/products/product/" + product.getId();
	}
	@RequestMapping(value = "/product/{id}")
	public String getProduct(@PathVariable("id") Long productId,
			Map<String, Object> model) {
		Product product = productService.findProduct(productId);
		model.put("product", product);
		return "product/view";
	}
	
	@RequestMapping(value = "/product/{id}/edit", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") Long productId,
			Model model) {
		Product product = productService.findProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product/edit";
	}
	
	@RequestMapping(value = "/featured")
	public List<Product> getFeaturedProducts(Model model) {
		List<Product> featuredProducts = productService.getFeaturedProducts();
		model.addAttribute("products", featuredProducts);
		return featuredProducts;
	}
	
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("product/error");
	    return mav;
	  }

}
