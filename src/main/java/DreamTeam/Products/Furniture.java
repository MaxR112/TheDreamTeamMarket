package main.java.DreamTeam.Products;

public class Furniture extends Product{
    private String material;
    private String weight;
    private String furnitureColor;

    public Furniture(String name, double price, int quantity, String description, String companyName, String material, String weight, String furnitureColor) {
        super(price, description, name, quantity, companyName);
        this.material = material;
        this.weight = weight;
        this.furnitureColor = furnitureColor;
    }

    public String getMaterial(){
        return this.material;
    }

    public String getWeight(){
        return this.weight;
    }

    public String getFurnitureColor(){
        return this.furnitureColor;
    }

    public void setSize(String material){
        this.material = material;
    }

    public void setFurnitureColor(String furnitureColor){
        this.furnitureColor = furnitureColor;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    @Override
    public final String toString(){
        return "Furniture, " + this.name + ", " + this.price + ", " + this.quantity + ", " + this.description + ", " + this.companyName + ", " + this.material + ", " + this.weight + ", " + this.furnitureColor;
    }
    @Override
    public final Object[][] getAttributes(){
        return new Object[][] {
            {"Name", this.name},
            {"Price", this.price},
            {"Quantity", this.quantity},
            {"Description", this.description},
            {"Company Name", this.companyName},
            {"Material", this.material},
            {"Weight", this.weight},
            {"Color", this.furnitureColor}
        };
    }
}
