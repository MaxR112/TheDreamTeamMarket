package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.fileHandler.fileReader;

public class Driver{
    public static void main(String[] args) {

        ArrayList<Product> allProducts;

        allProducts = readAllProductCatalogAndSaveToArray();

        productCatalog catalog = new productCatalog(allProducts);
        productCart cart = new productCart(catalog);

        catalog.displayAllCatalog();
        catalog.removeProductQuantity("Dell X15", 2);
        catalog.displayAllCatalog();
        catalog.displayByProductType("Electronics");
        catalog.getProductByName("Aqua-Man Shirt"); 
        
        cart.addProduct("Aqua-Man Shirt");
        cart.addProduct("Aqua-Man Shirt");
        System.out.println(cart.displayCart());
        cart.updateQuantityOfItemInCart("Aqua-Man Shirt", 11);
        System.out.println(cart.displayCart());



        //For the purposes of testing, this is commented out.
        // fileWriter allProductWriter = new fileWriter(catalog.getRawProductsArray(), "allProductCatalog.txt");
        // allProductWriter.writeProductsToFile();

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