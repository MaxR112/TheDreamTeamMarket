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

    @Override
    public Product cloneProduct(){
        return new Furniture(this.name, this.price, this.quantity, this.description, this.companyName, this.material, this.weight, this.furnitureColor);
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
    @Override
    public void setAttributes(Object[][] objects) throws IndexOutOfBoundsException {
        for(Object[] object : objects){
            if(String.valueOf(object[0]) == "Name" && object[1].getClass().getSimpleName() == "Integer"){
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
            if(String.valueOf(object[0]) == "Material"){
                this.material = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Weight"){
                this.weight = String.valueOf(object[1]);
            }
            if(String.valueOf(object[0]) == "Color"){
                this.furnitureColor = String.valueOf(object[1]);
            }
        }
    }
}
