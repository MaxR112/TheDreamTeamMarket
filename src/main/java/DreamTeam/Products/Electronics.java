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
}
