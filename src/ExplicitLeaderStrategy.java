public class ExplicitLeaderStrategy extends LeaderState{


    int signal;
    LeaderState[] possibleNext;

    public ExplicitLeaderStrategy(int signal, LeaderState[] possibleNext) {
        this.signal = signal;
        this.possibleNext = possibleNext;
    }

    @Override
    int getSignal() {
        return signal;
    }


    @Override
    LeaderState next(int observation) {
        return possibleNext[observation];
    }

    @Override
    LeaderState copy() {
        return new ExplicitLeaderStrategy(signal, possibleNext);
    }

    @Override
    LeaderState copy(Game g) {
        return new ExplicitLeaderStrategy(signal, possibleNext);
    }
}
