public class Electronics extends Product{
    private double powerConsumption;
    private double weight;
    private String electronicColor;

    public Electronics(double powerConsumption, double weight, String electronicColor) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.electronicColor = electronicColor;
    }

    public double getPowerConsumption(){
        return this.powerConsumption;
    }

    public double getWeight(){
        return this.weight;
    }

    public String getElectronicColor(){
        return this.electronicColor;
    }

    public void setSize(double powerConsumption){
        this.powerConsumption = powerConsumption;
    }

    public void setElectronicColor(String electronicColor){
        this.electronicColor = electronicColor;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
}
