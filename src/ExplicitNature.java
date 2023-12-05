public class ExplicitNature extends IterableNature{

    double[] nature; //probability nature selects any action

    @Override
    int getWorld() {
        double choice = Math.random();
        double search = 0;
        int decision = 0;
        while(search < choice){
            search += nature[decision];
            decision++;
        }
        return decision;
    }

    @Override
    double getProb(int seed) {
        return nature[seed];
    }

    @Override
    int getTotal() {
        return nature.length;
    }
}
