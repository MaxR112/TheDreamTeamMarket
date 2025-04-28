package main.java.DreamTeam.Screen.Assets.AttributeTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseAttributeTextField {
    private JTextField nameTextbox;
    private JTextField companyTextbox;
    private JFormattedTextField quantityTextbox;
    private JFormattedTextField priceTextbox;
    private JTextArea descriptionTextbox;

    public void NameTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
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
        
    }
    public JTextField getNameTextbox(){
        return nameTextbox;
    }
    public void NameTextbox(JPanel panel, GridBagConstraints constraints, String value, int gridX, int gridY){
        nameTextbox = new JTextField(value, 1);

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 115, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(nameTextbox, constraints);
        
    }
    public void CompanyTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
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
        
    }
    public JTextField getCompanyTextbox(){
        return companyTextbox;
    }
    public void CompanyTextbox(JPanel panel, GridBagConstraints constraints, String value, int gridX, int gridY){
        companyTextbox = new JTextField(value, 1);

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 190, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(companyTextbox, constraints);
        
    }
    public void QuantityTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
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
        
    }
    public JFormattedTextField getQuantityTextbox(){
        return quantityTextbox;
    }
    public void QuantityTextbox(JPanel panel, GridBagConstraints constraints, int value, int gridX, int gridY){
        quantityTextbox = new JFormattedTextField(NumberFormat.getNumberInstance());
        quantityTextbox.setValue(value);
        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 140, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(quantityTextbox, constraints);
        
    }
    public void PriceTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
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
        
    }
    public JFormattedTextField getPriceTextbox(){
        return priceTextbox;
    }
    public void PriceTextbox(JPanel panel, GridBagConstraints constraints, double value, int gridX, int gridY){
        priceTextbox = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        priceTextbox.setValue(value);

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 110, 0, 0);
        //Set the size of the component
        constraints.ipadx = 200;
        constraints.ipady = 10;

        panel.add(priceTextbox, constraints);
        
    }
    public void DescriptionTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
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
        
    }
    public JTextArea getDescriptionTextbox(){
        return descriptionTextbox;
    }
    //Read the value of description only when it's about to be added.
    public void DescriptionTextbox(JPanel panel, GridBagConstraints constraints, String value, int gridX, int gridY){
        descriptionTextbox = new JTextArea(0, 0);
        descriptionTextbox.setPreferredSize(new Dimension(600, 50));
        descriptionTextbox.setText(value);

        //Set the position of the component relative to grid layout.
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 0;

        panel.add(descriptionTextbox, constraints);
        
    }
}
