package main.java.DreamTeam.Screen.Panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;

//TODO: refactor this?
public class DisplayAdditionalAttributes {
    /**
     * Displays the item info and its attributes.
     * @param window
     * @param panel
     * @param constraints
     * @param product
     * @param gridX
     * @param gridY
     * @return The additional distance for the the X-coordinate for the grid layout.
     */
    public static int DisplayItemInfo(
            JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        //Get current positions that won't be altered.
        for(int i = 0; i < product.getAttributes().length; i++){
            String attributeTitle = String.valueOf(product.getAttributes()[i][0]);
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                AttributeTitle(panel, constraints, attributeTitle, gridX, gridY);
                Attribute(panel, constraints, product.getAttributes()[i][1], gridX, gridY + 1);
                gridX += 1;
            }
        }
        return gridX;
    }
    private static void AttributeTitle(
            JPanel panel, GridBagConstraints constraints, String attributeName, int gridX, int gridY){
        JLabel priceTitle = new JLabel(attributeName);
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
    //Assumes price is in USD
    private static void Attribute(
            JPanel panel, GridBagConstraints constraints, Object attributeValue, int gridX, int gridY){
        JLabel priceTitle = new JLabel(String.valueOf(attributeValue));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
}
