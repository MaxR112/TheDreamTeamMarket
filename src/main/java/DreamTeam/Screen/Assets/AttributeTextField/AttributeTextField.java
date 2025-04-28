package main.java.DreamTeam.Screen.Assets.AttributeTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.DreamTeam.Screen.Assets.ChangeItem;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;

public class AttributeTextField {
    //Get the distance of objects to properly distance each item out.
    private static int gridXDistance = 0;
    private static int gridYDistance = 0;

    public static int getGridXDistance(){
        return gridXDistance;
    }
    public static int getGridYDistance(){
        return gridYDistance;
    }
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
    public static ArrayList<modifyAttributes> Layout(
        JPanel panel, GridBagConstraints constraints, ChangeItem item, ArrayList<modifyAttributes> textFields, int gridX, int gridY){
        for(int i = 0; i < item.getProduct().getAttributes().length; i++){
            String attributeTitle = null;
            if(item.getProduct().getAttributes()[i][0] != null){
                attributeTitle = String.valueOf(item.getProduct().getAttributes()[i][0]);
            }
            String attributeValue = null;
            if(item.getProduct().getAttributes()[i][1] != null){
                attributeValue = String.valueOf(item.getProduct().getAttributes()[i][1]);
            }

            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                AttributeTitle(panel, constraints, attributeTitle, gridX, gridY);
                textFields.add(Attribute(panel, constraints, attributeTitle, attributeValue, gridX, gridY + 1));
                gridY += 2;
            }
        }
        gridXDistance = gridX;
        gridYDistance = gridY;
        return textFields;
    }
    private static void AttributeTitle(
            JPanel panel, GridBagConstraints constraints, String attributeName, int gridX, int gridY){
        JLabel attributeTitle = new JLabel(attributeName);
        attributeTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(attributeTitle, constraints);
    }
    private static modifyAttributes Attribute(
            JPanel panel, GridBagConstraints constraints, String attributeName, String value, int gridX, int gridY){
        JTextField field = new JTextField(1);
        field.setText(value);

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 200, 10);

        panel.add(field, constraints);
        return new AttributeTextField().new modifyAttributes(attributeName, field);
    }
    public class modifyAttributes{
        private String attributeName;
        private JTextField textField;
        public modifyAttributes(String attributeName, JTextField field){
            this.attributeName = attributeName;
            this.textField = field;
        }
        public String getAttributeName(){
            return attributeName;
        }
        public JTextField getTextField(){
            return textField;
        }
    }
}
