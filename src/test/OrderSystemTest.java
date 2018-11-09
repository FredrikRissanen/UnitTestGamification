package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import build.Item;
import build.OrderSystem;
import build.Warehouse;

public class OrderSystemTest {
	OrderSystem os = new OrderSystem();

	
	@Before
	public void setUpBeforeEach() throws Exception {
		//System.out.println("Before");
		Item jordan = new Item("Shoe", "Jordan", 40);
		os.getCart().add(jordan); //There's always an item added before each test
	}

	@After
	public void tearDownBeforeEach() throws Exception {
		//System.out.println("After");
	}
	
	@Test
	public void addOrder() {
		Item jordan = new Item("Shoe", "Jordan", 41); 
		os.addItemToCart(jordan);
		
		Boolean inCart = os.inCart(jordan);

		try{
			assertEquals(inCart, true);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	
	@Test
	public void removeFromCart() {
		os.setCart(new ArrayList<Item>()); //Clears cart
		Item jordan = new Item("Shoe", "Jordan", 41); 
		os.getCart().add(jordan);	//Adds item to be removed
	
		os.removeFromCart(jordan);
		
		try{	
			assertEquals(os.getCart().size(), 0);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	@Test
	public void inCart() {
		Item jordan = new Item("Shoe", "Jordan", 41); 
		os.getCart().add(jordan);	//Adds item to be removed
	
		Boolean inCart = os.inCart(jordan);
		
		try{	
			assertEquals(inCart, true);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	@Test
	public void emptyCart() {
		os.emptyCart();
		int size = os.getCart().size();
		
		try{
			assertEquals(size, 0);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	@Test
	public void getOrder() {
		Item item = os.getCartItem(0);
		
		try{
			assertNotEquals(item, null);	
		}
		catch (AssertionError e){
			fail();
		}
	}
	
	@Test
	public void checkoutCart() {
		int warehouseSize;
		int warehouseSizeAfter;
		int cartSize;
		int cartSizeAfter;
		
		warehouseSize = Warehouse.getStock().size();
		cartSize = os.getCart().size();
		os.checkoutCart("2018-11-08");
		warehouseSizeAfter = Warehouse.getStock().size();
		cartSizeAfter = os.getCart().size();

		try{
			assertNotEquals(warehouseSize, warehouseSizeAfter);	
		}
		catch (AssertionError e){
			fail();
		}
		
		try{
			assertNotEquals(cartSize, cartSizeAfter);	
		}
		catch (AssertionError e){
			fail();
		}		
	}
	
	
	@Test
	public void formatDeliveryDate() {
		try{
			os.formatDeliveryDate("2018-12-08");	
		}
	
		catch (ParseException e){
			fail();
		}	
	}
	
	
	
	
	
	

}

