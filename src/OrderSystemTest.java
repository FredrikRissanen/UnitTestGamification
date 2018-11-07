


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





public class OrderSystemTest {
	OrderSystem os = new OrderSystem();
	

	
	@Before
	public void setUpBeforeEach() throws Exception {
		//System.out.println("Before");
	}

	@After
	public void tearDownBeforeEach() throws Exception {
		//System.out.println("After");
	}
	
	@Test
	public void addOrder() {
		Item shoe = new Item("Shoe");
		shoe.setBrand("Adidas");
		shoe.setSize(41);
		os.addOrder(shoe);
		//os.addOrder(shoe);
		
		String brand = Item.getBrand(shoe);
		assertEquals(brand, "Adidas");
	}
	
	
	@Test
	public void removeFromCart() {
		os.removeFromCart(os.getOrder(0));
	}
	
	@Test
	public void cancelAllOrders() {
		Item shoe = new Item("Shoe");
		shoe.setBrand("Adidas");
		shoe.setSize(41);
		os.addOrder(shoe);
		int size = os.cart.size();
		try{
			assertEquals(size, 0);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	@Test
	public void getOrder() {
		
	}
	
	@Test
	public void checkoutCart() {
		
	}
	
	@Test
	public void formatDeliveryDate() {
		
	}
	
	

}

