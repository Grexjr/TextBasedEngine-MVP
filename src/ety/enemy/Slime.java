package ety.enemy;

public class Slime extends Enemy{

    // === CONSTRUCTOR FOR SLIME ===
    public Slime(int level){
        super(
                "Slime",
                "A gooey, disgusting blob!",
                level,
                level + 9,
                level,
                Math.max(level - 1,0),
                level
        );
    }

}
