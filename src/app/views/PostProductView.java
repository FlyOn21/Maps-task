package app.views;

import app.model.PostProductModel;

import java.util.Scanner;

public class PostProductView {
    String name;
    double price = -1;
    String description;
    int quantity = -1;

    PostProductModel postProductModel = new PostProductModel();

    public void createProductProcessing(Scanner scanner) {
        while (true) {
            if (name == null) {
                System.out.println("Enter product name: ");
                name = scanner.nextLine();
            } else if (price == -1) {
                System.out.println("Enter product price: ");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price");
                    continue;
                }
            } else if (description == null) {
                System.out.println("Enter product description: ");
                description = scanner.nextLine();
            } else if (quantity == -1) {
                System.out.println("Enter product quantity: ");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity");
                    continue;
                }
            } else {
                boolean isCreated = postProductModel.createNewProduct(name, description, price, quantity);
                if (isCreated) {
                    System.out.println("Product created SUCCESS => " + name + ", " + price + ", " + description + ", " + quantity);
                } else {
                    System.out.println("Product with that name exists. New product doesn't create");
                }
                return;
            }
        }
    }
}