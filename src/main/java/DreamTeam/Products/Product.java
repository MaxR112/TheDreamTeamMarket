package main.java.DreamTeam.Products;

public abstract class Product {
    public double price;
    public String description;
    public String name;
    public int quantity;
    public String companyName;
    public String identifier;

    public Product(double price, String description, String name, int quantity, String companyName, String identifier){
        this.price = price;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.companyName = companyName;
        this.identifier = identifier;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getCompany(){
        return this.companyName;
    }

    public void setCompany(String companyName){
        this.companyName = companyName;
    }

    public String getIdentifier(){
        return this.identifier;
    }
}
