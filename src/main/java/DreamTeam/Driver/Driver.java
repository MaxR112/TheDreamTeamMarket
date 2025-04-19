package main.java.DreamTeam.Driver;

import java.util.ArrayList;
import main.java.DreamTeam.Catalog.productCatalog;
import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.ScreenManager;

public class Driver{
    public static void main(String[] args) {
        //Init the catalog.
        //Some code is commented out as implementation does not exist on this branch.
        ArrayList<Product> sampleProducts = new ArrayList<>();

        Clothing shirt = new Clothing("Aqua-Man Shirt", "C001", 19.99, 10, "Soft, blue Aqua-Man Shirt", "CottonCo", "Large", "T-Shirt", "Blue");

        Electronics laptop = new Electronics("Dell X15", "E001", 999.99, 5, "15-inch gaming laptop", "Dell", "350 watts", "12.3 pounds", "Dark Gray");


        sampleProducts.add(shirt);
        sampleProducts.add(laptop);

        productCatalog catalog = new productCatalog(sampleProducts);
        catalog.displayAllCatalog();

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Creates a screen with set size, then sets screen to the main screen.
                new ScreenManager(800, 600).setScreen(new MainScreen());
            }
        });
    }
}