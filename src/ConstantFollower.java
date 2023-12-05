public class ConstantFollower extends Follower{

    int action;

    public ConstantFollower(int action) {
        this.action = action;
    }

    @Override
    FollowerState getStrategy() {
        return new ConstantFollowerStrategy(action);
    }
}
