package stack.old;

public class StaticStack {
    private static int[] array;
    private static int top;
    private static int capacity;

    StaticStack(int size) {
        array = new int[size];
        capacity = size;
        top = -1;
    }

    public static void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        System.out.println("Inserting " + item);
        array[++top] = item;
    }

    public static int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    public static boolean isEmpty() {
        return top == - 1;
    }

    public static boolean isFull() {
        return top == capacity - 1;
    }

}