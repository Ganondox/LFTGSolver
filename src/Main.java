public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Leader[] leaders = {new FirstBomb(), new FirstGold()};
        Follower[] followers = {new GoldDiggerinit(0), new GoldDiggerinit(1), new GoldDiggerinit(2), new GoldDiggerinit(3)};

        double[] leaderProbability = {0.75, 0.25};
        double[] followerProbability = {0.25, 0.25, 0.25, 0.25};



        int wins = 0;
        /*
        for(int i = 0; i < 100; i++) {
            Game g = new Game(new BombsAndGold(2, 2, 0));
            if(g.play(new MixedLeader(leaders, leaderProbability), new SimpleFollower(), new EmptyLeader(), new MixedFollower(followers, followerProbability))){
                wins++;
            }
        }
        System.out.println("Wins " + wins);
        */
        Game g = new Game(new BombsAndGold(2, 2, 0));
        System.out.println(g.expectedValue(new MixedLeader(leaders, leaderProbability), new MixedLeader(new EmptyLeader()), new MixedFollower(new SimpleFollower()), new MixedFollower(followers, followerProbability),new Shuffle(4)));



        EmpiricalHistory e = new EmpiricalHistory();
        PlayThrough p = new PlayThrough();

        wins = 0;

        System.out.println("TEST");


        int runs = 1440;
        for (int i = 0; i < runs; i++){
            //System.out.println(i);

            if(g.play(new BestResponseLeaderInit(true, g, 4, p),  new SimpleFollower(), new EmptyLeader(), new BehavioralFollower(followers, followerProbability)) ){
                e.addWin(g);
                wins++;
                //System.out.println("WIN");
            } else {
                e.addLose(g);
                //System.out.println("LOSE");
            }
            if(i % 12 == 0){
                System.out.println(wins);
                wins = 0;
            }
        }



    }


}