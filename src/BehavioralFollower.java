public class BehavioralFollower extends Follower{

    Follower[] possibleStrategies;
    double[] probabilityofStrategy;


    public BehavioralFollower(Follower[] possibleStrategies, double[] probabilityofStrategy) {
        this.possibleStrategies = possibleStrategies;
        this.probabilityofStrategy = probabilityofStrategy;
    }


    @Override
    FollowerState getStrategy() {
        FollowerState[] starts = new FollowerState[possibleStrategies.length];
        for(int i = 0; i<starts.length; i++){
            starts[i] = possibleStrategies[i].getStrategy();
        }

        return new BehavioralFollowerState(starts, probabilityofStrategy);
    }
}
