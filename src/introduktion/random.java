package introduktion;/*  Set up a benchmark where you call the access function with a larger and larger n.
    Present your conclusions in a nice table and pay attention
    to the number of significant figures that you use.
*/

import java.util.Random;

public class random {
    public static void main(String args[]) {
            System.out.println("resolution " + function(100) + " nanoseconds");
    }

    private static double function (int n) {
        int k = 1_000_000;
        Random rnd = new Random();
        int[] indx = new int[n];
        for (int i = 0; i < n; i++) indx[i] = rnd.nextInt(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = 1;
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++)
            for (int i = 0; i < n; i++)
                sum += array[indx[i]];
        long t_access = (System.nanoTime() - t0);
        t0 = System.nanoTime();
        for (int j = 0; j < k; j++)
            for (int i = 0; i < n; i++)
                sum += array[i];
        long t_dummy = (System.nanoTime() - t0);
        return ((double) (t_access - t_dummy)) / ((double) k * (double) n);
    }
}
