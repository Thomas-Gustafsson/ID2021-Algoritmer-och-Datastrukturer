package stack;

public class StaticStack {
    // store elements of stack
    private static int[] array;
    // represent top of stack
    private static int top;
    // total capacity of the stack
    private static int capacity;

    // Creating a stack
    StaticStack(int size) {
        // initialize the array
        // initialize the stack variables
        array = new int[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of the stack
    public static void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        // insert element on top of stack
        System.out.println("Inserting " + item);
        array[++top] = item;
    }

    // insert element on top of stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // pop element from top of stack
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // check what value is on top
        return array[top];
    }

    public int getSize() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == - 1;
    }

    public static boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++)
            System.out.println(array[i] + ", ");
    }

}