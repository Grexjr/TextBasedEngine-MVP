package view.guiparts.buttons;

import controller.BattleController;
import controller.StoryController;

import java.util.function.Consumer;

public enum GameButton {

    // === VALUES OF ENUM ===
    YES(
           "Yes",
           StoryController::handleYes
    ),
    NO(
            "No",
            StoryController::handleNo
    );


    // === VARIABLES AND FIELDS ===
    private final String buttonDisplayName;
    private final Consumer<StoryController> buttonAction;

    // === CONSTRUCTOR ===
    GameButton(String label, Consumer<StoryController> action){
        this.buttonDisplayName = label;
        this.buttonAction = action;
    }


    // === GETTERS ===
    public String getButtonDisplayName() {return buttonDisplayName;}

    public Consumer<StoryController> getButtonAction() {return buttonAction;}


    // === BASIC METHOD ===
    public void performAction(StoryController controller){
        this.buttonAction.accept(controller);
    }


}
