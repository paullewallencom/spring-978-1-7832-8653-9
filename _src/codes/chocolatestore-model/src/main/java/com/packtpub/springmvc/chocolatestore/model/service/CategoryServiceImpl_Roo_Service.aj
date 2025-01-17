// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.packtpub.springmvc.chocolatestore.model.service;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CategoryServiceImpl_Roo_Service {
    
    declare @type: CategoryServiceImpl: @Service;
    
    declare @type: CategoryServiceImpl: @Transactional;
    
    public long CategoryServiceImpl.countAllCategorys() {
        return Category.countCategorys();
    }
    
    public void CategoryServiceImpl.deleteCategory(Category category) {
        category.remove();
    }
    
    public Category CategoryServiceImpl.findCategory(Long id) {
        return Category.findCategory(id);
    }
    
    public List<Category> CategoryServiceImpl.findAllCategorys() {
        return Category.findAllCategorys();
    }
    
    public List<Category> CategoryServiceImpl.findCategoryEntries(int firstResult, int maxResults) {
        return Category.findCategoryEntries(firstResult, maxResults);
    }
    
    public void CategoryServiceImpl.saveCategory(Category category) {
        category.persist();
    }
    
    public Category CategoryServiceImpl.updateCategory(Category category) {
        return category.merge();
    }
    
}
