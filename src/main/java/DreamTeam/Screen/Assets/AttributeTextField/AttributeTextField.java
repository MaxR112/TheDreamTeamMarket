package main.java.DreamTeam.Screen.Assets.AttributeTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.DreamTeam.Screen.Assets.ResetConstraints;

public class AttributeTextField {
    public static GridBagConstraints createAttributeTitle(
            JPanel panel, GridBagConstraints constraints, String attributeName, int gridX, int gridY){
        JLabel attributeTitle = new JLabel(attributeName);
        attributeTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(attributeTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    public static returnValues createAttribute(
            JPanel panel, GridBagConstraints constraints, String attributeName, String value, int gridX, int gridY){
        JTextField field = new JTextField(1);
        field.setText(value);

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 200, 10);

        panel.add(field, constraints);
        AttributeTextField item = new AttributeTextField();
        return item.new returnValues(
            ResetConstraints.reset(constraints),
            item.new modifyAttributes(attributeName, field)
        );
    }
    public class returnValues{
        private GridBagConstraints constraint;
        private modifyAttributes attributes;
        public returnValues(GridBagConstraints constraint, modifyAttributes attributes){
            this.constraint = constraint;
            this.attributes = attributes;
        }
        public GridBagConstraints getConstraint(){
            return constraint;
        }
        public modifyAttributes getAttribute(){
            return attributes;
        }
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
