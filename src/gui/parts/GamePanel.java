package gui.parts;

import javax.swing.*;
import java.awt.*;

///  GENERIC GAME PANEL INHERITED BY BATTLE PANEL AND MAIN PANEL TO PRESERVE TEXT LOG AND NECESSARY COMPONENTS
/// Abstract since this class will never be instantiated directly, only through its subclasses

public abstract class GamePanel extends JPanel {

    // === VARIABLES AND FIELDS ===
    private final JTextArea textLog;
    private final JScrollPane battleScroller;
    private final JLabel titleLabel;
    private final JPanel buttonPanel;


    // === CONSTRUCTOR ===
    public GamePanel(JLabel titleLabel){
        // Title label; supered by each subclass
        this.titleLabel = titleLabel;

        // TextLog, shared by ALL panels... at least except for the main menu panel (set invisible for that one)
        this.textLog = new JTextArea(30,65);
        this.textLog.setEditable(false);
        this.battleScroller = new JScrollPane(textLog);
        this.add(battleScroller, BorderLayout.CENTER);

        // Creating the buttons panel - no JLabel by default, added by subclasses individually
        this.buttonPanel = new JPanel(new FlowLayout());
    }


    // === GETTERS AND SETTERS ===
    public JTextArea getTextLog() {return textLog;}

    public JScrollPane getBattleScroller() {return battleScroller;}

    public JLabel getTitleLabel() {return titleLabel;}

    public JPanel getButtonPanel() {return buttonPanel;}






}
