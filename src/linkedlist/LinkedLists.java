package linkedlist;
import java.util.LinkedList;

public class LinkedLists {
    int head;
    LinkedList tail;

    public void LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }
    public int head() {
        return this.head;
    }
    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this.tail();
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public static void main(String[] args) {
        LinkedList b = new LinkedList();
        b.add(3);
        b.add(15);
        b.add(129);
        append(b);
    }
}