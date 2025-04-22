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

import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.ResetConstraints;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.Screen.AddItemScreen.AddItemScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

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
        constraints = createScreenTitle(panel, constraints, 0, 0);

        constraints = createBackButton(window, panel, constraints, 0, 1);
        constraints = createAddButton(window, panel, constraints, 1, 1);

        constraints = createCatalogTitle(panel, constraints, 0, 2);
        constraints = createListing(window, panel, constraints, Window.getCatalog(), 0, 3);
        return panel;
    }
    GridBagConstraints createScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Seller Panel");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));


        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createAddButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Add Item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new AddItemScreen(window));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 100, 30);

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createBackButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Return to Login");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new MainScreen(window));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 320, 0, 0), 100, 30);

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createCatalogTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel catalogTitle = new JLabel("Catalog");
        catalogTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(50, 50, 0, 0), 0, 20);

        panel.add(catalogTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createListing(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        for(int i = 0; i < catalog.allProducts.size(); i++){
            constraints = DisplayItem.createItemInfo(window, panel, constraints, catalog.allProducts.get(i), i);
            constraints.gridy += 11;
        }
        return ResetConstraints.reset(constraints);
    }
}
