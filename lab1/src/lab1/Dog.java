package lab1;

public class Dog extends HomePets {

    public static short dogcount = 0;

    public Dog(String name) {
        super(300, 50, name,"Хозяин1");
        dogcount++;
    }
}
