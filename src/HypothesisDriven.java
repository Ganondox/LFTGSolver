public class HypothesisDriven extends FollowerState{


    BombsAndGold.stuff[] hypothesis;
    int[] state;

    MirrorFollowerStrategy.state cur;

    public HypothesisDriven(BombsAndGold.stuff[] hypothesis, int[] state, MirrorFollowerStrategy.state cur) {
        this.hypothesis = hypothesis;
        this.state = state;
        this.cur = cur;
    }

    @Override
    int getAction() {

        //dig gold if possible
        for(int i = 0; i < hypothesis.length; i++){
            if(hypothesis[i] == BombsAndGold.stuff.gold && state[i] == 1){

                return i;

            }
        }

        //otherwise avoid bombs and 1-gold
        for(int i = 0; i < hypothesis.length; i++){
            if(hypothesis[i] == BombsAndGold.stuff.bomb && state[i] == 0){

                return i;

            }
        }

        return 0;
    }

    @Override
    FollowerState next(int observation) {

        MirrorFollowerStrategy.state nextround = null;
        switch (cur) {
            case mysignal:
                nextround = MirrorFollowerStrategy.state.myaction;
                break;
            case myaction:
                nextround = MirrorFollowerStrategy.state.myfeedback;
                break;
            case myfeedback:
                nextround = MirrorFollowerStrategy.state.othersignal;
                break;
            case othersignal:
                nextround = MirrorFollowerStrategy.state.otheraction;
                break;
            case otheraction:
                nextround = MirrorFollowerStrategy.state.otherfeedback;
                break;
            case otherfeedback:
                nextround = MirrorFollowerStrategy.state.mysignal;
                break;
        }
        //update state
        int[] newstate = state.clone();
        if(cur.equals(MirrorFollowerStrategy.state.myaction) || cur.equals(MirrorFollowerStrategy.state.otheraction)  ) newstate[observation]++;
        return new HypothesisDriven(hypothesis,newstate, nextround);
    }

    @Override
    FollowerState copy() {
        return new HypothesisDriven(hypothesis, state.clone(), cur);
    }

    @Override
    FollowerState copy(Game g) {
        return new HypothesisDriven(hypothesis, state.clone(), cur);
    }
}
