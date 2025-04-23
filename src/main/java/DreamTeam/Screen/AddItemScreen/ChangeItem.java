package main.java.DreamTeam.Screen.AddItemScreen;

import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Furniture;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.fileHandler.fileWriter;

public class ChangeItem {
    private String itemType;
    private Product product;

    public ChangeItem(String itemType){
        this.itemType = itemType;
    }
    //TODO: maybe have a universal createProduct in the product class?
    public void createProduct(String name, String companyName, double price, int quantity, String description){
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
    public void addToCatalog() throws Exception{
        Window.getCatalog().addProduct(product);
    }
    public void writeCatalogFile(){
        //TODO: don't do it on this function.
        fileWriter writer = new fileWriter(Window.getCatalog().allProducts, "allProductCatalog.txt");
        writer.writeProductsToFile();
    }
    public Product getProduct(){
        return product;
    }
}
