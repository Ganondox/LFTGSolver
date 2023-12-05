public abstract class  GameState {


    boolean terminal;
    boolean won;
    abstract GameState next(int action);
    abstract int getFeedback();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    abstract GameState copy();
}
