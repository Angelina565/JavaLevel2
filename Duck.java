package lesson1;

public class Duck extends Animal implements Swim {

    int canSwimDistance;

    public Duck(String name, int canRunDistance, int canSwimDistance) {
        super(name, canRunDistance);
        this.canSwimDistance = canSwimDistance;
    }

    @Override
    public void swim(int distance) {
        if (canSwimDistance < distance) {
            setOnDistance(false);
        }
    }
}
