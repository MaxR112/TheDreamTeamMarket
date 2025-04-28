package main.java.DreamTeam.Screen.SellerScreen.AddItemScreen;

import static javax.swing.JOptionPane.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.BaseAttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.ReadAttributes;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

public class AddDetails{
    //This is stored as a private static variable for when the items are added eventually (this is to fix forcing pressing enter)
    private static BaseAttributeTextField textFields = new BaseAttributeTextField();
    private static ArrayList<AttributeTextField.modifyAttributes> otherTextField;
    private static ChangeItem item;

    //Doesn't require a catalog to be passed on as it's adding a product to the Window catalog.
    public static JPanel Layout(
            Window window, JPanel panel, GridBagConstraints constraints, String productType, int gridX, int gridY){
        item = new ChangeItem(productType);
        item.createProduct();

        otherTextField = new ArrayList<AttributeTextField.modifyAttributes>();

        //Draw elements
        DetailsTitle(panel, constraints, gridX, gridY );

        textFields.NameTitle(panel, constraints, gridX, gridY + 1);
        textFields.NameTextbox(panel, constraints, null, gridX + 1, gridY + 1);

        textFields.CompanyTitle(panel, constraints, gridX, gridY + 2);
        textFields.CompanyTextbox(panel, constraints, null, gridX + 1, gridY + 2);

        textFields.QuantityTitle(panel, constraints, gridX, gridY + 3);
        textFields.QuantityTextbox(panel, constraints, 0, gridX + 1, gridY + 3);

        textFields.PriceTitle(panel, constraints, gridX, gridY + 4);
        textFields.PriceTextbox(panel, constraints, 0, gridX + 1, gridY + 4);

        textFields.DescriptionTitle(panel, constraints, gridX, gridY + 5);
        textFields.DescriptionTextbox(panel, constraints, null, gridX, gridY + 6);

        //This affects constraints
        otherTextField = AttributeTextField.Layout(panel, constraints, item, otherTextField, gridX, gridY + 7);
        //Set to new constraints after creating additional attribute layout.
        gridX = AttributeTextField.getGridXDistance();
        gridY = AttributeTextField.getGridYDistance();

        AddButton(window, panel, constraints, gridX, gridY);
        Buffer(panel, constraints, gridX, gridY + 1);
        return panel;
    }
    private static void DetailsTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel nameTextbox = new JLabel("Details for this item");
        nameTextbox.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50, 10, 0), 100, 10);
        
        panel.add(nameTextbox, constraints);
    }
    private static void AddButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Add Item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isThrown = false;
                productCatalog catalog = null;
                try{
                    //Ensure all of these operations run successfully before switching screens.
                    item.createProduct(
                        textFields.getNameTextbox().getText(),
                        textFields.getCompanyTextbox().getText(),
                        ((Number)textFields.getPriceTextbox().getValue()).intValue(),
                        ((Number)textFields.getQuantityTextbox().getValue()).intValue(),
                        textFields.getDescriptionTextbox().getText());
                    item.setProduct(ReadAttributes.readAttributeFields(item.getProduct(), otherTextField));

                    catalog = item.addToCatalog();
                    ChangeItem.writeCatalogFile();
                }
                catch(IllegalArgumentException ex){
                    showMessageDialog(null, "There are missing values, please fill them out!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(NullPointerException ex){
                    showMessageDialog(null, "There are missing values, please fill them out!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(IOException ex){
                    showMessageDialog(null, "Cannot add the product because of file error!");
                    System.out.println(ex);
                    isThrown = true;
                }
                if(!isThrown){
                    System.out.println("Successfully added product to the catalog, and saved to the file.");
    
                    window.setContentPane(new SellerScreen(window, catalog));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 10, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private static void Buffer(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel label = new JLabel("");

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 0, 0, 0), 100, 30);

        panel.add(label, constraints);
    }
}
