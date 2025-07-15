package view.scenes;

import view.parts.ButtonPanel;
import view.parts.TextLog;

import javax.swing.*;
import java.awt.*;

///  GENERIC GAME PANEL INHERITED BY BATTLE PANEL AND MAIN PANEL TO PRESERVE TEXT LOG AND NECESSARY COMPONENTS
/// Abstract since this class will never be instantiated directly, only through its subclasses

public abstract class GameGUI extends JPanel {

    // === VARIABLES AND FIELDS ===
    private final TextLog textLog;
    private final JScrollPane scroller;
    private final JLabel titleLabel;
    private final ButtonPanel buttonPanel;


    // === CONSTRUCTOR ===
    public GameGUI(JLabel titleLabel, TextLog log, ButtonPanel panel){
        // Title label; supered by each subclass
        this.titleLabel = titleLabel;
        this.add(titleLabel,BorderLayout.NORTH);

        // TextLog, shared by ALL panels... at least except for the main menu panel (set invisible for that one)
        this.textLog = log;
        this.scroller = new JScrollPane(textLog);
        this.add(scroller, BorderLayout.CENTER);

        // Creating the buttons panel - no JLabel by default, added by subclasses individually
        this.buttonPanel = panel;
        this.add(buttonPanel,BorderLayout.SOUTH);
    }


    // === GETTERS AND SETTERS ===
    public TextLog getTextLog() {return textLog;}

    public JScrollPane getBattleScroller() {return scroller;}

    public JLabel getTitleLabel() {return titleLabel;}

    public ButtonPanel getButtonPanel() {return buttonPanel;}


    // === HELPER METHODS ===
    // always scroll to bottom of text
    public void scrollDown(){
        JScrollBar scroller = this.scroller.getVerticalScrollBar();
        scroller.setValue(scroller.getMaximum());
    }

    // printing text for any panel
    public void print(String message){
        this.textLog.log(message);
        SwingUtilities.invokeLater(this::scrollDown);
    }

    // -- Helper Methods --
    // method to refresh -- DO I need this or just on the base frame's content panel?
    public void refresh(){
        this.revalidate();
        this.repaint();
    }

    // method to clear
    public void clear(){
        this.removeAll();
        refresh();
    }

    // method to hide a component
    public void hide(Component part){
        part.setVisible(false);
    }

    // method to show a component
    public void show(Component part){
        part.setVisible(true);
    }






}
