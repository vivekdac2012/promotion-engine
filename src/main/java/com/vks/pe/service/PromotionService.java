package com.vks.pe.service;

import java.util.List;

import com.vks.pe.model.Cart;
import com.vks.pe.promotion.Promotion;

/**
 * @author Vksingh
 */
public interface PromotionService
{
    public Double getRawPrice(Cart cart);
    public Double getPromotedPrice(Cart cart, List<Promotion> promotions);
}
