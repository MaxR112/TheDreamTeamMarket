package main.java.DreamTeam.Screen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.BuyerScreen.BuyerScreen;
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
        JPanel panel = Window.initPanel(this);
        panel.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        Layout(window, panel, constraints);
    }
    /**Create the layout of the panel, while setting properties for each element inside a part of the grid. */
    private void Layout(Window window, JPanel panel, GridBagConstraints constraints){
        constraints.fill = GridBagConstraints.NONE;
        TitleLabel(panel, constraints, 0, 0);

        BuyerButton(window, panel, constraints, 0, 1);
        SellerButton(window, panel, constraints, 0, 2);
    }
    private void TitleLabel(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel loginLabel = new JLabel("Login as Buyer or Seller?");
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 20, 0), 0, 40);

        panel.add(loginLabel, constraints);
    }
    private void BuyerButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton buyerButton = new JButton("Buyer");
        buyerButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        //Inline way (and non-DRY way) to listen to button inputs.
        buyerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new BuyerScreen(window, Window.getCatalog(), Window.getCart()));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 20, 0), 200, 40);

        panel.add(buyerButton, constraints);
    }
    private void SellerButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton sellerButton = new JButton("Seller");
        sellerButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        //Inline way (and non-DRY way) to listen to button inputs.
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new SellerScreen(window, Window.getCatalog()));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 0, 20, 0), 200, 40);

        panel.add(sellerButton, constraints);
    }
}