public class HypothesisDrivenFollower extends Follower{

    BombsAndGold.stuff[] hypothesis;
    int[] state;

    MirrorFollowerStrategy.state cur;

    public HypothesisDrivenFollower(BombsAndGold.stuff[] hypothesis, int[] state, MirrorFollowerStrategy.state cur) {
        this.hypothesis = hypothesis;
        this.state = state;
        this.cur = cur;
    }


    @Override
    FollowerState getStrategy() {
        return new HypothesisDriven(hypothesis, state.clone(), cur);
    }
}
