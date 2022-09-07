package search;
import java.util.Random;
public class duplicates {

    public static void main(String[] args) {
        int num = 20;
        int rounds = 2000;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Size: " + num + " | " + "Time: " + function(num, num, rounds));
            num *= 2;
        }
    }
    private static double function (int n, int m, int k) {
        int sum = 0;
        long t_total = 0;
        Random rnd = new Random();
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < m; i++) {
                keys[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                array[i] = rnd.nextInt(10*n);
            }
            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++) {
                for (int i = 0; i < m; i++)
                    if(array[i] == keys[i]) {
                        sum++;
                        break;
                    }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((double)(t_total)/(double)n);
    }
}