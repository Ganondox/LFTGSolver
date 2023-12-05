public abstract class GameHead {

    abstract GameState init();

    abstract GameState init(int world);

    GameState init(Nature nature){
        return init(nature.getWorld());
    }



}
