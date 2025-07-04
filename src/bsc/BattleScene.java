package bsc;

import ety.Entity;
import ety.Player;
import ety.enemy.Enemy;
import gui.parts.BattlePanel;

import java.util.ArrayList;
import java.util.Random;

public class BattleScene {

    // === VARIABLES AND FIELDS FOR BATTLESCENE ===
    private boolean inBattle, isPlayerTurn;
    private final Enemy enemy;
    private final Player player;


    // == CONSTRUCTOR FOR BATTLESCENE ===
    public BattleScene(Player player, Enemy enemy){
        this.enemy = enemy;
        this.player = player;
        this.inBattle = true;
        this.isPlayerTurn = false;

        // Debug
        System.out.println("Starting battle!");
        //battleLoop();
    }


    // === GETTERS AND SETTERS ===
    public boolean isInBattle() {return this.inBattle;}
    public void setInBattle(boolean value) {this.inBattle = value;}

    public Enemy getEnemy() {return this.enemy;}
    public Player getPlayer() {return this.player;}

    public boolean isPLayerTurn() {return this.isPlayerTurn;}
    public void setPlayerTurn(boolean value) {this.isPlayerTurn = value;}


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method that compares speeds of enemy and player and returns higher
    private int compareSpeeds(Entity comparer, Entity target){
        return comparer.compareSpeed(target.getEntitySpeed());
    }

    // method to determine which of two entities goes first
    //TODO: Determine where you want this method to be
    protected Entity determineTurn(Entity entity1, Entity entity2){
        Entity goer = null;
        if(entity1.getEntitySpeed() > entity2.getEntitySpeed()){
            goer = entity1;
            return goer;
        } else if(entity1.getEntitySpeed() < entity2.getEntitySpeed()){
            goer = entity2;
            return goer;
        } else {
            int rand = new Random().nextInt(0,1);
            if(rand == 0){
                goer = entity1;
                return goer;
            } else if(rand == 1){
                goer = entity2;
                return goer;
            }
        }
        return goer; //TODO: Throw exception here
    }

    // method to determine if firstGoer is instance of player, to do player turn
    protected boolean isGoerPlayer(Entity goer){
        return goer instanceof Player;
    }

    // attack entity method
    //TODO: Split this up, put some in entity, some here
    protected void attackEntity(Entity attacker, Entity target){
        int attackPower = attacker.getEntityAttack() - target.getEntityDefense();
        target.setEntityCurrentHealth(target.getEntityCurrentHealth() - attackPower);
        // Debug
        System.out.println(attacker.getEntityName() + " attacks " + target.getEntityName());
    }

    // method to return the loser of the battle -- null check if neither loses
    private Entity findLoser(){
        if(this.player.getEntityCurrentHealth() <= 0) {return this.player;}
        if(this.enemy.getEntityCurrentHealth() <= 0) {return this.enemy;}
        return null;
    }

    // method to find the winner of the battle -- null check if neither wins
    private Entity findWinner(){
        return this.player.getEntityCurrentHealth() > this.enemy.getEntityCurrentHealth() ? this.player : this.enemy;
    }




}
