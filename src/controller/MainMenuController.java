package controller;

import view.ViewManager;
import view.guiparts.TextLog;
import view.guiparts.buttons.MainMenuButton;
import view.guis.MainMenuGUI;
import view.guis.StoryGUI;

import javax.swing.*;
import java.awt.*;

public class MainMenuController extends SceneController {

    // === VARIABLES AND FIELDS ===

    // === CONSTRUCTOR ===
    public MainMenuController(ViewManager viewer, MainMenuGUI menu){
        super(viewer,menu);

        for(MainMenuButton b : MainMenuButton.values()){
            JButton btn = new JButton(b.getButtonDisplayName());
            btn.addActionListener(_ -> b.performAction(this));
            menu.getButtonPanel().add(btn);
        }
    }

    // === GETTERS ===


    // === BUTTON METHODS ===
    public void handleNewGame(){
        System.out.println("Game Instance created.");
        this.getViewer().viewTransition(new StoryGUI(new TextLog()));
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
