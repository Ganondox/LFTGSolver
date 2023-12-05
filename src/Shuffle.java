public class Shuffle extends IterableNature{


    int items;

    public Shuffle(int items) {
        this.items = items;
    }

    @Override
    double getProb(int seed) {
        return 1.0/(getTotal());
    }

    @Override
    int getTotal() {
        return factorial(items);
    }

    @Override
    int getWorld() {
        return (int) (Math.random() * getTotal());
    }

    int factorial(int n){
        int total = 1;
        for(int i = 1; i <= n; i++){
            total *= i;
        }
        return total;
    }
}
