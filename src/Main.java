import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
        Cart cart = new Cart();
        System.out.println(menu.getFoodItems());
        List<Food> foodItems = menu.getFoodItems();
        for (int i = 0; i < foodItems.size(); i++)
        {
            Food selectedFood = foodItems.get(i);
            cart.addItem(selectedFood);
        }
        System.out.println("\n" + cart.getItems() + "\n" + cart.getTotal());
        Food removeFood = foodItems.get(2);
        cart.removeItem(removeFood);
        System.out.println("\n" + cart.getItems() + "\n" + cart.getTotal());
    }
}