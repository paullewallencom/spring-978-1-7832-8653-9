package com.packtpub.springmvc.chocolatestore.model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "purchase")
public class Purchase {
	
    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     */
    @ManyToOne
    private Customer orderedBy;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase")
    private List<PurchaseItem> purchaseItem = new ArrayList<PurchaseItem>();

    /**
     */
    private Boolean completed;
}
