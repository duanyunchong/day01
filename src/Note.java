import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class Note extends JFrame  {
    JMenuBar Mb;
    JMenu fileMenu, editMenu, viewMenu, aboutMenu;
    JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem, saveOtherItem, aboutMenuItem, helpMenuItem;
    MenuItem mItemCopy, mItemPaste, mItemCut;
    JTextArea jta;
    JScrollPane jsp;
    JFileChooser chooser;
    File file;
    FileWriter fw;
    PopupMenu pMenu;
    Note note;
    public void start() {
        this.setLayout(null);
        this.setBounds(400, 400, 400, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("记事本");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\IdeaProjects\\day01\\resource\\img\\dog.png"));


        jta = new JTextArea();
        //在文本框上添加滚动条
        jsp = new JScrollPane(jta);
        //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
        jsp.setBounds(13, 30, 385, 390);
        //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //把滚动条添加到容器里面
        this.add(jsp);

        JMenuBar menuBar = new JMenuBar();
        /*
         * 创建一级菜单
         */
        fileMenu = new JMenu("文件(F)");
        editMenu = new JMenu("编辑(E)");
        viewMenu = new JMenu("查看(V)");
        aboutMenu = new JMenu("帮助(H)");
        // 一级菜单添加到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);

        /*
         * 创建 "文件" 一级菜单的子菜单
         */
        newMenuItem = new JMenuItem("新建(N)");
        openMenuItem = new JMenuItem("打开(O)");
        saveMenuItem = new JMenuItem("保存(S)");
        saveOtherItem = new JMenuItem("另存为（A）");
        exitMenuItem = new JMenuItem("退出（Exit）");
        /**
         * 创建弹出式菜单
         */
        pMenu = new PopupMenu(); //创建弹出式菜单，下面三项是菜单项
        mItemCopy = new MenuItem("copy");
        mItemPaste = new MenuItem("paste");
        mItemCut = new MenuItem("cut");

        pMenu.add(mItemCopy);
        pMenu.add(mItemPaste);
        pMenu.add(mItemCut);
        jta.add(pMenu);
/**
 * 右键菜单
 */
        jta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseReleased(e);
                // 如果释放的是鼠标右键
                if (e.isPopupTrigger()) {
                    pMenu.show(jta, e.getX(), e.getY());
                }
            }
        });

        /**
         * 创建"帮助"一级菜单的子菜单
         */
        aboutMenuItem = new JMenuItem("关于笔记本(A)");
        helpMenuItem = new JMenuItem("查看帮助(H)");
        /**
         * exitMenuItem的监听事件
         */
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * saveOtherItem的监听事件
         */
        saveOtherItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                File file = null;
                String s = "新建记事本";
                chooser.setCurrentDirectory(new File("."));
                try {
                    if (file == null) s = JOptionPane.showInputDialog("请输入文件名：") + ".txt";
                    else s = file.getName();
                    chooser.setSelectedFile(new File(s));
//                    chooser.setFileFilter(new filter());
                    int yn = chooser.showSaveDialog(null);
                    if (yn == chooser.APPROVE_OPTION) {
                        if (file != null) file.delete();
                        file = new File(chooser.getCurrentDirectory(), s);
                        file.createNewFile();
                        FileWriter fw = new FileWriter(file);
                        fw.write(jta.getText());
                        fw.close();
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            }

        });
        /**
         * aboutmenuItem的监听事件
         */
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aboutMenuItem.........");
              JOptionPane.showMessageDialog(note,"hello","消息标题",JOptionPane.INFORMATION_MESSAGE);
            }
        });
   /* *//**
     * aboutmenuItem的监听事件
     *//*
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Note note = new Note();
                JOptionPane.showMessageDialog(note, "hello", "消息标题", JOptionPane.INFORMATION_MESSAGE);
            }
        });*/
        /************************************************************************************************************/
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveOtherItem);
        fileMenu.addSeparator();       // 添加一条分割线
        fileMenu.add(exitMenuItem);
        aboutMenu.add(helpMenuItem);
        aboutMenu.add(aboutMenuItem);
        this.setJMenuBar(menuBar);
    }






    public static void main(String[] args) {
        Note note = new Note();
        note.start();
    }


}

