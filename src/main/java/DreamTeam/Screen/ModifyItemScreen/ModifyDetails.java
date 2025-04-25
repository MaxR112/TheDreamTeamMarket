package main.java.DreamTeam.Screen.ModifyItemScreen;

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

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.CreateAdditionalAttributes;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField.modifyAttributes;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.BaseAttributeTextField;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;

//TODO: unDRY this code.
public class ModifyDetails{
    //This is stored as a private static variable for when the items are added eventually (this is to fix forcing pressing enter)
    private static BaseAttributeTextField textFields = new BaseAttributeTextField();
    private static ArrayList<modifyAttributes> otherTextField;
    private static int productIndex;
    private static ChangeItem item;

    public static JPanel createLayout(JPanel panel, Window window, GridBagConstraints constraints, int productIndex){
        ModifyDetails.productIndex = productIndex;
        Product product = Window.getCatalog().getRawProductsArray().get(productIndex);

        item = new ChangeItem(product.getClass().getSimpleName());
        item.setProduct(product);

        otherTextField = new ArrayList<AttributeTextField.modifyAttributes>();

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
        constraints = textFields.createNameTextbox(window, panel, constraints, product.getName(), gridX + 1, gridY + 2);

        constraints = textFields.createCompanyTitle(window, panel, constraints, gridX, gridY + 3);
        constraints = textFields.createCompanyTextbox(window, panel, constraints, product.getCompany(), gridX + 1, gridY + 3);

        constraints = textFields.createQuantityTitle(window, panel, constraints, gridX, gridY + 4);
        constraints = textFields.createQuantityTextbox(window, panel, constraints, product.getQuantity(), gridX + 1, gridY + 4);

        constraints = textFields.createPriceTitle(window, panel, constraints, gridX, gridY + 5);
        constraints = textFields.createPriceTextbox(window, panel, constraints, product.getPrice(), gridX + 1, gridY + 5);

        constraints = textFields.createDescriptionTitle(window, panel, constraints, gridX, gridY + 6);
        constraints = textFields.createDescriptionTextbox(window, panel, constraints, product.getDescription(), gridX, gridY + 7);

        //This affects constraints
        otherTextField = CreateAdditionalAttributes.createLayout(panel, window, constraints, item, otherTextField, gridX, gridY + 8);
        //Set to new constraints after creating additional attribute layout.
        gridX = constraints.gridx;
        gridY = constraints.gridy;

        constraints = createAddButton(window, panel, constraints, gridX, gridY);
        constraints = createRemoveButton(window, panel, constraints, gridX + 1, gridY);

        constraints = createBuffer(window, panel, constraints, gridX, gridY + 1);
        return panel;
    }
    private static GridBagConstraints createDetailsTitle(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel nameTextbox = new JLabel("Details for this item");
        nameTextbox.setFont(new Font("Tahoma", Font.BOLD, 20));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50, 10, 0), 100, 10);
        
        panel.add(nameTextbox, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createAddButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Modify this item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Read all the values of GUI elements just before addition.
                Product product = Window.getCatalog().allProducts.get(productIndex);
                item = new ChangeItem(product.getClass().getSimpleName());
                boolean isThrown = false;
                try{
                    //Ensure all of these operations run successfully before switching screens.
                    item.createProduct(
                        textFields.getNameTextbox().getText(),
                        textFields.getCompanyTextbox().getText(),
                        ((Number)textFields.getPriceTextbox().getValue()).doubleValue(),
                        ((Number)textFields.getQuantityTextbox().getValue()).intValue(),
                        textFields.getDescriptionTextbox().getText());
                    item.setProduct(CreateAdditionalAttributes.readAttributeFields(item.getProduct(), otherTextField));

                    Window.getCatalog().updateProduct(product.name, item.getProduct());
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
                    System.out.println("Successfully modified product to the catalog, and saved to the file.");

                    window.setContentPane(new SellerScreen(window));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 100, 30);

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createRemoveButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Remove this item");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = Window.getCatalog().allProducts.get(productIndex).name;
                boolean isThrown = false;
                try{
                    Window.getCatalog().removeProduct(name);
                    System.out.println("Successfully removed product from the catalog, and saved to the file.");
                }
                catch(Exception ex){
                    showMessageDialog(null, ex.getMessage());
                    isThrown = true;
                }
                //Don't switch screens when exception is thrown, don't write to catalog as well.
                if(!isThrown){
                    window.setContentPane(new SellerScreen(window));
                    window.validate();

                    item.writeCatalogFile();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 360, 0, 0), 100, 30);

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createBuffer(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel label = new JLabel("");

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 0, 0, 0), 100, 30);

        panel.add(label, constraints);
        return ResetConstraints.reset(constraints);
    }
}
