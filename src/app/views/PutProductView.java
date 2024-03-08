package app.views;

import app.model.PutProductModel;
import app.utils.ProductIsExist;

import java.util.Scanner;

public class PutProductView {
    private static final String readMenu = """
            ------------ UPDATE PRODUCT--------------
            Choice 1 => update description
            Choice 2 => update price
            Choice 3 => update quantity
            """;

    PutProductModel putProductModel = new PutProductModel();
    public void updateProduct(Scanner scanner) {
        while (true) {
            System.out.println(readMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    updateProductProcessing(scanner, "description");
                    return;
                case "2":
                    updateProductProcessing(scanner, "price");
                    return;
                case "3":
                    updateProductProcessing(scanner, "quantity");
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }


    }

    private void updateProductProcessing(Scanner scanner, String attributeName) {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        if(!ProductIsExist.isExist(name)) {
            System.out.println("Product with name " + name + " not exist");
            return;
        }
        switch (attributeName) {
            case "description" -> {
                System.out.println("Enter product description: ");
                String description = scanner.nextLine();
                boolean result = putProductModel.updateProductDescription(name, description);
                if (!result) {
                    System.out.println("Product description not updated");
                }
                System.out.println("Product description updated");
            }
            case "price" -> {
                System.out.println("Enter product price: ");
                String priceStr = scanner.nextLine();
                try {
                    double price = Double.parseDouble(priceStr);
                    boolean result = putProductModel.updateProductPrice(name, price);
                    if (!result) {
                        System.out.println("Product price not updated");
                    }
                    System.out.println("Product price updated");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Price not updated");
                }
            }
            case "quantity" -> {
                System.out.println("Enter product quantity: ");
                String quantityStr = scanner.nextLine();
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    boolean result = putProductModel.updateProductQuantity(name, quantity);
                    if (!result) {
                        System.out.println("Product quantity not updated");
                    }
                    System.out.println("Product quantity updated");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Quantity not updated");
                }
            }
        }
    }
}
