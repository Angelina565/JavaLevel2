package lesson1;

public class Water extends Obstacle{
    @Override
    public void doIt(Animal a) {
        if (a instanceof Swim) {
            ((Swim) a).swim(size);
        }
    }

    public Water(int size) {
        super(size);
    }
}
