import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display
{

    private JFrame frame;
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final String NAME = "Menu";
    
    public Display() {
        createFrame();
        //initializeComponents();
        displayFrame();
    }

    public JFrame getFrame(){
        return this.frame;
    }

    private void createFrame(){
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void displayFrame(){
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new Display();
    }

}