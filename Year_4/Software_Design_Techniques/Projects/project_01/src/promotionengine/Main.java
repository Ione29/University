package promotionengine;

import promotionengine.promotions.PromotionFactory;
import promotionengine.promotions.PromotionManager;
import promotionengine.promotions.PromotionStrategy;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        Product product1 = new Product.ProductBuilder()
                .setName("Laptop")
                .setPrice(1000.0)
                .setProductType("Electronics")
                .setSaleVolume(500)
                .setStock(50)
                .build();

        Product product2 = new Product.ProductBuilder()
                .setName("Phone")
                .setPrice(500.0)
                .setProductType("Electronics")
                .setSaleVolume(300)
                .setStock(30)
                .build();

        Product product3 = new Product.ProductBuilder()
                .setName("Shoes")
                .setPrice(100.0)
                .setProductType("Apparel")
                .setSaleVolume(200)
                .setStock(20)
                .build();

        Product product4 = new Product.ProductBuilder()
                .setName("Watch")
                .setPrice(200.0)
                .setProductType("Accessories")
                .setSaleVolume(150)
                .setStock(25)
                .build();

        Product product5 = new Product.ProductBuilder()
                .setName("Headphones")
                .setPrice(150.0)
                .setProductType("Electronics")
                .setSaleVolume(400)
                .setStock(40)
                .build();

        Product product6 = new Product.ProductBuilder()
                .setName("Jacket")
                .setPrice(120.0)
                .setProductType("Apparel")
                .setSaleVolume(250)
                .setStock(30)
                .build();

        PromotionManager promotionManager = PromotionManager.getInstance();
        promotionManager.addProduct(product1);
        promotionManager.addProduct(product2);
        promotionManager.addProduct(product3);
        promotionManager.addProduct(product4);
        promotionManager.addProduct(product5);
        promotionManager.addProduct(product6);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createPromotion(scanner, promotionManager);
                    break;
                case 2:
                    applyPromotionToFilteredProducts(scanner, promotionManager);
                    break;
                case 3:
                    deletePromotion(scanner, promotionManager);
                    break;
                case 4:
                    seeProductDetails(scanner, promotionManager);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nThe Promotion Engine");
        System.out.println("Main Menu:");
        System.out.println("1. Apply a promotion to a single product");
        System.out.println("2. Apply promotion to filtered products");
        System.out.println("3. Delete an existing promotion");
        System.out.println("4. See product details");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void createPromotion(Scanner scanner, PromotionManager promotionManager) {
        System.out.println("\nSelect promotion type:");
        System.out.println("1. Percentage Discount");
        System.out.println("2. Fixed Amount Discount");
        System.out.print("Choose an option: ");
        int promotionType = scanner.nextInt();
        scanner.nextLine(); 

        String type;
        switch (promotionType) {
            case 1:
                type = "PercentageDiscount";
                break;
            case 2:
                type = "FixedAmountDiscount";
                break;
            default:
                System.out.println("Invalid promotion type.");
                return;
        }

        System.out.print("Enter promotion value: ");
        double value = scanner.nextDouble();
        scanner.nextLine();
        PromotionStrategy newPromotion = PromotionFactory.createPromotion(type, value);

        System.out.print("Enter product name to apply promotion: ");
        String productName = scanner.nextLine();
        Product product = findProductByName(promotionManager.getProducts(), productName);
        if (product != null) {
            promotionManager.addPromotion(product, newPromotion);
            System.out.println("Promotion added.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void applyPromotionToFilteredProducts(Scanner scanner, PromotionManager promotionManager) {
        System.out.println("\nSelect promotion type:");
        System.out.println("1. Percentage Discount");
        System.out.println("2. Fixed Amount Discount");
        System.out.print("Choose an option: ");
        int promotionType = scanner.nextInt();
        scanner.nextLine();

        String type;
        switch (promotionType) {
            case 1:
                type = "PercentageDiscount";
                break;
            case 2:
                type = "FixedAmountDiscount";
                break;
            default:
                System.out.println("Invalid promotion type.");
                return;
        }

        System.out.print("Enter promotion value: ");
        double value = scanner.nextDouble();
        scanner.nextLine(); 
        PromotionStrategy promotion = PromotionFactory.createPromotion(type, value);

        System.out.print("Enter product type (or leave blank): ");
        System.out.println("\nAvailable product types:");
        printProductTypes(promotionManager.getProducts());
        String productType = scanner.nextLine();
        if (productType.isEmpty()) productType = null;

        System.out.print("Enter minimum sale volume (or leave blank): ");
        String saleVolumeInput = scanner.nextLine();
        Integer saleVolume = saleVolumeInput.isEmpty() ? null : Integer.parseInt(saleVolumeInput);

        System.out.print("Enter minimum stock (or leave blank): ");
        String stockInput = scanner.nextLine();
        Integer stock = stockInput.isEmpty() ? null : Integer.parseInt(stockInput);

        System.out.print("Enter maximum price (or leave blank): ");
        String priceInput = scanner.nextLine();
        Double price = priceInput.isEmpty() ? null : Double.parseDouble(priceInput);

        promotionManager.applyPromotionToFilteredProducts(promotion, productType, saleVolume, stock, price);
        System.out.println("Promotion applied to filtered products.");
    }

    private static void deletePromotion(Scanner scanner, PromotionManager promotionManager) {
        System.out.print("\nEnter product name to delete promotion: ");
        String productName = scanner.nextLine();
        Product product = findProductByName(promotionManager.getProducts(), productName);
        if (product != null) {
            promotionManager.removePromotion(product);
            System.out.println("Promotion deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void seeProductDetails(Scanner scanner, PromotionManager promotionManager) {
        System.out.println("\nAvailable products:");
        List<Product> products = promotionManager.getProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }

        System.out.print("Enter the number of the product to see details: ");
        int productIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (productIndex >= 0 && productIndex < products.size()) {
            Product product = products.get(productIndex);
            System.out.println(product);
            PromotionStrategy promotion = promotionManager.getPromotion(product);
            if (promotion != null) {
                System.out.println("Promotion applied: " + promotion.getClass().getSimpleName());
            } else {
                System.out.println("No promotion applied.");
            }
            System.out.println("New Price after promotion: " + promotionManager.calculateFinalPrice(product));
        } else {
            System.out.println("Invalid product number.");
        }
    }

    private static void printProductTypes(List<Product> products) {
        Set<String> productTypes = products.stream()
                .map(Product::getProductType)
                .collect(Collectors.toSet());
        productTypes.forEach(System.out::println);
    }

    private static Product findProductByName(List<Product> products, String productName) {
        return products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }
}