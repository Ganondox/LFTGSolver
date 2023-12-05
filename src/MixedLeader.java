import java.util.List;

public class MixedLeader extends Leader {

    Leader[] possibleStarts;
    double[] probabilityofStart;


    public MixedLeader(Leader[] possibleStarts, double[] probabilityofStart) {
        this.possibleStarts = possibleStarts;
        this.probabilityofStart = probabilityofStart;
    }

    public MixedLeader(Leader f) {
        this.possibleStarts = new Leader[] {f};
        this.probabilityofStart = new double[] {1.0};
    }

    @Override
    LeaderState getStrategy(GameState initialState) {
        double choice = Math.random();
        double search = 0;
        int decision = 0;
        while(search < choice){
            search += probabilityofStart[decision];
            decision++;
        }
        return possibleStarts[decision-1].getStrategy(initialState);
    }
}
