package view.guis;

import controller.MainMenuController;
import view.guiparts.PrintMessage;
import view.guiparts.buttonpanels.ButtonPanel;
import view.guiparts.buttonpanels.MainMenuButtonPanel;

import javax.swing.*;

public class MainMenuGUI extends GUI {

    // === VARIABLES AND FIELDS ===

    // === CONSTRUCTOR ===
    public MainMenuGUI(MainMenuButtonPanel menuActions){
        super(new JLabel("RogueCrawler Timescapes"),menuActions);

        // Individual formatting goes here


    }

    // === OVERRIDE METHODS ===
    @Override
    public void print(PrintMessage msg){
        System.out.println("Main Menu Called to Print!"); // TODO: Throw an error here
    }

    @Override
    public void disableButtons(){
        System.out.println("Main Menu Called to Disable Buttons!"); // TODO: Throw an error here
    }

    @Override
    public void enableButtons(){
        System.out.println("Main Menu Called to Enable Buttons!"); // TODO: Throw an error here
    }




}
