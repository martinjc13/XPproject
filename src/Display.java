import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {
    private JFrame frame;
    private JPanel cartp;
    private JLabel totalL;
    private Cart cart;
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;
    private static final String NAME = "Food Order App";

    public Display() 
    {
        cart = new Cart();
        createFrame();
        initializeComponents();
        displayFrame();
    }

    private void createFrame() 
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    private void initializeComponents() 
    {
        JPanel menuP = new JPanel();
        menuP.setLayout(new GridLayout(0, 1));
        Menu menu = new Menu();
        List<Food> foodItems = menu.getFoodItems();
        for (Food food : foodItems) 
        {
            JPanel menuitemp = new JPanel();
            menuitemp.setLayout(new GridLayout(0, 1));

            JLabel foodl = new JLabel(food.getName() + " - $" + food.getPrice());
            JButton add = new JButton("Add");

            add.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    cart.addItem(food);
                    update();
                }
            });

            menuitemp.add(foodl);
            menuitemp.add(add);
            menuP.add(menuitemp);
        }
        cartp = new JPanel();
        cartp.setLayout(new FlowLayout());
        cartp.setPreferredSize(new Dimension(300, HEIGHT));
        totalL = new JLabel("Total: $0.00");
        JPanel totalPanel = new JPanel();
        totalPanel.add(totalL);
        JButton placeOB = new JButton("Place Order");
        placeOB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 placeO();
            }
        });
        totalPanel.add(placeOB);
        JButton clear = new JButton("Clear All Items");
        clear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                cart.getItems().clear();
                update();
            }
        });
        totalPanel.add(clear);
        frame.add(new JScrollPane(menuP), BorderLayout.WEST);
        frame.add(new JScrollPane(cartp), BorderLayout.CENTER);
        frame.add(totalPanel, BorderLayout.SOUTH);
    }

    private void update() 
    {
        cartp.removeAll();

        for (Food item : cart.getItems()) 
        {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridLayout(0, 1));
            JLabel cartItemLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    cart.removeItem(item);
                    update();
                }
           });
            itemPanel.add(cartItemLabel);
            itemPanel.add(removeButton);
            cartp.add(itemPanel);
        }
        totalL.setText("Total: $" + String.format("%.2f", cart.getTotal()));
        cartp.revalidate();
        cartp.repaint();
    }

    private void  placeO() 
    {
        List<Food> foods = cart.getItems();
        if (foods.isEmpty()) 
        {
            JOptionPane.showMessageDialog(frame, "Your cart is empty, add items before placing an order.");
            return;
        }

        StringBuilder orderDetails = new StringBuilder("You've ordered:\n");
        for (Food item : foods) 
        {
            orderDetails.append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
        }
        orderDetails.append("\nTotal: $").append(String.format("%.2f", cart.getTotal()));

        JOptionPane.showMessageDialog(frame, orderDetails.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayFrame() 
    {
        frame.setVisible(true);
    }
}
