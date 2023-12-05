public class DeadSignal extends LeaderState{

    @Override
    int getSignal() {
        return 0;
    }

    @Override
    LeaderState next(int observation) {
        return this;
    }

    @Override
    LeaderState copy() {
        return new DeadSignal();
    }

    @Override
    LeaderState copy(Game g) {
        return new DeadSignal();
    }
}
