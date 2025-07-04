package bsc;

import ety.BattleChoice;
import ety.Player;
import ety.enemy.Enemy;
import gui.parts.BattlePanel;

import javax.swing.*;

public class BattleController {

    // === VARIABLES AND FIELDS ===
    private final BattleScene battleScene;
    private final BattlePanel battlePanel;


    // === BATTLE CONTROLLER CONSTRUCTOR ===
    public BattleController(BattleScene bsc){
        this.battleScene = bsc;
        this.battlePanel = new BattlePanel(bsc.getEnemy().getEntityName());
        setUpActionListeners(bsc.getEnemy().getEntityName());

        if(!this.battleScene.isPLayerTurn()){
            this.battlePanel.getButtonPanel().setVisible(false);
        }

        startBattle();
        runBattleLoop();
    }


    // === GETTERS AND SETTERS ===
    public BattleScene getBattleScene() {return this.battleScene;}
    public BattlePanel getBattlePanel() {return this.battlePanel;}


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method to set the action listeners for the buttons
    private void setUpActionListeners(String enemyName){
        this.battlePanel.getAttackButton().addActionListener(e -> {

            this.handlePlayerAttack(enemyName);
            this.battlePanel.getButtonPanel().setVisible(false);

            if(this.battleScene.getEnemy().getEntityCurrentHealth() <= 0){
                //TODO: add battle end function
                System.out.println("Battle won player");
                System.exit(0);
            }
            this.battleScene.setPlayerTurn(false);
            SwingUtilities.invokeLater(this::runEnemyTurn);
        });
        this.battlePanel.getDefendButton().addActionListener(e -> {
            this.handlePlayerDefense();
            this.battlePanel.getButtonPanel().setVisible(false);
            this.battleScene.setPlayerTurn(false);
            SwingUtilities.invokeLater(this::runEnemyTurn);
        });
        this.battlePanel.getItemButton().addActionListener(e -> {
            this.handlePlayerItemUse();
            this.battlePanel.getButtonPanel().setVisible(false);
            this.battleScene.setPlayerTurn(false);
            SwingUtilities.invokeLater(this::runEnemyTurn);
        });
        this.battlePanel.getRunButton().addActionListener(e -> {
            this.handlePlayerRun();
            this.battlePanel.getButtonPanel().setVisible(false);
            this.battleScene.setPlayerTurn(false);
            SwingUtilities.invokeLater(this::runEnemyTurn);
        });
    }

    // method to handle attacks
    private void handlePlayerAttack(String enemyName){
        if(this.battleScene.isPLayerTurn()){
            this.battlePanel.log("You attack the " + enemyName +"!");
            this.battleScene.attackEntity(this.battleScene.getPlayer(),this.battleScene.getEnemy());
            this.battlePanel.printHealth(this.battleScene.getEnemy());
        }
    }

    // method to handle defense
    private void handlePlayerDefense(){
        if(this.battleScene.isPLayerTurn()){
            this.battlePanel.log("You defend!");
        }
    }

    // method to handle item use
    private void handlePlayerItemUse(){
        if(this.battleScene.isPLayerTurn()){
            this.battlePanel.log("You try to use an item!");
        }
    }

    // method to handle running
    private void handlePlayerRun(){
        if(this.battleScene.isPLayerTurn()){
            this.battlePanel.log("You attempt to escape!");
        }
    }

    // === BATTLE PROGRESS METHODS ===

    // check if player turn method
    private boolean ifPlayerTurn(){
        return this.battleScene.isGoerPlayer(
                this.battleScene.determineTurn(
                        this.battleScene.getPlayer(),
                        this.battleScene.getEnemy()
                ));
    }

    // player turn method
    private void runPlayerTurn(){
        if(ifPlayerTurn()){
            this.battlePanel.log("Player turn time!\n");
            this.battleScene.setPlayerTurn(true);
            this.battlePanel.getButtonPanel().setVisible(true);
        }
    }

    // enemy turn method
    private void runEnemyTurn(){
        switch(this.battleScene.getEnemy().makeBattleChoice()){
            default:
                this.battlePanel.log("Slime attacks!\n");
                this.battleScene.attackEntity(this.battleScene.getEnemy(),this.battleScene.getPlayer());
                this.battlePanel.printHealth(this.battleScene.getPlayer());
                break;
        }
        runPlayerTurn();
    }

    // start battle method
    private void startBattle(){
        this.battlePanel.log("The battle between " +
                this.battleScene.getPlayer().getEntityName() +
                " and " +
                this.battleScene.getEnemy().getEntityName() +
                " has begun!\n");
    }

    // battle loop method
    private void runBattleLoop(){
        runPlayerTurn();

    }




}
