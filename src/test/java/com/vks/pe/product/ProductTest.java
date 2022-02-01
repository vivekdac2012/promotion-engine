package com.vks.pe.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.vks.pe.model.Product;

/**
 * @author Vksingh
 */
public class ProductTest {
    
    @Test
    public void testProductCreation() {
        
        Product product = new Product("A", 50);
        Assertions.assertEquals(50, product.getPrice());
        Assertions.assertEquals("A", product.getName());
        Assertions.assertNotNull(product, "Unable to create a product instance.");
    
    }
    
}