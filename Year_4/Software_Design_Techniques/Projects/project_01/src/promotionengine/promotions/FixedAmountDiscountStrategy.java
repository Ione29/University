package promotionengine.promotions;

import promotionengine.Product;

public class FixedAmountDiscountStrategy implements PromotionStrategy {
    private double discountAmount;

    public FixedAmountDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public void applyPromotion(Product product) {
        double newPrice = product.getOriginalPrice() - discountAmount;
        product.setCurrentPrice(newPrice);
    }
}