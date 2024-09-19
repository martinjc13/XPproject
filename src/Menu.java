import java.util.ArrayList;
import java.util.List;

public class Menu 
{
    private List<Food> foods;

    public Menu() 
    {
        foods = new ArrayList<>();
        foods.add(new Food("Pizza", 14.99));
        foods.add(new Food("Burger", 12.99));
        foods.add(new Food("Pasta", 10.99));
        foods.add(new Food("Steak", 12.99));
        foods.add(new Food("Chicken Fajita", 9.99));
        foods.add(new Food("BBQ", 11.99));
        foods.add(new Food("Sandwich", 10.99));
        foods.add(new Food("Ribs", 12.99));
        foods.add(new Food("Salad", 7.99));
    }

    public List<Food> getFoodItems() 
    {
        return foods;
    }
}
