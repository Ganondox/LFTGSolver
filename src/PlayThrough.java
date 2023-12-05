import java.util.List;

public class PlayThrough extends EvalState{


    int attempts = 1;

    @Override
    double value(GameState state, List<Integer> observations, FollowerState follower1, FollowerState follower2, LeaderState leader1, LeaderState leader2) {

        if(state.terminal) {
            if (state.won) return 1; else return 0;
        }

        double value = 0;


        for(int i = 0; i < attempts; i++) {

            //wrap players
            FollowerState f1 = follower1;
            FollowerState f2 = follower2;
            LeaderState l1 = leader1;
            LeaderState l2 = leader2;
            GameState g = state;
            for(int j = 0; j < observations.size() % 6; j++){
                f1 = new DelayFollower(f1);
                f2 = new DelayFollower(f2);
                l2 = new DelayLeader(l2);
                l1 = new DelayLeader(l1);
                if(j == 1 || j == 4 ){
                    g = new DelayGame(g);
                }
            }


            

            if(new Game(new GameWrapper(g)).play(new LeaderWrapper(l1), new FollowerWrapper(f1), new LeaderWrapper(l2), new FollowerWrapper(f2))){
                value++;
            }


        }



        return value/attempts;
    }
}
