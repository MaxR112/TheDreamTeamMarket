package main.java.DreamTeam.Catalog;

import java.util.ArrayList;
import java.util.List;

import main.java.DreamTeam.Products.Product;

public class Catalog {

    public ArrayList<Product> allProducts;

    public Catalog(){}

    public void setCatalog(List<Product> productList) {
        this.allProducts = new ArrayList<>(productList);
        System.out.println("Catalog has been set with " + productList.size() + " products.");

    }

    //* Buyer Methods *//
    public void displayAllCatalog() {
        if (allProducts.isEmpty()) {
            System.out.println("Catalog is currently empty.");
            return;
        }

        System.out.println("\n--- All Products in Catalog ---");
        for (Product product : allProducts) {
            displayProduct(product);
        }
    }

    public ArrayList<Product> displayByProduct(String productType) {
        ArrayList<Product> filtered = new ArrayList<>();
        System.out.println("\n--- Products filtered by type: " + productType + " ---");
        for (Product product : allProducts) {
            if (product.getClass().getSimpleName().equalsIgnoreCase(productType)) {
                displayProduct(product);
                filtered.add(product);
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("No products found in category: " + productType);
        }
        return filtered;
    }

    public Product getProductByName(String name) {
        for (Product product : allProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Found product: " + product.getName());
                return product;
            }
        }
        System.out.println("Product not found with name: " + name);
        return null;
    }

    public boolean updateQuantity(String identifier, int quantityToSubtract) {
        for (Product product : allProducts) {
            if (product.getIdentifier().equals(identifier)) {
                int currentQty = product.getQuantity();
                if (currentQty >= quantityToSubtract) {
                    product.setQuantity(currentQty - quantityToSubtract);
                    System.out.println("Updated quantity for " + product.getName()
                            + ": " + currentQty + " -> " + product.getQuantity());
                    return true;
                } else {
                    System.out.println("Insufficient quantity for " + product.getName()
                            + ". Available: " + currentQty + ", Requested: " + quantityToSubtract);
                    return false;
                }
            }
        }
        System.out.println("Product with ID " + identifier + " not found.");
        return false;
    }

//* Seller Methods *//
    public void addProduct(Product product) {
        allProducts.add(product);
        System.out.println("Added new product to catalog: " + product.getName()
                + " (Type: " + product.getClass().getSimpleName() + ")");
    }

    public boolean removeProduct(String name) {
        for (Product product : allProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                allProducts.remove(product);
                System.out.println("Removed product: " + product.getName());
                return true;
            }
        }
        System.out.println("Could not find product to remove: " + name);
        return false;
    }

    public boolean updateProduct(String name, Product updatedProduct) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getName().equalsIgnoreCase(name)) {
                allProducts.set(i, updatedProduct);
                System.out.println("Updated product: " + name);
                return true;
            }
        }
        System.out.println("No product found with name: " + name + " to update.");
        return false;
    }

//!Helpers 
    private void displayProduct(Product product) {
        System.out.println("[" + product.getClass().getSimpleName() + "] "
                + product.getName() + " | $" + product.getPrice()
                + " | Qty: " + product.getQuantity());
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}
