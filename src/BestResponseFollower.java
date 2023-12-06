import java.util.LinkedList;
import java.util.List;

public class BestResponseFollower extends FollowerState{


    EvalState evalState;

    boolean isteam1;
    int maxAction;


    public BestResponseFollower(boolean isteam1, Game game, int maxAction, EvalState evalState) {
        this.isteam1 = isteam1;
        this.game = game;
        this.maxAction = maxAction;
        this.evalState = evalState;
    }


    @Override
    int getAction() {

        int best = 0;
        double value = 0;
        for(int i = 0; i < maxAction; i++){

            List<Integer> obs = new LinkedList<>();

            for(Integer n: game.observationList){
                obs.add(n);
            }

            obs.add(i);

            double v = evalState.value(game.current, obs, game.f1Strategy.next(i), game.f2Strategy.next(i), game.l1Strategy.next(i), game.l2Strategy.next(i));

            if(!isteam1) v = 1 - v;

            if( v > value) {
                best = i;
                value = v;
            }
            //FollowerState f;
            //if(isteam1) f = game.f1Strategy; else f = game.f2Strategy;
            //f = f.next(i);
            //int action = f.getAction();
            // try {
            //GameState next = ((GameState)game.current.clone()).next(action);



            // evalState.value(next, game.observationList, game.f1Strategy.next(i).next(action), game.f2Strategy, )


            // } catch (Exception e){

            //   System.out.println("Clone is broke ");
            // }



        }

        return best;
    }

    @Override
    FollowerState next(int observation) {

        return new BestResponseFollower(isteam1, game, maxAction, evalState);
    }


    //todo: make like leader version
    @Override
    FollowerState copy() {
        return new BestResponseFollower(isteam1, game.copy(), maxAction, evalState);
    }

    @Override
    FollowerState copy(Game g) {
        return null;
    }
}
