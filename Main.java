/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author viole
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    protected String name;
    protected double price;
    protected int qty;
    

    public Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return "General";
    }
    public int getQty(){
        return qty;
    }
    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Category: " + getCategory() + ", Quantity: " + qty;
    }
}

class Electronics extends Product {
    private String brand;

    public Electronics(String name, double price, int qty,  String brand) {
        super(name, price, qty);
        this.brand = brand;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, double price,int qty, String size) {
        super(name, price, qty);
        this.size = size;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}

class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to inventory: " + product.getName());
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int num = 5, ch, des;
        String n;
        double p;
        String b;
        int q1;
        String na;
        double pr;
        String si;
        int q2;
        //assess what is there, review what has to be added, check if stock reduces
        while(true){
        System.out.println("Enter 1 to add products to inventory, 2 to check inventory database and 3 to list items out of stock");
        des = sc.nextInt();
        Electronics[] ele = new Electronics[num];
        Clothing[] cl = new Clothing[num];
        if(des == 1){
        System.out.println("Enter number of items to be added into inventory");
        num = sc.nextInt();
        ele = new Electronics[num];
        cl = new Clothing[num];
        for(int x = 0; x < num; x++){
            System.out.println("Enter 1 for electronics and 2 for clothing");
            ch = sc.nextInt();
            if(ch == 1){
                System.out.println("Enter name of product");
                n = sc.next();
                sc.nextLine();
                System.out.println("Enter price");
                p = sc.nextDouble();
                System.out.println("Enter product brand");
                b = sc.next();
                sc.nextLine();
                System.out.println("Enter quantity");
                q1 = sc.nextInt();
                ele[x] = new Electronics(n,p,q1,b);
                inventory.addProduct(ele[x]);
            }
            else if(ch == 2){
                System.out.println("Enter name of product");
                na = sc.next();
                sc.nextLine();
                System.out.println("Enter price");
                pr = sc.nextDouble();
                System.out.println("Enter product size");
                si = sc.next();
                sc.nextLine();
                System.out.println("Enter quantity");
                q2 = sc.nextInt();
                cl[x] = new Clothing(na,pr,q2,si);
                inventory.addProduct(cl[x]);
            }
        }
        }
        else if(des == 2){
            inventory.displayInventory();
        }
        else if(des == 3){
                boolean outOfStock = true;

                for (int i = 0; i < num; i++) {
                    if (ele[i] != null && ele[i].getQty() < 5) {
                        System.out.println("Item: " + ele[i].getName() + ", Quantity: " + ele[i].getQty());
                        outOfStock = false;
                    } else if (cl[i] != null && cl[i].getQty() < 5) {
                        System.out.println("Item: " + cl[i].getName() + ", Quantity: " + cl[i].getQty());
                        outOfStock = false;
                    }
                }

                if (outOfStock) {
                    System.out.println("All items in stock");
                    for(int i = 0; i < num; i++){
                        if(ele[i] != null && cl[i] != null){
                        System.out.println("Item: " + ele[i].getName() + ", Quantity: " + ele[i].getQty());
                        System.out.println("Item: " + cl[i].getName() + ", Quantity: " + cl[i].getQty());
                        }
                    }
                }

            }
        else{
                System.exit(0);
                }
        }
        
        
    }
}



