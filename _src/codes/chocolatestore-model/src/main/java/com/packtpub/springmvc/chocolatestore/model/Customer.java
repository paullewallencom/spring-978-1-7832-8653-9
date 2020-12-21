package com.packtpub.springmvc.chocolatestore.model;
import java.beans.Transient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "customer", finders = { "findCustomersByNameEquals" })
public class Customer {

    /**
     */
    @NotNull
    @Size(max = 100, min = 5)
    private String name;

    /**
     */
    @NotNull @Email
    private String email;

    /**
     */
    private String firstName;

    /**
     */
    private String lastName;

    /**
     */
    @NotNull
    private String password;

    /**
     */
    @Size(max = 20)
    private String phone;
    
    
    @Transient
    public String getUserID() {
    	return this.name;
    }
}
