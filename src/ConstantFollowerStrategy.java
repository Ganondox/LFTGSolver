public class ConstantFollowerStrategy extends FollowerState{

    int action;

    public ConstantFollowerStrategy(int action) {
        this.action = action;
    }

    @Override
    int getAction() {
        return action;
    }

    @Override
    FollowerState next(int observation) {
        return this;
    }

    @Override
    FollowerState copy() {
        return new ConstantFollowerStrategy(action);
    }

    @Override
    FollowerState copy(Game g) {
        return new ConstantFollowerStrategy(action);
    }
}
