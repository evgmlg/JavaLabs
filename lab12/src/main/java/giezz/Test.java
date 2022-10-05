package giezz;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.println((long) (Math.random() * 40 + 1));
        }
    }
}
