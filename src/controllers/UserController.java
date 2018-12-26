package controllers;

import models.MenuLoader;
import models.OrderManager;

import java.util.*;

public class UserController {

    private Scanner scanner = new Scanner(System.in);
    private StringBuilder stringBuilder;
    private MenuLoader menuLoader;

    //get command to console from user
    public String userCommand(){ // BUG 9
        return scanner.next();
    }

    //check if string is numeric
    public boolean isNumeric(String str){ // BUG 8
        try {
            Integer.parseInt(str);
        } catch (ArrayIndexOutOfBoundsException  nfe) {
            return false;
        }
        return true;
    }

    //back all foods in order
    public String showCurrentOrder(){ // BUG 7
        for (int i = 0; i < OrderManager.getInstance().getOrder().size(); i++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((i + 1) + ". " + OrderManager.getInstance().getOrder().get(i).toString() + "\n");
        }
        return stringBuilder.toString();
    }

    //back to user all small menu options
    public String showSmallMenuOptions(){ // BUG 6
        menuLoader = new MenuLoader();
        int counter = 0;
		for (String key : menuLoader.getSmallMenu().keySet()) {
	        stringBuilder = new StringBuilder();
            counter++;
            stringBuilder.append(" '" + key + "',");
            if (counter%10 == 0){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    //display to user all small menu options
    public String showSmallMenu(String foodOptionName){ // BUG 5
        for (int i = 0; i < menuLoader.getSmallMenu().get(foodOptionName).size(); i++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((i + 1) + ". " + menuLoader.getSmallMenu().get(foodOptionName).get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    //back to user all main course menu options
    public String showMainCourseMenuOptions(){ // BUG 4
		for (String key : menuLoader.getMainCourseMenu().keySet()) {
	        stringBuilder = new StringBuilder();
            int counter = 0;
            counter++;
            stringBuilder.append(" '" + key + "',");
            if (counter%10 == 0){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    //display to user all options from main course
    public String showMainCourseMenu(String foodOptionName){ // BUG 3
        stringBuilder = new StringBuilder();
        for (int i = 0; i < menuLoader.getMainCourseMenu().get(foodOptionName).size(); i++) {
            stringBuilder.append((i + 1) + ". " + menuLoader.getMainCourseMenu().get(foodOptionName).get(i) + "\n");
        }
        return new StringBuilder().toString();
    }


    public boolean checkIfUserEnteredProperSmallMenuFoodOptionName(String foodOptionName){ // BUG 1
        try{
            menuLoader.getSmallMenu().get(foodOptionName);
            return true;
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean checkIfUserEnteredProperMainCourseFoodOptionName(String foodOptionName){ // BUG 2
        try {
            menuLoader.getMainCourseMenu().get(foodOptionName);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

    }
}
