package controller;

import model.BattleScene;
import model.ety.Player;
import model.ety.enemy.Enemy;
import model.ety.enemy.Slime;
import view.ViewManager;
import view.guiparts.TextLog;
import view.guiparts.buttonpanels.BattleButtonPanel;
import view.guiparts.buttons.GameButton;
import view.guis.BattleGUI;
import view.guis.StoryGUI;

import javax.swing.*;

public class StoryController extends SceneController{

    // === VARIABLES AND FIELDS ===


    // === CONSTRUCTOR ===
    public StoryController(ViewManager viewer, StoryGUI story){
        super(viewer,story);

        for(GameButton b : GameButton.values()){
            JButton btn = new JButton(b.getButtonDisplayName());
            btn.addActionListener(_ -> b.performAction(this));
            story.getButtonPanel().add(btn);
        }
    }


    // === BUTTON HANDLING === | TODO: abstract these to the super class since they'll be used everywhere
    public void handleYes(){
        System.out.println("Yes");
        //TEMP
        BattleGUI battle = new BattleGUI(new BattleButtonPanel(),this.getCurrentSceneView().getTextLog());
        Player player = new Player("Play guy");
        Enemy slime = new Slime(1);
        BattleScene bs = new BattleScene(player, slime);
        BattleController bc = new BattleController(this.getViewer(),bs,battle);

        this.getViewer().viewTransition(bc.getCurrentSceneView());
    }

    public void handleNo(){
        System.out.println("No");
    }





}
