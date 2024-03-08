package app.views;

import app.model.GetProductOrProductsModel;
import app.utils.Printer;
import app.utils.ProductIsExist;

import java.util.Scanner;

public class GetOneProdactView {

    public void getOneProductProcessing(Scanner scanner) {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        if (!ProductIsExist.isExistProduct(name)) {
            System.out.println("Product with name " + name + " not exist");
            return;
        }
        GetProductOrProductsModel getProductOrProductsModel = new GetProductOrProductsModel();
        Printer.printProducts( getProductOrProductsModel.getOneProduct(name));
    }
}
