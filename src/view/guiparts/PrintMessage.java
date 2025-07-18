package view.guiparts;

public class PrintMessage {

    public enum Type{
        // Generic print usage
        CUSTOM,

        // Out of battle print types
        ENTITY_ITEM_USE, ENTITY_FAILED_ITEM_USE, ENTITY_SUCCESSFUL_ITEM_USE,

        // Battle print types
        ENTITY_START_TURN, ENTITY_ATTACK, ENTITY_DEFEND, ENTITY_RUN,
        ENTITY_SUCCESSFUL_RUN, ENTITY_FAILED_RUN, ENTITY_HEALTH, ENTITY_END_TURN
    }


    private final Type type;
    private final String[] args;



    public PrintMessage(Type type, String... args){
        this.type = type;
        this.args = args;
    }


    public Type getType() {return type;}

    public String[] getArgs() {return args;}



}
