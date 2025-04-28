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

import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.mainMarket.productCart;
import main.java.DreamTeam.mainMarket.productCatalog;

public class Checkout extends JPanel {
    /**
     * Init the screen with certain properties.
    */
    public Checkout(Window window, productCatalog catalog, productCart cart) throws IllegalArgumentException{
        //Set the constraints of layout manager (automatic rescaling and such)
        if(cart.getCountOfItemsInCart() == 0){
            throw new IllegalArgumentException("Cart count is too low for checkout.");
        }
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel panel = Window.initPanel(this);
        panel.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        Layout(panel, window, constraints, catalog, cart);
    }
    JPanel Layout(JPanel panel, Window window, GridBagConstraints constraints, productCatalog catalog, productCart cart){
        //Use default constraints for element centering.
        //Draw elements
        ScreenTitle(panel, constraints, 0, 0);

        CartCount(panel, constraints, cart, 0, 1);
        CartTotalPrice(panel, constraints, cart, 0, 2);

        PurchaseButton(window, panel, constraints, 0, 3);
        ViewCartButton(window, panel, constraints, catalog, cart, 0, 4);
        BackButton(window, panel, constraints, catalog, cart, 0, 5);
        return panel;
    }
    private static void ScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Do you want to purchase those items?");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
    }
    private static void CartCount(JPanel panel, GridBagConstraints constraints, productCart cart, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Items in cart: " + cart.getCountOfItemsInCart());
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 0, 0, 0), 0, 5);

        panel.add(screenTitle, constraints);
    }
    private static void CartTotalPrice(JPanel panel, GridBagConstraints constraints, productCart cart, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Total price: $" + String.format ("%.2f", cart.getTotalCost()));
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 0, 5, 0), 0, 5);

        panel.add(screenTitle, constraints);
    }

    private static void PurchaseButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Purchase");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int cartCount = Window.getCart().getCountOfItemsInCart();
                double totalPrice = Window.getCart().getTotalCost();
                boolean isThrown = false;
                try{
                    Window.getCart().checkout();
                }
                catch(Exception ex){
                    isThrown = true;
                    showMessageDialog(null, ex.getMessage());
                }
                //Prevent switching when exception is thrown so it stays in the same spot.
                if(!isThrown){
                    if(cartCount <= 1){
                        showMessageDialog(null, "Successfully purchased " + cartCount + " item for a total of $" + String.format ("%.2f", totalPrice) + ".");
                    }
                    else{
                        showMessageDialog(null, "Successfully purchased " + cartCount + " items for a total of $" + String.format ("%.2f", totalPrice) + ".");
                    }
                    //TODO: don't do this (move writeCatalogFile somewhere else)
                    ChangeItem item = new ChangeItem("Electronics");
                    item.writeCatalogFile();
                    window.setContentPane(new BuyerScreen(window, Window.getCatalog(), Window.getCart()));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 5, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private static void ViewCartButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, productCart cart, int gridX, int gridY){
        JButton addButton = new JButton("View Cart");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new ViewCart(window, catalog, cart));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 0, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private static void BackButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, productCart cart, int gridX, int gridY){
        JButton addButton = new JButton("Return to Buyer Panel");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new BuyerScreen(window, catalog, cart));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 0, 0), 100, 30);

        panel.add(addButton, constraints);
    }
}
