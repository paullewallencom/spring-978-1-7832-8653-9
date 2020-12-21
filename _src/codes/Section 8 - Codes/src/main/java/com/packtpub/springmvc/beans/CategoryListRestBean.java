package com.packtpub.springmvc.beans;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.packtpub.springmvc.CategoryRestController;

@XmlRootElement
public class CategoryListRestBean {
	private List<Category> categories = new ArrayList<>();
	
	public CategoryListRestBean(List<com.packtpub.springmvc.chocolatestore.model.Category> modelCategories) {
		
		for (com.packtpub.springmvc.chocolatestore.model.Category modelCategory : modelCategories ) {
			Category c = new Category();
			c.setName(modelCategory.getName());
			c.setDescription(modelCategory.getDescription());
			c.add(linkTo(CategoryRestController.class).slash(modelCategory.getId()).withSelfRel());
			categories.add(c);
		}
	}

	
	
	public List<Category> getCategories() {
		return categories;
	}



	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}



	public class Category extends ResourceSupport {
		
		private String name;

	    private String description;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
}
