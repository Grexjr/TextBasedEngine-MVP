package gui.parts;

import javax.swing.*;
import java.awt.*;

public class TextLog extends JTextArea {

    // === VARIABLES AND FIELDS ===
    private int rows, columns;
    private boolean isEditable;
    private final JScrollPane scroller;


    // === CONSTRUCTOR FOR TEXT LOG ===
    public TextLog(){
        // TODO: Far in future, make this change with the window size
        // Initialize local variables
        this.rows = 30;
        this.columns = 65;
        this.isEditable = false;
        this.scroller = new JScrollPane(this);

        // Initialize the text log itself
        this.setEditable(isEditable);
        this.add(scroller, BorderLayout.CENTER);
    }


    // GETTERS AND SETTERS || NOTE: Overrides from the super JTextArea class
    @Override
    public int getRows() {return rows;}

    @Override
    public void setRows(int rows) {this.rows = rows;}

    @Override
    public int getColumns() {return columns;}

    @Override
    public void setColumns(int columns) {this.columns = columns;}

    @Override
    public boolean isEditable() {return isEditable;}

    @Override
    public void setEditable(boolean editable) {isEditable = editable;}

    public JScrollPane getScroller() {return scroller;}


    // === HELPER METHODS ===
    // immediately scrolls to the bottom of the pane when new text is added
    public void scrollDown(){
        JScrollBar scroller = this.scroller.getVerticalScrollBar();
        scroller.setValue(scroller.getMaximum());
    }


    // === BASIC METHODS ===
    // generic log method
    public void log(String message){
        this.append(message + "\n");
        SwingUtilities.invokeLater(this::scrollDown);
    }


}
