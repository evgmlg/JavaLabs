package giezz;

import giezz.model.Item;
import jakarta.persistence.LockModeType;
import jakarta.persistence.OptimisticLockException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static giezz.HibernateUtil.sessionFactory;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        optimisticWrite();
        long endOptimisticWrite = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        pessimisticWrite();
        long endPessimisticWrite = System.currentTimeMillis() - startTime;
        System.out.println("Время выполнения оптимистической блокировки: " + endOptimisticWrite);
        System.out.println("Время выполнения песимистической блокировки: " + endPessimisticWrite);


        sessionFactory.close();
    }

    public static void pessimisticWrite() throws InterruptedException {
        int threadAmount = 8;
        Thread[] threads = new Thread[threadAmount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                boolean isUpdated;
                Session session = sessionFactory.openSession();
                for (int j = 0; j < 20000; j++) {
                    isUpdated = false;
                    while (!isUpdated) {
                        try {
                            session.beginTransaction();
                            Item item = session
                                    .createQuery("from Item where id = :id ", Item.class)
                                    .setParameter("id", (long) (Math.random() * 40 + 1))
                                    .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                                    .getSingleResult();
                            item.setVal(item.getVal() + 1);
                            session.persist(item);
                            session.getTransaction().commit();
                            System.out.println(Thread.currentThread().getName() + " commited");
                            isUpdated = true;
                        } catch (HibernateException | OptimisticLockException e) {
                            session.getTransaction().rollback();
                            System.out.println(Thread.currentThread().getName() + " rollback");
                            System.err.println("in " + Thread.currentThread().getName() + " " + e.getMessage());
                        }
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                session.close();
            }, "Thread " + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void optimisticWrite() throws InterruptedException {
        int threadAmount = 8;
        Thread[] threads = new Thread[threadAmount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                boolean isUpdated;
                Session session = sessionFactory.openSession();
                for (int j = 0; j < 20000; j++) {
                    isUpdated = false;
                    while (!isUpdated) {
                        try {
                            session.beginTransaction();
                            Item item = session
                                    .get(Item.class, (long) (Math.random() * 40 + 1));
                            item.setVal(item.getVal() + 1);
                            session.persist(item);
                            session.getTransaction().commit();
                            System.out.println(Thread.currentThread().getName() + " commited");
                            isUpdated = true;
                        } catch (HibernateException | OptimisticLockException e) {
                            session.getTransaction().rollback();
                            System.out.println(Thread.currentThread().getName() + " rollback");
                            System.err.println("in " + Thread.currentThread().getName() + " " + e.getMessage());
                        }
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                session.close();
            }, "Thread " + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

}