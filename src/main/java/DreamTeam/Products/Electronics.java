package main.java.DreamTeam.Products;

public class Electronics extends Product{
    private String powerConsumption;
    private String weight;
    private String electronicColor;

    public Electronics(String name, double price, int quantity, String description, String companyName, String powerConsumption, String weight, String electronicColor) {
        super(price, description, name, quantity, companyName);
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.electronicColor = electronicColor;
    }
    
    @Override
    public Product cloneProduct(){
        return new Electronics(this.name, this.price, this.quantity, this.description, this.companyName, this.powerConsumption, this.weight, this.electronicColor);
    }

    public String getPowerConsumption(){
        return this.powerConsumption;
    }

    public String getWeight(){
        return this.weight;
    }

    public String getElectronicColor(){
        return this.electronicColor;
    }

    public void setPowerConsumption(String powerConsumption){
        this.powerConsumption = powerConsumption;
    }

    public void setElectronicColor(String electronicColor){
        this.electronicColor = electronicColor;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    @Override
    public final String toString(){
        return "Electronics, " + this.name + ", " + this.price + ", " + this.quantity + ", " + this.description + ", " + this.companyName + ", " + this.powerConsumption + ", " + this.weight + ", " + this.electronicColor;
    }
    @Override
    public final Object[][] getAttributes(){
        return new Object[][] {
            {"Name", this.name},
            {"Price", this.price},
            {"Quantity", this.quantity},
            {"Description", this.description},
            {"Company Name", this.companyName},
            {"Power", this.powerConsumption},
            {"Weight", this.weight},
            {"Color", this.electronicColor}
        };
    }
    @Override
    public void setAttributes(Object[][] objects) throws IndexOutOfBoundsException {
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
            if(String.valueOf(object[0]) == "Power"){
                this.powerConsumption = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Weight"){
                this.weight = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Color"){
                this.electronicColor = String.valueOf(object[1]);
            }
        }
    }
}
