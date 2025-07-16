package view;

import view.guiparts.GameWindow;

import javax.swing.*;

public class ViewManager {

    // === VARIABLES AND FIELDS ===
    private final GameWindow window;


    // === CONSTRUCTOR ===
    public ViewManager(GameWindow window){
        this.window = window;
    }


    // === GETTER ===
    public GameWindow getWindow() {return window;}


    // === BASIC METHODS ===
    public void endOldView(){
        this.window.clear();
    }

    public void startNewView(JPanel newView){
        this.window.add(newView);
        this.window.refresh();
    }

    public void viewTransition(JPanel newView){
        this.endOldView();
        this.startNewView(newView);
    }
}
