package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.ScreenManager;
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
        
        catalog.addProduct(new Electronics("Dell X1522", 999.99, 5, "15-inch gaming laptop", "Dell", "350 watts", "12.3 pounds", "Dark Gray"));

        fileWriter allProductWriter = new fileWriter(catalog.getRawProductsArray(), "allProductCatalog.txt");
        allProductWriter.writeProductsToFile();

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Creates a screen with set size, then sets screen to the main screen.
                new ScreenManager(800, 600).setScreen(new MainScreen());
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