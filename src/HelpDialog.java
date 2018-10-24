import javax.swing.*;
import java.awt.*;

public  class HelpDialog extends JOptionPane {

    public static void initFrame(JFrame frame, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();
        int x = 400;
        int y = 400;
        frame.setBounds(x,y,x,y);


        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }




    public static void main(String[] args){
        JFrame frame=new JFrame("界面");
        initFrame(frame,400,300);
        JPanel jPanel=new JPanel();
        jPanel.setBackground(Color.black);
        jPanel.setBounds(50,50,400,300);
        Button button1=new Button("true");
        button1.setBounds(90,90,12,12);
        button1.setBackground(Color.red);
        jPanel.add(button1);
        frame.add(jPanel);
        frame.setVisible(true);


    }
}
