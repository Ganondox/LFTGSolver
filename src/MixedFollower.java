import java.util.List;

public class MixedFollower extends Follower {




        Follower[] possibleStarts;
        double[] probabilityofStart;


    public MixedFollower(Follower[] possibleStarts, double[] probabilityofStart) {
        this.possibleStarts = possibleStarts;
        this.probabilityofStart = probabilityofStart;
    }

    public MixedFollower(Follower f) {
        this.possibleStarts = new Follower[] {f};
        this.probabilityofStart = new double[] {1.0};
    }

    @Override
    FollowerState getStrategy() {
        double choice = Math.random();
        double search = 0;
        int decision = 0;
        while(search < choice){
            search += probabilityofStart[decision];
            decision++;
        }
        return possibleStarts[decision-1].getStrategy();
    }

}
