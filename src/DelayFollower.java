public class DelayFollower extends FollowerState{

    FollowerState next;

    public DelayFollower(FollowerState followerState) {
        this.next = followerState;
    }

    @Override
    int getAction() {
        return 0;
    }

    @Override
    FollowerState next(int observation) {
        return next;
    }

    @Override
    FollowerState copy() {
        return new DelayFollower(next);
    }

    @Override
    FollowerState copy(Game g) {
        return new DelayFollower(next);
    }
}
