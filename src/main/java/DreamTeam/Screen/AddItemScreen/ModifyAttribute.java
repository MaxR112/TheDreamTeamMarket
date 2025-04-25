package main.java.DreamTeam.Screen.AddItemScreen;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.AttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.modifyAttributes;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.returnValues;
import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;

public class ModifyAttribute {
    /**
     * Creates a layout for additional attributes.
     * Constraints is automatically updated when this method is called, and is set to a new value after method execution.
     * @param panel
     * @param window
     * @param constraints
     * @param item
     * @param textFields
     * @return
     */
    public static ArrayList<modifyAttributes> createLayout(
        JPanel panel, Window window, GridBagConstraints constraints, ChangeItem item, ArrayList<modifyAttributes> textFields, int gridX, int gridY){
        for(int i = 0; i < item.getProduct().getAttributes().length; i++){
            String attributeTitle = String.valueOf(item.getProduct().getAttributes()[i][0]);
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){

                constraints = AttributeTextField.createAttributeTitle(panel, constraints, attributeTitle, null, gridX, gridY);
                returnValues values = AttributeTextField.createAttribute(panel, constraints, attributeTitle, null, gridX, gridY + 1);
                constraints = values.getConstraint();
                textFields.add(values.getAttribute());
                gridY += 2;
            }
        }
        constraints = ResetConstraints.reset(constraints);
        constraints.gridy = gridY;
        return textFields;
    }
    public static Product readAttributeFields(Product product, ArrayList<modifyAttributes> textFields){
        ArrayList<Object[]> attributes = new ArrayList<>();
        //Get string list to compare to
        ArrayList<String> attributeNames = new ArrayList<String>();
        for(int i = 0; i < textFields.size(); i++){
            attributeNames.add(textFields.get(i).getAttributeName());
        }
        for(int i = 0; i < attributeNames.size(); i++){
            String attributeTitle = String.valueOf(attributeNames.get(i));
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                attributes.add(new Object[] { attributeTitle, textFields.get(i).getTextField().getText()});
            }
        }

        product.setAttributes(attributes.toArray(new Object[attributes.size()][]));
        return product;
    }
}