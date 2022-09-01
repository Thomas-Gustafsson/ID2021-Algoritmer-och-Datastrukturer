package introduktion;
import java.util.Random;
public class search {

    public static void main(String[] args) {
        System.out.println(function(100, 1000, 2000));
    }
    private static double function (int n, int m, int k) {
        int sum = 0;
        long t_total = 0;
        Random rnd = new Random();
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < m; i++) {
                keys[i] = rnd.nextInt(10*n);
            }
            for (int i = 0; i < n; i++) {
                array[i] = rnd.nextInt(10*n);
            }
            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++)
                    if(array[i] == key) {
                        sum++;
                        break;
                    }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((double)(t_total)/(double) n);
    }
}
