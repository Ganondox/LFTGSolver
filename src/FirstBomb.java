public class FirstBomb extends Leader{

    @Override
    LeaderState getStrategy(GameState initialState) {

        //fix this as this is a broken strategy - not static strategy, need to make them mirror follower on second turn

        BombsAndGoldState init = (BombsAndGoldState) initialState;
        for(int i = 0; i < init.world.size(); i++){
            if(init.world.get(i).equals(BombsAndGold.stuff.bomb)) return new MirrorLeaderStrategy(MirrorFollowerStrategy.state.mysignal,i);
        }

        return null;
    }
}
