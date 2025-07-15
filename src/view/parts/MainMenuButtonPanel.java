package view.parts;

import controller.MainMenuController;
import view.parts.buttons.MainMenuButton;

import javax.swing.*;

public class MainMenuButtonPanel extends ButtonPanel{

    // === VARIABLES AND FIELDS ===


    // === CONSTRUCTOR ===
    public MainMenuButtonPanel(MainMenuController mmc){
        // NO label

        // buttons
        for(MainMenuButton b : MainMenuButton.values()){
            JButton btn = new JButton(b.getButtonDisplayName());
            btn.addActionListener(_ -> b.performAction(mmc));
            this.add(btn);
        }

    }
}
