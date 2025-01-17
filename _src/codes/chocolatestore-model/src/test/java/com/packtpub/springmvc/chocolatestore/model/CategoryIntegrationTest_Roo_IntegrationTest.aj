// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.packtpub.springmvc.chocolatestore.model;

import com.packtpub.springmvc.chocolatestore.model.CategoryDataOnDemand;
import com.packtpub.springmvc.chocolatestore.model.CategoryIntegrationTest;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CategoryIntegrationTest_Roo_IntegrationTest {
    
    declare @type: CategoryIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: CategoryIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: CategoryIntegrationTest: @Transactional;
    
    @Autowired
    CategoryDataOnDemand CategoryIntegrationTest.dod;
    
    @Autowired
    CategoryService CategoryIntegrationTest.categoryService;
    
    @Test
    public void CategoryIntegrationTest.testCountAllCategorys() {
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", dod.getRandomCategory());
        long count = categoryService.countAllCategorys();
        Assert.assertTrue("Counter for 'Category' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void CategoryIntegrationTest.testFindCategory() {
        Category obj = dod.getRandomCategory();
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Category' failed to provide an identifier", id);
        obj = categoryService.findCategory(id);
        Assert.assertNotNull("Find method for 'Category' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Category' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void CategoryIntegrationTest.testFindAllCategorys() {
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", dod.getRandomCategory());
        long count = categoryService.countAllCategorys();
        Assert.assertTrue("Too expensive to perform a find all test for 'Category', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Category> result = categoryService.findAllCategorys();
        Assert.assertNotNull("Find all method for 'Category' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Category' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void CategoryIntegrationTest.testFindCategoryEntries() {
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", dod.getRandomCategory());
        long count = categoryService.countAllCategorys();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Category> result = categoryService.findCategoryEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Category' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Category' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void CategoryIntegrationTest.testFlush() {
        Category obj = dod.getRandomCategory();
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Category' failed to provide an identifier", id);
        obj = categoryService.findCategory(id);
        Assert.assertNotNull("Find method for 'Category' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyCategory(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Category' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void CategoryIntegrationTest.testUpdateCategoryUpdate() {
        Category obj = dod.getRandomCategory();
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Category' failed to provide an identifier", id);
        obj = categoryService.findCategory(id);
        boolean modified =  dod.modifyCategory(obj);
        Integer currentVersion = obj.getVersion();
        Category merged = categoryService.updateCategory(obj);
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Category' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void CategoryIntegrationTest.testSaveCategory() {
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", dod.getRandomCategory());
        Category obj = dod.getNewTransientCategory(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Category' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Category' identifier to be null", obj.getId());
        try {
            categoryService.saveCategory(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'Category' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void CategoryIntegrationTest.testDeleteCategory() {
        Category obj = dod.getRandomCategory();
        Assert.assertNotNull("Data on demand for 'Category' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Category' failed to provide an identifier", id);
        obj = categoryService.findCategory(id);
        categoryService.deleteCategory(obj);
        obj.flush();
        Assert.assertNull("Failed to remove 'Category' with identifier '" + id + "'", categoryService.findCategory(id));
    }
    
}
