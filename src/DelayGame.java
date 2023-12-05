public class DelayGame extends GameState{


    GameState next;

    public DelayGame(GameState next) {
        this.next = next;
    }

    @Override
    GameState next(int action) {
        return next;
    }

    @Override
    int getFeedback() {
        return 0;
    }

    @Override
    GameState copy() {
        return new DelayGame(next);
    }
}
