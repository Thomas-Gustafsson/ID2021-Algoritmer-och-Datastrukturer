
public class Main {

	final static int EXPRESSIONLENGTH = 100;

	public static void main(String[] args) {

		int itemCounter = 0;

		Item[] item = new Item[EXPRESSIONLENGTH];

		item[0] = new Item(6);
        item[1] = new Item(12);
        item[2] = new Item(Item.ItemType.ADD);
        item[3] = new Item(4);
        item[4] = new Item(4);
        item[5] = new Item(Item.ItemType.ADD);
        item[6] = new Item(Item.ItemType.SUB);

        for(int i=0; i<item.length; i++) {
        	if(item[i] != null) {
        		itemCounter++;
        	}
        }

        Item[] itemCopy = new Item[itemCounter];

        for(int i=0; i<itemCounter; i++) {
        	itemCopy[i] = item[i];
        }

        Calculator calc = new Calculator(itemCopy);
        System.out.println(calc.run());

	}

}
