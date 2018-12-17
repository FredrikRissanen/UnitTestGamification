package models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import models.foodModels.Food;



public class OrderManager {

    private static OrderManager ourInstance = new OrderManager();

    public static OrderManager getInstance() {
        return ourInstance;
    }

    private OrderManager() {
    }

    private List<Food> order = new ArrayList<>();

    public List<Food> getOrder() {
        return order;
    }

    public boolean addFoodToOrder(Food foodToAdd){
        if (foodToAdd!=null){
            order.add(foodToAdd);
            return true;
        }
        return false;
    }

    public boolean removeFoodFromOrder(int orderIndex){
        if (orderIndex < order.size()) {  // BUG && orderIndex >= 0
            order.remove(orderIndex);
            return true;
        }
        return false;
    }

    public String getOrderTotalCost(){
        int sum = 0; // BUG this is DOUBLE MAN
        for (Food food : order) {
        	int i = (int) food.getPrice();
            sum+=i;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(sum);
    }

}
