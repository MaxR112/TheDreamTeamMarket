package main.java.DreamTeam.fileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.java.DreamTeam.Products.Product;

public class fileWriter implements Files{

    public ArrayList<Product> allProductsToWrite;
    public String filePath;
    public File productFile;

    public fileWriter(ArrayList<Product> productList, String fileName){
        this.allProductsToWrite = new ArrayList<>(productList);
        this.filePath = "src/main/resources/" + fileName;
        this.productFile = new File(this.filePath);
    }

    public void writeProductsToFile() throws IOException{
        checkForFileAndCreateIfNotPresent();
        try{
            FileWriter writer = new FileWriter(filePath);
            for (Product product : allProductsToWrite){
                writer.write(product.toString() + "\n");
            }
            writer.close();
        } catch (IOException e){
            throw new IOException();
        }
}

    @Override
    public void checkForFileAndCreateIfNotPresent() throws IOException {
        if (productFile.createNewFile()){
            System.out.println("Product file created: " + productFile.getName());
        }
    }
    

}
