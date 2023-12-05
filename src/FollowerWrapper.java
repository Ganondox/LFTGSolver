public class FollowerWrapper extends Follower{

    FollowerState state;

    public FollowerWrapper(FollowerState state) {
        this.state = state;
    }

    @Override
    FollowerState getStrategy() {
        return state;
    }
}
