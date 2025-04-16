package TheDreamTeamMarket.Products;

public interface Product{
    public int getQuantity();
    public void setQuantity(int quantity);
    public double getPrice();
    public void setPrice(double price);
    public String getName(); 
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
    public String getCompany();
    public void setCompany(String company);
    public String getIdentifier();
}