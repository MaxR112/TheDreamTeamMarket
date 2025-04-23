package main.java.DreamTeam.Screen.SellerScreen;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.ResetConstraints;
import main.java.DreamTeam.Screen.Window;

public class DisplayAdditionalItem {
    static GridBagConstraints createItemInfo(
            Window window, JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        //Get current positions that won't be altered.
        for(int i = 0; i < product.getAttributes().length; i++){
            String attributeTitle = String.valueOf(product.getAttributes()[i][0]);
            if(attributeTitle.matches("Name|Price|Quantity|Description|Company Name") == false){
                constraints = createAttributeTitle(panel, constraints, attributeTitle, gridX, gridY);
                constraints = createAttribute(panel, constraints, product.getAttributes()[i][1], gridX, gridY + 1);
                gridX += 1;
            }
        }
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createAttributeTitle(
            JPanel panel, GridBagConstraints constraints, String attributeName, int gridX, int gridY){
        JLabel priceTitle = new JLabel(attributeName);
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    //Assumes price is in USD
    private static GridBagConstraints createAttribute(
            JPanel panel, GridBagConstraints constraints, Object attributeValue, int gridX, int gridY){
        JLabel priceTitle = new JLabel(String.valueOf(attributeValue));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
}
