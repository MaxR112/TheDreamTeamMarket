package main.java.DreamTeam.fileHandler;

import java.util.ArrayList;
import main.java.DreamTeam.Products.Product;

public class fileWriter{

    public ArrayList<Product> allProductsToWrite;

    public fileWriter(ArrayList<Product> productList){
        this.allProductsToWrite = new ArrayList<>(productList);
        System.out.println("Test: Successfully created fileWriter instance");
    }

    

}
