package main.java.DreamTeam.fileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Furniture;
import main.java.DreamTeam.Products.Product;

public class fileReader implements Files{

    public ArrayList<Product> allProductsRead = new ArrayList<>();
    public String filePath;
    public File productFile;

    public fileReader(String fileName){
        this.filePath = "src/main/resources/" + fileName;
        this.productFile = new File(this.filePath);
    }

    public static ArrayList<Product> readAllProductCatalogAndSaveToArray() {
        ArrayList<Product> productArray;

        fileReader pr = new fileReader("allProductCatalog.txt");

        pr.readFileAndStoreInList();
        productArray = new ArrayList<>(pr.getProductListFromRead());
        return productArray;
    }

    public void readFileAndStoreInList(){
        checkForFileAndCreateIfNotPresent();
        try {
            Scanner reader = new Scanner(new File(filePath));
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] individualLineValues = line.split(", ");
                switch (individualLineValues[0]) {
                    case "Electronics" -> {
                        createElectronicObject(individualLineValues);
                        System.out.println("electronic");
                    }
                    case "Clothing" -> {
                        createClothingObject(individualLineValues);
                        System.out.println("clothing");
                    }
                    case "Furniture" -> {
                        createFurnitureObject(individualLineValues);
                        System.out.println("furniture");
                    }
                    default -> System.out.println("Unknown product type!");
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File error: " + e);
        }
    }


    public ArrayList<Product> getProductListFromRead(){
        return allProductsRead;
    } 

    @Override
    public void checkForFileAndCreateIfNotPresent() {
        try {
            if (productFile.createNewFile()){
                System.out.println("Product file created: " + productFile.getName());
            }
        } catch (IOException e) {
            System.out.println("File error " + e);
        }
    }

    private void createFurnitureObject(String[] individualLineValues) {
        allProductsRead.add(new Furniture(individualLineValues[1], Double.parseDouble(individualLineValues[2]), Integer.parseInt(individualLineValues[3]), individualLineValues[4], individualLineValues[5], individualLineValues[6], individualLineValues[7], individualLineValues[8]));
    }

    private void createClothingObject(String[] individualLineValues) {
        allProductsRead.add(new Clothing(individualLineValues[1], Double.parseDouble(individualLineValues[2]), Integer.parseInt(individualLineValues[3]), individualLineValues[4], individualLineValues[5], individualLineValues[6], individualLineValues[7], individualLineValues[8]));
    }

    private void createElectronicObject(String[] individualLineValues) {
        allProductsRead.add(new Electronics(individualLineValues[1], Double.parseDouble(individualLineValues[2]), Integer.parseInt(individualLineValues[3]), individualLineValues[4], individualLineValues[5], individualLineValues[6], individualLineValues[7], individualLineValues[8]));
    }

}
