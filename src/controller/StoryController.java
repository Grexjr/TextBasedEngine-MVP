package controller;

import view.ViewManager;
import view.guiparts.buttons.GameButton;
import view.guis.StoryGUI;

import javax.swing.*;

public class StoryController extends SceneController{

    // === VARIABLES AND FIELDS ===


    // === CONSTRUCTOR ===
    public StoryController(ViewManager viewer, StoryGUI story){
        super(viewer,story);

        for(GameButton b : GameButton.values()){
            JButton btn = new JButton(b.getButtonDisplayName());
            btn.addActionListener(_ -> b.performAction(this));
            story.getButtonPanel().add(btn);
        }
    }


    // === BUTTON HANDLING === | TODO: abstract these to the super class since they'll be used everywhere
    public void handleYes(){
        System.out.println("Yes");
    }

    public void handleNo(){
        System.out.println("No");
    }





}
