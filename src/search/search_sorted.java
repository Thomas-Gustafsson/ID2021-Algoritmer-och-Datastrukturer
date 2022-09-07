package search;
import java.util.Random;

public class search_sorted {

    private static int[] sorted(int n) {
        Random random = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += random.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 20;
        int key = 4;
        int benchmark = 100000000;
        for (int times = 0; times < 10; times++) {
            int[] array = sorted(size);
            long t0 = System.nanoTime();
            for (int rounds = 0; rounds < benchmark; rounds++) {
                search(array, key);
            }
            long t1 = System.nanoTime() - t0;
            System.out.println("Size: " + size + " | " + t1/benchmark + "ns");
            size *= 2;
            key *= 2;
        }
    }
}

