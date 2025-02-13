package org.example.Management;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCartImplement {
    public static void main(String[] args) {
        CartManager manager = new CartManager();
        manager.addProduct("Laptop", 800.00);
        manager.addProduct("Phone", 500.00);
        manager.addProduct("Headphones", 100.00);


        manager.addToCart("Phone");
        manager.addToCart("Laptop");
        manager.addToCart("Headphones");
        manager.addToCart("custom");
        System.out.println("");

        CartDisplay.displaySortedCart(manager.getCart());
    }
}

class CartManager {
    // Stores product prices
    private HashMap<String, Double> productPrices;
    // Maintains order of items added
    private LinkedHashMap<String, Double> cart;

    public CartManager() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            cart.put(product, productPrices.get(product));
            System.out.println(product+ " Added");
        } else {
            System.out.println(product +" Not found in cart");
        }
    }

    public HashMap<String, Double> getProductPrices() {
        return productPrices;
    }

    public LinkedHashMap<String, Double> getCart() {
        return cart;
    }
}

class CartDisplay {
    //method to display all cart items
    public static void displaySortedCart(HashMap<String, Double> cart) {
        TreeMap<String, Double> sortedCart = new TreeMap<>(cart);
        System.out.println("Shopping Cart (Sorted by Product Name):");
        for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + " : $" + entry.getValue());
        }
    }
}
