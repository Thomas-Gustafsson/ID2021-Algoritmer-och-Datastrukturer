package stack.old;

public class Calculator {

    static Item[] expr;
    static int ip;
    StaticStack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new StaticStack(4);
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return StaticStack.pop();
    }

    public static void step() {
        Item nxt = expr[ip++];
        switch ((nxt.getType())) {
            case ADD : {
                int y = StaticStack.pop();
                int x = StaticStack.pop();
                StaticStack.push(x + y);
                break;
            }
            case SUB : {
                int y = StaticStack.pop();
                int x = StaticStack.pop();
                StaticStack.push(x - y);
                break;
            }
            case MUL : {
                int y = StaticStack.pop();
                int x = StaticStack.pop();
                StaticStack.push(x * y);
                break;
            }
            case DIV : {
                int y = StaticStack.pop();
                int x = StaticStack.pop();
                StaticStack.push(x / y);
                break;
            }
            case VALUE : {
                StaticStack.push(nxt.getValue());
                break;
            }
        }
    }
}