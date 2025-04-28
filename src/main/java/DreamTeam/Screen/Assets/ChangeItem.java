package main.java.DreamTeam.Screen.Assets;

import java.io.IOException;

import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Furniture;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.fileHandler.fileWriter;
import main.java.DreamTeam.mainMarket.productCatalog;

public class ChangeItem {
    private String itemType;
    private Product product;

    public ChangeItem(String itemType){
        this.itemType = itemType;
    }
    public void createProduct() throws IllegalArgumentException{
        switch(itemType){
            //Escape condition when not selecting an item.
            case "Select an item":
                break;
            case "Electronics":
                this.product =
                    new Electronics(null, 0, 0, null, null,
                        null, null, null);
                System.out.println("electronic");
                break;
            case "Clothing":
                this.product =
                    new Clothing(null, 0, 0, null, null,
                        null, null, null);
                System.out.println("clothing");
                break;
            case "Furniture":
                this.product =
                    new Furniture(null, 0, 0, null, null,
                        null, null, null);
                System.out.println("furniture");
                break;
            default: throw new IllegalArgumentException("Invalid item type");
        }
    }
    public void createProduct(String name, String companyName, double price, int quantity, String description) throws IllegalArgumentException{
        if(name.equals("") || name.equals("") || name.equals("")){
            throw new IllegalArgumentException("The string values are empty.");
        }
        switch(itemType){
            //Escape condition when not selecting an item.
            case "Select an item":
                break;
            case "Electronics":
                this.product =
                    new Electronics(name, price, quantity, description, companyName,
                        null, null, null);
                System.out.println("electronic");
                break;
            case "Clothing":
                this.product =
                    new Clothing(name, price, quantity, description, companyName,
                        null, null, null);
                System.out.println("clothing");
                break;
            case "Furniture":
                this.product =
                    new Furniture(name, price, quantity, description, companyName,
                        null, null, null);
                System.out.println("furniture");
                break;
            default: throw new IllegalArgumentException("Invalid item type");
        }
    }
    /**
     * Adds the product to the static Window catalog.
     * @return the catalog in Window.
     */
    public productCatalog addToCatalog() throws Exception{
        Window.getCatalog().addProduct(product);
        return Window.getCatalog();
    }
    /**
     * Modifies the product to the static Window catalog.
     * @return the catalog in Window.
     */
    public productCatalog setItemAtCatalog() throws Exception{
        Window.getCatalog().updateProduct(product.getName(), product);
        return Window.getCatalog();
    }
    public productCatalog removeItemAtCatalog() throws Exception{
        Window.getCatalog().removeProduct(product.getName());
        return Window.getCatalog();
    }
    public void writeCatalogFile(){
        //TODO: don't do it on this function.
        fileWriter writer = new fileWriter(Window.getCatalog().allProducts, "allProductCatalog.txt");
        try {
            writer.writeProductsToFile();
        } catch (IOException e) {
            System.out.println("File error.");
        }
    }
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
}
