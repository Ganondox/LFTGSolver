public class BestResponseFollowerInit extends Follower {


    boolean isTeam1;

    Game game;

    int max;
    EvalState evaluator;



    public BestResponseFollowerInit(boolean isTeam1, Game game, int max, EvalState evaluator) {
        this.isTeam1 = isTeam1;
        this.game = game;
        this.max = max;
        this.evaluator = evaluator;

    }

    @Override
    FollowerState getStrategy() {

        return new BestResponseFollower(isTeam1,game,max, evaluator);
    }

}
