package stack.old;

// The Item class will have methods to construct different items, return the type and return the value.

public class Item {

    private ItemType type;
    private int value = 0;

    public enum ItemType { ADD, SUB, MUL, DIV, VALUE };

    public Item(stack.ItemType add, int i) {

        this.type = ItemType.VALUE;
    }

    public Item(int n) {

        this.type = ItemType.VALUE;
        this.value = n;
    }

    public ItemType getType() {

        return this.type;
    }

    public int getValue() {

        return this.value;
    }

}
