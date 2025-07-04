package tst;

import bsc.BattleController;
import bsc.BattleScene;
import ety.Player;
import ety.enemy.Enemy;
import ety.enemy.Slime;
import gui.GameWindow;
import gui.parts.BattlePanel;

public class Tester {

    // The tester main method
    public static void main(String[] args){

        GameWindow gameWindow = new GameWindow(800,600,"Game");
        Player player = new Player("Player");
        Enemy slime = new Slime(5); //TODO: FIX ATTACK AT HIGHER LEVELS; adds attack to defense into negatives
        BattleScene bsc = new BattleScene(player,slime);

        BattleController bc = new BattleController(bsc);

        gameWindow.add(bc.getBattlePanel());

        gameWindow.refresh();

    }





}
