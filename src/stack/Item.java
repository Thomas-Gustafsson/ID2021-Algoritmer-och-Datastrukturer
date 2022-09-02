
class Item {
	private ItemType type;
	private int value = 0;
	
	public Item(int value) {
        this.value = value;
        this.type = ItemType.VALUE; 
    }

    public Item(ItemType itemType) {
        this.value = 0;
        this.type = itemType; 
    }

	public enum ItemType {
		ADD,
		SUB,
		MUL,
		DIV,
		VALUE
	}
	
	public int getValue() {
		return this.value;
	}
	
	public ItemType getType() {
		return this.type;
	}
	
}
