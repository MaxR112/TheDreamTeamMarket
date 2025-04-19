package main.java.DreamTeam.Driver;

import java.util.ArrayList;

import main.java.DreamTeam.Catalog.productCatalog;
import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Furniture;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Window;

public class Driver{
    public static void main(String[] args) {
        //Init the catalog.
        //Some code is commented out as implementation does not exist on this branch.
        ArrayList<Product> sampleProducts = new ArrayList<>();

        Clothing shirt =
            new Clothing("Aqua-Man Shirt", 19.99, 10, "Soft, blue Aqua-Man Shirt", "CottonCo", "Large", "T-Shirt", "Blue");

        Electronics laptop =
            new Electronics("Dell X15", 999.99, 5, "15-inch gaming laptop", "Dell", "350 watts", "12.3 pounds", "Dark Gray");
        
        Furniture cabinet =
            new Furniture("Light Gray Cabinet", 1999.99, 20, "insert really long description that describes the product and other details that may or may not be necessary to describe the product. This product has a very long description because the description is used to test the user interface. For this test, this test is designed to test the text wrapping and text truncation system. This is important because some there will be some absurdly long descriptions that some items have and the application should be able to handle this case properly.", "AFictionalCompany", "Marble", 200, "Gray");

        sampleProducts.add(shirt);
        sampleProducts.add(laptop);
        sampleProducts.add(cabinet);

        // Test a bunch of catalog methods
        productCatalog catalog = new productCatalog(sampleProducts);
        catalog.displayAllCatalog();
        catalog.addProduct(shirt);
        catalog.removeProductQuantity("Dell X15", 2);
        catalog.displayAllCatalog();
        catalog.displayByProductType("Electronics");
        catalog.getProductByName("Aqua-Man Shirt");

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Creates a screen with set size, then sets screen to the main screen.
                Window window = new Window(800, 600);
                Window.setCatalog(catalog);
                window.setContentPane(new MainScreen(window));
            }
        });
    }
}