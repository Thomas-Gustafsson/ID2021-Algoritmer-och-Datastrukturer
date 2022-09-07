package search;
import java.util.Random;
import java.util.Arrays;

public class duplicatebin {

    public static void duplicatebinary(int[] Arr1, int[] Arr2) {
        Arrays.sort(Arr1);
        Arrays.sort(Arr2);
        int benchmark = 1000000;

        long t0 = System.nanoTime();
        for (int i = 0; i < benchmark; i++) {
            int index2 = 0, index1 = 0;
            while (index2 < Arr2.length && index1 < Arr1.length) {
                int left1 = 0, right1 = (Arr1.length) - 1; // 1) Reinitialize left1 and right1 in each iteration of iArr2.

                while (left1 <= right1) {
                    int mid1 = (left1 + right1) / 2;
                    if (Arr2[index2] == Arr1[mid1]) {
                        break; // 2) Break out of the binary search when you've found the common element.
                    } else if (Arr2[index2] > Arr1[mid1])
                        left1 = mid1 + 1;
                    else right1 = mid1 - 1;
                }

                index2++; // 3) Move to next item of iArr2.
            }
        }
        double t1 = System.nanoTime() - t0;
        System.out.println("Size: " + Arr1.length + " | " + "Time: " + t1/1000000);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int times = 10;
        int size = 20;

        for (int j = 0; j < times; j++) {
            int[] Arr1 = new int[size];
            int[] Arr2 = new int[size];
            for (int i = 0; i < Arr1.length; i++) {
                Arr1[i] = random.nextInt();
                Arr2[i] = random.nextInt();
            }
            duplicatebinary(Arr1, Arr2);
            size *= 2;
        }
    }

}