import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int Cars_Count = 8;
    public static final int HalfCarsCount = Cars_Count / 8;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ГОТОВИМСЯ!");
        CyclicBarrier cb = new CyclicBarrier(9);
        CountDownLatch cdl = new CountDownLatch(Cars_Count);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[Cars_Count];


        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car(race, 20 + (int)(Math.random() * 1), cb, cdl);
        }
        for (int i = 0; i < cars.length; i++){
            new Thread(cars[i]).start();
        }
        try{
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ГОНКА НАЧАЛАСЬ!!!");
            cb.await();
            cb.await();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ГОНКА ЗАКОНЧИЛАСЬ!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ПОБЕДИТЕЛИ!!!");

           Car.CheckWinner();


    }
}
