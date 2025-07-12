package gui.parts;

import javax.swing.*;
import java.awt.*;

///  GENERIC GAME PANEL INHERITED BY BATTLE PANEL AND MAIN PANEL TO PRESERVE TEXT LOG AND NECESSARY COMPONENTS
/// Abstract since this class will never be instantiated directly, only through its subclasses

public abstract class GamePanel extends JPanel {

    // === VARIABLES AND FIELDS ===
    private final TextLog textLog;
    private final JScrollPane scroller;
    private final JLabel titleLabel;
    private final JPanel buttonPanel;


    // === CONSTRUCTOR ===
    public GamePanel(JLabel titleLabel){
        // Title label; supered by each subclass
        this.titleLabel = titleLabel;
        this.add(titleLabel,BorderLayout.NORTH);

        // TextLog, shared by ALL panels... at least except for the main menu panel (set invisible for that one)
        this.textLog = new TextLog();
        this.scroller = new JScrollPane(textLog);
        this.add(scroller, BorderLayout.CENTER);

        // Creating the buttons panel - no JLabel by default, added by subclasses individually
        this.buttonPanel = new JPanel(new FlowLayout());
    }


    // === GETTERS AND SETTERS ===
    public TextLog getTextLog() {return textLog;}

    public JScrollPane getBattleScroller() {return scroller;}

    public JLabel getTitleLabel() {return titleLabel;}

    public JPanel getButtonPanel() {return buttonPanel;}


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





}
