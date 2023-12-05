public class GoldDigger extends FollowerState{

    //optimal strategy for p2 in Bombs and Gold

    int action;

    MirrorFollowerStrategy.state cur;

    public GoldDigger(MirrorFollowerStrategy.state cur, int action) {
        this.action = action;
        this.cur = cur;
    }


    @Override
    int getAction() {
        return action;

    }

    @Override
    FollowerState next(int observation) {

            switch (cur){
                case mysignal:
                    return new GoldDigger(MirrorFollowerStrategy.state.myaction, action);
                case myaction:
                    return new MirrorFollowerStrategy(MirrorFollowerStrategy.state.myfeedback, action);
                case myfeedback:
                    return new GoldDigger(MirrorFollowerStrategy.state.othersignal, action);
                case othersignal:
                    return new GoldDigger(MirrorFollowerStrategy.state.otheraction, action);
                case otheraction:
                    return new GoldDigger(MirrorFollowerStrategy.state.otherfeedback, action);
                case otherfeedback:
                    return new GoldDigger(MirrorFollowerStrategy.state.mysignal, action);

            }
            return this;
    }

    @Override
    FollowerState copy() {
        return new GoldDigger(cur ,action);
    }

    @Override
    FollowerState copy(Game g) {
        return new GoldDigger(cur, action);
    }
}
