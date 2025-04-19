package main.java.DreamTeam.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Borrowing properties from JPanel, used as a screen.
public class MainScreen extends JPanel{
    public MainScreen() {
        //Settings for the screen.
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight());
        createLayout(this);
    }
    void createLayout(JPanel panel){
        JLabel loginLabel = new JLabel("Login as Buyer or Seller?");
        loginLabel.setBounds(50, 20, 200, 40);
        panel.add(loginLabel);

        panel.add(createBuyerButton());
        panel.add(createSellerButton());
    }
    JButton createBuyerButton(){
        JButton buyerButton = new JButton("Buyer");
        buyerButton.setBounds(50, 70, 200, 40);
        //Inline way (and non-DRY way) to listen to button inputs.
        buyerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: implement buyer screen.
                System.out.println("buyer");
            }
        });
        return buyerButton;
    }
    JButton createSellerButton(){
        JButton sellerButton = new JButton("Seller");
        sellerButton.setBounds(50, 120, 200, 40);
        //Inline way (and non-DRY way) to listen to button inputs.
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: implement seller screen.
                System.out.println("seller");
            }
        });
        return sellerButton;
    }
}