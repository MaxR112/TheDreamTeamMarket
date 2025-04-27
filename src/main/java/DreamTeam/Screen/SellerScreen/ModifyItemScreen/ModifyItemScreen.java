package main.java.DreamTeam.Screen.SellerScreen.ModifyItemScreen;

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

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

//This class doesn't allow changing type, requiring the user to delete and create a new object this way.
public class ModifyItemScreen extends JScrollPane {
    private int productIndex;
    /**
     * Init the screen with certain properties.
    */
    //As of now this is a (mostly) duplicate of AddItemScreen.
    //This has a completely different functionality concept so DRY would not be effective here.
    public ModifyItemScreen(Window window, productCatalog catalog, int productIndex) {
        this.productIndex = productIndex;
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(BaseLayout(window, panel, catalog, constraints));
    }
    private JPanel BaseLayout(Window window, JPanel panel, productCatalog catalog, GridBagConstraints constraints){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        ScreenTitle(panel, constraints, 0, 0);

        BackButton(window, panel, catalog, constraints, 0, 1);

        ItemType(panel, constraints, catalog.allProducts.get(productIndex), 0, 2);

        Details(window, panel, constraints, catalog, 0, 3);
        
        return panel;
    }
    private void ScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Modify an item");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);
        
        panel.add(screenTitle, constraints);
    }
    private void BackButton(Window window, JPanel panel, productCatalog catalog, GridBagConstraints constraints, int gridX, int gridY){
        JButton backButton = new JButton("Return to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new SellerScreen(window, catalog));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 100, 30);

        panel.add(backButton, constraints);
    }
    private void ItemType(JPanel panel, GridBagConstraints constraints, Product item, int gridX, int gridY){
        JLabel itemTypeTitle = new JLabel("Item Type: " + item.getClass().getSimpleName());
        itemTypeTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 0, 20);
        
        panel.add(itemTypeTitle, constraints);
    }
    private void Details(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        JPanel detailsPanel = Window.initPanel(new JPanel());
        detailsPanel = ModifyDetails.Layout(detailsPanel, window, constraints, catalog, productIndex, gridX, gridY);
        //Jank to fix layout.
        panel.add(detailsPanel, constraints);
    }
}
