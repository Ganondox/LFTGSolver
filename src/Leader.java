public abstract class Leader {

    abstract LeaderState getStrategy(GameState initialState);
}
