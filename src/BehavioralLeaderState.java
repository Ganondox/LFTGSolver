public class BehavioralLeaderState extends LeaderState{


    LeaderState[] possibleStrategies;
    double[] probabilityofStrategy;


    public BehavioralLeaderState(LeaderState[] possibleStrategies, double[] probabilityofStrategy) {
        this.possibleStrategies = possibleStrategies;
        this.probabilityofStrategy = probabilityofStrategy;
    }

    @Override
    int getSignal() {
        double choice = Math.random();
        double search = 0;
        int decision = 0;
        while(search < choice){
            search += probabilityofStrategy[decision];
            decision++;
        }
        return possibleStrategies[decision-1].getSignal();
    }

    @Override
    LeaderState next(int observation) {
        LeaderState[] strats = new LeaderState[possibleStrategies.length];
        for(int i = 0; i < strats.length; i++){
            strats[i] = possibleStrategies[i].next(observation);
        }

        return new BehavioralLeaderState(strats, probabilityofStrategy.clone());
    }

    @Override
    LeaderState copy() {


        LeaderState[] strategies = new LeaderState[possibleStrategies.length];

        for(int i = 0; i < possibleStrategies.length; i++){
            strategies[i] = possibleStrategies[i].copy();
        }

        return new BehavioralLeaderState(strategies, probabilityofStrategy);
    }

    @Override
    LeaderState copy(Game g)
    {


        LeaderState[] strategies = new LeaderState[possibleStrategies.length];

        for(int i = 0; i < possibleStrategies.length; i++){
            strategies[i] = possibleStrategies[i].copy(g);
        }

        return new BehavioralLeaderState(strategies, probabilityofStrategy);
    }
}
