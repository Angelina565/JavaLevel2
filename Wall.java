package lesson1;

public class Wall extends Obstacle {
    @Override
    public void doIt(Animal a) {
        if (a instanceof Jump) {
            ((Jump) a).jump(size);
        } else {
            a.setOnDistance(false);
        }
    }

    public Wall(int size) {
        super(size);
    }
}
