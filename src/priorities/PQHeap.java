package priorities;

import java.util.Random;

public class PQHeap {

    @SuppressWarnings("rawtypes")
    private Comparable[] pQueue;
    private int index;

    public PQHeap(int capacity){
        pQueue = new Comparable[capacity];
    }

    public void insert(Comparable item ){
        if(index == pQueue.length){
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        //System.out.println("Adding element: "+item);
    }

    @SuppressWarnings("unchecked")
    public Comparable remove(){
        if(index == 0){
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority
        for (int i=1; i<index; i++) {
            if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        Comparable result = pQueue[maxIndex];
        //System.out.println("removing: "+result);
        // move the last item into the empty slot
        index--;
        pQueue[maxIndex] = pQueue[index];
        return result;
    }

    public static void main(String a[]){
        Random random = new Random();
        int next = 0;
        // Create a Priority Queue
        int n = 1;
        for (int times = 0; times < 100; times++) {
            PQHeap pqi = new PQHeap(1000);
            long t0 = System.nanoTime();
            for (int rounds = 0; rounds < 1000; rounds++) {
                next = random.nextInt();
                pqi.insert(next);            }
            long t1 = System.nanoTime() - t0;
            long t2 = System.nanoTime();
            pqi.remove();
            long t3 = System.nanoTime() - t2;
            System.out.println(n + " "  + t1/100 + " " + t3);
            n += 100;
        }

    }
}