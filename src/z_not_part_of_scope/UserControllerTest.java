package z_not_part_of_scope;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.UserController;
import models.OrderManager;
import models.foodModels.Drink;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UserControllerTest {

    private static UserController userController;

    @BeforeClass
    public static void start(){
        userController = new UserController();
    }

    @AfterClass
    public static void stop(){
       userController = null;
    }

    @Test
    public void isNumericTest(){ // FOR BUG 8
        assertTrue(userController.isNumeric("-5"));
        assertTrue(userController.isNumeric("1"));
        assertFalse(userController.isNumeric("test"));
    }

    @Test
    public void showOrderTest(){ // FOR BUG 7
        String expected = "1. test, $9.99\n";
        expected += expected;
		OrderManager.getInstance().addFoodToOrder(new Drink("test", 9.99));
		OrderManager.getInstance().addFoodToOrder(new Drink("test", 9.99));
        assertEquals(expected,userController.showCurrentOrder());
    }
    @Test
    public void shouldTakeUserInput(){ // FOR BUG 9
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        UserController usercontroller = new UserController();
        assertEquals("add 5", usercontroller.userCommand());
    }

    @Test
    public void checkIfUserEnteredProperMainCourseFoodOptionNameTest(){ // FOR BUG 1
        UserController usercontroller = new UserController();
        boolean x = usercontroller.checkIfUserEnteredProperMainCourseFoodOptionName("Doesnt exists");
        assertEquals(x, false);
    }
    @Test
    public void checkIfUserEnteredProperMainCourseFoodOptionNameTest2(){ // FOR BUG 2
        UserController usercontroller = new UserController();
        boolean x = usercontroller.checkIfUserEnteredProperSmallMenuFoodOptionName("Doesnt exists");
        assertEquals(x, false);
    }
    @Test
    public void SmallMenuTests() { // BUG 6
    	UserController us = new UserController();
    	assertTrue(us.showSmallMenuOptions().length() > 10);
    	
    }
    
    @Test
    public void SmallMenuTests2() { // BUG 5
    	UserController us = new UserController();
    	us.showSmallMenuOptions();
        assertTrue(us.showMainCourseMenuOptions().length() > 10);
    	
    }
    
    @Test
    public void SmallMenuTests3() { // BUG 4
    	UserController us = new UserController();
    	us.showSmallMenuOptions();
    	assertTrue(us.showSmallMenu("drink").length() > 15);
    	
    }

    @Test
    public void SmallMenuTests4() { // BUG 3
    	UserController us = new UserController();
    	us.showSmallMenuOptions();
    	assertTrue(us.showMainCourseMenu("italian").length() > 1);
    	
    }
    
}