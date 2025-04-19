package main.java.DreamTeam.Products;

public class Clothing extends Product{
    private String size;
    private String clothingType;
    private String clothingColor;

    public Clothing(String name, double price, int quantity, String description, String companyName, String size, String clothingType, String clothingColor) {
        super(price, description, name, quantity, companyName);
        this.size = size;
        this.clothingType = clothingType;
        this.clothingColor = clothingColor;
    }

    public String getSize(){
        return this.size;
    }

    public String getClothingType(){
        return this.clothingType;
    }

    public String getClothingColor(){
        return this.clothingColor;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setClothingType(String clothingType){
        this.clothingType = clothingType;
    }

    public void setClothingColor(String clothingColor){
        this.clothingColor = clothingColor;
    }
}
