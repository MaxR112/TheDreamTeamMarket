package main.java.DreamTeam.mainMarket;
import java.util.ArrayList;

import main.java.DreamTeam.Products.Product;
public class productCart {

    private ArrayList<Product> cartList;
    private productCatalog catalog;

    public productCart(productCatalog catalog) {
        this.catalog = catalog;
        this.cartList = new ArrayList<>();
    }

    public boolean addProduct(String name) {
        Product catalogProduct = catalog.getProductByName(name);
        if (catalogProduct == null) {
            System.out.println("Product not found in catalog.");
            return false;
        }

        for (Product cartProduct : cartList) {
            if (cartProduct.getName().equalsIgnoreCase(name)) {
                if (catalogProduct.getQuantity() > cartProduct.getQuantity()) {
                    cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                    System.out.println("Increased quantity in cart: " + cartProduct.getName());
                    return true;
                } else {
                    System.out.println("Not enough stock for: " + catalogProduct.getName());
                    return false;
                }
            }
        }

        if (catalogProduct.getQuantity() >= 1) {
            Product productCopy = new Product(
                    catalogProduct.getPrice(),
                    catalogProduct.getDescription(),
                    catalogProduct.getName(),
                    1,
                    catalogProduct.getCompany()
            ) {
            };
            cartList.add(productCopy);
            System.out.println("Added to cart: " + productCopy.getName());
            return true;
        } else {
            System.out.println("Out of stock: " + catalogProduct.getName());
            return false;
        }
    }

    public void removeProduct(String name) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getName().equalsIgnoreCase(name)) {
                cartList.remove(i);
                System.out.println("Removed from cart: " + name);
                return;
            }
        }
        System.out.println("Product not found in cart: " + name);
    }

    public void updateQuantityOfItemInCart(String name, int newQuantity){
        for (Product product : cartList){
            if (product.getName().equalsIgnoreCase(name) && product.getQuantity() != newQuantity && catalog.getProductByName(name).getQuantity() >= newQuantity){
                product.setQuantity(newQuantity);
            } else {
                System.out.println("Could not update quantity.");
            }
        }
    }

    public void checkout() {
        if (cartList.isEmpty()) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }

        for (Product cartProduct : cartList) {
            boolean success = catalog.removeProductQuantity(cartProduct.getName(), cartProduct.getQuantity());
            if (!success) {
                System.out.println("Could not complete checkout for: " + cartProduct.getName());
            }
        }

        cartList.clear();
        System.out.println("Checkout complete. Cart is now empty.");
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Product p : cartList) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    public String displayCart() {
        if (cartList.isEmpty()) {
            return "Cart is currently empty.";
        }

        StringBuilder sb = new StringBuilder("\n--- Your Cart ---\n");
        for (Product p : cartList) {
            sb.append(p.getName())
                    .append(" | Qty: ").append(p.getQuantity())
                    .append(" | $").append(p.getPrice()).append(" each\n");
        }
        sb.append("Total: $").append(getTotalCost()).append("\n");
        return sb.toString();
    }

    public ArrayList<Product> getCartList() {
        return cartList;
    }

    public int getCountOfItemsInCart(){
        int total = 0;
        for (Product cartProduct : cartList){
            total += cartProduct.getQuantity();
        }
        return total;
    }
}