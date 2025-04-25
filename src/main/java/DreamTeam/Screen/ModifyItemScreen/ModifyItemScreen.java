package main.java.DreamTeam.Screen.ModifyItemScreen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;

//TODO: make it able to change item type as well.
public class ModifyItemScreen extends JScrollPane {
    private int productIndex;
    private JPanel detailsPanel;
    /**
     * Init the screen with certain properties.
    */
    //As of now this is a (mostly) duplicate of AddItemScreen.
    //This has a completely different functionality concept so DRY would not be effective here.
    public ModifyItemScreen(Window window, int productIndex) {
        this.productIndex = productIndex;
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();
        detailsPanel = new JPanel();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(createBaseLayout(panel, window, constraints));
    }
    JPanel createBaseLayout(JPanel panel, Window window, GridBagConstraints constraints){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        constraints = createScreenTitle(panel, constraints);

        constraints = createBackButton(window, panel, constraints);

        constraints = createItemTypeTitle(panel, constraints);
        constraints =
            createItemTypeDropdown(
                window,
                panel,
                constraints,
                new String[] { "Electronics", "Clothing", "Furniture"},
                Window.getCatalog().allProducts.get(productIndex));
        // constraints = createCatalogTitle(panel, constraints);
        // constraints = createListing(panel, constraints, Window.getCatalog());
        return panel;
    }
    GridBagConstraints createScreenTitle(JPanel panel, GridBagConstraints constraints){
        JLabel screenTitle = new JLabel("Modify an item");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 0;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipady = 20;
        
        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createBackButton(Window window, JPanel panel, GridBagConstraints constraints){
        JButton addButton = new JButton("Return to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new SellerScreen(window));
                window.validate();
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 1;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 30;

        panel.add(addButton, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createItemTypeTitle(JPanel panel, GridBagConstraints constraints){
        JLabel screenTitle = new JLabel("Item Type: ");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 2;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 50, 0, 0);
        //Set the size of the component
        constraints.ipady = 20;
        
        panel.add(screenTitle, constraints);
        return ResetConstraints.reset(constraints);
    }
    GridBagConstraints createItemTypeDropdown(Window window, JPanel panel, GridBagConstraints constraints, String[] itemTypes, Product item){
        JComboBox<String> itemTypeDropdown = new JComboBox<String>(itemTypes);
        if(item != null){
            switch(item.getClass().getSimpleName()){
                case "Electronics":
                    itemTypeDropdown.setSelectedIndex(0);
                    ShowDetailsPanel(window, panel, itemTypeDropdown, constraints);
                    break;
                case "Clothing":
                    itemTypeDropdown.setSelectedIndex(1);
                    ShowDetailsPanel(window, panel, itemTypeDropdown, constraints);
                    break;
                case "Furniture":
                    itemTypeDropdown.setSelectedIndex(2);
                    ShowDetailsPanel(window, panel, itemTypeDropdown, constraints);
                    break;
                default: throw new IllegalArgumentException("Invalid item type");
            }
        }
        //Inline way (and non-DRY way) to listen to button inputs.
        itemTypeDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowDetailsPanel(window, panel, itemTypeDropdown, constraints);
            }
        });

        //Set the position of the component relative to grid layout.
        constraints.gridx = 1;
        constraints.gridy = 2;
        //Set the position within the grid layout.
        constraints.insets = new Insets(20, 150, 0, 0);
        //Set the size of the component
        constraints.ipadx = 100;
        constraints.ipady = 10;

        panel.add(itemTypeDropdown, constraints);
        return ResetConstraints.reset(constraints);
    }
    public GridBagConstraints ShowDetailsPanel(Window window, JPanel panel, JComboBox<String> dropdown, GridBagConstraints constraints){
        panel.remove(detailsPanel);
        detailsPanel = Window.initPanel(new JPanel());
        detailsPanel = ModifyDetails.createLayout(detailsPanel, window, constraints, productIndex);
        //Jank to fix layout.
        constraints.gridy = 3;
        panel.add(detailsPanel, constraints);
        constraints.gridy = 0;

        panel.revalidate();

        return ResetConstraints.reset(constraints);
    }
}
