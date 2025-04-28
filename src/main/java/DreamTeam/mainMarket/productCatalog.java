package main.java.DreamTeam.mainMarket;

import java.util.ArrayList;

import main.java.DreamTeam.Exceptions.CouldNotUpdateQuantityException;
import main.java.DreamTeam.Exceptions.ProductNotFoundException;
import main.java.DreamTeam.Products.Product;

public class productCatalog {

    public ArrayList<Product> allProducts;

    public productCatalog(ArrayList<Product> productList) {
        this.allProducts = new ArrayList<>(productList);
        System.out.println("Catalog has been set with " + productList.size() + " products.");
    }

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

    public ArrayList<Product> displayByProductType(String productType) throws ProductNotFoundException {
        ArrayList<Product> filtered = new ArrayList<>();
        System.out.println("\n--- Products filtered by type: " + productType + " ---");
        for (Product product : allProducts) {
            if (product.getClass().getSimpleName().equalsIgnoreCase(productType)) {
                displayProduct(product);
                filtered.add(product);
            }
        }

        if (filtered.isEmpty()) {
            throw new ProductNotFoundException("No products found in category: " + productType);
        }
        return filtered;
    }

    public double getProductCost(String name) throws ProductNotFoundException {
        Product product = getProductByName(name);
        return product.getPrice();
    }

    public Product getProductByName(String name) throws ProductNotFoundException {
        for (Product product : allProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Found product: " + product.getName());
                return product;
            }
        }
        throw new ProductNotFoundException("Product not found with name: " + name);
    }

    public void removeProductQuantity(String name, int quantityToSubtract) throws CouldNotUpdateQuantityException, ProductNotFoundException {
        for (Product product : allProducts) {
            if (product.getName().equals(name)) {
                int currentQty = product.getQuantity();
                if (currentQty >= quantityToSubtract) {
                    product.setQuantity(currentQty - quantityToSubtract);
                    System.out.println("Updated quantity for " + product.getName()
                            + ": " + currentQty + " -> " + product.getQuantity());
                    return;
                } else {
                    throw new CouldNotUpdateQuantityException("Insufficient quantity for " + product.getName()
                            + ". Available: " + currentQty + ", Requested: " + quantityToSubtract);
                }
            }
        }
        throw new ProductNotFoundException("Product not found: " + name);
    }

    public void addProduct(Product product) throws IllegalArgumentException {
        for (Product productAlreadyInList : allProducts) {
            if (productAlreadyInList.getName().equals(product.getName())) {
                throw new IllegalArgumentException("Product name " + product.getName() + " already exists!");
            }
        }
        allProducts.add(product);
        System.out.println("Added new product to catalog: " + product.getName()
                + " (Type: " + product.getClass().getSimpleName() + ")");
    }

    public boolean removeProduct(String name) throws ProductNotFoundException {
        for (Product product : allProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                allProducts.remove(product);
                System.out.println("Removed product: " + product.getName());
                return true;
            }
        }
        throw new ProductNotFoundException("Could not find product to remove: " + name);
    }

    public boolean updateProduct(String name, Product updatedProduct) throws ProductNotFoundException {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getName().equalsIgnoreCase(name)) {
                allProducts.set(i, updatedProduct);
                System.out.println("Updated product: " + name);
                return true;
            }
        }
        throw new ProductNotFoundException("No product found with name: " + name + " to update.");

    }

    private void displayProduct(Product product) {
        System.out.println("[" + product.getClass().getSimpleName() + "] "
                + product.getName() + " | $" + product.getPrice()
                + " | Qty: " + product.getQuantity());
    }

    public ArrayList<Product> getRawProductsArray() {
        return allProducts;
    }

}
