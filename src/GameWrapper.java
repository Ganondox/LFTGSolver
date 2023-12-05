public class GameWrapper extends GameHead{

    GameState state;


    public GameWrapper(GameState state) {
        this.state = state;
    }

    @Override
    GameState init() {
        return state;
    }

    @Override
    GameState init(int world) {
        return state;
    }
}
