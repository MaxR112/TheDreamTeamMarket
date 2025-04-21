package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;
import main.java.DreamTeam.Products.Product;

public class productCart {
    
    public ArrayList<Product> itemsInCart;
    private productCatalog currentProductCatalog;

    public productCart(productCatalog productCatalog){
        this.itemsInCart = new ArrayList<>();
        this.currentProductCatalog = productCatalog;
        System.out.println("Cart has been set with " + this.itemsInCart.size() + " products.");
    }

    public boolean addProductToCart(String name){
        Product catalogProduct = currentProductCatalog.getProductByName(name);
        for (Product cartProduct : itemsInCart){
            if (catalogProduct == null){
                return false;
            }if (cartProduct.equals(catalogProduct)){
                if (catalogProduct.getQuantity() >= 1){
                    cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                    return true;
                }
            }else {
                catalogProduct.setQuantity(1);
                itemsInCart.add(catalogProduct);
                return true;
            }
        }    
        return false;
    }  

    public boolean removeItemFromCart(String name){
        for (Product product : itemsInCart){
            if (product.getName().equalsIgnoreCase(name) && product.getQuantity() >= 2){
                product.setQuantity(product.getQuantity() - 1);
                return true;
            } else if (product.getName().equalsIgnoreCase(name)){
                itemsInCart.remove(product);
                System.out.println("Removed product " + product.getName() + " from cart.");
                return true;
            }
        }
        System.out.println("Could not remove this product from the cart " + name);
        return false;
        }

    public void updateQuantityOfItemInCart(String name, int newQuantity){
        for (Product product : itemsInCart){
            if (product.getName().equalsIgnoreCase(name) && product.getQuantity() != newQuantity){
                product.setQuantity(newQuantity);
            } else {
                System.out.println("Could not update quantity as your new quantity is the same as the old quantity.");
            }
        }
    }

    // TODO 
    // getTotalCartCost
    // checkout (update catalog quantity if successfull)
    // displayTotalCart


}
