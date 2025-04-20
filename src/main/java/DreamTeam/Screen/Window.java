package main.java.DreamTeam.Screen;

import javax.swing.JFrame;
import main.java.DreamTeam.mainMarket.productCatalog;

//Borrowing properties from JFrame, used as the application window.
public class Window extends JFrame{
    //These use static so as to easily access those values without instantiating ScreenManager on other classes.
    private static int screenWidth;
    private static int screenHeight;
    private static productCatalog catalog;
    public Window(int width, int height){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        Window.screenWidth = width;
        Window.screenHeight = height;
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
}
