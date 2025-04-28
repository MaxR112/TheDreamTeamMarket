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

public class DisplayItem {
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
     * Displays the item info and its attributes.
     * @param window
     * @param panel
     * @param constraints
     * @param product
     * @param productIndex
     */
    public static void DisplayItemInfo(
            JPanel panel, GridBagConstraints constraints, Product product, int productIndex){
        //Get current positions that won't be altered.
        int gridX = constraints.gridx;
        int gridY = constraints.gridy;
        ItemTitle(panel, constraints, product, gridX, gridY + 1);

        TypeTitle(panel, constraints, product, gridX, gridY + 2);
        Type(panel, constraints, product, gridX, gridY + 3);

        PriceTitle(panel, constraints, product, gridX + 1, gridY + 2);
        Price(panel, constraints, product, gridX + 1, gridY + 3);
        
        QuantityTitle(panel, constraints, product, gridX + 2, gridY + 2);
        Quantity(panel, constraints, product, gridX + 2, gridY + 3);

        DisplayAdditionalAttributes.DisplayItemInfo(panel, constraints, product, gridX, gridY + 4);

        DescriptionTitle(panel, constraints, product, gridX, gridY + 6);
        Description(panel, constraints, product, gridX, gridY + 7);

        gridXDistance = 0;
        gridYDistance = 7;
    }
    private static void ItemTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel itemTitle = new JLabel(product.name + " - " + product.companyName);
        itemTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 10);

        panel.add(itemTitle, constraints);
    }
    private static void TypeTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Item Type");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
    private static void Type(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel(product.getClass().getSimpleName());
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50, 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
    private static void PriceTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("Price");
        priceTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
    //Assumes price is in USD
    private static void Price(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel priceTitle = new JLabel("$" + String.format("%.2f", product.price));
        priceTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(priceTitle, constraints);
    }
    private static void QuantityTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel quantityTitle = new JLabel("Quantity");
        quantityTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(quantityTitle, constraints);
    }
    private static void Quantity(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel quantity = new JLabel(String.valueOf(product.quantity));
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(0, 50 + (120 * gridX), 0, 0), 0, 10);

        panel.add(quantity, constraints);
    }
    private static void DescriptionTitle(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        JLabel descriptionTitle = new JLabel("Description");
        descriptionTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 5);

        panel.add(descriptionTitle, constraints);
    }
    private static void Description(JPanel panel, GridBagConstraints constraints, Product product, int gridX, int gridY){
        //Html tags to wrap the text.
        JLabel description = new JLabel("<html>" + product.description + "</html>");
        description.setFont(new Font("Tahoma", Font.PLAIN, 15));
        description.setVerticalAlignment(JLabel.TOP);
        description.setPreferredSize(new Dimension(Window.getScreenWidth() - 100, 50));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 0, 0), 0, 5);

        panel.add(description, constraints);
    }
}
