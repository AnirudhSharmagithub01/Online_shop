package com.example.inventory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Capacity and size of the Inventory: ");
        Inventory inventory = new Inventory(input.nextInt(), input.nextInt());
        int id, quantity;
        String name;
        double price;
        for (int i = 0; i < inventory.getSize(); i++) {
            System.out.println("Enter id of the product: ");
            id = input.nextInt();
            System.out.println("Enter Quantity of the product: ");
            quantity = input.nextInt();
            System.out.println("Enter Name of the product : ");
            name = input.next();
            System.out.println("Enter price of the product: ");
            price = input.nextDouble();
            inventory.products[i] = new Product(id, name, price, quantity);
        }

        System.out.println("Enter the size of the Cart: ");
        Customer customer = new Customer(input.nextInt(), inventory);
        for (int i = 0; i < customer.cart.getSize(); i++) {
            System.out.println("Enter the name of the product into the cart: ");
            String curr = input.next();
            Product product = inventory.prodExists(curr);
            System.out.println("Enter the quantity of the product: ");
            customer.cart.products[i] = new Product(product.getId(), product.getName(), product.getPrice(),
                    input.nextInt());

        }

        System.out.println("1 AddProduct in Inventory ");
        System.out.println("2 UpdateProduct in Inventory ");
        System.out.println("3 removeProduct from Inventory ");
        System.out.println("4 AddProductToCart ");
        System.out.println("5 RemoveFromCart");
        System.out.println("6 PlaceOrder \n");

        System.out.println("Enter the choice : ");
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                id = input.nextInt();
                name = input.next();
                price = input.nextDouble();
                quantity = input.nextInt();
                inventory.addProduct(id, name, price, quantity);
                inventory.display();
                break;
            case 2:
                id = input.nextInt();
                quantity = input.nextInt();
                inventory.updateProduct(id, quantity);
                inventory.display();
                break;

            case 3:
                id = input.nextInt();
                inventory.removeProduct(id);
                inventory.display();
                break;

            case 4:
                name = input.next();
                quantity = input.nextInt();
                customer.addProductToCart(name, quantity);
                customer.displayCart();
                break;

            case 5:
                name = input.next();
                customer.removeProductToCart(name);
                customer.displayCart();
                break;

            case 6:
                customer.placeOrder(input.next(), input.next());
                break;
        }

        input.close();
    }
}
