package app;

import app.controller.ProductController;

public class App {
    private static final ProductController productController = new ProductController();

    private void run() {
        productController.productsControllerProcessing();
    }
    public static void main(String[] args) {
        new App().run();
    }

}
