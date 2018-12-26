package tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import models.OrderManager;
import models.foodModels.Drink;
import static org.junit.Assert.*;

public class OrderManagerTest {

    @Test
    public void getOrderTotalCostTest(){ // FOR BUG 10
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56));
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 9.99));
        assertEquals("15.55", OrderManager.getInstance().getOrderTotalCost());
    }

    @Test
    public void removingTest(){ // FOR BUG 11
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56));
        boolean x = OrderManager.getInstance().removeFoodFromOrder(
        		OrderManager.getInstance().getOrder().size()-1);
        assertEquals(x, true);
        x = OrderManager.getInstance().removeFoodFromOrder(OrderManager.getInstance().getOrder().size()-1);
        assertEquals(x, false);
    }





}
