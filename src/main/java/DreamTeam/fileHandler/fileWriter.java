package main.java.DreamTeam.fileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import main.java.DreamTeam.Products.Product;

public class fileWriter{

    public ArrayList<Product> allProductsToWrite;

    public fileWriter(ArrayList<Product> productList){
        this.allProductsToWrite = new ArrayList<>(productList);
        System.out.println("Test: Successfully created fileWriter instance");
    }

    public void writeProductsToFile(){
        checkForFileAndCreateIfNotPresent();
        
    }

    private void checkForFileAndCreateIfNotPresent() {
        try {
            File productFile = new File("allProductCatalog.txt");
            if (productFile.createNewFile()){
                System.out.println("Product file created: " + productFile.getName());
            }
        } catch (IOException e) {
            System.out.println("File error " + e);
        }
    }

    

}
