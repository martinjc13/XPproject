import java.util.ArrayList;
import java.util.List;

public class Menu 
{
    private List<Food> foods;

    public Menu() 
    {
        foods = new ArrayList<>();
        foods.add(new Food("Pizza", 14.99, "Pizzahut"));
        foods.add(new Food("Burger", 12.99, "Burger bar"));
        foods.add(new Food("Pasta", 10.99, "Italian restaurant"));
        foods.add(new Food("Steak", 12.99, "Steak house"));
        foods.add(new Food("Chicken Fajita", 9.99, "Mexican food"));
        foods.add(new Food("BBQ", 11.99, "BBQ place"));
        foods.add(new Food("Sandwich", 10.99, "Lunch place"));
        foods.add(new Food("Ribs", 12.99, "BBQ place"));
        foods.add(new Food("Salad", 7.99, "Healthy foods"));
    }

    public List<Food> getFoodItems() 
    {
        return foods;
    }
}
