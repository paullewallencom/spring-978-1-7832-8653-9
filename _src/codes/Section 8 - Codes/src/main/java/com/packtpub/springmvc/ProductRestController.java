package com.packtpub.springmvc;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;
import com.packtpub.springmvc.beans.MessageRestBean;

@Controller
@RequestMapping("/api")
public class ProductRestController {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;


	@RequestMapping(value = "/categories/{categoryId}/products/{productId}")
	@ResponseBody
	public Product getProduct(@PathVariable("productId") Long productId) {
		Product product = productService.findProduct(productId);
		return product;
	}
	
	
	@RequestMapping(value = "/categories/{categoryId}/products")
	@ResponseBody
	public List<Product> getProducts(@PathVariable("categoryId") Long categoryId) { 
		Category category = categoryService.findCategoryEagerly(categoryId);
		return category.getProducts();
	}
	
	
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Error on server") 
	@ResponseBody
    public MessageRestBean handleDatabaseErrors() {
	    return new MessageRestBean("Database Error", "DBERR");
	  }
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
      public ResponseEntity<MessageRestBean> notFoundError(HttpServletRequest request, Exception e) {
		return new ResponseEntity<>(new MessageRestBean("No product found"), HttpStatus.NOT_FOUND);
	  }

}
