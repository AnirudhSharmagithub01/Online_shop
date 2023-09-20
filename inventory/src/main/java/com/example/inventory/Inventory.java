package com.example.inventory;

public class Inventory {

    private int capacity;
    private int size;
    Product[] products;

    public Inventory(int capacity, int size) {
        setCapacity(capacity);
        setSize(size);
        products = new Product[capacity];
    }

    // Getter
    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    // Setter
    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setSize(int size) {
        this.size = size;
    }

    // Method
    public double get_Price(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (products[i].getId() == id) {
                return products[i].getPrice();
            }
        }
        return 0;
    }

    public void addProduct(int id, String name, double price, int quantity) {
        try {
            if (capacity == size) {
                throw new Exception("Inventory is full, Product can't be added to the cart.");
            }

            products[size] = new Product(id, name, price, quantity);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public Product prodExists(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    public void updateProduct(int id, int quantity) {
        try {
            Product curr = prodExists(id);
            if (curr == null) {
                throw new Exception("Product doesn't exist");
            }
            curr.setQuantity(quantity);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void removeProduct(int id) {
        try {
            Product curr = prodExists(id);
            if (curr == null) {
                throw new Exception("Product doesn't exist");
            }
            curr.setQuantity(0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getName() + " : " + products[i].getQuantity());
        }
    }

    public Product prodExists(String name) {
        for (int i = 0; i < getSize(); i++) {
            if (products[i].getName().equals(name)) {
                return products[i];
            }
        }
        return null;
    }
}
