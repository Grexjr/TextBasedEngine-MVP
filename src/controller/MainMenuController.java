package controller;

import view.ViewManager;
import view.guis.MainMenuGUI;

public class MainMenuController extends SceneController {

    // === VARIABLES AND FIELDS ===
    private final MainMenuGUI mainMenuPanel;

    // === CONSTRUCTOR ===
    public MainMenuController(ViewManager viewer){
        super(viewer,new MainMenuGUI(null));

        this.mainMenuPanel = new MainMenuGUI(this);
    }

    // === GETTERS ===
    public MainMenuGUI getMainMenuPanel() {return mainMenuPanel;}


    // === BUTTON METHODS ===
    public void handleNewGame(){
        // TEMP
        System.out.println("Game Instance created.");
    }

    public void handleContinue(){
        //TEMP
        System.out.println("Not yet implemented!");
    }

    public void handleSettings(){
        //TEMP
        System.out.println("Not yet implemented!");
    }

    public void handleQuit(){System.exit(0);}




}
