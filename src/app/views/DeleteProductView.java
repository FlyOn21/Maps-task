package app.views;

import app.model.DeleteProductModel;
import app.utils.ProductIsExist;

import java.util.Scanner;

public class DeleteProductView {

    DeleteProductModel deleteProductModel = new DeleteProductModel();
    public void deleteProductProcessing(Scanner scanner) {
        System.out.println("Input product name to delete: ");
        String name = scanner.nextLine();
        if (!ProductIsExist.isExist(name)) {
            System.out.println("Product with name " + name + " is not exist!");
            return;
        }
        boolean isDeleted = deleteProductModel.deleteProduct(name);
        if (isDeleted) {
            System.out.println("Product with name " + name + " is deleted!");
        } else {
            System.out.println("Error while deleting product with name " + name);
        }
    }
}
