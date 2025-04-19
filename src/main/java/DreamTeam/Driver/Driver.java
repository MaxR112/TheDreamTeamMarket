package main.java.DreamTeam.Driver;

import java.util.ArrayList;

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

        Clothing shirt = new Clothing("M", "Blue", "Casual");
        shirt.setName("T-Shirt");
        shirt.setPrice(19.99);
        shirt.setQuantity(10);
        shirt.setCompany("CottonCo");
        shirt.setDescription("100% Cotton T-Shirt");
        //shirt.setIdentifier("C001");

        Electronics laptop = new Electronics(120, 2.5, "Black");
        laptop.setName("Laptop X15");
        laptop.setPrice(999.99);
        laptop.setQuantity(5);
        laptop.setCompany("TechWorld");
        laptop.setDescription("15-inch gaming laptop");
        //laptop.setIdentifier("E001");

        sampleProducts.add(shirt);
        sampleProducts.add(laptop);

        //Catalog catalog = new Catalog();
        //catalog.setCatalog(sampleProducts);
        //catalog.displayAllCatalog();

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Creates a screen with set size, then sets screen to the main screen.
                new ScreenManager(800, 600).setScreen(new MainScreen());
            }
        });
    }
}