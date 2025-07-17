package controller;

import model.ety.Entity;
import model.ety.Player;
import model.ety.enemy.Enemy;
import view.ViewManager;
import view.guiparts.PrintMessage;
import view.guiparts.buttons.BattleButton;
import view.guis.BattleGUI;
import view.guiparts.TextLog;
import model.BattleScene;
import view.guis.GameplayGUI;

import javax.swing.*;

public class BattleController extends SceneController {
    //TODO: REFACTOR REFACTOR REFACTOR!!!
    // TODO: Standardize the print methods even more so you have the arguments you need in there

    // === VARIABLES AND FIELDS ===
    private final BattleScene battleScene;
    private final Player player;
    private final Enemy enemy;


    // === BATTLE CONTROLLER CONSTRUCTOR ===
    public BattleController(ViewManager viewer, BattleScene bsc, BattleGUI gui){
        super(viewer,gui);
        this.battleScene = bsc;

        this.player = bsc.getPlayer();
        this.enemy = bsc.getEnemy();

        for(BattleButton b : BattleButton.values()){
            JButton btn = new JButton(b.getButtonDisplayName());
            btn.addActionListener(_ -> b.performAction(this));
            gui.getButtonPanel().add(btn);
        }
    }

    // === GETTERS AND SETTERS ===


    // === CONSTRUCTOR METHODS ===

    // method to set the action listeners for the buttons

    // button handling methods
    public void handlePlayerAttack(){
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_ATTACK,
                            this.player.getEntityName(),
                            this.enemy.getEntityName()
                    ));
            this.battleScene.attackEntity(this.player,this.enemy);
            if(checkWin()){
                System.exit(0);
            }
            this.currentSceneView.print( //TODO: Put this in another method
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_HEALTH,
                            this.enemy.getEntityName(),
                            String.valueOf(this.enemy.getEntityStatBlock().getEntityCurrentHealth()),
                            String.valueOf(this.enemy.getEntityStatBlock().getEntityMaxHealth())
                            ));
            endPlayerTurn();
    }

    public void handlePlayerDefend(){
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_DEFEND,
                            this.player.getEntityName()
                    ));
            this.player.guard();
            endPlayerTurn();
            this.player.getEntityStatBlock().resetTempStats();
    }

    public void handlePlayerItem() {
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.CUSTOM
                    ));
            if(this.player.getPlayerInventory().checkEmpty()){
                this.currentSceneView.print(
                        new PrintMessage(
                                PrintMessage.Type.CUSTOM
                        ));
            } else{
                // TEMP: Hard coded for just using healable, need to expand and genericize this.
                // TEMP: only takes from first slot, no choice | TODO: Add choice for items
                // TODO: Add local variable for item
                this.currentSceneView.print(
                        new PrintMessage(
                                PrintMessage.Type.ENTITY_SUCCESSFUL_ITEM_USE,
                                this.player.getEntityName(),
                                this.player.getPlayerInventory().getFromIndex(0).getItemName()
                        ));
                this.player.useItem(this.player.getPlayerInventory().getFromIndex(0));
                System.out.println("useItem.success");
            }
    }

    public void handlePlayerRun(){ // TODO: Refactor and make smaller
            boolean runSuccess = this.player.run(this.enemy);

            if(runSuccess){

                endBattle(); // First so set in false so ending player turn doesn't run enemy turn
                endPlayerTurn();

                // Debug
                System.out.println("Run Successful.");

                this.currentSceneView.print(
                        new PrintMessage(
                                PrintMessage.Type.ENTITY_SUCCESSFUL_RUN,
                                this.player.getEntityName()
                        ));

                new Timer(1000,_ -> System.exit(0)).start(); // TODO: Better end function

            } else{
                // Debug
                System.out.println("Run failed.");

                this.currentSceneView.print(
                        new PrintMessage(
                                PrintMessage.Type.ENTITY_FAILED_RUN,
                                this.player.getEntityName()
                        ));
                endPlayerTurn();
            }
    }


    // === PLAYER TURN METHODS ===
    private void endPlayerTurn(){
        this.currentSceneView.disableButtons();
        if(this.battleScene.getFirstGoer() instanceof Player){
            runEnemyTurn();
        } else{
            runTurnSetOrder();
        }
    }

    // running player turn
    private void runPlayerTurn(){
        if(this.battleScene.isInBattle() && !checkLoss()){
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_START_TURN,
                            this.player.getEntityName()
                    ));
            this.currentSceneView.enableButtons();
        }
    }


    // === ENEMY TURN METHODS ===
    // TODO: Add an endEnemyTurn method so you can check in there for battle ends
    private void runEnemyTurn(){
        if(this.battleScene.isInBattle()){
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_ATTACK,
                            this.enemy.getEntityName(),
                            this.player.getEntityName()
                    ));
            this.battleScene.attackEntity(this.enemy,this.player);
            this.currentSceneView.print(
                    new PrintMessage(
                            PrintMessage.Type.ENTITY_HEALTH,
                            this.enemy.getEntityName(),
                            String.valueOf(this.player.getEntityStatBlock().getEntityCurrentHealth()),
                            String.valueOf(this.player.getEntityStatBlock().getEntityMaxHealth())
                    ));
            if(this.battleScene.getFirstGoer() instanceof Enemy){
                runPlayerTurn();
            } else{
                runTurnSetOrder();
            }
        }
    }

    // === BATTLE START METHODS ===
    public void startBattle(){
        this.currentSceneView.print(
                new PrintMessage(
                        PrintMessage.Type.CUSTOM,
                        "Battle has begun!\n"
                ));
        this.currentSceneView.disableButtons();
        if(this.battleScene.getFirstGoer() instanceof Player){
            runPlayerTurn();
        } else {
            runEnemyTurn();
        }
    }

    // === BATTLE END METHODS ===
    //TODO: Refactor the below with battleExits and one singular method

    // method to check if battle won
    private boolean checkWin(){
        return this.enemy.isDead();
    }

    // method to check if battle lost
    private boolean checkLoss(){
        return this.player.isDead();
    }

    // method to end the battle
    private void endBattle(){
        this.battleScene.setInBattle(false);
        // If checkWin vs if checkLoss vs returning run
        //TODO: Add better functionality for this; exit codes, etc.
    }


    // === BATTLE PROGRESSION METHODS ===
    private boolean checkFirstGoerIsPlayer(){
        Entity firstGoer = this.battleScene.determineWhoGoesFirst(this.player,this.enemy);
        return  firstGoer instanceof Player;
    }

    private void runTurnSetOrder(){
        if(checkFirstGoerIsPlayer()){
            this.battleScene.setFirstGoer(this.player);
            runPlayerTurn();
        } else {
            this.battleScene.setFirstGoer(this.enemy);
            runEnemyTurn();
        }
    }
}
