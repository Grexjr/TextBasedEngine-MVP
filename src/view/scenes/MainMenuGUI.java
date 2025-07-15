package view.scenes;

import controller.MainMenuController;
import view.parts.MainMenuButtonPanel;
import view.parts.TextLog;

import javax.swing.*;

public class MainMenuGUI extends GameGUI{

    // === VARIABLES AND FIELDS ===
    private static final TextLog NULL_LOG = new TextLog();

    // === CONSTRUCTOR ===
    public MainMenuGUI(MainMenuController mmc){
        super(new JLabel("RogueCrawler Timescapes"),NULL_LOG,new MainMenuButtonPanel(mmc));
        NULL_LOG.setVisible(false);
        NULL_LOG.setEnabled(false);

    }




}
