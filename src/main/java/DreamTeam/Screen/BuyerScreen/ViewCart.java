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

import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Panels.DisplayItem;
import main.java.DreamTeam.mainMarket.productCart;

/**
 * High-level screen for sellers to add and remove items.
*/
public class ViewCart extends JScrollPane{
    /**
     * Init the screen with certain properties.
    */
    public ViewCart(Window window) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(createLayout(panel, window, constraints));
    }
    JPanel createLayout(JPanel panel, Window window, GridBagConstraints constraints){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        constraints = createScreenTitle(panel, constraints, 0, 0);

        constraints = createCartTitle(panel, constraints, 0, 1);
        constraints = createCartCount(panel, constraints, 0, 2);
        constraints = createCartTotalPrice(panel, constraints, 0, 3);

        constraints = createBackButton(window, panel, constraints, 0, 4);
        constraints = createCheckoutButton(window, panel, constraints, 1, 4);

        constraints = createCartListingTitle(panel, constraints, 0, 5);
        constraints = createListing(window, panel, constraints, Window.getCart(), 0, 6);
        return panel;
    }
    GridBagConstraints createScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("View Cart");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    
    GridBagConstraints createCartTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Your Cart");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createCartCount(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Items in cart: " + Window.getCart().getCountOfItemsInCart());
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 5);

        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createCartTotalPrice(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Total price: $" + String.format ("%.2f", Window.getCart().getTotalCost()));
        screenTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 5, 0), 0, 5);

        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }

    GridBagConstraints createBackButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("View Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new BuyerScreen(window));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 5, 0), 100, 30);

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createCheckoutButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        if(Window.getCart().getCountOfItemsInCart() != 0){
            JButton addButton = new JButton("Checkout");
            //Inline way (and non-DRY way) to listen to button inputs.
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    window.setContentPane(new Checkout(window));
                    window.validate();
                }
            });
    
            constraints = ResetConstraints.setConstraints(
                constraints, gridX, gridY, new Insets(5, 265, 0, 0), 100, 30);
    
            panel.add(addButton, constraints);
        }
        return ResetConstraints.reset(constraints);
    }
    
    GridBagConstraints createCartListingTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel catalogTitle = new JLabel("Your Item List");
        catalogTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 0, 20);

        panel.add(catalogTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createListing(Window window, JPanel panel, GridBagConstraints constraints, productCart cart, int gridX, int gridY){
        if(cart.getCartList().size() != 0){
            for(int i = 0; i < cart.getCartList().size(); i++){
                //gridY resets upon calling method, requires setting value every time on the loop.
                constraints.gridy = gridY;
                DisplayItem.createItemInfo(window, panel, constraints, cart.getCartList().get(i), i);
                constraints.gridy = gridY + 7;
                constraints = createRemoveButton(window, panel, constraints, i, gridX, gridY + 8);
                gridY += 8;
            }
        }
        else{
        JLabel catalogTitle = new JLabel("There are no items in your list.");
        catalogTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50, 0, 0), 0, 20);

        panel.add(catalogTitle, constraints);
        }
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createRemoveButton(Window window, JPanel panel, GridBagConstraints constraints, int productIndex, int gridX, int gridY){
        JButton modifyButton = new JButton("Remove from Cart");
        //Inline way (and non-DRY way) to listen to button inputs.
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = Window.getCart().getCartList().get(productIndex).getName();
                boolean isThrown = false;
                try{
                    Window.getCart().removeProduct(productName);
                }
                catch(Exception ex){
                    isThrown = true;
                    showMessageDialog(null, ex.getMessage());
                }

                //Prevent switching when exception is thrown so it stays in the same spot.
                if(!isThrown){
                    //Very stupid way to update the value but it works.
                    window.setContentPane(new ViewCart(window));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 40, 0), 50, 20);

        panel.add(modifyButton, constraints);
        return ResetConstraints.reset(constraints);
    }
}
