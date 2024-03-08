package app.views;

import app.entity.Product;
import app.model.GetProductOrProductsModel;
import app.utils.Printer;

import java.util.List;

public class GetAllProductsView {
    public void getAllProductProcessing() {
        GetProductOrProductsModel getProductOrProductsModel = new GetProductOrProductsModel();
        List<Product> allProducts = getProductOrProductsModel.getAllProducts();
        if (allProducts.isEmpty()) {
            System.out.println("Db is empty");
            return;
        }
        Printer.printProducts(getProductOrProductsModel.getAllProducts());
    }
}
