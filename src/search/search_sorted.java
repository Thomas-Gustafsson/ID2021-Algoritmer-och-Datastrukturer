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

    public static void main(String[] args) {
        int benchmark = 1000000;
        long t0 = System.nanoTime();
        for (int rounds = 0; rounds < benchmark; rounds++) {
            sorted(8192);
        }
        long t1 = System.nanoTime() - t0;
        System.out.println(t1/1000000 + "ns");
    }
}

