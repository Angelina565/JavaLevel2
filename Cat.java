package lesson1;

public class Cat extends Animal implements Jump{
    private String color;
    int canJumpHeight;


    public Cat(String name, int canRunDistance, String color, int canJumpHeight) {
        super(name, canRunDistance);
        this.color = color;
        this.canJumpHeight = canJumpHeight;
    }

    @Override
    public void jump(int height) {
        if(this.canJumpHeight<height) {
            setOnDistance(false);
        }
    }
}
