import java.util.ArrayList;
import java.util.List;

public class Cart 
{
    private List<Food> items;

    public Cart() 
    {
        items = new ArrayList<>();
    }

    public void addItem(Food food) 
    {
        items.add(food);
    }

    public void removeItem(Food food) 
    {
        items.remove(food);
    }

    public List<Food> getItems() 
    {
        return items;
    }

    public double getTotal() 
    {
        double total = 0.0;
        for (Food item : items) 
        {
            total += item.getPrice();
        }
        return total;
    }
}
