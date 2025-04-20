package main.java.DreamTeam.Screen.AddItemScreen;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.DreamTeam.Products.Clothing;
import main.java.DreamTeam.Products.Electronics;
import main.java.DreamTeam.Products.Furniture;
import main.java.DreamTeam.Products.Product;
import main.java.DreamTeam.Screen.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;

public class AddItemScreen extends JScrollPane {
    public static Product product;
    private JPanel detailsPanel;
    /**
     * Init the screen with certain properties.
    */
    public AddItemScreen(Window window) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();
        detailsPanel = new JPanel();

        JPanel panel = initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(createBaseLayout(panel, window, constraints));
    }
    /**Init the panel with the layout set to a grid layout. */
    JPanel initPanel(JPanel panel){
        //Settings for the screen.
        panel.setVisible(true);
        panel.setLayout(new GridBagLayout());
        //panel.setPreferredSize(new Dimension(Window.getScreenWidth(), panel.getPreferredSize().height));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        return panel;
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
        constraints = createItemTypeDropdown(window, panel, constraints, new String[] { "Select an item", "Electronics", "Clothing", "Furniture"});
        // constraints = createCatalogTitle(panel, constraints);
        // constraints = createListing(panel, constraints, Window.getCatalog());
        return panel;
    }
    GridBagConstraints createScreenTitle(JPanel panel, GridBagConstraints constraints){
        JLabel screenTitle = new JLabel("Add an item");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 0;
        //Set the position within the grid layout.
        constraints.insets = new Insets(5, 50, 0, 0);
        //Set the size of the component
        constraints.ipady = 20;
        
        panel.add(screenTitle, constraints);
        return constraints;
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
        return constraints;
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
        return constraints;
    }
    GridBagConstraints createItemTypeDropdown(Window window, JPanel panel, GridBagConstraints constraints, String[] itemTypes){
        JComboBox<String> itemTypeDropdown = new JComboBox<String>(itemTypes);
        //Inline way (and non-DRY way) to listen to button inputs.
        itemTypeDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selection = (String)itemTypeDropdown.getSelectedItem();

                if(selection != "Select an item"){
                    panel.remove(detailsPanel);
                    detailsPanel = initPanel(new JPanel());
                    detailsPanel = AddDetails.createLayout(detailsPanel, window, constraints);
                    panel.add(detailsPanel, constraints);
                }
                else{
                    panel.remove(detailsPanel);
                }

                //Set to that value specifically for other items to be added.
                constraints.gridy = 6;
                //TODO: maybe collect all of these into one singluar function? btw this violates open-closed principles.
                switch(selection){
                    //Escape condition when not selecting an item.
                    case "Select an item":
                        break;
                    case "Electronics":
                        product =
                            new Electronics("", 0, 0, null, null, null, null, null);
                        System.out.println("electronic");
                        break;
                    case "Clothing":
                        product =
                            new Clothing("", 0, 0, null, null, null, null, null);
                        System.out.println("clothing");
                        break;
                    case "Furniture":
                        product =
                            new Furniture("", 0, 0, null, null, null, null, null);
                        System.out.println("furniture");
                        break;
                    default: throw new IllegalArgumentException("Invalid item type");
                }
                panel.revalidate();
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
        return constraints;
    }
}
