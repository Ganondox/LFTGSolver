public class SimpleFollowerStrategy extends FollowerState{

    int action;

    public SimpleFollowerStrategy(int action) {
        this.action = action;
    }

    @Override
    int getAction() {
        return action;
    }

    @Override
    FollowerState next(int observation) {
        return new SimpleFollowerStrategy(observation);
    }

    @Override
    FollowerState copy() {
        return new SimpleFollowerStrategy(action);
    }

    @Override
    FollowerState copy(Game g) {
        return new SimpleFollowerStrategy(action);

    }
}
