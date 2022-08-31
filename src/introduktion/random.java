package introduktion;/*  Set up a benchmark where you call the access function with a larger and larger n.
    Present your conclusions in a nice table and pay attention
    to the number of significant figures that you use.
*/

import java.util.Random;

public class random {
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            System.out.println("resolution " + function(1000) + " nanoseconds");
        }
    }

    private static double function (int n) {
        int k = 1_000_000;
        int l = n;
        Random rnd = new Random();
        int[] indx = new int[l];
        for (int i = 0; i < l; i++) { // fill the indx array with random number from 0 to n (not including n)
            indx[i] = rnd.nextInt(n);
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {// fill the array with dummy values (why not 1)
            array[i] = 1;
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum += array[indx[i]];     // access the array with the index given by indx[i] // sum up the result
            }
        }
        long t_access = (System.nanoTime() - t0);
        t0 = System.nanoTime();
        // do the same loop iteration but only do a dummy add operation
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum += array[i];
            }
        }
        long t_dummy = (System.nanoTime() - t0);
        return ((double) (t_access - t_dummy)) / ((double) k * (double) l);
    }
}
