// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.packtpub.springmvc.chocolatestore.model.service;

import com.packtpub.springmvc.chocolatestore.model.Purchase;
import com.packtpub.springmvc.chocolatestore.model.service.PurchaseServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PurchaseServiceImpl_Roo_Service {
    
    declare @type: PurchaseServiceImpl: @Service;
    
    declare @type: PurchaseServiceImpl: @Transactional;
    
    public long PurchaseServiceImpl.countAllPurchases() {
        return Purchase.countPurchases();
    }
    
    public void PurchaseServiceImpl.deletePurchase(Purchase purchase) {
        purchase.remove();
    }
    
    public Purchase PurchaseServiceImpl.findPurchase(Long id) {
        return Purchase.findPurchase(id);
    }
    
    public List<Purchase> PurchaseServiceImpl.findAllPurchases() {
        return Purchase.findAllPurchases();
    }
    
    public List<Purchase> PurchaseServiceImpl.findPurchaseEntries(int firstResult, int maxResults) {
        return Purchase.findPurchaseEntries(firstResult, maxResults);
    }
    
    public void PurchaseServiceImpl.savePurchase(Purchase purchase) {
        purchase.persist();
    }
    
    public Purchase PurchaseServiceImpl.updatePurchase(Purchase purchase) {
        return purchase.merge();
    }
    
}
