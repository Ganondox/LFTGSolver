public class SimpleFollower extends Follower{

    @Override
    FollowerState getStrategy() {
        return new SimpleFollowerStrategy(0);
    }
}
