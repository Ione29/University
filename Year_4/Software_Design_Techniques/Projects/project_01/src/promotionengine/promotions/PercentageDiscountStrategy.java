package promotionengine.promotions;

import promotionengine.Product;

public class PercentageDiscountStrategy implements PromotionStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public void applyPromotion(Product product) {
        double newPrice = product.getOriginalPrice() - (product.getOriginalPrice() * (percentage / 100));
        product.setCurrentPrice(newPrice);
    }
}