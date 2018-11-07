
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderSystem {
	static ArrayList<Item> cart;
	static ArrayList<Item> sentOrders;
	
	public OrderSystem() {
		cart = new ArrayList<Item>();
		sentOrders = new ArrayList<Item>();
		Warehouse warehouse = new Warehouse();
		Item jordan = new Item("Shoe", "Jordan", 40);
		cart.add(jordan); //There's always an item added before each test
	}
		
	public static void addOrder(Item item) {
			Boolean inStock = Warehouse.inStock(item);
			if (inStock) {
				cart.add(item);
				System.out.println("Your order has been added to cart!");
			}
			
			else {
				System.out.println("The item is unfortunately not in stock");
			}	
		}
	
	public static void removeFromCart(Item item) {
		System.out.println("Cancel");
		int index = cart.indexOf(item);
		cart.remove(index);
		System.out.println("Order has been canceled");
		Warehouse.returnToStock(item);
	}
	
	public static boolean inCart(Item item) {
		int index = cart.indexOf(item);
		if(index < 0) {
			return false;
		}
		
		return true;	
	}
	
	public static void emptyCart() {
		for (int i = 0; i < cart.size(); i++) {
			Warehouse.returnToStock(getOrder(i));
		}
		cart = new ArrayList<Item>();
	}
	
	
	public static Item getOrder(int index) {
		return cart.get(index);
	}
	
	
	
	public static void checkoutCart(String date) {
		Date deliveryDate = null;
		try {
			deliveryDate = formatDeliveryDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date currentDate = new Date();

		if (currentDate.before(deliveryDate)) {
			if(cart.size() > 0) {
				for (int i = 0; i < cart.size(); i++) {
					Warehouse.removeFromStock(getOrder(i));
					//add to sentOrder
				}
				cart = new ArrayList<Item>();
				System.out.println("Checkout completed!");
			}
			else {
				System.out.println("Your cart is empty, please add something before checking out.");
			}
		}
		
		else if(currentDate.after(deliveryDate)) {
			System.out.println("The delivery date is unfortunately not available, please choose a different date");
		}
	}
	
	public static Date formatDeliveryDate(String deliveryDate) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
	    Date t = null;
	    t = ft.parse(deliveryDate); 
	    System.out.println(t);

        return t;
	}
		

	public static void main(String[] args) {
		
		cart = new ArrayList<Item>();
		sentOrders = new ArrayList<Item>();
		Warehouse warehouse = new Warehouse();
		
		
		Item jordan = new Item("Shoe", "Jordan", 40);
		addOrder(jordan);
		
		checkoutCart("2018-12-12");
		
		
		/*System.out.println("Hi, what would you like to do?\n1: Place a new order \n2: Check your cart\n3: Checkout");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("What would you like to order?\n1: Shoes\n2: Jackets\n3: Pants");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("What type of shoe would you like?\n1: Sneakers\n2: Boots\n3: Slippers");
				choice = sc.nextInt();
				if (choice == 1) { 
					Shoe shoe = new Shoe("Sneaker");
					System.out.println("What shoe brand would you like?\n1: Adidas\n2: Nike\n3: Stan Smith's");
					choice = sc.nextInt();
					if (choice == 1) {
						shoe.setBrand("Adidas");
						shoe.setModel("low cut");
						System.out.println("What shoe size would you like?\n1: 41\n2: 42\n3: 43");
						
						if (choice == 1) {
							shoe.setSize(41);
							System.out.println(shoe.getBrand());
							System.out.println(shoe.getModel());
							System.out.println(shoe.getSize());
							
							addOrder(shoe);
							getOrder(0);
						}
					}
					
					
				}
			}
		}
		else if (choice == 2){
			
		}
		
		else if(choice == 3) {
			
		}
		
		else {
			System.out.println("Wrong selection, please try again");
		}
		
		sc.close();
		*/
	}	
	
	
}

