package main.java.DreamTeam.Screen.Assets;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField.modifyAttributes;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField.returnValues;

public class CreateAdditionalAttributes {
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
            String attributeValue = String.valueOf(item.getProduct().getAttributes()[i][1]);
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                constraints = AttributeTextField.createAttributeTitle(panel, constraints, attributeTitle, gridX, gridY);
                returnValues values = AttributeTextField.createAttribute(panel, constraints, attributeTitle, attributeValue, gridX, gridY + 1);
                constraints = values.getConstraint();
                textFields.add(values.getAttribute());
                gridY += 2;
            }
        }
        constraints = ResetConstraints.reset(constraints);
        constraints.gridy = gridY;
        return textFields;
    }
    public static Product readAttributeFields(Product product, ArrayList<modifyAttributes> textFields) throws IllegalArgumentException{
        ArrayList<Object[]> attributes = getUniqueAttributes(textFields);

        product.setAttributes(attributes.toArray(new Object[attributes.size()][]));
        return product;
    }
    //TODO: May violate dependency inversion
    private static ArrayList<Object[]> getUniqueAttributes(ArrayList<modifyAttributes> textFields) throws IllegalArgumentException{
        ArrayList<Object[]> attributes = new ArrayList<>();
        //Get string list to compare to
        ArrayList<String> attributeNames = new ArrayList<String>();
        for(modifyAttributes attribute : textFields){
            attributeNames.add(attribute.getAttributeName());
        }

        for(int i = 0; i < attributeNames.size(); i++){
            String attributeTitle = String.valueOf(attributeNames.get(i));
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                String attributeValue = textFields.get(i).getTextField().getText();
                if(attributeValue.equals(null) || attributeValue.equals("")){
                    throw new IllegalArgumentException("There are missing values in the textfields. Please fill them out!");
                }
                else{
                    attributes.add(new Object[] { attributeTitle, textFields.get(i).getTextField().getText()});
                }
            }
        }
        return attributes;
    }
}