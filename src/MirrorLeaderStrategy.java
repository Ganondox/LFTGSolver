public class MirrorLeaderStrategy extends LeaderState{


    int signal;


    MirrorFollowerStrategy.state cur;
    @Override
    int getSignal() {
        return signal;
    }

    public MirrorLeaderStrategy( MirrorFollowerStrategy.state cur, int signal) {
        this.signal = signal;
        this.cur = cur;
    }

    @Override
    LeaderState next(int observation) {
        switch (cur){
            case mysignal:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.myaction, signal);
            case myaction:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.myfeedback, signal);
            case myfeedback:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.othersignal, signal);
            case othersignal:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.otheraction, signal);
            case otheraction:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.otherfeedback, observation);
            case otherfeedback:
                return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.mysignal, signal);

        }
        return this;
    }

    @Override
    LeaderState copy() {
        return new MirrorLeaderStrategy(cur, signal);
    }

    @Override
    LeaderState copy(Game g) {
        return new MirrorLeaderStrategy(cur, signal);
    }
}
