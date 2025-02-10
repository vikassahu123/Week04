//1. Smart Warehouse Management System
//Concepts: Generic Classes, Bounded Type Parameters, Wildcards
//Problem Statement:
//You are developing a Smart Warehouse System that manages different types of items like Electronics, Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
//        Hints:
//Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
//Implement a generic class Storage<T extends WarehouseItem> to store items safely.
//Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).


package org.example.Day01;
import java.util.*;

abstract class WarehouseItem
{   String name;
    double  price;
    int  quantity;

    public WarehouseItem(String name, int  price,int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }


    abstract void displayDetails();

    public double totalPrice()
    {
        double tp=price*quantity;
        return tp;
    }


}

class Electronics extends WarehouseItem
{
    int yearOfWarenty;
    public  Electronics(String name, int  price,int quantity,int yearOfWarenty)
    {
        super(name,price,quantity);
        this.yearOfWarenty=yearOfWarenty;

    }
    public void displayDetails() {
        System.out.print("Electronics item name : " + name + " price " + price + " quantity " + quantity + " year of warrenty is  " + yearOfWarenty);
    }

}

class Groceries extends WarehouseItem
{
    String expDate;
    public  Groceries(String name, int  price,int quantity,String expDate)
    {
        super(name,price,quantity);
        this.expDate=expDate;

    }
    public void displayDetails() {
        System.out.print("Groceries item name : " + name + " price " + price + " quantity " + quantity + " Expiration Date: " + expDate);
    }

}

class Furniture extends WarehouseItem
{
    String material;
    public  Furniture(String name, int  price,int quantity,String material)
    {
        super(name,price,quantity);
        this.material=material;

    }
    public void displayDetails() {
        System.out.print("Furniture item name : " + name + " price " + price + " quantity " + quantity + " material used " + material);
    }

}

class Storage<T extends  WarehouseItem>
{
    List< T > items;
   public Storage()
   {
       this.items=new ArrayList<>();
   }

   public void addItem(T item) {
       items.add(item);
       System.out.println("item added: "+ item.name);
   }

   public void remove(T item)
   {
       items.remove(item);
       System.out.println("item removed "+item.name);
   }

   public List<T> getItems()
    {
        return items;
    }
}

class WarehouseUtils {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println(" Warehouse Inventory: ");
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}


public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        Electronics laptop = new Electronics("Laptop", 45000, 2, 4);
        Electronics phone = new Electronics("Smartphone", 12000, 6, 1);
        electronicsStorage.addItem(laptop);
        electronicsStorage.addItem(phone);

        Groceries apple = new Groceries("Apple", 20, 50, "2025-01-01");
        Groceries milk = new Groceries("Milk", 15, 30, "2024-06-01");
        groceriesStorage.addItem(apple);
        groceriesStorage.addItem(milk);

        Furniture chair = new Furniture("Office Chair", 150, 6, "Wood");
        Furniture table = new Furniture("Dining Table", 550, 2, "Glass");
        furnitureStorage.addItem(chair);
        furnitureStorage.addItem(table);


        WarehouseUtils.displayAllItems(electronicsStorage.getItems());
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}
