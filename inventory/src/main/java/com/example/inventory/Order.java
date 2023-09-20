package com.example.inventory;

public class Order {

    Customer customer;
    private String date;
    private String time;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void placeOrder(String date, String time) {
        this.date = date;
        this.time = time;
        double total = 0;
        System.out.println(date);
        System.out.println(time);

        for (int i = 0; i < customer.cart.getSize(); i++) {
            if (customer.cart.products[i].getQuantity() == 0) {
                continue;
            }
            double currPrice = customer.cart.products[i].getQuantity()
                    * customer.inventory.get_Price(customer.cart.products[i].getId());

            System.out.println(customer.cart.products[i].getQuantity() + "qty x " + customer.cart.products[i].getName()
                    + " = " + currPrice);

            total += currPrice;
        }

        System.out.println("Total : " + total);
    }
}
