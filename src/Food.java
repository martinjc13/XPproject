/**
 * Food data structure.
 * 
 * @version 09/16/24
 * @author Josh Martin
 */
public class Food 
{
    private String location;
    private String name;
    private double price;

    public Food(String name, double price, String location) 
    {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public String getLocation()
    {
        return location;
    }

    public String toString() 
    {
        return name + " - $" + price + ", {" + location + "}";
    }
}
