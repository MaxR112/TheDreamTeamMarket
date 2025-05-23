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
    
    @Override
    public Product cloneProduct(){
        return new Clothing(this.name, this.price, this.quantity, this.description, this.companyName, this.size, this.clothingType, this.clothingColor);
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

    @Override
    public final String toString(){
        return "Clothing, " + this.name + ", " + this.price + ", " + this.quantity + ", " + this.description + ", " + this.companyName + ", " + this.size + ", " + this.clothingType + ", " + this.clothingColor;
    }
    @Override
    public final Object[][] getAttributes(){
        return new Object[][] {
            {"Name", this.name},
            {"Price", this.price},
            {"Quantity", this.quantity},
            {"Description", this.description},
            {"Company Name", this.companyName},
            {"Size", this.size},
            {"Type", this.clothingType},
            {"Color", this.clothingColor}
        };
    }
    @Override
    public void setAttributes(Object[][] objects){
        for(Object[] object : objects){
            if(String.valueOf(object[0]) == "Name"){
                this.name = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Price"){
                this.price = (Double)object[1];
            }
            if(String.valueOf(object[0]) == "Quantity"){
                this.quantity = (Integer)object[1];
            }
            if(String.valueOf(object[0]) == "Description"){
                this.description = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Company Name"){
                this.companyName = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Size"){
                this.size = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Type"){
                this.clothingType = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Color"){
                this.clothingColor = String.valueOf(object[1]);
            }
        }
    }

}
