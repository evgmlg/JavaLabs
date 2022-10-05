import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 60_000000;
    private static final int H = SIZE / 2;
    private static final int Q = SIZE / 4;
    private static final int F = SIZE / 5;
    private static final int S = SIZE / 6;


    public static void main(String[] args) {
        float[] arr1 = new float[SIZE];
        float[] arr2 = new float[SIZE];
        float[] arr3 = new float[SIZE];
        float[] arr4 = new float[SIZE];
        float[] arr5 = new float[SIZE];

        Arrays.fill(arr1, 1);
        Arrays.fill(arr2, 1);
        Arrays.fill(arr3, 1);
        Arrays.fill(arr4, 1);
        Arrays.fill(arr5, 1);

        Scanner s = new Scanner(System.in);
        System.out.print("Введите количество потоков цифрой(1, 2, 4, 5, 6)\n" +
                "Если хотите сравнить все потоки то введите цифру 0: ");
        int num = s.nextInt();
        switch (num){
            case 0:
                oneArray(arr1);
                twoArray(arr2);
                fourArray(arr3);
                fiveArray(arr4);
                sixArray(arr5);
                break;
            case 1: oneArray(arr1);
                break;
            case 2: twoArray(arr2);
                break;
            case 4: fourArray(arr3);
                break;
            case 5: fiveArray(arr4);
                break;
            case 6: sixArray(arr5);
                break;
        }
//        oneArray(arr1);
//        twoArray(arr2);
//        fourArray(arr3);
//        fiveArray(arr4);
//        sixArray(arr5);
    }

    private static void oneArray(float[] arr) {

        long a = System.currentTimeMillis();

        operateArray(arr, 0);

        System.out.println("Время выполнения метода в один поток: " + (System.currentTimeMillis() - a) + " мс.");
        System.out.println(arr[SIZE-1]);

    }

    private static void twoArray(float[] arr) {

        float[] a1 = new float[H];
        float[] a2 = new float[H];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0 , a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        Thread thread1 = new Thread(() -> {
            operateArray(a1, 0);
        });

        Thread thread2 = new Thread(() -> {
            operateArray(a2, H);
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, a1.length, a2.length);

        System.out.println("Время выполнения метода в 2 потока: " + (System.currentTimeMillis() - a) + " мс.");
        System.out.println(arr[SIZE-1]);

    }

    private static void fourArray(float[] arr) {

        float[] b1 = new float[Q];
        float[] b2 = new float[Q];
        float[] b3 = new float[Q];
        float[] b4 = new float[Q];

        long b = System.currentTimeMillis();

        System.arraycopy(arr, 0, b1, 0, Q);
        System.arraycopy(arr, Q, b2, 0, Q);
        System.arraycopy(arr, H, b3, 0, Q);
        System.arraycopy(arr, SIZE-Q, b4, 0, Q);

        Thread thread1 = new Thread(() -> {
            operateArray(b1, 0);
        });

        Thread thread2 = new Thread(() -> {
            operateArray(b2, Q);
        });

        Thread thread3 = new Thread(() -> {
            operateArray(b3, H);
        });

        Thread thread4 = new Thread(() -> {
            operateArray(b4, SIZE-Q);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(b1, 0, arr, 0, Q);
        System.arraycopy(b2, 0, arr, Q, Q);
        System.arraycopy(b3, 0, arr, H, Q);
        System.arraycopy(b4, 0, arr, SIZE-Q, Q);

        System.out.println("Время выполнения метода в 4 потока: " + (System.currentTimeMillis() - b) + " мс.");
        System.out.println(arr[SIZE-1]);

    }

    private static void fiveArray(float[] arr) {

        float[] c1 = new float[F];
        float[] c2 = new float[F];
        float[] c3 = new float[F];
        float[] c4 = new float[F];
        float[] c5 = new float[F];

        long c = System.currentTimeMillis();

        System.arraycopy(arr, 0, c1, 0, F);
        System.arraycopy(arr, F, c2, 0, F);
        System.arraycopy(arr, 2*F, c3, 0, F);
        System.arraycopy(arr, 3*F, c4, 0, F);
        System.arraycopy(arr, SIZE-F, c5, 0, F);

        Thread thread1 = new Thread(() -> {
            operateArray(c1, 0);
        });

        Thread thread2 = new Thread(() -> {
            operateArray(c2, F);
        });

        Thread thread3 = new Thread(() -> {
            operateArray(c3, 2*F);
        });

        Thread thread4 = new Thread(() -> {
            operateArray(c4, 3*F);
        });

        Thread thread5 = new Thread(() -> {
            operateArray(c5, SIZE-F);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(c1, 0, arr, 0, F);
        System.arraycopy(c2, 0, arr, F, F);
        System.arraycopy(c3, 0, arr, 2*F, F);
        System.arraycopy(c4, 0, arr, 3*F, F);
        System.arraycopy(c5, 0, arr, SIZE-F, F);

        System.out.println("Время выполнения метода в 5 потоков: " + (System.currentTimeMillis() - c) + " мс.");
        System.out.println(arr[SIZE-1]);

    }
    private static void sixArray(float[] arr) {

        float[] d1 = new float[S];
        float[] d2 = new float[S];
        float[] d3 = new float[S];
        float[] d4 = new float[S];
        float[] d5 = new float[S];
        float[] d6 = new float[S];

        long d = System.currentTimeMillis();

        System.arraycopy(arr, 0, d1, 0, S);
        System.arraycopy(arr, S, d2, 0, S);
        System.arraycopy(arr, 2*S, d3, 0, S);
        System.arraycopy(arr, 3*S, d4, 0, S);
        System.arraycopy(arr, 4*S, d5, 0, S);
        System.arraycopy(arr, SIZE-S, d6, 0, S);

        Thread thread1 = new Thread(() -> {
            operateArray(d1, 0);
        });

        Thread thread2 = new Thread(() -> {
            operateArray(d2, S);
        });

        Thread thread3 = new Thread(() -> {
            operateArray(d3, 2*S);
        });

        Thread thread4 = new Thread(() -> {
            operateArray(d4, 3*S);
        });

        Thread thread5 = new Thread(() -> {
            operateArray(d5, 4*S);
        });
        Thread thread6 = new Thread(() -> {
            operateArray(d6, SIZE-S);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(d1, 0, arr, 0, S);
        System.arraycopy(d2, 0, arr, S, S);
        System.arraycopy(d3, 0, arr, 2*S, S);
        System.arraycopy(d4, 0, arr, 3*S, S);
        System.arraycopy(d5, 0, arr, 4*S, S);
        System.arraycopy(d6, 0, arr, SIZE-S, S);

        System.out.println("Время выполнения метода в 6 потоков: " + (System.currentTimeMillis() - d) + " мс.");
        System.out.println(arr[SIZE-1]);

    }

    private static void operateArray(float[] _arr, int i) {

        for (int j = 0; j < _arr.length; j++, i++) {
            _arr[j] = (float)(_arr[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

}
