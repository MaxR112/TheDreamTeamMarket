package main.java.DreamTeam.Screen;

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

import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;

/**
 * High-level screen to log in as a buyer or seller.
*/
public class MainScreen extends JPanel{
    /**
     * Init the screen with certain properties.
    */
    public MainScreen(Window window) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();
        createLayout(window, initPanel(this), constraints);
    }
    /**Init the panel with the layout set to a grid layout. */
    JPanel initPanel(JPanel panel){
        //Settings for the screen.
        panel.setVisible(true);
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        return panel;
    }
    /**Create the layout of the panel, while setting properties for each element inside a part of the grid. */
    void createLayout(Window window, JPanel panel, GridBagConstraints constraints){
        constraints = createLabel(panel, constraints);

        constraints = createBuyerButton(window, panel, constraints);
        constraints = createSellerButton(window, panel, constraints);
    }
    GridBagConstraints createLabel(JPanel panel, GridBagConstraints constraints){
        JLabel loginLabel = new JLabel("Login as Buyer or Seller?");
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

        //Set the position of the component relative to grid layout.
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 0;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 0, 20, 0);
        //Set the size of the component
        constraints.ipady = 40;

        panel.add(loginLabel, constraints);
        return constraints;
    }
    GridBagConstraints createBuyerButton(Window window, JPanel panel, GridBagConstraints constraints){
        JButton buyerButton = new JButton("Buyer");
        buyerButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        //Inline way (and non-DRY way) to listen to button inputs.
        buyerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: implement buyer screen.
                System.out.println("buyer");
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 0, 20, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 40;

        panel.add(buyerButton, constraints);
        return constraints;
    }
    GridBagConstraints createSellerButton(Window window, JPanel panel, GridBagConstraints constraints){
        JButton sellerButton = new JButton("Seller");
        sellerButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        //Inline way (and non-DRY way) to listen to button inputs.
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new SellerScreen(window));
                window.validate();
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 2;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 0, 20, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 40;

        panel.add(sellerButton, constraints);
        return constraints;
    }
}