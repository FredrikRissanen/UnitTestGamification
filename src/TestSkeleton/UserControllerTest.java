package TestSkeleton;


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

/*   @Test   
    public void MyFirstTestCase {
       
        
    }
    
   */
    
}