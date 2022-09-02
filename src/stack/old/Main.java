package stack.old;

import static stack.Calculator.*;

public class Main {

        Item[] expr = {
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.ADD,0)
        };
        Calculator cal = new Calculator(expr);
        System.out.println(cal.run());

    }
}
