public abstract class Product {
    protected  double price;
    protected String description;
    protected String name;
    protected int quantity;
    protected String companyName;
    protected String identifier;

    protected double getPrice(){
        return this.price;
    }

    protected void setPrice(double price){
        this.price = price;
    }

    protected String getDescription(){
        return this.description;
    }

    protected void setDescription(String description){
        this.description = description;
    }

    protected String getName(){
        return this.name;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected int getQuantity(){
        return this.quantity;
    }

    protected void setQuantity(int quantity){
        this.quantity = quantity;
    }

    protected String getCompany(){
        return this.companyName;
    }

    protected void setCompany(String companyName){
        this.companyName = companyName;
    }

    protected String getIdentifer(){
        return this.identifier;
    }
}
