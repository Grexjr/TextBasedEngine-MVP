package controller;

import view.ViewManager;
import view.guis.GUI;
import view.guis.GameplayGUI;

public class SceneController {

    // === VARIABLES AND FIELDS ===
    private final ViewManager viewer;
    private GameplayGUI currentSceneView;
    // TODO: Create scene class that battlescene extends from

    // === CONSTRUCTOR ===
    public SceneController(ViewManager view, GameplayGUI currentView){
        this.viewer = view;
        this.currentSceneView = currentView;
    }


    // === GETTERS ===
    public ViewManager getViewer() {return viewer;}

    public GameplayGUI getCurrentSceneView() {return currentSceneView;}
    public void setCurrentSceneView(GameplayGUI currentSceneView) {this.currentSceneView = currentSceneView;}

}
