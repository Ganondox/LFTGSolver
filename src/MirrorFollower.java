public class MirrorFollower extends Follower{




    @Override
    FollowerState getStrategy() {
        return new MirrorFollowerStrategy(MirrorFollowerStrategy.state.othersignal, 0);
    }
}
