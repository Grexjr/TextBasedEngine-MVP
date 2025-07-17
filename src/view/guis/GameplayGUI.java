package view.guis;

import view.guiparts.PrintMessage;
import view.guiparts.buttonpanels.ButtonPanel;
import view.guiparts.TextLog;

import javax.swing.*;
import java.awt.*;

public class GameplayGUI extends GUI{

    // === VARIABLES AND FIELDS ===
    protected final TextLog textLog;
    private final JScrollPane scroller;


    // === CONSTRUCTOR ===
    public GameplayGUI(TextLog log, ButtonPanel panel){
        super(new JLabel("Game"),panel);

        // TextLog, shared by all gameplay panels
        this.textLog = log;
        this.scroller = new JScrollPane(textLog);
        this.add(scroller, BorderLayout.CENTER);
        this.refresh();
    }


    // === GETTERS ===
    public TextLog getTextLog() {return textLog;}

    public JScrollPane getScroller() {return scroller;}


    // === BASIC METHODS ===
    // always scroll to bottom of text
    public void scrollDown(){
        JScrollBar scroller = this.scroller.getVerticalScrollBar();
        scroller.setValue(scroller.getMaximum());
    }

    // === OVERRIDE METHODS ===

    // Printing for out of battle | TODO: Put this in story
    @Override
    public void print(PrintMessage msg){
        switch(msg.getType()){
            case ENTITY_ITEM_USE -> this.textLog.log(msg.getArgs()[0] + " attempts to use an item!\n");
            case ENTITY_SUCCESSFUL_ITEM_USE -> this.textLog.log(msg.getArgs()[0] + " uses " + msg.getArgs()[1] + ".\n");
            case ENTITY_FAILED_ITEM_USE -> this.textLog.log(msg.getArgs()[0] + " has no items!\n");
            case CUSTOM -> this.textLog.log(msg.getArgs()[0]);
        }
    }

    // Enable buttons
    @Override
    public void enableButtons(){}


    @Override
    public void disableButtons(){}



}
