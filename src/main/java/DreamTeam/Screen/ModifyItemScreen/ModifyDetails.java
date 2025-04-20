package main.java.DreamTeam.Screen.ModifyItemScreen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;
import main.java.DreamTeam.fileHandler.fileWriter;

public class ModifyDetails{
    //This is stored as a private static variable for when the items are added eventually (this is to fix forcing pressing enter)
    private static JTextField nameTextbox;
    private static JTextField companyTextbox;
    private static JFormattedTextField quantityTextbox;
    private static JFormattedTextField priceTextbox;
    private static JTextArea descriptionTextbox;
    private static int productIndex;

    public static JPanel createLayout(JPanel panel, Window window, GridBagConstraints constraints, int productIndex){
        ModifyDetails.productIndex = productIndex;
        int gridX = constraints.gridx;
        int gridY = constraints.gridy;
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        constraints = createDetailsTitle(window, panel, constraints, gridX, gridY + 1);

        constraints = createNameTitle(window, panel, constraints, gridX, gridY + 2);
        constraints = createNameTextbox(window, panel, constraints, gridX + 1, gridY + 2);

        constraints = createCompanyTitle(window, panel, constraints, gridX, gridY + 3);
        constraints = createCompanyTextbox(window, panel, constraints, gridX + 1, gridY + 3);

        constraints = createQuantityTitle(window, panel, constraints, gridX, gridY + 4);
        constraints = createQuantityTextbox(window, panel, constraints, gridX + 1, gridY + 4);

        constraints = createPriceTitle(window, panel, constraints, gridX, gridY + 5);
        constraints = createPriceTextbox(window, panel, constraints, gridX + 1, gridY + 5);

        constraints = createDescriptionTitle(window, panel, constraints, gridX, gridY + 6);
        constraints = createDescriptionTextbox(window, panel, constraints, gridX, gridY + 7);

        constraints = createAddButton(window, panel, constraints, gridX, gridY + 8);
        constraints = createRemoveButton(window, panel, constraints, gridX + 1, gridY + 8);

        constraints = createBuffer(window, panel, constraints, gridX, gridY + 9);
        return panel;
    }
    private static GridBagConstraints createDetailsTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel nameTextbox = new JLabel("Details for this item");
        nameTextbox.setFont(new Font("Tahoma", Font.BOLD, 20));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 50, 10, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;
        
        panel.add(nameTextbox, constraints);
        return constraints;
    }
    private static GridBagConstraints createNameTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(name, constraints);
        return constraints;
    }
    private static GridBagConstraints createNameTextbox(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        nameTextbox = new JTextField(1);
        nameTextbox.setText(Window.getCatalog().allProducts.get(productIndex).getName());

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 115, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(nameTextbox, constraints);
        return constraints;
    }
    //TODO: The code below is basically the most unDRY'd code ever. Figure out a way to DRY that code.
    private static GridBagConstraints createCompanyTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel company = new JLabel("Company name:");
        company.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(company, constraints);
        return constraints;
    }
    private static GridBagConstraints createCompanyTextbox(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        companyTextbox = new JTextField(1);
        companyTextbox.setText(Window.getCatalog().allProducts.get(productIndex).getCompany());

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 190, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(companyTextbox, constraints);
        return constraints;
    }
    private static GridBagConstraints createQuantityTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel quantity = new JLabel("Quantity:");
        quantity.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(quantity, constraints);
        return constraints;
    }
    private static GridBagConstraints createQuantityTextbox(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        quantityTextbox = new JFormattedTextField(NumberFormat.getNumberInstance());
        quantityTextbox.setValue(Window.getCatalog().allProducts.get(productIndex).getQuantity());

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 140, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(quantityTextbox, constraints);
        return constraints;
    }
    private static GridBagConstraints createPriceTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel price = new JLabel("Price:");
        price.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(price, constraints);
        return constraints;
    }
    private static GridBagConstraints createPriceTextbox(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        priceTextbox = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        priceTextbox.setValue(Window.getCatalog().allProducts.get(productIndex).getPrice());

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 110, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(priceTextbox, constraints);
        return constraints;
    }
    private static GridBagConstraints createDescriptionTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel description = new JLabel("Description");
        description.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(description, constraints);
        return constraints;
    }
    //Read the value of description only when it's about to be added.
    private static GridBagConstraints createDescriptionTextbox(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        descriptionTextbox = new JTextArea(0, 0);
        descriptionTextbox.setPreferredSize(new Dimension(600, 50));
        descriptionTextbox.setText(Window.getCatalog().allProducts.get(productIndex).getDescription());

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 0;

        panel.add(descriptionTextbox, constraints);
        return constraints;
    }
    private static GridBagConstraints createAddButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Modify this item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window.getCatalog().allProducts.get(productIndex).setName(nameTextbox.getText());
                Window.getCatalog().allProducts.get(productIndex).setCompany(companyTextbox.getText());
                Window.getCatalog().allProducts.get(productIndex).setQuantity(((Number)quantityTextbox.getValue()).intValue());
                Window.getCatalog().allProducts.get(productIndex).setPrice(((Number)priceTextbox.getValue()).intValue());
                Window.getCatalog().allProducts.get(productIndex).setDescription(descriptionTextbox.getText());
                
                window.setContentPane(new SellerScreen(window));
                window.validate();

                fileWriter writer = new fileWriter(Window.getCatalog().allProducts, "allProductCatalog.txt");
                writer.writeProductsToFile();
                System.out.println("Successfully added product to the catalog, and saved to the file.");
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(addButton, constraints);
        return constraints;
    }
    private static GridBagConstraints createRemoveButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Remove this item");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window.getCatalog().allProducts.remove(productIndex);
                
                window.setContentPane(new SellerScreen(window));
                window.validate();

                fileWriter writer = new fileWriter(Window.getCatalog().allProducts, "allProductCatalog.txt");
                writer.writeProductsToFile();
                System.out.println("Successfully removed product from the catalog, and saved to the file.");
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 360, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(addButton, constraints);
        return constraints;
    }
    private static GridBagConstraints createBuffer(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel label = new JLabel("");

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 0, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(label, constraints);
        return constraints;
    }
}
