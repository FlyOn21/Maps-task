package app.controller;

import app.views.*;

import java.util.Scanner;

public class ProductController {
    public void productsControllerProcessing() {
        String title = """
                #########################
                Realize home work 10 Map
                #########################
                """;
        System.out.println(title);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String menu = """ 
                    --------------
                    Choice action:
                    --------------
                    Choice 1 => see all products list
                    Choice 2 => see specific product
                    Choice 3 => create new product
                    Choice 4 => update product
                    Choice 5 => delete product
                    Choice 6 => stop and exit
                    """;
            System.out.println(menu);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    GetAllProductsView getAllProductsView = new GetAllProductsView();
                    getAllProductsView.getAllProductProcessing();
                    break;
                case "2":
                    GetOneProdactView getOneProdactView = new GetOneProdactView();
                    getOneProdactView.getOneProductProcessing(scanner);
                    break;
                case "3":
                    PostProductView postProductView = new PostProductView();
                    postProductView.createProductProcessing(scanner);
                    break;
                case "4":
                    PutProductView putProductView = new PutProductView();
                    putProductView.updateProduct(scanner);
                    break;
                case "5":
                    DeleteProductView deleteProductView = new DeleteProductView();
                    deleteProductView.deleteProductProcessing(scanner);
                    break;
                case "6":
                    running = false;
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
