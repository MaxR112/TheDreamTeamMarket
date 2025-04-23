package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.fileHandler.fileReader;


public class Driver{
    public static void main(String[] args) {

        ArrayList<Product> allProducts;

        allProducts = readAllProductCatalogAndSaveToArray();

        productCatalog catalog = new productCatalog(allProducts);

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window(catalog, 800, 600);
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