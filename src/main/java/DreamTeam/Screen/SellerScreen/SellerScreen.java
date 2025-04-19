package main.java.DreamTeam.Screen.SellerScreen;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.DreamTeam.Catalog.productCatalog;
import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Window;

/**
 * High-level screen for sellers to add and remove items.
*/
public class SellerScreen extends JScrollPane{
    /**
     * Init the screen with certain properties.
    */
    public SellerScreen(Window window) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(createLayout(panel, window, constraints));
    }
    /**Init the panel with the layout set to a grid layout. */
    JPanel initPanel(JPanel panel){
        //Settings for the screen.
        panel.setVisible(true);
        panel.setLayout(new GridBagLayout());
        //panel.setPreferredSize(new Dimension(Window.getScreenWidth(), panel.getPreferredSize().height));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        return panel;
    }
    JPanel createLayout(JPanel panel, Window window, GridBagConstraints constraints){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        constraints = createScreenTitle(panel, constraints);

        constraints = createBackButton(window, panel, constraints);
        constraints = createAddButton(panel, constraints);

        constraints = createCatalogTitle(panel, constraints);
        constraints = createListing(panel, constraints, Window.getCatalog());
        return panel;
    }
    GridBagConstraints createScreenTitle(JPanel panel, GridBagConstraints constraints){
        JLabel screenTitle = new JLabel("Seller Panel");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 0;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipady = 20;
        
        panel.add(screenTitle, constraints);
        return constraints;
    }
    GridBagConstraints createAddButton(JPanel panel, GridBagConstraints constraints){
        JButton addButton = new JButton("Add Item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: implement add/modify screen.
                System.out.println("add item");
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 1;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(addButton, constraints);
        return constraints;
    }
    GridBagConstraints createBackButton(Window window, JPanel panel, GridBagConstraints constraints){
        JButton addButton = new JButton("Return to Login");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new MainScreen(window));
                window.validate();
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = 1;
        constraints.gridy = 1;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 320, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(addButton, constraints);
        return constraints;
    }
    GridBagConstraints createCatalogTitle(JPanel panel, GridBagConstraints constraints){
        JLabel screenTitle = new JLabel("Catalog");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 2;
        //Set the position within the grid layout.
        constraints.insets = new Insets(50, 50, 0, 0);
        //Set the size of the component
        constraints.ipady = 20;
        
        panel.add(screenTitle, constraints);
        return constraints;
    }
    GridBagConstraints createListing(JPanel panel, GridBagConstraints constraints, productCatalog catalog){
        for(int i = 0; i < catalog.allProducts.size(); i++){
            constraints = DisplayItem.createItemInfo(panel, constraints, catalog.allProducts.get(i));
        }
        return constraints;
    }
}
