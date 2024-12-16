package promotionengine.promotions;

import promotionengine.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class PromotionManager {
    private static PromotionManager instance;
    private Map<Product, PromotionStrategy> activePromotions;
    private List<Product> products;

    private PromotionManager() {
        activePromotions = new HashMap<>();
        products = new ArrayList<>();
    }

    public static PromotionManager getInstance() {
        if (instance == null) {
            instance = new PromotionManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addPromotion(Product product, PromotionStrategy promotion) {
        activePromotions.put(product, promotion);
    }

    public PromotionStrategy getPromotion(Product product) {
        return activePromotions.get(product);
    }

    public void removePromotion(Product product) {
        activePromotions.remove(product);
    }

    public void applyPromotion(Product product) {
        PromotionStrategy promotion = getPromotion(product);
        if (promotion != null) {
            promotion.applyPromotion(product);
        }
    }

    public double calculateFinalPrice(Product product) {
        double finalPrice = product.getOriginalPrice();
        PromotionStrategy promotion = getPromotion(product);
        if (promotion instanceof PercentageDiscountStrategy) {
            PercentageDiscountStrategy discount = (PercentageDiscountStrategy) promotion;
            finalPrice -= finalPrice * (discount.getPercentage() / 100);
        } else if (promotion instanceof FixedAmountDiscountStrategy) {
            FixedAmountDiscountStrategy discount = (FixedAmountDiscountStrategy) promotion;
            finalPrice -= discount.getDiscountAmount();
        }
        return finalPrice;
    }

    public List<Product> filterProducts(String productType, Integer saleVolume, Integer stock, Double price) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            boolean matches = true;
            if (productType != null && !product.getProductType().equals(productType)) {
                matches = false;
            }
            if (saleVolume != null && product.getSaleVolume() < saleVolume) {
                matches = false;
            }
            if (stock != null && product.getStock() < stock) {
                matches = false;
            }
            if (price != null && product.getCurrentPrice() > price) {
                matches = false;
            }
            if (matches) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public void applyPromotionToFilteredProducts(PromotionStrategy promotion, String productType, Integer saleVolume, Integer stock, Double price) {
        List<Product> filteredProducts = filterProducts(productType, saleVolume, stock, price);
        for (Product product : filteredProducts) {
            addPromotion(product, promotion);
            promotion.applyPromotion(product);
            System.out.println("Applying promotion to: " + product.getName() + ". New price: " + product.getCurrentPrice());
        }
    }
}