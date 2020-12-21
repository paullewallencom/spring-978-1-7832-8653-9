package com.packtpub.springmvc.chocolatestore.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packtpub.springmvc.chocolatestore.model.Product;

@Service
public class ProductServiceImpl implements ProductService {


	@Override
	public List<Product> getFeaturedProducts() {
		return Product.findProductsByFeatured(true).getResultList();
	}
}
