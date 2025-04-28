package main.java.DreamTeam.mainMarket;

import java.io.IOException;

import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.fileHandler.fileReader;


public class Driver {
    public static void main(String[] args) throws IOException {
        productCatalog catalog = new productCatalog(fileReader.readAllProductCatalogAndSaveToArray());

        //Run the screen operation on a seperate thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window(catalog, 800, 600);
                window.setContentPane(new MainScreen(window));
            }
        });
    }

}