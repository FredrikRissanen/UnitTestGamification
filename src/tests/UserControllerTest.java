package tests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.UserController;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
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
    public void isNumericTest(){
        assertTrue(userController.isNumeric("-5"));
        assertTrue(userController.isNumeric("1"));
        assertFalse(userController.isNumeric("test"));
    }

    @Test
    public void shouldTakeUserInput() {
        UserController usercontroller = new UserController();

        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("add 5", usercontroller.userCommand());
    }

}