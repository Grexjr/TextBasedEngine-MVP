package gui.parts;

import ety.Entity;
import ety.Player;
import itm.Item;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends GamePanel {

    // === VARIABLES AND FIELDS ===
    private final JButton attackButton, defendButton, itemButton, runButton;
    private final JPanel buttonPanel;


    // === THE CONSTRUCTOR ===
    public BattlePanel(String enemyName){
        super(new JLabel("Battle versus " + enemyName));

        //add all buttons, for now just do manual below | TODO: Use enum or class(?) for future
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
    }


    // === GETTERS AND SETTERS ===
    public JPanel getButtonPanel() {return this.buttonPanel;}
    public JButton getAttackButton() {return this.attackButton;}
    public JButton getDefendButton() {return this.defendButton;}
    public JButton getItemButton() {return this.itemButton;}
    public JButton getRunButton() {return this.runButton;}


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method to refresh
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

    // method to enable buttons
    public void enableButtons(){
        this.getAttackButton().setEnabled(true);
        this.getDefendButton().setEnabled(true);
        this.getItemButton().setEnabled(true);
        this.getRunButton().setEnabled(true);
    }

    // method to disable buttons
    public void disableButtons(){
        this.getAttackButton().setEnabled(false);
        this.getDefendButton().setEnabled(false);
        this.getItemButton().setEnabled(false);
        this.getRunButton().setEnabled(false);
    }


    // -- Printing Methods --
    // method to print battle start
    public void printBattleStart(Entity player, Entity enemy){
        this.print("The battle between " +
                player.getEntityName() +
                " and " +
                enemy.getEntityName() +
                " has begun!\n");
    }

    // method to print battle over
    public void printBattleOver(){
        this.print("Battle over!\n\n\n");
    }

    // method to print health
    public void printHealth(Entity battler){
        int currentHealth = battler.getEntityStatBlock().getEntityCurrentHealth();
        int maxHealth = battler.getEntityStatBlock().getEntityMaxHealth();

        this.print(battler.getEntityName() + " health: " + currentHealth + "/" + maxHealth +"\n");
    }

    // method to print loss
    public void printLoss(Entity finisher){
        if(finisher instanceof Player){
            this.print(finisher.getEntityName() + " has lost!");
        } else{
            this.print(finisher.getEntityName() + " has won!");
        }
    }

    // generic start turn print method
    public void printStartTurn(Entity starter){
        this.print("\n\n" + starter.getEntityName() + " act time!\n\n");
    }

    // generic attack print method
    public void printAttack(Entity attacker, Entity target){
        this.print(attacker.getEntityName() + " attacks " + target.getEntityName() + "!");
    }

    // generic defend print method
    public void printDefend(Entity defender){
        this.print(defender.getEntityName() + " defends!");
    }

    // generic item use attempt print method
    public void printItemUseAttempt(Entity user){
        this.print(user.getEntityName() + " tries to use an item!");
    }

    // generic no items print
    public void printNoItems(Entity user){
        this.print(user.getEntityName() + " has no items!");
    }

    // generic item use success print
    public void printSuccessfulItemUse(Entity entity, Item item){
        this.print("\n" + entity.getEntityName() + " uses " + item.getItemName() + "!\n");
    }

    // print generic entity run
    private void printRun(String runnerName){
        this.print(runnerName + " attempted to escape!");
    }

    // print generic entity successful run
    public void printSuccessfulRun(String runnerName){
        printRun(runnerName);
        this.print(runnerName +  " escaped!\n");
    }

    // print entity failed run
    public void printFailedRun(String runnerName){
        printRun(runnerName);
        this.print(runnerName + " failed to escape!\n");
    }

}
