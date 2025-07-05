package ety.enemy;

import ety.BattleChoice;
import ety.Entity;

public class Enemy extends Entity {

    // === CONSTRUCTOR FOR ENEMY ===
    public Enemy(String name, String description, int level, int maxHealth, int attack, int defense, int speed){
        super(name,description,level,maxHealth,attack,defense,speed);
    }

    // === OTHER METHODS ===

    // -- Battle Methods --
    public BattleChoice makeBattleChoice(){
        //TODO: add enemy AI
        return BattleChoice.ATTACK;
    }

}
