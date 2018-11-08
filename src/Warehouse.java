
import java.util.ArrayList;
import java.util.Date;

public class Warehouse{
	String type;
	String model;
	Integer size;
	Date deliveryDate;
	
	static ArrayList<Item> stock;
	
	public static ArrayList<Item> getStock() {
		return stock;
	}
	
	public static void removeFromStock(Item item) {
		stock.remove(item);
	}
		
	public boolean inStock (Item item) {
		String type = Item.getType(item);
		String brand = Item.getBrand(item);
		Integer size = Item.getSize(item);
	
		for (int i = 0; i < stock.size(); i++) {
			if(Item.getType(stock.get(i)) == type) {
				if(Item.getBrand(stock.get(i)) == brand) {
					if(Item.getSize(stock.get(i)) == size) {	
						return true;
					}	
				}	
			}
		}
			return false;
	}
	
	public void returnToStock(Item item) {
		stock.add(item);
		System.out.println("returned to stock");
	}
	

	public Warehouse () {
		stock = new ArrayList<Item>();
		Item jordan41 = new Item("Shoe", "Jordan", 41);
		Item jordan42 = new Item("Shoe", "Jordan", 42);
		Item jordan43 = new Item("Shoe", "Jordan", 43);
		Item jordan44 = new Item("Shoe", "Jordan", 44);
		
		Item ultraBoost40 = new Item("Shoe", "Adidas", 40);
		Item ultraBoost41 = new Item("Shoe", "Adidas", 41);
		Item ultraBoost42 = new Item("Shoe", "Adidas", 42);
		Item ultraBoost43 = new Item("Shoe", "Adidas", 43);
		Item ultraBoost44 = new Item("Shoe", "Adidas", 44);
		
		Item peak38 = new Item("jacket", "Peak Performance", 38);
		Item peak39 = new Item("jacket", "Peak Performance", 39);
		Item peak40 = new Item("jacket", "Peak Performance", 40);
		Item peak41 = new Item("jacket", "Peak Performance", 41);
		
		Item riley35 = new Item("jacket", "Riley", 35);
		Item riley36 = new Item("jacket", "Riley", 36);
		Item riley37 = new Item("jacket", "Riley", 37);
		Item riley38 = new Item("jacket", "Riley", 38);
		
		Item nudie30 = new Item("jeans", "nudie", 30);
		Item nudie31 = new Item("jeans", "nudie", 31);
		Item nudie32 = new Item("jeans", "nudie", 32);
		Item nudie33 = new Item("jeans", "nudie", 33);
		
		Item jc30 = new Item("jeans", "jc", 30);
		Item jc31 = new Item("jeans", "jc", 31);
		Item jc32 = new Item("jeans", "jc", 32);
		Item jc33 = new Item("jeans", "jc", 33);
		
		stock.add(jordan41);
		stock.add(jordan42);
		stock.add(jordan43);
		stock.add(jordan44);
		
		stock.add(ultraBoost40);
		stock.add(ultraBoost41);
		stock.add(ultraBoost42);
		stock.add(ultraBoost43);
		stock.add(ultraBoost44);
		
		stock.add(peak38);
		stock.add(peak39);
		stock.add(peak40);
		stock.add(peak41);
		
		stock.add(riley35);
		stock.add(riley36);
		stock.add(riley37);
		stock.add(riley38);
		
		stock.add(nudie30);
		stock.add(nudie31);
		stock.add(nudie32);
		stock.add(nudie33);
		
		stock.add(jc30);
		stock.add(jc31);
		stock.add(jc32);
		stock.add(jc33);
		
	

	}



	
	
	

}
