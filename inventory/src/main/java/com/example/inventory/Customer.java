package com.example.inventory;

public class Customer {

    Cart cart;
    Inventory inventory;

    Customer(int size, Inventory inventory) {
        this.inventory = inventory;
        this.cart = new Cart(size, inventory);
    }

    public void addProductToCart(String name, int quantity) {
        cart.addProduct(name, quantity);
    }

    public void removeProductToCart(String name) {
        cart.removeProduct(name);
    }

    public void placeOrder(String date, String time) {
        System.out.println("Order placed!");
        Order order = new Order(this);
        order.placeOrder(date, time);
    }

    void displayCart() {
        cart.display();
    }
}
