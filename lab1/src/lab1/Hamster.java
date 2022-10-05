package lab1;

public class Hamster extends Animal {

    public static short hamstercount = 0;

    public Hamster(String name) {
        super(25, 0, name);
        hamstercount++;
    }
}
