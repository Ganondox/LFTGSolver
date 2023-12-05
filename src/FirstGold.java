public class FirstGold extends Leader{

    @Override
    LeaderState getStrategy(GameState initialState) {

       BombsAndGoldState init = (BombsAndGoldState) initialState;
       for(int i = 0; i < init.world.size(); i++){
           if(init.world.get(i).equals(BombsAndGold.stuff.gold)) return new StaticLeaderStrategy(i);
       }

        return null;
    }
}
