package main.java.DreamTeam.Screen.Assets.AttributeTextField;

import java.util.ArrayList;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.AttributeTextField.AttributeTextField.modifyAttributes;

public class ReadAttributes {
    public static Product readAttributeFields(Product product, ArrayList<modifyAttributes> textFields) throws IllegalArgumentException{
        ArrayList<Object[]> attributes = getUniqueAttributes(textFields);

        product.setAttributes(attributes.toArray(new Object[attributes.size()][]));
        return product;
    }
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