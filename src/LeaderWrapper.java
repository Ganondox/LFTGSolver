public class LeaderWrapper extends Leader{

    LeaderState state;

    public LeaderWrapper(LeaderState state) {
        this.state = state;
    }

    @Override
    LeaderState getStrategy(GameState initialState) {
        return state;
    }
}
