package lab1;

public class Homecat extends HomePets{

    public static short homecatcount = 0;

    public Homecat(String name){
        super(250, 0, name,"Хозяин2");
        homecatcount++;
    }
}
