package main.java.DreamTeam.Screen.AddItemScreen;

import static javax.swing.JOptionPane.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Screen.Assets.AttributeTextField.modifyAttributes;
import main.java.DreamTeam.Screen.Assets.BaseAttributeTextField;
import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;

//TODO: pass catalog as a parameter?
public class AddDetails{
    //This is stored as a private static variable for when the items are added eventually (this is to fix forcing pressing enter)
    private static BaseAttributeTextField textFields = new BaseAttributeTextField();
    private static ArrayList<modifyAttributes> otherTextField;
    private static ChangeItem item;

    public static JPanel createLayout(JPanel panel, Window window, GridBagConstraints constraints, String productType){
        item = new ChangeItem(productType);
        item.createProduct("", "", 0, 0, "");

        otherTextField = new ArrayList<>();

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

        constraints = textFields.createNameTitle(window, panel, constraints, gridX, gridY + 2);
        constraints = textFields.createNameTextbox(window, panel, constraints, null, gridX + 1, gridY + 2);

        constraints = textFields.createCompanyTitle(window, panel, constraints, gridX, gridY + 3);
        constraints = textFields.createCompanyTextbox(window, panel, constraints, null, gridX + 1, gridY + 3);

        constraints = textFields.createQuantityTitle(window, panel, constraints, gridX, gridY + 4);
        constraints = textFields.createQuantityTextbox(window, panel, constraints, 0, gridX + 1, gridY + 4);

        constraints = textFields.createPriceTitle(window, panel, constraints, gridX, gridY + 5);
        constraints = textFields.createPriceTextbox(window, panel, constraints, 0, gridX + 1, gridY + 5);

        constraints = textFields.createDescriptionTitle(window, panel, constraints, gridX, gridY + 6);
        constraints = textFields.createDescriptionTextbox(window, panel, constraints, null, gridX, gridY + 7);

        //This affects constraints
        otherTextField = ModifyAttribute.createLayout(panel, window, constraints, item, otherTextField, gridX, gridY + 8);
        //Set to new constraints after creating additional attribute layout.
        gridX = constraints.gridx;
        gridY = constraints.gridy;

        constraints = createAddButton(window, panel, constraints, gridX, gridY);
        constraints = createBuffer(window, panel, constraints, gridX, gridY + 1);
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
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createAddButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Add Item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isThrown = false;
                //TODO: maybe don't instantiate a product?
                try{
                    
                    //Ensure all of these operations run successfully before switching screens.
                    item.createProduct(
                        textFields.getNameTextbox().getText(),
                        textFields.getCompanyTextbox().getText(),
                        ((Number)textFields.getPriceTextbox().getValue()).intValue(),
                        ((Number)textFields.getQuantityTextbox().getValue()).intValue(),
                        textFields.getDescriptionTextbox().getText());

                    item.setProduct(ModifyAttribute.readAttributeFields(item.getProduct(), otherTextField));

                    item.addToCatalog();
                }
                catch(NullPointerException ex){
                    showMessageDialog(null, "There are missing values, please fill them out!");
                    isThrown = true;
                }
                catch(Exception ex){
                    showMessageDialog(null, ex.getMessage());
                    isThrown = true;
                }
                if(!isThrown){
                    item.writeCatalogFile();
                    System.out.println("Successfully added product to the catalog, and saved to the file.");
    
                    window.setContentPane(new SellerScreen(window));
                    window.validate();
                }
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
        return ResetConstraints.reset(constraints);
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
        return ResetConstraints.reset(constraints);
    }
}
