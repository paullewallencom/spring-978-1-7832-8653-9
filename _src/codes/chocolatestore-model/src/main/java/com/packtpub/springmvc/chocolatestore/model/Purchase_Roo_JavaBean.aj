// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.packtpub.springmvc.chocolatestore.model;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.Purchase;
import com.packtpub.springmvc.chocolatestore.model.PurchaseItem;
import java.util.Calendar;
import java.util.List;

privileged aspect Purchase_Roo_JavaBean {
    
    public Calendar Purchase.getOrderDate() {
        return this.orderDate;
    }
    
    public void Purchase.setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
    
    public Customer Purchase.getOrderedBy() {
        return this.orderedBy;
    }
    
    public void Purchase.setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }
    
    public List<PurchaseItem> Purchase.getPurchaseItem() {
        return this.purchaseItem;
    }
    
    public void Purchase.setPurchaseItem(List<PurchaseItem> purchaseItem) {
        this.purchaseItem = purchaseItem;
    }
    
    public Boolean Purchase.getCompleted() {
        return this.completed;
    }
    
    public void Purchase.setCompleted(Boolean completed) {
        this.completed = completed;
    }
    
}
