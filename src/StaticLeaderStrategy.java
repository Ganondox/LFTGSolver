public class StaticLeaderStrategy extends LeaderState {

    int signal;
    @Override
    int getSignal() {
        return signal;
    }

    public StaticLeaderStrategy(int signal) {
        this.signal = signal;
    }

    @Override
    LeaderState next(int observation) {
        return new StaticLeaderStrategy(signal);
    }

    @Override
    LeaderState copy() {
        return  new StaticLeaderStrategy(signal);
    }

    @Override
    LeaderState copy(Game g) {
        return  new StaticLeaderStrategy(signal);
    }
}
