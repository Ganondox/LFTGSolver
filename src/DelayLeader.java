public class DelayLeader extends LeaderState{

    LeaderState next;

    public DelayLeader(LeaderState next) {
        this.next = next;
    }

    @Override
    int getSignal() {
        return 0;
    }

    @Override
    LeaderState next(int observation) {
        next.setGame(game);
        return next;
    }

    @Override
    LeaderState copy() {
        return new DelayLeader(next);
    }

    @Override
    LeaderState copy(Game g) {
        return new DelayLeader(next);
    }
}
