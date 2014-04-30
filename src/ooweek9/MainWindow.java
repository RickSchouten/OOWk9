package ooweek9;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */

/**
 * creates a window to which a GridView panel is added
 * 
 */
public class MainWindow implements ActionListener{
    // the size of the window
    public static final double WIDTH = 650, HEIGHT = 680;
    
    // The grid panel
    private GridView grid;
    
    private GridFiller filler;
    private JTextField xcenter, ycenter, zoom;
    
    public MainWindow () {
    	JFrame mainFrame = new JFrame ("Mandelbrot");
        
    	mainFrame.setSize ((int)WIDTH, (int)HEIGHT);                
    	mainFrame.setLocationRelativeTo(null);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout( new BorderLayout());
    	mainFrame.setResizable(false);
    	mainFrame.setVisible(true);
    	
        Insets insets = mainFrame.getInsets ();
        grid = new GridView ((int)WIDTH - insets.left - insets.right, (int)HEIGHT - insets.top - insets.bottom - 30);
        
        MouseHandler handler = new MouseHandler();
        grid.addMouseListener(handler);
        grid.addMouseMotionListener(handler);
        
        mainFrame.add(grid, BorderLayout.NORTH);
        
        filler = new GridFiller(grid);
        
        insets = mainFrame.getInsets();
        JPanel zoomPanel = new JPanel();
        zoomPanel.setSize((int)WIDTH - insets.left - insets.right, 30 - insets.top - insets.bottom);
        zoomPanel.setLayout( new FlowLayout());
        zoomPanel.setBackground(Color.GRAY);
        
        xcenter = new JTextField("0", 5);
        zoomPanel.add(xcenter);
        
        ycenter = new JTextField("0", 5);
        zoomPanel.add(ycenter);
        
        zoom = new JTextField("130", 5);
        zoomPanel.add(zoom);
        
        JButton zoomButton = new JButton("Apply");
        zoomButton.addActionListener(this);
        zoomPanel.add(zoomButton);
                
        mainFrame.add(zoomPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Apply")){
            double width = WIDTH/stringToDouble(zoom.getText());
            filler.fill(stringToDouble(xcenter.getText()), stringToDouble(ycenter.getText()), width, width);
        }
        else{
        }
    }
    
    private double stringToDouble(String s){
        int dot = 0;
        while(dot < s.length()-1 && s.charAt(dot) != '.' && s.charAt(dot) != ',')
            dot++;
        double output = 0;
        for(int i = 0; i < s.length(); i++){
            if(dot == s.length()-1 || i != dot){
                int charAt = s.charAt(i) - 48;
                if(dot == s.length()-1 || (dot != s.length()-1 && i > dot))
                    output += (double)charAt*power(10, dot - i);
                else if(dot != s.length()-1 && i < dot)
                    output += (double)charAt*power(10, dot - i - 1);
            }
        }
        return output;
    }
    
    private double power(double x, int y){
        double out = 1;
        if(y >= 0){
            for(int i = 0; i < y; i++)
                out = out*x;
        }
        else{
            for(int i = 0; i > y; i--)
                out = out/x;
        }
        return out;
    }
    
    public GridFiller getFiller(){
        return filler;
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener{

        public MouseHandler(){

        }

        @Override
        public void mouseClicked(MouseEvent e){

        }

        @Override
        public void mousePressed(MouseEvent e){

        }

        @Override
        public void mouseReleased(MouseEvent e){

        }

        @Override
        public void mouseEntered(MouseEvent e){

        }

        @Override
        public void mouseExited(MouseEvent e){

        }

        @Override
        public void mouseDragged(MouseEvent e){

        }

        @Override
        public void mouseMoved(MouseEvent e){

        }

    }
}
