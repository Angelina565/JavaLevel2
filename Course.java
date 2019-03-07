package lesson1;

public class Course {
    private Obstacle [] obstacles;
    private Animal [] animals;

    public Course(Obstacle[] obstacles, Animal[] animals) {
        this.obstacles = obstacles;
        this.animals = animals;
    }


    public void doIt (Team team) {
        for (Obstacle obst:
             obstacles) {
            for (Animal an:
                 animals) {
                obst.doIt(an);
            }

        }
    }
}
