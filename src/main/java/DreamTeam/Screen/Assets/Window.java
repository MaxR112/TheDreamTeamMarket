package main.java.DreamTeam.Screen.Assets;

import javax.swing.JFrame;

import main.java.DreamTeam.mainMarket.productCart;
import main.java.DreamTeam.mainMarket.productCatalog;

/**
    The window that manages screen operations along with holding values that persist until operation close, like the catalog and cart. 
*/
public class Window extends JFrame{
    //These use static so as to easily access those values without instantiating ScreenManager on other classes.
    private static int screenWidth;
    private static int screenHeight;
    //Global variables that persist until closing the program.
    private static productCatalog catalog;
    private static productCart cart;
    /**
        Init the window and JFrame, along with the product catalog and cart.
    */
    public Window(productCatalog catalog, int width, int height){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        Window.screenWidth = width;
        Window.screenHeight = height;

        Window.catalog = catalog;
        cart = new productCart(Window.catalog);
    }
    public static int getScreenWidth(){
        return screenWidth;
    }
    public static int getScreenHeight(){
        return screenHeight;
    }
    public static productCatalog getCatalog(){
        return catalog;
    }
    public static void setCatalog(productCatalog catalog){
        Window.catalog = catalog;
    }
    public static productCart getCart(){
        return cart;
    }
    public static void setCart(productCart cart){
        Window.cart = cart;
    }
}
