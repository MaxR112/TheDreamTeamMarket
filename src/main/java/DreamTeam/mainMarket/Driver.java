package main.java.DreamTeam.mainMarket;

import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.fileHandler.fileReader;


public class Driver{
    public static void main(String[] args) {

        productCatalog catalog = new productCatalog(fileReader.readAllProductCatalogAndSaveToArray());
        productCart cart = new productCart(catalog);

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window(800, 600);
                Window.setCatalog(catalog);
                window.setContentPane(new MainScreen(window));
            }
        });
    }

}