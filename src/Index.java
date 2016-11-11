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
                ImageIcon img = new ImageIcon("4.jpg");
                g.drawImage(img.getImage(), 0,0, null);
            }
        };
        Font font=new Font("΢���ź�",Font.BOLD,20);
        JMenuBar jMenuBar=new JMenuBar();
        JMenu login=new JMenu("��¼");
        JMenu jiapu=new JMenu("�ҵļ���");
        JMenuItem chakan=new JMenuItem("�鿴����");
        JMenuItem xiugai=new JMenuItem("�޸ļ���");
        jiapu.add(chakan);
        jiapu.add(xiugai);
        JMenu jisi=new JMenu("����");
        JMenu exit=new JMenu("�˳�");
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
