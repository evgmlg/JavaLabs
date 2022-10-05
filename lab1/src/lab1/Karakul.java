package lab1;

public class Karakul extends Animal {

    public static short karakulcount = 0;

    public Karakul(String name) {
        super(350, 75, name);
        karakulcount++;
    }
}
