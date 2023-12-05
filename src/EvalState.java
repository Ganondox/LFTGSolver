import java.util.List;

public abstract class EvalState {

    abstract double value(GameState state, List<Integer> observations, FollowerState follower1, FollowerState follower2, LeaderState leader1, LeaderState leader2);


}
