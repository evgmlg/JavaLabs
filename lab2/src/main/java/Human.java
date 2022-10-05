public class Human extends Competitors implements SuperJump {
    private String name;
    private int runDist;
    private int jumpHeight;
    private int SuperJumpEx = 2;

    public Human(String name, int distance, int jumpHeight) {
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

    public void run(int distance) {System.out.println("Человек " + this.name + " пробежал " + distance + " м");}

    public void jump(int height) {System.out.println("Человек " + this.name + " прыгнул на " + height + " м");}

    public int getRunDist() {
        return this.runDist;
    }

    public int getJumpHeight() {
        return this.jumpHeight;
    }

    public boolean super_jump() {
        if (SuperJumpEx > 0) {
            SuperJumpEx--;
            return true;
        } else {
            return false;
        }
    }
}