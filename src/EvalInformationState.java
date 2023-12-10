import java.util.List;

public abstract class EvalInformationState {

    abstract double value(InformationState state, List<Integer> observations, FollowerState follower1, FollowerState follower2, LeaderState leader1, LeaderState leader2);


}
