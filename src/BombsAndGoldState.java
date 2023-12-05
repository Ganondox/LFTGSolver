import java.util.ArrayList;
import java.util.List;

public class BombsAndGoldState extends GameState{



    //0 blank
    //1 bomb
    //2 gold
    List<BombsAndGold.stuff> world;
    List<Integer> state;
    boolean turn;
    //boolean isover;
    //boolean won;

    public BombsAndGoldState(List<BombsAndGold.stuff> world, List<Integer> state, boolean turn, boolean isover, boolean won) {
        this.world = world;
        this.state = state;
        this.turn = turn;
        this.terminal = isover;
        this.won = won;
    }

    @Override
    GameState next(int action) {
        //System.out.println("Dug " + action);
        //illegal moves are instant loose
        if(state.get(action) == 2){
            //System.out.println("Illegal move!");
            return new BombsAndGoldState(world, state, turn, true, !turn);
        }

        //dig location
        List<Integer> next = new ArrayList<>(state);
       next.set(action, state.get(action) + 1);
       boolean over = false;
       boolean winner = false;
       if(next.get(action) == 2){
           //System.out.println("searching pit");
           //lose if dig bomb
           if(world.get(action).equals(BombsAndGold.stuff.bomb)){
               //System.out.println("Found bomb!");
               over = true;
               winner = !turn;
           }
           //win if dig gold
           if(world.get(action).equals(BombsAndGold.stuff.gold)){
               //System.out.println("Found gold!");
               over = true;
               winner = turn;
           }
       }

        return new BombsAndGoldState(world, next, !turn, over, winner);




    }

    //no feedback needed as information beyond action only revealed when game ends
    @Override
    int getFeedback() {
        return 0;
    }

    @Override
    GameState copy() {
        List<Integer> next = new ArrayList<>(state);
        return new BombsAndGoldState(world, next, turn, terminal, won);
    }
}
