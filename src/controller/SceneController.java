package controller;

import view.ViewManager;
import view.guis.GUI;

public class SceneController {

    // === VARIABLES AND FIELDS ===
    private final ViewManager viewer;
    private GUI currentSceneView;
    // TODO: Create scene class that battlescene extends from

    // === CONSTRUCTOR ===
    public SceneController(ViewManager view, GUI currentView){
        this.viewer = view;
        this.currentSceneView = currentView;
    }


    // === GETTERS ===
    public ViewManager getViewer() {return viewer;}

    public GUI getCurrentSceneView() {return currentSceneView;}
    public void setCurrentSceneView(GUI currentSceneView) {this.currentSceneView = currentSceneView;}

}
