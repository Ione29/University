package promotionengine;

public class Product {
    private String name;
    private double originalPrice;
    private double currentPrice;
    private String productType;
    private int saleVolume;
    private int stock;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.originalPrice = builder.price;
        this.currentPrice = builder.price;
        this.productType = builder.productType;
        this.saleVolume = builder.saleVolume;
        this.stock = builder.stock;
    }

    public static class ProductBuilder {
        private String name;
        private double price;
        private String productType;
        private int saleVolume;
        private int stock;

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public ProductBuilder setSaleVolume(int saleVolume) {
            this.saleVolume = saleVolume;
            return this;
        }

        public ProductBuilder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getProductType() {
        return productType;
    }

    public int getSaleVolume() {
        return saleVolume;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product details:\n" +
                "Name: " + name + "\n" +
                "Original Price: " + originalPrice + "\n" +
                "Product Type: " + productType + "\n" +
                "Sale Volume: " + saleVolume + "\n" +
                "Stock: " + stock;
    }
}