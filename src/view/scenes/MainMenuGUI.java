package view.scenes;

import controller.MainMenuController;
import view.parts.MainMenuButtonPanel;
import view.parts.TextLog;

import javax.swing.*;

public class MainMenuGUI extends GUI {

    // === VARIABLES AND FIELDS ===

    // === CONSTRUCTOR ===
    public MainMenuGUI(MainMenuController mmc){
        super(new JLabel("RogueCrawler Timescapes"),new MainMenuButtonPanel(mmc));

        // Load in an image -- make something simple!



    }




}
