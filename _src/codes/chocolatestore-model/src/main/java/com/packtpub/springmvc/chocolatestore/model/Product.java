package com.packtpub.springmvc.chocolatestore.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "product", finders = { "findProductsByFeatured"})
public class Product {

    /**
     */
    @NotNull
    @Size(max = 100)
    private String productName;

    /**
     */
    @NotNull
    @Size(max = 700)
    private String description;

    /**
     */
    @Size(max = 700)
    private String imagePath;

    /**
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    /**
     */
    private Boolean featured;

    /**
     */
    private double price;
}
