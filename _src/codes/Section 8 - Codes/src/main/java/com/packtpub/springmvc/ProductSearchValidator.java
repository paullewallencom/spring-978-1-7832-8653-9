package com.packtpub.springmvc;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packtpub.springmvc.chocolatestore.model.Product;
@Component
public class ProductSearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);  
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		String name = product.getName();
        if (!StringUtils.hasLength(name) && product.getCategory() == null) {
            errors.rejectValue("name", "required", "Either name or category is required");
        } else if (product.getCategory() == null && name.trim().length() < 3) {
            errors.rejectValue("name", "tooShort", "Please enter at least 3 letters");
        }
	}
	
	
}
