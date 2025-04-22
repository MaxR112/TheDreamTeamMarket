package main.java.DreamTeam.Products;

public abstract class Product {
    public double price;
    public String description;
    public String name;
    public int quantity;
    public String companyName;

    public Product(double price, String description, String name, int quantity, String companyName){
        this.price = price;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.companyName = companyName;
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

    @Override
    public String toString(){
        return "Product, " + this.name + ", " + this.price + ", " + this.quantity + ", " + this.description + ", " + this.companyName;
    }
    //Set to object to allow for integers.
    public Object[][] getAttributes(){
        return new Object[][] {
            {"Name", this.name},
            {"Price", this.price},
            {"Quantity", this.quantity},
            {"Description", this.description},
            {"Company Name", this.companyName}
        };
    }
}
