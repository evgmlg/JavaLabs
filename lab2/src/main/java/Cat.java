
public class Cat extends Competitors {
    private String name;
    private int runDist;
    private int jumpHeight;

    public Cat(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDist = distance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return this.name;
    }

    public boolean out_of_comp() {
        return true;
    }

    public void run(int distance) {
        System.out.println("Кот " + this.name + " пробежал " + distance + " м");
    }

    public void jump(int visota) {
        System.out.println("Кот " + this.name + " прыгнул на " + visota + " м");
    }

    public int getRunDist() {
        return this.runDist;
    }

    public int getJumpHeight() {
        return this.jumpHeight;
    }
}
