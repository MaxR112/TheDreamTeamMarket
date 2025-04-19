package main.java.DreamTeam.Screen;

import javax.swing.JFrame;

//Borrowing properties from JFrame, used as the application window.
public class ScreenManager extends JFrame{
    //These use static so as to easily access those values without instantiating ScreenManager on other classes.
    private static int screenWidth;
    private static int screenHeight;
    public ScreenManager(int width, int height){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        ScreenManager.screenWidth = width;
        ScreenManager.screenHeight = height;
    }
    public static int getScreenWidth(){
        return screenWidth;
    }
    public static int getScreenHeight(){
        return screenHeight;
    }
}
