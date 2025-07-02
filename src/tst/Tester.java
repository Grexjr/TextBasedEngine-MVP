package tst;

import bsc.BattleScene;
import ety.Player;
import ety.enemy.Slime;

public class Tester {

    // The tester main method
    public static void main(String[] args){

        BattleScene.startBattle(new Player("You"), new Slime(1));

    }





}
