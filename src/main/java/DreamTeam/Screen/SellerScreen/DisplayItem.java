package main.java.DreamTeam.Screen.SellerScreen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.Screen.ModifyItemScreen.ModifyItemScreen;

public class DisplayItem {
    //Adds +5 to gridY.
    static GridBagConstraints createItemInfo(
            Window window, JPanel panel, GridBagConstraints constraints, Product product, int productIndex){
        //Get current positions that won't be altered.
        int gridX = constraints.gridx;
        int gridY = constraints.gridy;
        constraints = createTitle(panel, constraints, product, gridX, gridY + 1);

        constraints = createTypeTitle(panel, constraints, product, gridX, gridY + 2);
        constraints = createType(panel, constraints, product, gridX, gridY + 3);

        constraints = createPriceTitle(panel, constraints, product, gridX + 1, gridY + 2);
        constraints = createPrice(panel, constraints, product, gridX + 1, gridY + 3);
        
        constraints = createQuantityTitle(panel, constraints, product, gridX + 2, gridY + 2);
        constraints = createQuantity(panel, constraints, product, gridX + 2, gridY + 3);

        constraints = createDescriptionTitle(panel, constraints, product, gridX, gridY + 4);
        constraints = createDescription(panel, constraints, product, gridX, gridY + 5);
        
        constraints = createModifyButton(window, panel, constraints, productIndex, gridX, gridY + 6);

        constraints.gridy += 5;
        return constraints;
    }
    private static GridBagConstraints createTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel itemTitle = new JLabel(product.name + " - " + product.companyName);
        itemTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(10, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(itemTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createTypeTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Item Type");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createType(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel(product.getClass().getSimpleName());
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createPriceTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Price");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 170, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    //Assumes price is in USD
    private static GridBagConstraints createPrice(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("$" + String.format("%.2f", product.price));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 170, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createQuantityTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Quantity");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 290, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    //Assumes price is in USD
    private static GridBagConstraints createQuantity(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel(String.valueOf(product.quantity));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 290, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 10;

        panel.add(priceTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createDescriptionTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel descriptionTitle = new JLabel("Description");
        descriptionTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(10, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 5;

        panel.add(descriptionTitle, constraints);
        return constraints;
    }
    private static GridBagConstraints createDescription(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        //Html tags to wrap the text.
        JLabel description = new JLabel("<html>" + product.description + "</html>");
        description.setFont(new Font("Tahoma", Font.PLAIN, 15));
        description.setVerticalAlignment(JLabel.TOP);
        description.setPreferredSize(new Dimension(Window.getScreenWidth() - 100, 50));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(10, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 5;

        panel.add(description, constraints);
        return constraints;
    }
    private static GridBagConstraints createModifyButton(Window window, JPanel panel, GridBagConstraints constraints, int productIndex, int gridX, int gridY){
        JButton modifyButton = new JButton("Modify this item");
        //Inline way (and non-DRY way) to listen to button inputs.
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new ModifyItemScreen(window, productIndex));
                window.validate();
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(10, 50, 40, 0);
        //Set the size of the component
        constraints.ipadx = 50;
        constraints.ipady = 20;

        panel.add(modifyButton, constraints);
        return constraints;
    }
}
