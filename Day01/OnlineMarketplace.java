//2. Dynamic Online Marketplace
//Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
//Problem Statement:
//Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
//Hints:
//Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
//Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
//Ensure type safety while allowing multiple product categories to exist in the same catalog.

package org.example.Day01;

import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void displayDetails();

    public double totalValue() {
        return price * quantity;
    }
}

class Book extends Product {
    String author;
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    public void displayDetails() {
        System.out.println("Book Name: " + name + " | Price: " + price + " | Quantity: " + quantity + " | Author: " + author);
    }
}

class Clothing extends Product {
    String size;
    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }
    public void displayDetails() {
        System.out.println("Clothing Item: " + name + " | Price: " + price + " | Quantity: " + quantity + " | Size: " + size);
    }
}

class Gadget extends Product {
    int warrantyMonths;
    public Gadget(String name, double price, int quantity, int warrantyMonths) {
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }
    public void displayDetails() {
        System.out.println("Gadget Name: " + name + " | Price: " + price + " | Quantity: " + quantity + " | Warranty: " + warrantyMonths + " months");
    }
}

class ProductStorage<T extends Product> {
    List<T> products;
    public ProductStorage() {
        this.products = new ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
        System.out.println("Product Added: " + product.name);
    }

    public void removeProduct(T product) {
        products.remove(product);
        System.out.println("Product Removed: " + product.name);
    }

    public List<T> getProducts() {
        return products;
    }
}

class ProductUtils {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
        System.out.println("Discount Applied: " + product.name + " now costs $" + product.price);
    }

    public static void displayAllProducts(List<? extends Product> products) {
        System.out.println("\nMarketplace Inventory:");
        for (Product product : products) {
            product.displayDetails();
        }
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductStorage<Book> bookStorage = new ProductStorage<>();
        ProductStorage<Clothing> clothingStorage = new ProductStorage<>();
        ProductStorage<Gadget> gadgetStorage = new ProductStorage<>();

        Book book1 = new Book("The Alchemist", 20.0, 10, "Paulo Coelho");
        Book book2 = new Book("Harry Potter", 35.0, 5, "J.K. Rowling");
        bookStorage.addProduct(book1);
        bookStorage.addProduct(book2);

        Clothing shirt = new Clothing("T-Shirt", 15.0, 20, "M");
        Clothing jeans = new Clothing("Jeans", 40.0, 15, "L");
        clothingStorage.addProduct(shirt);
        clothingStorage.addProduct(jeans);

        Gadget phone = new Gadget("Smartphone", 500.0, 5, 12);
        Gadget laptop = new Gadget("Laptop", 1200.0, 2, 24);
        gadgetStorage.addProduct(phone);
        gadgetStorage.addProduct(laptop);

        ProductUtils.applyDiscount(book1, 10);
        ProductUtils.applyDiscount(phone, 5);

        ProductUtils.displayAllProducts(bookStorage.getProducts());
        ProductUtils.displayAllProducts(clothingStorage.getProducts());
        ProductUtils.displayAllProducts(gadgetStorage.getProducts());
    }
}
