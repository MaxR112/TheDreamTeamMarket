package main.java.DreamTeam.Screen.SellerScreen.ModifyItemScreen;

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

import main.java.DreamTeam.Exceptions.ProductNotFoundException;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField.modifyAttributes;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.BaseAttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.ReadAttributes;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

public class ModifyDetails{
    //This is stored as a private static variable for when the items are added eventually (this is to fix forcing pressing enter)
    private static BaseAttributeTextField textFields = new BaseAttributeTextField();
    private static ArrayList<modifyAttributes> otherTextField;
    private static int productIndex;
    private static ChangeItem item;

    public static JPanel Layout(JPanel panel, Window window, GridBagConstraints constraints, productCatalog catalog, int productIndex, int gridX, int gridY){
        ModifyDetails.productIndex = productIndex;
        Product product = catalog.getRawProductsArray().get(productIndex);

        item = new ChangeItem(product.getClass().getSimpleName());
        item.setProduct(product);

        otherTextField = new ArrayList<AttributeTextField.modifyAttributes>();
        
        //Draw elements
        DetailsTitle(panel, constraints, gridX, gridY);

        textFields.NameTitle(panel, constraints, gridX, gridY + 1);
        textFields.NameTextbox(panel, constraints, product.getName(), gridX + 1, gridY + 1);

        textFields.CompanyTitle(panel, constraints, gridX, gridY + 2);
        textFields.CompanyTextbox(panel, constraints, product.getCompany(), gridX + 1, gridY + 2);

        textFields.QuantityTitle(panel, constraints, gridX, gridY + 3);
        textFields.QuantityTextbox(panel, constraints, product.getQuantity(), gridX + 1, gridY + 3);

        textFields.PriceTitle(panel, constraints, gridX, gridY + 4);
        textFields.PriceTextbox(panel, constraints, product.getPrice(), gridX + 1, gridY + 4);

        textFields.DescriptionTitle(panel, constraints, gridX, gridY + 5);
        textFields.DescriptionTextbox(panel, constraints, product.getDescription(), gridX, gridY + 6);

        //This affects constraints
        otherTextField = AttributeTextField.Layout(panel, constraints, item, otherTextField, gridX, gridY + 7);
        //Set to new constraints after creating additional attribute layout.
        gridX = AttributeTextField.getGridXDistance();
        gridY = AttributeTextField.getGridYDistance();

        modifyButton(window, panel, constraints, gridX, gridY);
        RemoveButton(window, panel, constraints, gridX + 1, gridY);

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
    /**
     * Note: Modifies the Window product catalog, may require retrieving the catalog from that again.
     * @param window
     * @param panel
     * @param constraints
     * @param catalog
     * @param gridX
     * @param gridY
     */
    private static void modifyButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton modifyButton = new JButton("Modify this item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Read all the values of GUI elements just before addition.
                Product product = Window.getCatalog().allProducts.get(productIndex);
                item = new ChangeItem(product.getClass().getSimpleName(), product);

                boolean isThrown = false;
                productCatalog catalog = null;
                try{
                    //Ensure all of these operations run successfully before switching screens.
                    item.createProduct(
                        textFields.getNameTextbox().getText(),
                        textFields.getCompanyTextbox().getText(),
                        ((Number)textFields.getPriceTextbox().getValue()).doubleValue(),
                        ((Number)textFields.getQuantityTextbox().getValue()).intValue(),
                        textFields.getDescriptionTextbox().getText());
                    item.setProduct(ReadAttributes.readAttributeFields(item.getProduct(), otherTextField));

                    catalog = item.setItemAtCatalog();
                    ChangeItem.writeCatalogFile();
                }
                catch(ProductNotFoundException ex){
                    showMessageDialog(null, "The selected product to modify in the catalog does not exist!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(NullPointerException ex){
                    showMessageDialog(null, "There are missing values, please fill them out!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(IllegalArgumentException ex){
                    showMessageDialog(null, "There are missing values, please fill them out!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(IOException ex){
                    showMessageDialog(null, "Cannot modify the product because of file error!");
                    System.out.println(ex);
                    isThrown = true;
                }
                if(!isThrown){
                    System.out.println("Successfully modified product to the catalog, and saved to the file.");

                    window.setContentPane(new SellerScreen(window, catalog));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 100, 30);

        panel.add(modifyButton, constraints);
    }
    /**
     * Note: Modifies the Window product catalog to remove the item from this catalog, may require retrieving the catalog from Window again.
     * @param window
     * @param panel
     * @param constraints
     * @param catalog
     * @param gridX
     * @param gridY
     */
    private static void RemoveButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton removeButton = new JButton("Remove this item");
        //Inline way (and non-DRY way) to listen to button inputs.
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = Window.getCatalog().allProducts.get(productIndex).name;
                boolean isThrown = false;
                try{
                    Window.getCatalog().removeProduct(name);
                    ChangeItem.writeCatalogFile();
                }
                catch(ProductNotFoundException ex){
                    showMessageDialog(null, "The selected product to remove in the catalog does not exist!");
                    System.out.println(ex);
                    isThrown = true;
                }
                catch(IOException ex){
                    showMessageDialog(null, "Cannot remove the product because of file error!");
                    System.out.println(ex);
                    isThrown = true;
                }
                //Don't switch screens when exception is thrown, don't write to catalog as well.
                if(!isThrown){
                    System.out.println("Successfully removed product from the catalog, and saved to the file.");

                    window.setContentPane(new SellerScreen(window, Window.getCatalog()));
                    window.validate();
                }
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 360, 0, 0), 100, 30);

        panel.add(removeButton, constraints);
    }
    private static void Buffer(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel label = new JLabel("");

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 0, 0, 0), 100, 30);

        panel.add(label, constraints);
    }
}
