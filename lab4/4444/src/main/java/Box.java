import java.util.*;

abstract class Box<T extends Fruit> {
    List<T> list = new ArrayList<>();
    String i;
    public String BoxName;


    Box()
    {}

    Box(T... fruits)
    {
        for(T fruit : fruits) list.add(fruit);
    }

    Box(List<T> list) {
        this.list = list;
    }

    private float getWeight()
    {
        float sum = 0;
        for (T f : list) sum += f.getWeight();
        return sum;
    }

    void add(T fruit)
    {
        list.add(fruit);
    }
    void info(){
        if (list.isEmpty()){
            System.out.println("Коробка пустая");
        }
        else {
            System.out.println("Коробка" );
            String text="";
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

        }
    }
//    void info() {
//        if (list.isEmpty()) {
//            System.out.println("Коробка пустая");
//        } else {
//            System.out.println(" В коробке " + BoxName + " лежат :");
//            for (T f : list) System.out.println(" " + f.getClass().getName()  + " весом " + f.getWeight());
//        }
//    }

    void ShowWeight() {
        if (list.isEmpty()) {
            System.out.println("Коробка " + BoxName + " пуста.");
        }
        else
        {
            System.out.println("Коробка " + BoxName + " весит " + getWeight());
        }
    }


    void compare(Box<T> box) {
        float difference = Math.abs(this.getWeight() - box.getWeight());
        if( this.getWeight() < box.getWeight())
        {
            System.out.println("Коробка " +  box.BoxName + " больше коробки " + BoxName + " на " + difference);
        }
        else if(difference == 0)
        {
            System.out.println("Коробка " +  box.BoxName + " и коробка " + BoxName + " равны");
        }
        else
        {
            System.out.println("Коробка " +  BoxName + " больше коробки " + box.BoxName + " на " + difference);
        }
    }

}
