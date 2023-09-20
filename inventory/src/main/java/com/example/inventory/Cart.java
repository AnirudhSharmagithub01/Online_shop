package com.example.inventory;

public class Cart {
    final int capacity = 10;
    Product[] products;
    private int size;
    Inventory inventory;

    Cart(int size, Inventory inventory) {
        this.inventory = inventory;
    }

    public Cart(int size) {
        this.size = size;
        products = new Product[capacity];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addProduct(String name, int quantity) {
        try {
            if (capacity == size) {
                throw new Exception("Cart is full. Product can't be added to the cart.");
            }
            Product product = inventory.prodExists(name);
            if (product == null) {
                throw new Exception("Product doesn't exist in the inventory.");
            }
            products[size] = new Product(product.getId(), product.getName(), product.getPrice(), quantity);
            size++;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void removeProduct(String name) {
        try {
            if (size == 0) {
                throw new Exception("Product can't be removed as cart is empty.");
            }
            Product product = prodExists(name);
            if (product == null) {
                throw new Exception("Product doesn't exist in the cart.");
            }
            product.setQuantity(0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private Product prodExists(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return products[i];
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getName() + " : " + products[i].getQuantity());
        }
    }
}
