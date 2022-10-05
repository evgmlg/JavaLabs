import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int Cars_Count;
    private static   Car[] cars = new Car[3];
    private static AtomicInteger et = new AtomicInteger(0) ;
    private static AtomicInteger ar = new AtomicInteger(0) ;
    private static Lock win = new ReentrantLock();

    static {
        Cars_Count = 0;
    }

    public String getName() {
        return name;
    }

    private Race race;

    public int getSpeed() {
        return speed;
    }

    private int speed;

    public int getCount() {
        return count;
    }

    private String name;
    private int count;
    private CyclicBarrier cb;
    private CountDownLatch cdl;

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        Cars_Count++;
        this.name = "Участник: " + Cars_Count;
        this.cb = cb;
        this.cdl = cdl;
      
    }

    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();


            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (ar.get() < 3){



                cars[ar.get()] = this  ;
                ar.getAndIncrement();
            }
            
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void CheckWinner() {
        for(int i = 0; i < 3;i++){
            System.out.println( cars[i].name + " Победил с местом "+ (i +1) );

        }
    }
}













