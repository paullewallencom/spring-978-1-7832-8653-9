package com.packtpub.springmvc.chocolatestore.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "category")
public class Category {
	
    /**
     */
    @NotNull
    @Size(max = 100)
    private String name;

    /**
     */
    @NotNull
    @Size(max = 700)
    private String description;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products = new ArrayList<Product>();
}
