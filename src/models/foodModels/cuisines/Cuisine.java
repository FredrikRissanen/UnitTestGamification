package models.foodModels.cuisines;

import models.foodModels.Food;

public abstract class Cuisine extends Food {

    //you can creating tons of class containing unique cuisines, after this go to Utils and add it there
    public String description;
    public String ingredients;

    public Cuisine() {
    }

    public Cuisine(String name, double price, String description, String ingredients) {
        super(name, price);
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return super.getName() + ", $" + super.getPrice() + ", description='" + description
                + "', ingredients='" + ingredients + "'.";
    }
}
