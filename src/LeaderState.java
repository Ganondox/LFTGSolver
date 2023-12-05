public abstract class LeaderState {


    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    boolean isPure = true;
    abstract int getSignal();
    abstract LeaderState next(int observation);

    abstract LeaderState copy();


    //shallow copy
    abstract LeaderState copy(Game g);
}
