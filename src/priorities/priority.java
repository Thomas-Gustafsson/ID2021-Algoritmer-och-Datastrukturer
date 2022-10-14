package priorities;
import java.util.Random;

// Java code to implement Priority Queue
// using Linked List


class priority
{

    // Node
    static class Node {
        int data;
        // Lower values indicate higher priority
        int priority;
        Node next;
    }

    static Node node = new Node();

    // Function to Create A New Node
    static Node newNode(int d, int p)
    {
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;

        return temp;
    }

    // Return the value at head
    static int peek(Node head)
    {
        return (head).data;
    }

    // Removes the element with the
// highest priority from the list
    static Node pop(Node head)
    {
        Node temp = head;
        (head) = (head).next;
        return head;
    }

    // Function to add according to prio
    static Node add(Node root, int number, int prio)
    {
        Node start = (root);
        Node temp = newNode(number, prio);

        if ((root).priority > prio) {
            temp.next = root;
            (root) = temp;
        }
        else {
            while (start.next != null && start.next.priority < prio)
                start = start.next;
            temp.next = start.next;
            start.next = temp;
        }
        return root;
    }

    // Function to check is list is empty
    static int isEmpty(Node head)
    {
        return ((head) == null)?1:0;
    }

    // Driver code
    public static void main(String args[])
    {
        Random random = new Random();
        int next = 0;
        // Create a Priority Queue
        Node pq = newNode(4, 4);

        int n = 1;
        for (int times = 0; times < 100; times++) {
            long t0 = System.nanoTime();
            for (int rounds = 0; rounds < 100; rounds++) {
                next = random.nextInt();
                pq = add(pq, next, next);
            }
            long t1 = System.nanoTime() - t0;
            long t2 = System.nanoTime();
            pq=pop(pq);
            long t3 = System.nanoTime() - t2;
            System.out.println(n + " "  + t1/100 + " " + t3);
            n += 100;
        }

        while (isEmpty(pq)==0) {
            //System.out.printf("%d ", peek(pq));
            pq=pop(pq);
        }
    }
}