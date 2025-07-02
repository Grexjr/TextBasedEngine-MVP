package bsc;

import ety.Entity;
import ety.Player;
import ety.enemy.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class BattleScene {

    // === VARIABLES AND FIELDS FOR BATTLESCENE ===
    private boolean inBattle;
    private final Enemy enemy;
    private final Player player;


    // == CONSTRUCTOR FOR BATTLESCENE ===
    public BattleScene(Player player, Enemy enemy){
        this.enemy = enemy;
        this.player = player;
        this.inBattle = true;

        // Debug
        System.out.println("Starting battle!");
        battleLoop();
    }


    // === GETTERS AND SETTERS ===
    public boolean isInBattle() {return this.inBattle;}
    public void setInBattle(boolean value) {this.inBattle = value;}

    public Enemy getEnemy() {return this.enemy;}
    public Player getPlayer() {return this.player;}


    // === OTHER METHODS ===

    // -- Helper Methods --
    // method that compares speeds of enemy and player and returns higher
    private int compareSpeeds(Entity comparer, Entity target){
        return comparer.compareSpeed(target.getEntitySpeed());
    }

    // method to determine which of two entities goes first
    //TODO: Determine where you want this method to be
    //TODO: takeTurn method
    private void determineFirst(Entity entity1, Entity entity2){
        if(compareSpeeds(entity1,entity2) == entity1.getEntitySpeed()){
            attackEntity(entity1,entity2);
        }
        if(compareSpeeds(entity1,entity2) == entity2.getEntitySpeed()){
            attackEntity(entity2,entity1);
        }
        Random rand = new Random();
        if(rand.nextInt(1,2) == 1) {attackEntity(entity1,entity2);}
        if(rand.nextInt(1,2) == 2) {attackEntity(entity1,entity2);}
    }

    // attack entity method
    //TODO: Split this up, put some in entity, some here
    private void attackEntity(Entity attacker, Entity target){
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


    // === BATTLE PROGRESS METHODS ===
    // method to start the battle, returns a new battlescene with the two entities involved
    // TODO: this won't work. move this out of this class or pass in the entities as parameters
    public static BattleScene startBattle(Player player, Enemy enemy){
        return new BattleScene(player, enemy);
    }

    // method to check if the battle is over, returns true if not so isInBattle stays true
    private boolean checkBattleEnd(){
        ArrayList<Entity> battlers = new ArrayList<Entity>();
        battlers.add(this.player);
        battlers.add(this.enemy);
        for(Entity battler : battlers){
            if(battler.getEntityCurrentHealth() < 0){
                return false;
            }
        }
        return true;
    }

    // Actual loop of battle method
    private void battleLoop(){
        while(this.isInBattle()){
            this.determineFirst(this.player,this.enemy);
            if(!checkBattleEnd()){
                Entity loser = findLoser();
                Entity winner = findWinner();
                // Debug
                System.out.println(loser.getEntityName() + "loses!");
                System.out.println(winner.getEntityName() + "wins!");
                this.setInBattle(false);
            }

        }
    }





}
