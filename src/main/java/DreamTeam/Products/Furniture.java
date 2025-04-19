package main.java.DreamTeam.Products;

public class Furniture extends Product{
    private String material;
    private double weight;
    private String furnitureColor;

    public Furniture(String name, double price, int quantity, String description, String companyName, String material, double weight, String furnitureColor) {
        super(price, description, name, quantity, companyName);
        this.material = material;
        this.weight = weight;
        this.furnitureColor = furnitureColor;
    }

    public String getMaterial(){
        return this.material;
    }

    public double getWeight(){
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

    public void setWeight(double weight){
        this.weight = weight;
    }

    @Override
    public String toString(){
        return this.name + this.price + this.quantity + this.description + this.companyName + this.material + this.weight + this.furnitureColor;
    }
}
