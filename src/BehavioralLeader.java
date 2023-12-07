public class BehavioralLeader extends Leader{

    Leader[] possibleStrategies;
    double[] probabilityofStrategy;


    public BehavioralLeader(Leader[] possibleStrategies, double[] probabilityofStrategy) {
        this.possibleStrategies = possibleStrategies;
        this.probabilityofStrategy = probabilityofStrategy;
    }


    @Override
    LeaderState getStrategy(GameState initialState) {
        LeaderState[] starts = new LeaderState[possibleStrategies.length];
        for(int i = 0; i<starts.length; i++){
            starts[i] = possibleStrategies[i].getStrategy(initialState);
        }

        return new BehavioralLeaderState(starts, probabilityofStrategy);
    }


}
