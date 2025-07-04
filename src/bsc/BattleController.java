package bsc;

import ety.Player;
import ety.enemy.Enemy;
import gui.parts.BattlePanel;

public class BattleController {

    // === VARIABLES AND FIELDS ===
    private final BattleScene battleScene;
    private final BattlePanel battlePanel;


    // === BATTLE CONTROLLER CONSTRUCTOR ===
    public BattleController(BattleScene bsc){
        this.battleScene = bsc;
        this.battlePanel = new BattlePanel(bsc.getEnemy().getEntityName());
        setUpActionListeners(bsc.getEnemy().getEntityName());
    }


    // === GETTERS AND SETTERS ===
    public BattleScene getBattleScene() {return this.battleScene;}
    public BattlePanel getBattlePanel() {return this.battlePanel;}


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method to set the action listeners for the buttons
    private void setUpActionListeners(String enemyName){
        this.battlePanel.getAttackButton().addActionListener(e -> this.handleAttack(enemyName));
        this.battlePanel.getDefendButton().addActionListener(e ->
                this.battlePanel.log("You defend!")
        );
        this.battlePanel.getItemButton().addActionListener(e ->
                this.battlePanel.log("You try to use an item!")
        );
        this.battlePanel.getRunButton().addActionListener(e ->
                this.battlePanel.log("You attempt to escape!")
        );
    }

    // method to handle attacks
    private void handleAttack(String enemyName){
        this.battlePanel.log("You attack the " + enemyName +"!");
        this.battleScene.attackEntity(this.battleScene.getPlayer(),this.battleScene.getEnemy());
        this.battlePanel.printHealth(this.battleScene.getEnemy());
    }



}
