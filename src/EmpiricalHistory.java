import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Note doesn't work with leaders because signals don't change the game state, should fix, but I also don't know if the map works even if the state is accurate

public class EmpiricalHistory extends EvalState{


    //ignore player strategies, just look at state value

    Map<GameState,Integer> wins;
    Map<GameState,Integer> plays;

    public EmpiricalHistory() {

        wins = new HashMap<>();
        plays = new HashMap<>();
    }

    @Override
    double value(GameState state, List<Integer> observations, FollowerState follower1, FollowerState follower2, LeaderState leader1, LeaderState leader2) {
      return value(state);
    }

    double value(GameState state){
        if(!plays.containsKey(state)){
            wins.put(state, 1);
            plays.put(state, 2);
        }

        return (wins.get(state)*1.0)/(plays.get(state));
    }

    void addWin(Game g){
        for(GameState s: g.history){
            if(plays.containsKey(s)) {
                plays.put(s, plays.get(s) + 1);
                wins.put(s, wins.get(s) + 1);
            } else {
                wins.put(s, 2);
                plays.put(s, 3);
            }
        }
    }

    void addLose(Game g){
        for(GameState s: g.history){
            if(plays.containsKey(s)) {
                plays.put(s, plays.get(s) + 1);
            } else {
                wins.put(s, 1);
                plays.put(s, 3);
            }
        }
    }
}
