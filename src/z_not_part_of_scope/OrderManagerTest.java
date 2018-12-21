package z_not_part_of_scope;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import models.OrderManager;
import models.foodModels.Drink;

import static org.junit.Assert.*;

public class OrderManagerTest {


    @BeforeClass
    public static void start(){

    }

    @AfterClass
    public static void stop(){
    }

   
    @Test
    public void RemoveFromListTest() {
    	assertTrue(OrderManager.getInstance().removeFoodFromOrder(0));
    	assertFalse(OrderManager.getInstance().removeFoodFromOrder(-1));
    }

   
    @Test
    public void getOrderTotalCostTest(){
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56));
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 9.99));
        assertEquals("15.55", OrderManager.getInstance().getOrderTotalCost());
    }

}
