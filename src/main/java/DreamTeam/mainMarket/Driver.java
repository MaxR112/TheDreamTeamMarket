package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.fileHandler.fileReader;
import main.java.DreamTeam.fileHandler.fileWriter;

public class Driver{
    public static void main(String[] args) {

        ArrayList<Product> allProducts;

        allProducts = readAllProductCatalogAndSaveToArray();

        productCatalog catalog = new productCatalog(allProducts);

        catalog.displayAllCatalog();
        catalog.removeProductQuantity("Dell X15", 2);
        catalog.displayAllCatalog();
        catalog.displayByProductType("Electronics");
        catalog.getProductByName("Aqua-Man Shirt");   

        fileWriter allProductWriter = new fileWriter(catalog.getRawProductsArray(), "allProductCatalog.txt");
        allProductWriter.writeProductsToFile();

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window(800, 600);
                Window.setCatalog(catalog);
                window.setContentPane(new MainScreen(window));
            }
        });
    }

    private static ArrayList<Product> readAllProductCatalogAndSaveToArray() {
        ArrayList<Product> productArray;

        fileReader pr = new fileReader("allProductCatalog.txt");

        pr.readFileAndStoreInList();
        productArray = new ArrayList<>(pr.getProductListFromRead());
        return productArray;
    }
}