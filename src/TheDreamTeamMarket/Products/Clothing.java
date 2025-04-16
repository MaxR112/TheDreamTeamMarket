package TheDreamTeamMarket.Products;

import java.awt.Color;
import java.util.UUID;

public class Clothing implements Product{
    //Enum to define common components of clothing people wear.
    //TODO: add more.
    public enum ClothingType{
        Pants,
        Shirt,
        Jacket,
        Hat,
    }
    //Clothing-specific properties
    private String size;
    private ClothingType clothingType;
    private Color clothingColor;

    //Implement identifier
    private UUID identifier;

    //Constructor (Create unique identifier with identifier "S")
    public Clothing(int quantity, double price, String name, String description, String company, String size, ClothingType type, Color color){
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.description = description;
        this.company = company;
        this.size = size;
        this.clothingType = type;
        this.clothingColor = color;
        identifier = UUID.randomUUID();
    }
    //Getters/Setters of clothing properties
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }
    public ClothingType getClothingType(){
        return clothingType;
    }
    public void setClothingType(ClothingType type){
        this.clothingType = type;
    }
    public Color getClothingColor(){
        return clothingColor;
    }
    public void setClothingColor(Color color){
        this.clothingColor = color;
    }
    //Implement interface
    private int quantity;
    private double price;
    private String name;
    private String description;
    private String company;
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    @Override
    public String getIdentifier() {
        return "CH" + identifier.toString();
    }
}
