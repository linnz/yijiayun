import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lnz on 2016/11/7.
 */
public class Index {
    private static void constructGUI(){

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel1=new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("background.jpg");
                g.drawImage(img.getImage(), 0,0, null);
            }
        };
        Font font=new Font("微软雅黑",Font.BOLD,20);
        JMenuBar jMenuBar=new JMenuBar();
        JMenu login=new JMenu("登录");
        JMenu jiapu=new JMenu("我的家谱");
        JMenuItem chakan=new JMenuItem("查看家谱");
        JMenuItem xiugai=new JMenuItem("修改家谱");
        jiapu.add(chakan);
        jiapu.add(xiugai);
        JMenu jisi=new JMenu("祭祀");
        JMenu exit=new JMenu("退出");
        login.setFont(font);
        jiapu.setFont(font);
        jisi.setFont(font);
        exit.setFont(font);
        jMenuBar.add(login);
        jMenuBar.add(jiapu);
        jMenuBar.add(jisi);
        jMenuBar.add(exit);


        frame.setJMenuBar(jMenuBar);
        frame.add(jPanel1);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int)screenSize.getWidth()/5,(int)screenSize.getHeight()/7,805,545);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                constructGUI();
            }
        });
    }
}
