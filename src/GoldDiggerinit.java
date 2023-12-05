public class GoldDiggerinit extends Follower{

    int action;

    public GoldDiggerinit(int action) {
        this.action = action;
    }

    @Override
    FollowerState getStrategy() {
        return new GoldDigger(MirrorFollowerStrategy.state.othersignal,action);
    }
}
