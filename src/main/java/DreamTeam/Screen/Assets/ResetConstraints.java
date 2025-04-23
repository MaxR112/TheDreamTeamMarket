package main.java.DreamTeam.Screen.Assets;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ResetConstraints {
    public static GridBagConstraints reset(GridBagConstraints constraints){
        //Set the position of the component relative to grid layout.
        constraints.gridx = 0;
        constraints.gridy = 0;
        //Set the position within the grid layout.
        constraints.insets = new Insets(0, 0, 0, 0);
        //Set the size of the component
        constraints.ipadx = 0;
        constraints.ipady = 0;

        return constraints;
    }
    public static GridBagConstraints setConstraints(
        GridBagConstraints constraints, int gridX, int gridY, Insets insets, int width, int height){
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        //Set the position within the grid layout.
        constraints.insets = insets;
        //Set the size of the component
        constraints.ipadx = width;
        constraints.ipady = height;
        
        return constraints;
    }
}
