public class Clothing extends Product{
    private String size;
    private String clothingType;
    private String clothingColor;

    public Clothing(String size, String clothingType, String clothingColor) {
        this.size = size;
        this.clothingType = clothingType;
        this.clothingColor = clothingColor;
    }

    public String getSize(){
        return this.size;
    }

    public String getClothingType(){
        return this.clothingColor;
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
}
