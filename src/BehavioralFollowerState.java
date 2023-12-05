public class BehavioralFollowerState extends FollowerState{


    FollowerState[] possibleStrategies;
    double[] probabilityofStrategy;


    public BehavioralFollowerState(FollowerState[] possibleStrategies, double[] probabilityofStrategy) {
        this.possibleStrategies = possibleStrategies;
        this.probabilityofStrategy = probabilityofStrategy;
    }

    @Override
    int getAction() {
        double choice = Math.random();
        double search = 0;
        int decision = 0;
        while(search < choice){
            search += probabilityofStrategy[decision];
            decision++;
        }
        return possibleStrategies[decision-1].getAction();
    }

    @Override
    FollowerState next(int observation) {
        FollowerState[] strats = new FollowerState[possibleStrategies.length];
        for(int i = 0; i < strats.length; i++){
            strats[i] = possibleStrategies[i].next(observation);
        }

        return new BehavioralFollowerState(strats, probabilityofStrategy.clone());
    }

    @Override
    FollowerState copy() {
        return null;
    }

    @Override
    FollowerState copy(Game g) {
        return null;
    }
}
