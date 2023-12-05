public class BestResponseFollower extends FollowerState{


    int maxAction;

    @Override
    int getAction() {
        return 0;
    }

    @Override
    FollowerState next(int observation) {

        return null;
    }


    //todo: make like leader version
    @Override
    FollowerState copy() {
        return null;
    }

    @Override
    FollowerState copy(Game g) {
        return null;
    }
}
