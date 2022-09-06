package search;

import java.util.Random;

public class binary {

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

        public static boolean binary_search(int[] array, int key) {
            int first = 0;
            int last = array.length-1;
            while (first <= last) {
                // jump to the middle
                int index = (first + last)/2;
                if (array[index] == key) {
                    // hmm what now?
                    return true;}
                else if(array[index] < key)
                    first = index + 1;
                else
                    last = index - 1;
            }

            return false;
        }

    public static void main(String[] args) {

        int benchmark = 100000000;
        int key = 4;
        int size = 1024;
        int benchnum = 1;
        for (int bench = 0; bench < 19; bench++) {
            int[] test = sorted(size);
            long t0 = System.nanoTime();
            for (int rounds = 0; rounds < benchmark; rounds++) {
                binary_search(test, key);
                key *= 2;
            }
            long t1 = System.nanoTime() - t0;
            System.out.println("|__" + benchnum + "__|__" + size +  "__|__" + t1 / 100000000 +  "__|");
            benchnum++;
            size *= 2;
        }
    }
}
