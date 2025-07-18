package view.guiparts.buttonpanels;

import controller.MainMenuController;
import view.guiparts.buttons.MainMenuButton;

import javax.swing.*;
import java.awt.*;

public class MainMenuButtonPanel extends ButtonPanel{

    // === VARIABLES AND FIELDS ===

    // === CONSTRUCTOR ===
    public MainMenuButtonPanel(){
        // Subclasses only to do layout and style of main menu buttons
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY,Color.GRAY));
        Box.createVerticalGlue();
        // TODO: Figure out how to center the buttons

    }


}
