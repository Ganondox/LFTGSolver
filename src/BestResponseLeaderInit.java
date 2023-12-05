import java.util.LinkedList;
import java.util.List;

public class BestResponseLeaderInit extends Leader{

    boolean isTeam1;

    Game game;

    int max;
    EvalState evaluator;



    public BestResponseLeaderInit(boolean isTeam1, Game game, int max, EvalState evaluator) {
        this.isTeam1 = isTeam1;
        this.game = game;
        this.max = max;
        this.evaluator = evaluator;

    }

    @Override
    LeaderState getStrategy(GameState initialState) {

        return new BestResponserLeader(isTeam1,game,max, evaluator);
    }
}
