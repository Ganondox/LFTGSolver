import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BombsAndGold extends GameHead{

    enum stuff{bomb, gold, blank}

    int bombs; //note: if bomb % 2 = 1 then t1 can win every time
    int gold;
    int blank;

    public BombsAndGold(int bombs, int gold, int blank) {
        this.bombs = bombs;
        this.gold = gold;
        this.blank = blank;

    }

    GameState init(int seed){
        List<stuff> world = new LinkedList<>();
        for(int i = 0; i < bombs; i++){
            world.add(stuff.bomb);
        }
        for(int i = 0; i < gold; i++){
            world.add(stuff.gold);
        }
        for(int i = 0; i < blank; i++){
            world.add(stuff.blank);
        }
        for(int i = bombs + gold + blank; i > 1; i--){

            int index = seed % i;
            if(index > 0){
                Collections.swap(world,index - 1, i-1);
            }

            seed /= i;

        }

        String w = "";
        for(int i = 0; i < world.size(); i++){
            switch (world.get(i)){
                case bomb:
                    w += "b";
                    break;
                case gold:
                    w += "*";
                    break;
                case blank:
                    w += "-";
                    break;
            }
        }
        //System.out.println(w);

        //initialize state
        List<Integer> state = new LinkedList<>();
        for(int i = 0; i < bombs + gold + blank; i++){
            state.add(0);
        }


        return new BombsAndGoldState(world, state, true, false, false);
    }

    @Override
    GameState init() {


        //create random world with necessary stuff
        List<stuff> world = new LinkedList<>();
        for(int i = 0; i < bombs; i++){
            world.add(stuff.bomb);
        }
        for(int i = 0; i < gold; i++){
            world.add(stuff.gold);
        }
        for(int i = 0; i < blank; i++){
            world.add(stuff.blank);
        }
        Collections.shuffle(world);

        String w = "";
        for(int i = 0; i < world.size(); i++){
            switch (world.get(i)){
                case bomb:
                    w += "b";
                    break;
                case gold:
                    w += "*";
                    break;
                case blank:
                    w += "-";
                    break;
            }
        }
        //System.out.println(w);

        //initialize state
        List<Integer> state = new LinkedList<>();
        for(int i = 0; i < bombs + gold + blank; i++){
            state.add(0);
        }


        return new BombsAndGoldState(world, state, true, false, false);
    }
}
