package com.vks.pe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vks.pe.promotion.BundlePromotion;
import com.vks.pe.promotion.Promotion;
import com.vks.pe.promotion.SingleProductGroupPromotion;

/**
 * @author Vksingh
 */
public class PromotionUtil
{
    public static List<Promotion> setupPromotions() {
        
        List<Promotion> promotions = new ArrayList<>();
        
        SingleProductGroupPromotion singleProductGroupPromotionA = new SingleProductGroupPromotion("A", 3, 130.0);
        SingleProductGroupPromotion singleProductGroupPromotionB = new SingleProductGroupPromotion("B",2, 45.0);
        BundlePromotion bundlePromotion = new BundlePromotion(Arrays.asList("C", "D"), 30.0);
        
        promotions.add(singleProductGroupPromotionA);
        promotions.add(singleProductGroupPromotionB);
        promotions.add(bundlePromotion);
        
        return promotions;
    }
}
