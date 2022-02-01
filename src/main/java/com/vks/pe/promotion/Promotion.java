package com.vks.pe.promotion;

import com.vks.pe.model.Cart;

/**
 * @author Vksingh
 */
public interface Promotion
{
    // Apply promotion to the cart and return the cart
    Cart applyPromotion(Cart cart);

    // Checks if promotion is available for the cart contents
    Boolean isAvailable(Cart cart);

    // Return discounted price after the promotion applied
    Double getDiscountedPrice();
}
