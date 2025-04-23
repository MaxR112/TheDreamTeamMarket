package main.java.DreamTeam.Screen.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;

//TODO: add universal reset values in constraints.
public class DisplayItem {
    public static GridBagConstraints createItemInfo(
            Window window, JPanel panel, GridBagConstraints constraints, Product product, int productIndex){
        //Get current positions that won't be altered.
        int gridX = constraints.gridx;
        int gridY = constraints.gridy;
        constraints = createTitle(panel, constraints, product, gridX, gridY + 1);

        constraints = createTypeTitle(panel, constraints, product, gridX, gridY + 2);
        constraints = createType(panel, constraints, product, gridX, gridY + 3);

        constraints = createPriceTitle(panel, constraints, product, gridX + 1, gridY + 2);
        constraints = createPrice(panel, constraints, product, gridX + 1, gridY + 3);
        
        constraints = createQuantityTitle(panel, constraints, product, gridX + 2, gridY + 2);
        constraints = createQuantity(panel, constraints, product, gridX + 2, gridY + 3);

        constraints = DisplayAdditionalItem.createItemInfo(window, panel, constraints, product, gridX, gridY + 4);

        constraints = createDescriptionTitle(panel, constraints, product, gridX, gridY + 6);
        constraints = createDescription(panel, constraints, product, gridX, gridY + 7);

        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel itemTitle = new JLabel(product.name + " - " + product.companyName);
        itemTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 10);

        panel.add(itemTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createTypeTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Item Type");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createType(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel(product.getClass().getSimpleName());
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50, 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createPriceTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Price");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    //Assumes price is in USD
    private static GridBagConstraints createPrice(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("$" + String.format("%.2f", product.price));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createQuantityTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel quantityTitle = new JLabel("Quantity");
        quantityTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(quantityTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createQuantity(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel quantity = new JLabel(String.valueOf(product.quantity));
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(quantity, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createDescriptionTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel descriptionTitle = new JLabel("Description");
        descriptionTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 5);

        panel.add(descriptionTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    private static GridBagConstraints createDescription(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        //Html tags to wrap the text.
        JLabel description = new JLabel("<html>" + product.description + "</html>");
        description.setFont(new Font("Tahoma", Font.PLAIN, 15));
        description.setVerticalAlignment(JLabel.TOP);
        description.setPreferredSize(new Dimension(Window.getScreenWidth() - 100, 50));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 5);

        panel.add(description, constraints);
        return ResetConstraints.reset(constraints);
    }
}
