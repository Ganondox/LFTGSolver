public class EmptyLeader extends Leader{

    @Override
    LeaderState getStrategy(GameState initialState) {
        return new DeadSignal();
    }
}
