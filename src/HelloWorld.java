import javax.swing.*;

public class HelloWorld extends JFrame {
    public  void start(){

    }
    public static void main(String[] args){
        HelloWorld mv=new HelloWorld();
        mv.setLayout(null);
        //实例化文本框
        JTextArea jta= new JTextArea();
        //在文本框上添加滚动条
        JScrollPane jsp = new JScrollPane(jta);
        //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
        jsp.setBounds(13, 10, 350, 340);
        //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //把滚动条添加到容器里面
        mv.add(jsp);
        mv.setSize(400, 400);
        mv.setVisible(true);
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("1111");
    }
}
