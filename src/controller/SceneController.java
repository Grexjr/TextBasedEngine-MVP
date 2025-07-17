package controller;

import view.ViewManager;
import view.guis.GUI;
import view.guis.GameplayGUI;

public class SceneController {

    // === VARIABLES AND FIELDS ===
    private final ViewManager viewer;
    protected GUI currentSceneView;
    // TODO: Create scene class that battlescene extends from

    // === CONSTRUCTOR ===
    public SceneController(ViewManager view, GUI currentView){
        this.viewer = view;
        this.currentSceneView = currentView;
    }


    // === GETTERS ===
    public ViewManager getViewer() {return viewer;}

    public GUI getCurrentSceneView() {return currentSceneView;}
    public void setCurrentSceneView(GameplayGUI currentSceneView) {this.currentSceneView = currentSceneView;}

}
