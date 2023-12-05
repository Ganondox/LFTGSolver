public abstract class FollowerState {

    boolean isPure = true;

    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    abstract int getAction();
    abstract FollowerState next(int observation);

    abstract FollowerState copy();


    //shallow copy
    abstract FollowerState copy(Game g);


}
