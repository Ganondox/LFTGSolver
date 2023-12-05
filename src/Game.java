import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {

    GameHead root;
    GameState current;

    LeaderState l1Strategy;
    LeaderState l2Strategy;
    FollowerState f1Strategy;
    FollowerState f2Strategy;

    List<Integer> observationList;

    List<GameState> history;

    public Game(GameHead root) {
        this.root = root;
    }

    //returns true if team 1 wins
    public boolean play( Leader l1, Follower f1, Leader l2, Follower f2){
        //mother nature initiates the game
        current = root.init();

        observationList = new LinkedList<>();
        history = new ArrayList<>();
        history.add(current);

        l1Strategy = l1.getStrategy(current);
         l2Strategy = l2.getStrategy(current);
         f1Strategy = f1.getStrategy();
         f2Strategy = f2.getStrategy();

         l1Strategy.setGame(this);
         l2Strategy.setGame(this);
         f1Strategy.setGame(this);
         f2Strategy.setGame(this);



        //games runs to completion
        while(!current.terminal){

            //first team acts

            //leader 1 signals, everyone observes it
           int signal = l1Strategy.getSignal();
           l1Strategy = l1Strategy.next(signal);
           l2Strategy = l2Strategy.next(signal);
           f1Strategy = f1Strategy.next(signal);
           f2Strategy = f2Strategy.next(signal);
           observationList.add(signal);
           //follower 1 acts, everyone observes it
           int action = f1Strategy.getAction();
           current = current.next(action);
            l1Strategy = l1Strategy.next(action);
            l2Strategy = l2Strategy.next(action);
            f1Strategy = f1Strategy.next(action);
            f2Strategy = f2Strategy.next(action);
            observationList.add(action);
            history.add(current);
            //feedback observed from follower 1's action
            int feedback = current.getFeedback();
            l1Strategy = l1Strategy.next(feedback);
            l2Strategy = l2Strategy.next(feedback);
            f1Strategy = f1Strategy.next(feedback);
            f2Strategy = f2Strategy.next(feedback);
            observationList.add(feedback);

            //second teams acts
            if(!current.terminal){
                //leader 2 signals, everyone observes it
                 signal = l2Strategy.getSignal();
                l1Strategy = l1Strategy.next(signal);
                l2Strategy = l2Strategy.next(signal);
                f1Strategy = f1Strategy.next(signal);
                f2Strategy = f2Strategy.next(signal);
                observationList.add(signal);
                //follower 2 acts, everyone observes it
                action = f2Strategy.getAction();
                current = current.next(action);
                l1Strategy = l1Strategy.next(action);
                l2Strategy = l2Strategy.next(action);
                f1Strategy = f1Strategy.next(action);
                f2Strategy = f2Strategy.next(action);
                observationList.add(action);
                history.add(current);
                //feedback observed from follower 1's action
                feedback = current.getFeedback();
                l1Strategy = l1Strategy.next(feedback);
                l2Strategy = l2Strategy.next(feedback);
                f1Strategy = f1Strategy.next(feedback);
                f2Strategy = f2Strategy.next(feedback);
                observationList.add(feedback);
            }
        }

        //game resolves
        return current.won;


    }

    public boolean play( Leader l1, Follower f1, Leader l2, Follower f2, Nature n){
        //mother nature initiates the game
        current = root.init(n);
        LeaderState l1Strategy = l1.getStrategy(current);
        LeaderState l2Strategy = l2.getStrategy(current);
        FollowerState f1Strategy = f1.getStrategy();
        FollowerState f2Strategy = f2.getStrategy();

        //games runs to completion
        while(!current.terminal){

            //first team acts

            //leader 1 signals, everyone observes it
            int signal = l1Strategy.getSignal();
            l1Strategy = l1Strategy.next(signal);
            l2Strategy = l2Strategy.next(signal);
            f1Strategy = f1Strategy.next(signal);
            f2Strategy = f2Strategy.next(signal);
            //follower 1 acts, everyone observes it
            int action = f1Strategy.getAction();
            current = current.next(action);
            l1Strategy = l1Strategy.next(action);
            l2Strategy = l2Strategy.next(action);
            f1Strategy = f1Strategy.next(action);
            f2Strategy = f2Strategy.next(action);
            //feedback observed from follower 1's action
            int feedback = current.getFeedback();
            l1Strategy = l1Strategy.next(feedback);
            l2Strategy = l2Strategy.next(feedback);
            f1Strategy = f1Strategy.next(feedback);
            f2Strategy = f2Strategy.next(feedback);

            //second teams acts
            if(!current.terminal){
                //leader 2 signals, everyone observes it
                signal = l2Strategy.getSignal();
                l1Strategy = l1Strategy.next(signal);
                l2Strategy = l2Strategy.next(signal);
                f1Strategy = f1Strategy.next(signal);
                f2Strategy = f2Strategy.next(signal);
                //follower 2 acts, everyone observes it
                action = f2Strategy.getAction();
                current = current.next(action);
                l1Strategy = l1Strategy.next(action);
                l2Strategy = l2Strategy.next(action);
                f1Strategy = f1Strategy.next(action);
                f2Strategy = f2Strategy.next(action);
                //feedback observed from follower 1's action
                feedback = current.getFeedback();
                l1Strategy = l1Strategy.next(feedback);
                l2Strategy = l2Strategy.next(feedback);
                f1Strategy = f1Strategy.next(feedback);
                f2Strategy = f2Strategy.next(feedback);
            }
        }

        //game resolves
        return current.won;


    }

    public boolean play( Leader l1, Follower f1, Leader l2, Follower f2, int n){
        //mother nature initiates the game
        current = root.init(n);
        LeaderState l1Strategy = l1.getStrategy(current);
        LeaderState l2Strategy = l2.getStrategy(current);
        FollowerState f1Strategy = f1.getStrategy();
        FollowerState f2Strategy = f2.getStrategy();

        //games runs to completion
        while(!current.terminal){

            //first team acts

            //leader 1 signals, everyone observes it
            int signal = l1Strategy.getSignal();
            l1Strategy = l1Strategy.next(signal);
            l2Strategy = l2Strategy.next(signal);
            f1Strategy = f1Strategy.next(signal);
            f2Strategy = f2Strategy.next(signal);
            //follower 1 acts, everyone observes it
            int action = f1Strategy.getAction();
            current = current.next(action);
            l1Strategy = l1Strategy.next(action);
            l2Strategy = l2Strategy.next(action);
            f1Strategy = f1Strategy.next(action);
            f2Strategy = f2Strategy.next(action);
            //feedback observed from follower 1's action
            int feedback = current.getFeedback();
            l1Strategy = l1Strategy.next(feedback);
            l2Strategy = l2Strategy.next(feedback);
            f1Strategy = f1Strategy.next(feedback);
            f2Strategy = f2Strategy.next(feedback);

            //second teams acts
            if(!current.terminal){
                //leader 2 signals, everyone observes it
                signal = l2Strategy.getSignal();
                l1Strategy = l1Strategy.next(signal);
                l2Strategy = l2Strategy.next(signal);
                f1Strategy = f1Strategy.next(signal);
                f2Strategy = f2Strategy.next(signal);
                //follower 2 acts, everyone observes it
                action = f2Strategy.getAction();
                current = current.next(action);
                l1Strategy = l1Strategy.next(action);
                l2Strategy = l2Strategy.next(action);
                f1Strategy = f1Strategy.next(action);
                f2Strategy = f2Strategy.next(action);
                //feedback observed from follower 1's action
                feedback = current.getFeedback();
                l1Strategy = l1Strategy.next(feedback);
                l2Strategy = l2Strategy.next(feedback);
                f1Strategy = f1Strategy.next(feedback);
                f2Strategy = f2Strategy.next(feedback);
            }
        }

        //game resolves
        return current.won;


    }

    double expectedValue( Leader l1, Follower f1, Leader l2, Follower f2, IterableNature n){
        double value = 0;
        //for each possible world
        for(int i = 0; i < n.getTotal(); i++){
            if(play(l1, f1, l2, f2, i)){
                value += n.getProb(i); //add probability of that world
            }
        }
       return value;
    }

    //need to handle mother nature
    //gives probability that the first team will win
    double expectedValue(MixedLeader l1, MixedLeader l2, MixedFollower f1, MixedFollower f2, IterableNature n) {
        double val = 0;
        for (int i = 0; i < l1.possibleStarts.length; i++) {
            for (int j = 0; j < l2.possibleStarts.length; j++) {
                for (int k = 0; k < f1.possibleStarts.length; k++) {
                    for (int l = 0; l < f2.possibleStarts.length; l++) {
                            val += l1.probabilityofStart[i] * l2.probabilityofStart[j] * f1.probabilityofStart[k] * f2.probabilityofStart[l] * expectedValue(l1.possibleStarts[i], f1.possibleStarts[k], l2.possibleStarts[j], f2.possibleStarts[l], n);
                    }
                }
            }
        }
        return val;
    }

    public Game(GameHead root, GameState current, LeaderState l1Strategy, LeaderState l2Strategy, FollowerState f1Strategy, FollowerState f2Strategy, List<Integer> observationList, List<GameState> history) {
        this.root = root;
        this.current = current;
        this.l1Strategy = l1Strategy;
        this.l2Strategy = l2Strategy;
        this.f1Strategy = f1Strategy;
        this.f2Strategy = f2Strategy;
        this.observationList = observationList;
        this.history = history;
    }

    Game copy(){

        List<Integer> oclone = new LinkedList<>();

        if(observationList != null) {
            for (Integer obs : observationList) {
                oclone.add(obs);
            }
        }

        List<GameState> hclone = new LinkedList<>();

        if(history != null) {
            for (GameState gs : history) {
                hclone.add(gs.copy());
            }
        }

        LeaderState l1;
        LeaderState l2;
        FollowerState f1;
        FollowerState f2;
        if(l1Strategy != null)  l1 = l1Strategy.copy(this); else l1 = null;
        if(l2Strategy != null)  l2 = l2Strategy.copy(this); else l2 = null;
        if(f1Strategy != null)  f1 = f1Strategy.copy(this); else f1 = null;
        if(f2Strategy != null)  f2 = f2Strategy.copy(this); else f2 = null;
        GameState state;
        if(current != null) state = current.copy(); else  state = null;
        Game game =  new Game(root, state, l1, l2, f1, f2, oclone, hclone);
        if(l1 != null) l1.setGame(game);
        if(l2 != null) l2.setGame(game);
        if(f1 != null) f1.setGame(game);
        if(f2 != null) f2.setGame(game);



        return  game;

    }

}
