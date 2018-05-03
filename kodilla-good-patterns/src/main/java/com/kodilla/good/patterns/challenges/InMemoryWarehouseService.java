package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InMemoryWarehouseService implements WarehouseService {

    private final Map<ProductCategory, Map<Product, Integer>> stock = new HashMap<>();

    {
        for(ProductCategory category : ProductCategory.values()){
            stock.put(category, new HashMap<>());
        }
        createSampleProducts(1000);
    }


    @Override
    public boolean stock(Product product, int quantity) {
        Integer initialQuantity = stock.get(product.getProductCategory()).get(product);
        int newQuantity = initialQuantity == null ? quantity : initialQuantity + quantity;
        stock.get(product.getProductCategory()).put(product, newQuantity);
        return true;
    }

    @Override
    public boolean isInStock(Product product, int quantity) {
        Integer inStock = stock.get(product.getProductCategory()).get(product);
        if (inStock == null) {
            return false;
        } else {
            return inStock >= quantity;
        }
    }

    @Override
    public boolean removeFromStock(Product product, int quantity) {
        Integer oldQuantity = stock.get(product.getProductCategory()).get(product);
        if(oldQuantity == null) {
            System.out.println("Product not found in warehouse, nothing removed.");
            return false;
        }
        if(oldQuantity < quantity) {
            System.out.println("Not enough products in the warehouse, cannot remove chosen quantity");
            return false;
        } else if(oldQuantity == quantity) {
            System.out.println("Removed all products of this type from warehouse, product no longer available.");
            stock.get(product.getProductCategory()).remove(product);
            return true;
        } else {
            System.out.println("Removing desired quantity of product from warehouse.");
            stock.get(product.getProductCategory()).put(product, oldQuantity-quantity);
            return true;
        }
    }

    @Override
    public boolean sendProducts(User user, Product product, int quantity) {
        if(isInStock(product, quantity)) {
            System.out.println("Sending " + product + " in quantity " + quantity + " to user " + user);
            removeFromStock(product, quantity);
            return true;
        } else {
            System.out.println("Not enough products in stock, products not sent.");
            return false;
        }
    }

    private void createSampleProducts(int quantity) {
        Random random = new Random();
        for (ProductCategory productCategory : ProductCategory.values()) {
            Map<Product, Integer> categoryMap = stock.get(productCategory);
            for(int i=0; i<quantity; i++) {
                categoryMap.put(new Product(productCategory, "" + productCategory + i,
                        new BigDecimal(random.nextInt(300) + 50)), random.nextInt(5) + 4);
            }
        }
    }

}
