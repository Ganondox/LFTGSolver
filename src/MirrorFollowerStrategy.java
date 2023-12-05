public class MirrorFollowerStrategy extends FollowerState{


    enum state{mysignal, myaction, myfeedback, othersignal, otheraction, otherfeedback}

    state cur;

    int action;

    public MirrorFollowerStrategy(state cur, int action) {
        this.cur = cur;
        this.action = action;
    }

    @Override
    int getAction() {
        return action;
    }

    @Override
    FollowerState next(int observation) {
        //keep up with what observation is coming from, set action to other player's action, mirroring them
        switch (cur){
            case mysignal:
                return new MirrorFollowerStrategy(state.myaction, action);
            case myaction:
                return new MirrorFollowerStrategy(state.myfeedback, action);
            case myfeedback:
                return new MirrorFollowerStrategy(state.othersignal, action);
            case othersignal:
                return new MirrorFollowerStrategy(state.otheraction, action);
            case otheraction:
                return new MirrorFollowerStrategy(state.otherfeedback, observation);
            case otherfeedback:
                return new MirrorFollowerStrategy(state.mysignal, action);

        }
        return this;
    }

    @Override
    FollowerState copy() {
        return new MirrorFollowerStrategy(cur, action);
    }

    @Override
    FollowerState copy(Game g) {
        return new MirrorFollowerStrategy(cur, action);
    }
}
