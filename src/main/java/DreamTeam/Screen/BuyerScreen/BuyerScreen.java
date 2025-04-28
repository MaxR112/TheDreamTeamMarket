package main.java.DreamTeam.Screen.BuyerScreen;

import static javax.swing.JOptionPane.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.DreamTeam.Exceptions.CouldNotUpdateQuantityException;
import main.java.DreamTeam.Exceptions.ProductNotFoundException;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Panels.DisplayItem;
import main.java.DreamTeam.mainMarket.productCart;
import main.java.DreamTeam.mainMarket.productCatalog;

/**
 * High-level screen for sellers to add and remove items.
*/
public class BuyerScreen extends JScrollPane{
    /**
     * Init the screen with certain properties.
    */
    public BuyerScreen(Window window, productCatalog catalog, productCart cart) {

        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(Layout(panel, window, constraints, catalog, cart));
    }
    JPanel Layout(JPanel panel, Window window, GridBagConstraints constraints, productCatalog catalog, productCart cart){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        ScreenTitle(panel, constraints, 0, 0);

        BackButton(window, panel, constraints, 0, 1);

        CartTitle(panel, constraints, 0, 2);
        CartCount(panel, constraints, cart, 0, 3);
        CartTotalPrice(panel, constraints, cart, 0, 4);
        ViewCartButton(window, panel, constraints, catalog, cart, 0, 5);
        CheckoutButton(window, panel, constraints, catalog, cart, 1, 5);

        CatalogTitle(panel, constraints, 0, 6);
        Listing(window, panel, constraints, catalog, 0, 7);
        return panel;
    }
    private void ScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Buyer Panel");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
    }
    private void BackButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Return to Login");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new MainScreen(window));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 5, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    
    private void CartTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Your Cart");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
    }
    private void CartCount(JPanel panel, GridBagConstraints constraints, productCart cart, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Items in cart: " + cart.getCountOfItemsInCart());
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 5);

        panel.add(screenTitle, constraints);
    }
    private void CartTotalPrice(JPanel panel, GridBagConstraints constraints, productCart cart, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Total price: $" + String.format ("%.2f", cart.getTotalCost()));
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 5, 0), 0, 5);

        panel.add(screenTitle, constraints);
    }
    private void ViewCartButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, productCart cart, int gridX, int gridY){
        JButton addButton = new JButton("View Cart");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new ViewCart(window, catalog, cart));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private void CheckoutButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, productCart cart, int gridX, int gridY){
        if(cart.getCountOfItemsInCart() != 0){
            JButton addButton = new JButton("Checkout");
            //Inline way (and non-DRY way) to listen to button inputs.
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    window.setContentPane(new Checkout(window, catalog, cart));
                    window.validate();
                }
            });
    
            constraints = ResetConstraints.setConstraints(
                constraints, gridX, gridY, new Insets(5, 265, 0, 0), 100, 30);
    
            panel.add(addButton, constraints);
        }
    }
    
    private void CatalogTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel catalogTitle = new JLabel("Buy Items");
        catalogTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 0, 20);

        panel.add(catalogTitle, constraints);
    }
    private void Listing(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        for(int i = 0; i < catalog.allProducts.size(); i++){
            //gridY resets upon calling method, requires setting value every time on the loop.
            constraints.gridx = gridX;
            constraints.gridy = gridY;
            DisplayItem.DisplayItemInfo(panel, constraints, catalog.allProducts.get(i), i);
            constraints.gridx = gridX + DisplayItem.getGridXDistance();
            constraints.gridy = gridY + DisplayItem.getGridYDistance();
            AddToCartButton(window, panel, constraints, i, gridX, gridY + 8);
            gridX += DisplayItem.getGridXDistance();
            gridY += DisplayItem.getGridYDistance() + 1;
        }
    }
    /**
     * Note: Modifies the Window product cart, may require retrieving the cart from Window again.
     * @param window
     * @param panel
     * @param constraints
     * @param productIndex
     * @param gridX
     * @param gridY
     */
    private static void AddToCartButton(Window window, JPanel panel, GridBagConstraints constraints, int productIndex, int gridX, int gridY){
        JButton modifyButton = new JButton("Add to Cart");
        //Inline way (and non-DRY way) to listen to button inputs.
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = Window.getCatalog().allProducts.get(productIndex).getName();
                boolean isThrown = false;
                try{
                    Window.getCart().addProduct(productName);
                }
                catch(ProductNotFoundException ex){
                    isThrown = true;
                    System.out.println(ex);
                    showMessageDialog(null, "The selected product for this catalog does not exist!");
                }
                catch(CouldNotUpdateQuantityException ex){
                    isThrown = true;
                    System.out.println(ex);
                    showMessageDialog(null, "There are too few items to add to your cart for this product!");
                }

                //Prevent switching when exception is thrown so it stays in the same spot.
                if(!isThrown){
                    //Very stupid way to update the value but it works.
                    window.setContentPane(new BuyerScreen(window, Window.getCatalog(), Window.getCart()));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 40, 0), 50, 20);

        panel.add(modifyButton, constraints);
    }
}
