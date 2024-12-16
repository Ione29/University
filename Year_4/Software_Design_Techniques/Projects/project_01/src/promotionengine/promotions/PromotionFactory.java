package promotionengine.promotions;

public class PromotionFactory {
    public static PromotionStrategy createPromotion(String type, double value) {
        switch (type) {
            case "PercentageDiscount":
                return new PercentageDiscountStrategy(value);
            case "FixedAmountDiscount":
                return new FixedAmountDiscountStrategy(value);
            default:
                throw new IllegalArgumentException("Unknown promotion type");
        }
    }
}