package tst;

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
        Enemy slime = new Slime(1);
        BattleScene bsc = new BattleScene(player,slime);

        gameWindow.add(new BattlePanel(bsc.getEnemy().getEntityName()));
        gameWindow.refresh();

    }





}
