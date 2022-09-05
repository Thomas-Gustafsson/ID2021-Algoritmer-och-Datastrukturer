package search;
import java.util.Random;

public class search_unsorted {

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] OrigArray = new int[] {9, 7, 5, 3, 1, 2, 4 , 6, 8, 0};
        int key = 4;
        int newnum = 10;
        Random random = new Random();

        for (int array = 0; array < 10; array++) {
            search_unsorted(OrigArray, key);
            int[] newArray = new int[OrigArray.length * 2];
            System.arraycopy(OrigArray, 0, newArray, 0, OrigArray.length);
            OrigArray = newArray;
            long t0 = System.nanoTime();
            boolean test = search_unsorted(OrigArray,key);
            long t1 = System.nanoTime() - t0;
            System.out.println(OrigArray.length + " | " + key + " | " + test + " | " + t1);
            key *= 2;
            for (int fill = newnum; fill < (OrigArray.length - newnum); fill++) {
                OrigArray[random.nextInt(OrigArray.length - newnum)] += newnum;
                newnum++;
            }
        }
    }
}
