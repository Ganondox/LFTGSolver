import java.util.List;

public class PlayThroughInfo extends EvalInformationState{

    int iterations = 1;

    @Override
    double value(InformationState state, List<Integer> observations, FollowerState follower1, FollowerState follower2, LeaderState leader1, LeaderState leader2) {

        double sum = 0;
        for( int j = 0; j < iterations; j++) {
            GameState cur = state.gameHead.init();
            for (Integer i : state.observation) {
                cur = cur.next(i);
            }
            sum += new PlayThrough().value(cur, observations, follower1, follower2, leader1, leader2);
        }

        return sum/iterations;
    }
}
