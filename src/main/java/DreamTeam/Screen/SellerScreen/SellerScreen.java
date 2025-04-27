package main.java.DreamTeam.Screen.SellerScreen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.DreamTeam.Screen.MainScreen;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.Panels.DisplayItem;
import main.java.DreamTeam.Screen.SellerScreen.AddItemScreen.AddItemScreen;
import main.java.DreamTeam.Screen.SellerScreen.ModifyItemScreen.ModifyItemScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

/**
 * High-level screen for sellers to add and remove items.
*/
public class SellerScreen extends JScrollPane{
    /**
     * Init the screen with certain properties.
    */
    public SellerScreen(Window window, productCatalog catalog) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(Layout(window, panel, catalog, constraints));
    }
    private JPanel Layout(Window window, JPanel panel, productCatalog catalog, GridBagConstraints constraints){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        ScreenTitle(panel, constraints, 0, 0);

        BackButton(window, panel, constraints, 0, 1);
        AddButton(window, panel, constraints, catalog, 1, 1);

        CatalogTitle(panel, constraints, 0, 2);
        Listing(window, panel, constraints, catalog, 0, 3);
        return panel;
    }
    private void ScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Seller Panel");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);

        panel.add(screenTitle, constraints);
    }
    private void AddButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        JButton addButton = new JButton("Add Item to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new AddItemScreen(window, catalog));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private void BackButton(Window window, JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JButton addButton = new JButton("Return to Login");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new MainScreen(window));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 320, 0, 0), 100, 30);

        panel.add(addButton, constraints);
    }
    private void CatalogTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel catalogTitle = new JLabel("Catalog");
        catalogTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(50, 50, 0, 0), 0, 20);

        panel.add(catalogTitle, constraints);
    }
    private void Listing(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        for(int i = 0; i < catalog.allProducts.size(); i++){
            //gridY resets upon calling method, requires setting value every time on the loop.
            constraints.gridx = gridX;
            constraints.gridy = gridY;
            DisplayItem.DisplayItemInfo(panel, constraints, catalog.allProducts.get(i), i);
            constraints.gridx = gridX + DisplayItem.getGridXDistance();
            constraints.gridy = gridY + DisplayItem.getGridYDistance();
            ModifyButton(window, panel, constraints, catalog, i, gridX, gridY + 8);
            gridX += DisplayItem.getGridXDistance();
            gridY += DisplayItem.getGridYDistance() + 1;
        }
    }
    private void ModifyButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int productIndex, int gridX, int gridY){
        JButton modifyButton = new JButton("Modify this item");
        //Inline way (and non-DRY way) to listen to button inputs.
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new ModifyItemScreen(window, catalog, productIndex));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(10, 50, 40, 0), 50, 20);

        panel.add(modifyButton, constraints);
    }
}
