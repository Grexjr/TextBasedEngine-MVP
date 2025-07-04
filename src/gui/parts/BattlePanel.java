package gui.parts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BattlePanel extends JPanel {

    // === VARIABLES AND FIELDS ===
    private final JLabel titleLabel;
    private final JTextArea textLog;
    private final JScrollPane battleScroller;
    private final JButton attackButton, defendButton, itemButton, runButton;
    private final JPanel buttonPanel;


    // === THE CONSTRUCTOR ===
    public BattlePanel(String enemyName){
        this.titleLabel = new JLabel("Battle versus " + enemyName);
        this.add(titleLabel, BorderLayout.NORTH);

        // Creating the text panel
        this.textLog = new JTextArea(30,65);
        this.textLog.setEditable(false);
        this.battleScroller = new JScrollPane(textLog);
        this.add(battleScroller,BorderLayout.CENTER);

        //add all buttons, for now just do manual below
        this.attackButton = new JButton("Attack");
        this.defendButton = new JButton("Defend");
        this.itemButton = new JButton("Items");
        this.runButton = new JButton("Run");

        // Creating the buttons panel
        this.buttonPanel = new JPanel(new FlowLayout());
        this.buttonPanel.add(new JLabel("Actions:"), BorderLayout.NORTH);
        this.buttonPanel.add(this.attackButton);
        this.buttonPanel.add(this.defendButton);
        this.buttonPanel.add(this.itemButton);
        this.buttonPanel.add(this.runButton);
        this.add(buttonPanel,BorderLayout.SOUTH);

        // Adding the functionality to the buttons
        this.setUpActionListeners(enemyName);
    }


    // === GETTERS AND SETTERS ===


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method to set the action listeners for the buttons
    private void setUpActionListeners(String enemyName){
        this.attackButton.addActionListener(e -> log("You attack the " + enemyName +'!'));
        this.defendButton.addActionListener(e -> log("You defend!"));
        this.itemButton.addActionListener(e -> log("You try to use an item!"));
        this.runButton.addActionListener(e -> log("You attempt to escape!"));
    }

    // method to log something on the text field
    private void log(String message){
        this.textLog.append(message + "\n");
    }







}
