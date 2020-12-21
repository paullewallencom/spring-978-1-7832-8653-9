package com.packtpub.springmvc.chocolatestore.model.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.packtpub.springmvc.chocolatestore.model.Product;

@RooService(domainTypes = { com.packtpub.springmvc.chocolatestore.model.Product.class })
public interface ProductService {
	public List<Product> getFeaturedProducts();
	
}
