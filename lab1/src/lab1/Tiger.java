package lab1;

public class Tiger extends Animal {

    public static short tigercount = 0;

    public Tiger(String name) {
        super(400, 100, name);
        tigercount++;
    }
}
