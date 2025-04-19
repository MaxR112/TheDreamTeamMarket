package main.java.DreamTeam.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Borrowing properties from JPanel, used as a screen.
public class MainScreen extends JPanel{
    public MainScreen(ScreenManager screenManager) {
        //Settings for the screen.
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight());
        createLayout(screenManager, this);
    }
    void createLayout(ScreenManager screenManager, JPanel panel){
        JLabel loginLabel = new JLabel("Login as Buyer or Seller?");
        loginLabel.setBounds(40, 10, 200, 40);
        panel.add(loginLabel);

        panel.add(createBuyerButton());
        panel.add(createSellerButton(screenManager));
    }
    JButton createBuyerButton(){
        JButton buyerButton = new JButton("Buyer");
        buyerButton.setBounds(40, 60, 200, 40);
        //Inline way (and non-DRY way) to listen to button inputs.
        buyerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: implement buyer screen.
                System.out.println("buyer");
            }
        });
        return buyerButton;
    }
    JButton createSellerButton(ScreenManager screenManager){
        JButton sellerButton = new JButton("Seller");
        sellerButton.setBounds(40, 110, 200, 40);
        //Inline way (and non-DRY way) to listen to button inputs.
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screenManager.setContentPane(new SellerScreen());
            }
        });
        return sellerButton;
    }
}