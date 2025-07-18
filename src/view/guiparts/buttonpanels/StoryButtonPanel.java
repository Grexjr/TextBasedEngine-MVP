package view.guiparts.buttonpanels;

import javax.swing.*;
import java.awt.*;

public class StoryButtonPanel extends ButtonPanel{

    // === VARIABLES AND FIELDS ===


    // === CONSTRUCTOR ===
    public StoryButtonPanel(){
        this.add(new JLabel("Actions"), BorderLayout.NORTH);
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY,Color.GRAY));
    }




}
