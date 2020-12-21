package com.packtpub.springmvc.chocolatestore.model;
import java.util.Calendar;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "purchaseitem")
public class PurchaseItem {
	/**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     */
    @ManyToOne
    private Product product;

    /**
     */
    @NotNull
    private int quantity;

    /**
     */
    @ManyToOne
    private Purchase purchase;

}
