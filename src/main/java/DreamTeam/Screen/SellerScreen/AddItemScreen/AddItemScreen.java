package main.java.DreamTeam.Screen.SellerScreen.AddItemScreen;

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

import main.java.DreamTeam.Screen.Assets.ResetConstraints;
import main.java.DreamTeam.Screen.Assets.Window;
import main.java.DreamTeam.Screen.SellerScreen.SellerScreen;
import main.java.DreamTeam.mainMarket.productCatalog;

public class AddItemScreen extends JScrollPane {
    private JPanel detailsPanel;
    /**
     * Init the screen with certain properties.
    */
    //There is some unDRY'd code, though they fufill completely different operations and thus different interfaces so they aren't cleaned up for now.
    public AddItemScreen(Window window, productCatalog catalog) {
        //Set the constraints of layout manager (automatic rescaling and such)
        GridBagConstraints constraints = new GridBagConstraints();
        detailsPanel = new JPanel();

        JPanel panel = Window.initPanel(new JPanel());
        this.setPreferredSize(new Dimension(Window.getScreenWidth(), Window.getScreenHeight()));
        this.setViewportView(BaseLayout(panel, window, constraints, catalog));
    }
    JPanel BaseLayout(JPanel panel, Window window, GridBagConstraints constraints, productCatalog catalog){
        //Properties for all elements
        constraints.fill = GridBagConstraints.NONE;
        //Align the grid to the left side (and thus set the anchors of all elements to the left side of screen).
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //Draw elements
        ScreenTitle(panel, constraints, 0, 0);

        BackButton(window, panel, constraints, catalog, 0, 1);

        ItemTypeTitle(panel, constraints, 0, 2);
        ItemTypeDropdown(window, panel, constraints, new String[] { "Select an item", "Electronics", "Clothing", "Furniture"}, 1, 2);
        return panel;
    }
    private void ScreenTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Add an item");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 0, 20);
        
        panel.add(screenTitle, constraints);
        
    }
    private void BackButton(Window window, JPanel panel, GridBagConstraints constraints, productCatalog catalog, int gridX, int gridY){
        JButton addButton = new JButton("Return to Catalog");
        //Inline way (and non-DRY way) to listen to button inputs.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setContentPane(new SellerScreen(window, catalog));
                window.validate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(5, 50, 0, 0), 100, 30);

        panel.add(addButton, constraints);
        
    }
    private void ItemTypeTitle(JPanel panel, GridBagConstraints constraints, int gridX, int gridY){
        JLabel screenTitle = new JLabel("Item Type: ");
        screenTitle.setFont(new Font("Tahoma", Font.BOLD, 15));

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 50, 0, 0), 0, 20);
        
        panel.add(screenTitle, constraints);
        
    }
    private void ItemTypeDropdown(Window window, JPanel panel, GridBagConstraints constraints, String[] itemTypes, int gridX, int gridY){
        JComboBox<String> itemTypeDropdown = new JComboBox<String>(itemTypes);
        //Fix error with constraints (and threading issues)
        GridBagConstraints localConstraints = constraints;
        //Inline way (and non-DRY way) to listen to button inputs.
        itemTypeDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selection = (String)itemTypeDropdown.getSelectedItem();

                if(selection != "Select an item"){
                    ShowDetailsPanel(window, panel, itemTypeDropdown, localConstraints, selection, 0, 3);
                }
                else{
                    panel.remove(detailsPanel);
                }
                panel.revalidate();
            }
        });

        constraints = ResetConstraints.setConstraints(
            constraints, gridX, gridY, new Insets(20, 150, 0, 0), 100, 10);

        panel.add(itemTypeDropdown, constraints);
    }
    private void ShowDetailsPanel(Window window, JPanel panel, JComboBox<String> dropdown, GridBagConstraints constraints, String itemType, int gridX, int gridY){
        panel.remove(detailsPanel);
        detailsPanel = Window.initPanel(new JPanel());
        detailsPanel = AddDetails.Layout(window, detailsPanel, constraints, itemType, gridX, gridY);
        panel.add(detailsPanel, constraints);
        panel.revalidate();
    }
}
