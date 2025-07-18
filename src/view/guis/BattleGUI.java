package view.guis;

import controller.BattleController;
import model.ety.Entity;
import model.ety.Player;
import view.guiparts.PrintMessage;
import view.guiparts.buttonpanels.BattleButtonPanel;
import view.guiparts.TextLog;
import model.itm.Item;

import javax.swing.*;
import java.awt.*;

public class BattleGUI extends GameplayGUI {

    // === VARIABLES AND FIELDS ===


    // === THE CONSTRUCTOR ===
    public BattleGUI(BattleButtonPanel actions, TextLog log){
        super(log, actions);
    }


    // === GETTERS AND SETTERS ===


    // === OTHER METHODS ===
    // method to enable buttons
    @Override
    public void enableButtons(){

    }

    // method to disable buttons
    @Override
    public void disableButtons(){

    }


    // === PRINTING METHODS ===
    @Override
    public void print(PrintMessage msg){
        switch(msg.getType()){
            case ENTITY_START_TURN -> this.textLog.log(msg.getArgs()[0] + " turn to act!\n\n");
            case ENTITY_ATTACK -> this.textLog.log(msg.getArgs()[0] + " attacks " + msg.getArgs()[1] + "\n");
            case ENTITY_DEFEND -> this.textLog.log(msg.getArgs()[0] + " defends!\n");
            case ENTITY_RUN -> this.textLog.log(msg.getArgs()[0] + " attempted to run away!\n");
            case ENTITY_SUCCESSFUL_RUN -> this.textLog.log(msg.getArgs()[0] + " escaped!\n");
            case ENTITY_FAILED_RUN -> this.textLog.log(msg.getArgs()[0] + " failed to escape!\n");
            case ENTITY_HEALTH ->
                    this.textLog.log(
                            msg.getArgs()[0] + " has " +
                                    msg.getArgs()[1] + "/" +
                                    msg.getArgs()[2] + " health remaining!\n"
                    );
            case ENTITY_END_TURN -> this.textLog.log(msg.getArgs()[0] + "'s turn is over!\n\n");
            default -> super.print(msg);
        }
    }

}
