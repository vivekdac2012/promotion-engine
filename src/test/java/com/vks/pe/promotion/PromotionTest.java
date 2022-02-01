package com.vks.pe.promotion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.vks.pe.model.Cart;
import com.vks.pe.model.Product;
import com.vks.pe.promotion.BundlePromotion;
import com.vks.pe.promotion.Promotion;
import com.vks.pe.promotion.SingleProductGroupPromotion;
import com.vks.pe.service.PromotionService;
import com.vks.pe.service.PromotionServiceImpl;
import com.vks.pe.util.PromotionUtil;

/**
 * @author Vksingh
 */
public class PromotionTest {
    
    private static PromotionService promotionService;
    private static List<Promotion> promotions;
    private static Cart cart;

    @BeforeAll
    public static void setup() {
        promotionService = new PromotionServiceImpl();
        promotions = PromotionUtil.setupPromotions();
        cart = new Cart();
    }

    @AfterAll
    public static void teardown() {
        cart.getContents().clear();
    }

    @Test
    public void testIsAvailableMethodOnPromotionsTrue() {
        Promotion promotion = new SingleProductGroupPromotion("A", 2, 90.0);
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(new Product("A"), 3);
        cart.setContents(testContents);
        assertTrue(promotion.isAvailable(cart), "This cart should contain items for this promotion.");
    }

    @Test
    public void testIsAvailableMethodOnPromotionsFalse() {
        Promotion promotion = new SingleProductGroupPromotion("A", 2, 90.0);
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(new Product("B"), 3);
        cart.setContents(testContents);
        assertFalse(promotion.isAvailable(cart), "This cart should not contain items for this promotion.");
    }

    @Test
    public void testIsAvailableMethodOnBundledPromotionsTrue() {
        Promotion promotion = new BundlePromotion(Arrays.asList("A", "B"), 30.0);
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(new Product("A"), 3);
        testContents.put(new Product("B"), 1);
        cart.setContents(testContents);
        assertTrue(promotion.isAvailable(cart), "This cart should contain items for this promotion.");
    }

    @Test
    public void testIsAvailableMethodOnBundledPromotionsFalse() {
        Promotion promotion = new BundlePromotion(Arrays.asList("A", "B"), 30.0);
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(new Product("A"), 3);
        testContents.put(new Product("C"), 1);
        cart.setContents(testContents);
        assertFalse(promotion.isAvailable(cart), "This cart should not contain items for this promotion.");
    }
}